package com.flixme.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.flixme.entity.Movie;
import com.flixme.entity.Review;

public interface ReviewDao {

	@Transactional(readOnly = false)
	public void addReview(Review r) throws DaoException;
	@Transactional(readOnly = false)
	public void EditReview(Review r)throws DaoException;
	public List<Review> getReviewByMovie(Movie m)throws DaoException;
	public List<Review> getReviewByUserId(Integer uId)throws DaoException;

}
