package com.flixme.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.flixme.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserDaoHibernateImpl implements UserDao {

	@Autowired
	HibernateTemplate template;

	@Override
	public void addNewUser(User user) throws DaoException {

		try {
			log.debug("template is {}", template);
			log.debug("cust is {}", user);
			template.persist(user);

		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public User findById(Integer id) throws DaoException {
		User u = template.get(User.class, id);
		return u;
	}

	@Override
	public void updateUser(User user) throws DaoException {

		try {
			template.merge(user);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void updateBalance(User user) throws DaoException {

		try {
			template.merge(user);
		} catch (Exception e) {
			throw new DaoException();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public User findByEmail(String email) throws DaoException {

		try {
			String hql = "from User where email=?0";

			return (User) template.find(hql, email).get(0);
		} catch (Exception e) {
			throw new DaoException();
		}
	}

	@Override
	public List<User> getAll() throws DaoException {

		return null;
	}

	@Override
	public List<User> findByCountry(String country) throws DaoException {

		return null;
	}

}
