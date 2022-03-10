package com.flixme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flixme.dao.DaoException;
import com.flixme.dao.MovieDao;
import com.flixme.entity.Movie;

@Controller("movieController")
public class MovieController {

	@Autowired
	MovieDao dao;

	@GetMapping("/add-movie")
	public String addMovie(Model model) {
		model.addAttribute("movie", new Movie());
		return "add-movie";
	}// end method

	@PostMapping("/add-movie")
	public String addMovieHandler(@ModelAttribute("movie") Movie movie) {
		try {
			dao.addMovie(movie);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}// end method

	@GetMapping("/get-movies-list")
	public String getMovies(Model model) {
		try {
			List<Movie> list = dao.getAllMovies();
			model.addAttribute("movies", list);
		} catch (DaoException e) {

			e.printStackTrace();
		}
		return "movie-list";
	}

	@GetMapping("view-movie-details")
	public String getMovieDetail(@RequestParam Integer id, Model model) {
		Movie m;
		try {
			m = dao.findById(id);
		} catch (DaoException e) {
			return "error-page";
		}
		model.addAttribute("movie", m);
		return "view-movie";
	}// end method

	@GetMapping("/search-movies")
	public String searchMovieByTitle() {
		return "search-movie";

	}

	@PostMapping("/search-movies")
	public String searchMovieByIdHandler(@RequestParam String title, Model model) {
		try {
			Movie m = dao.getMovieByName(title);
			model.addAttribute("movie", m);
		} catch (DaoException e) {
			return "error-page";
		}
		return "view-movie";
	}

}
