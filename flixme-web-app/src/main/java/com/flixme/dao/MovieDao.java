package com.flixme.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.flixme.entity.Movie;

public interface MovieDao {

	//CRUD Operations
	@Transactional(readOnly = false)
	public void addMovie(Movie m) throws DaoException;
	
	@Transactional(readOnly = false)
	public void updateMovie(Movie m) throws DaoException;
	//public void deleteMovie();
	
	//query operations
	public Movie findById(Integer id) throws DaoException;
	
	public List<Movie> getAllMovies() throws DaoException;
	
	public Movie getMovieByName(String name) throws DaoException;
	
	public List<Movie> getMovieByGenere(String genere) throws DaoException;
	
	public List<Movie> getMovieByReleaseYear(Integer year) throws DaoException;
	
	public List<Movie> getMovieByCast(String name) throws DaoException;

}
