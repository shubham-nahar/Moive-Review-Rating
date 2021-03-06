package com.flixme.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flixme.dao.DaoException;
import com.flixme.dao.UserDao;
import com.flixme.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("userController")
public class UserController {

	@Autowired
	private UserDao dao;

	@RequestMapping(method = RequestMethod.GET, path = "/login")
	public String getLoginForm() {

		return "login-form";
	}// end method

	@RequestMapping(method = RequestMethod.POST, path = "/login")
	public String handleLogin(@RequestParam String email, @RequestParam String password, HttpSession session,
			Model model) {
		User user;
		try {
			user = dao.findByEmail(email);
			if (user.getPassword().equals(password)) {
				session.setAttribute("loggedInUser", user);
				System.out.println("Login Successful*********************************************");
				return "redirect:/";
			} // end if
			System.out.println("Login Failed & Try*********************************************");
			model.addAttribute("errmsg", "Invalid UserName/password");
			return "login-form";

		} catch (DaoException e) {
			System.out.println("Login Failed & Catch*********************************************");
			model.addAttribute("errmsg", "Invalid UserName/password");
			return "login-form";

		}

	}

	@GetMapping("/register")
	public String getRegistrationForm(Model model) {
		System.out.println("Entered in GET Registration Form*********");
		model.addAttribute("cust", new User());
		return "registration-form";
	}// end method

	@RequestMapping(method = RequestMethod.POST, path = "/register")
	public String handleRegistration(@ModelAttribute("cust") User user) {
		try {

			dao.addNewUser(user);
		} catch (DaoException e) {

			e.printStackTrace();
		}
		return "login-form";
	}// end method

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}// end method

	// Profile Controllers

	@GetMapping("/profile")
	public String profile() {
		return "view-profile";
	}// end method

	@GetMapping("/edit-profile")
	public String editProfile(Model model, HttpSession session) {

		User user = new User();
		user.setId(((User) session.getAttribute("loggedInUser")).getId());
		model.addAttribute("customer", user);
		log.debug("*************profile editor get method**************");
		return "edit-profile";
	}// end method

	@PostMapping("/edit-profile")
	public String editProfilHandler(@ModelAttribute("customer") User user, HttpSession session) {
		User u = (User) session.getAttribute("loggedInUser");

		if (u == null) {
			return "redirect:/login";
		}

		user.setPassword(u.getPassword());
		user.setBalance(u.getBalance());

		try {
			dao.updateUser(user);
			// model.addAttribute("msg", "user details successfully updated");
			session.setAttribute("loggedInUser", user);
			return "Index";
		} catch (DaoException e) {

			e.printStackTrace();
		}
		return "edit-profile";
	}// end method

	// Balance controllers

	@GetMapping("/check-balance")
	public String getBalance() {

		return "check-balance";
	}

	@GetMapping("/add-balance")
	public String updateBalance() {
		return "add-balance";
	}

	@PostMapping("/add-balance")
	public String updateBalanceHandler(@RequestParam double balance, HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		user.setBalance(user.getBalance() + balance);
		try {
			dao.updateBalance(user);
		} catch (DaoException e) {

			log.debug(e.getMessage());
		}
		return "redirect:/";
	}

}
