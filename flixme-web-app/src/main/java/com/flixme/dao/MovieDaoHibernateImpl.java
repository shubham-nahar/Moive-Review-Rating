package com.flixme.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.flixme.entity.Movie;

@Repository
public class MovieDaoHibernateImpl implements MovieDao {

	@Autowired
	HibernateTemplate template;

	@Override
	public void addMovie(Movie m) throws DaoException {

		System.out.println("*************************" + m);
		template.persist(m);
	}

	@Override
	public void updateMovie(Movie m) throws DaoException {

		template.merge(m);
	}

	@Override
	public Movie findById(Integer id) throws DaoException {

		Movie m = template.get(Movie.class, id);
		return m;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Movie> getAllMovies() throws DaoException {

		return (List<Movie>) template.find("from Movie order by id");
	}

	@SuppressWarnings("deprecation")
	@Override
	public Movie getMovieByName(String name) throws DaoException {

		String hql = "from Movie where name =?0";
		List<?> list = template.find(hql, name);
		return (Movie) list.get(0);
	}

	@Override
	public List<Movie> getMovieByGenere(String genere) throws DaoException {
		return null;
	}

	@Override
	public List<Movie> getMovieByReleaseYear(Integer year) throws DaoException {
		return null;
	}

	@Override
	public List<Movie> getMovieByCast(String name) throws DaoException {
		return null;
	}
}
