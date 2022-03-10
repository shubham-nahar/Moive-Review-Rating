package com.flixme.cfg;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.flixme.entity.Movie;
import com.flixme.entity.Review;
import com.flixme.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:jdbc-info.properties")
@ComponentScan(basePackages = { "com.flixme.controllers", "com.flixme.dao" })

public class AppConfig implements WebApplicationInitializer {

	@Bean
	public PlatformTransactionManager txMgr(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		log.debug("Inside AppConfig.onStartup() method");

		AnnotationConfigWebApplicationContext ctx;
		ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);

		Dynamic ds = servletContext.addServlet("ds", new DispatcherServlet(ctx));
		ds.addMapping("/"); // handle all incoming requests "/" or "/*"
		ds.setLoadOnStartup(1);

	}

	@Value("${jdbc.driver-class-name}")
	String driverClassName;
	@Value("${jdbc.connection.url}")
	String url;
	@Value("${jdbc.connection.username}")
	String username;
	@Value("${jdbc.connection.password}")
	String password;

	@Bean
	public BasicDataSource ds() {
		BasicDataSource bds = new BasicDataSource();

		bds.setDriverClassName(driverClassName);
		bds.setUrl(url);
		bds.setUsername(username);
		bds.setPassword(password);
		bds.setInitialSize(20);
		bds.setMaxTotal(100);
		bds.setMaxIdle(3);
		bds.setMaxWaitMillis(2000);

		return bds;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds) {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(ds);
		lsfb.setAnnotatedClasses(User.class, Movie.class, Review.class);

		Properties props = new Properties();
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		props.setProperty("hibernate.show_sql", "false");
		props.setProperty("hibernate.format_sql", "true");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		props.setProperty("hibernate.enable_lazy_load_no_trans", "true");

		lsfb.setHibernateProperties(props);

		return lsfb;
	}

	@Bean
	public HibernateTemplate ht(SessionFactory sessionFactory) { // dependency injection by Spring
		return new HibernateTemplate(sessionFactory); // manual wiring by me
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("./WEB-INF/pages/");
		vr.setSuffix(".jsp");
		return vr;
	}
}
