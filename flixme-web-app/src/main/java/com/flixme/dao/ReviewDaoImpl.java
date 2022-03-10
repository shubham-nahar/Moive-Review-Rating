package com.flixme.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.flixme.entity.Movie;
import com.flixme.entity.Review;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	HibernateTemplate template;
	
	@Override
	public void addReview(Review r) throws DaoException {

		System.out.println("review values RDHML " +r);
		template.persist(r);

	}

	@Override
	public void EditReview(Review r) throws DaoException {

		template.merge(r);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Review> getReviewByMovie(Movie m) throws DaoException {

		String hql = "from Review where movie_id=?0";
		return (List<Review>) template.find(hql, m.getId());
	}

	@Override
	public List<Review> getReviewByUserId(Integer uId) throws DaoException {

		return null;
	}

}
