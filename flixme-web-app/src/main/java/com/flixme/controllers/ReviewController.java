package com.flixme.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flixme.dao.DaoException;
import com.flixme.dao.MovieDao;
import com.flixme.dao.ReviewDao;
import com.flixme.dao.UserDao;
import com.flixme.entity.Movie;
import com.flixme.entity.Review;
import com.flixme.entity.User;

@Controller
public class ReviewController {

	@Autowired
	ReviewDao dao;

	@Autowired
	MovieDao mDao;

	@Autowired
	UserDao uDao;

	@GetMapping("/add-review")
	public String addReview(@RequestParam("movieId") int id, Model model, HttpSession session) {
		Review r = new Review();
		try {
			session.setAttribute("movie", mDao.findById(id));
			model.addAttribute("review", r);
			return "add-movie-review";
		} catch (Exception e) {

		}

		return "movie-list";
	}

	@PostMapping("/add-review")
	public String addReviewHandler(@ModelAttribute("review") Review r, HttpSession session) {
		try {
			User u = (User) session.getAttribute("loggedInUser");
			Movie m = (Movie) session.getAttribute("movie");
			r.setUser(u);
			r.setMovie(m);

			session.removeAttribute("movie");
			dao.addReview(r);
		} catch (DaoException e) {
			e.printStackTrace();
		}

		return "movie-list";
	}

	@GetMapping("/get-review")
	public String getReview(@RequestParam("movieId") int id, Model model) {
		try {
			Movie m = mDao.findById(id);
			List<Review> list = dao.getReviewByMovie(m);
			System.out.println("reviews are " + list);
			model.addAttribute("reviews", list);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "review-list";
	}

}
