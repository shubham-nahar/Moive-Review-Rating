package com.flixme.service;

import java.util.List;

import com.flixme.dao.DaoException;
import com.flixme.dao.UserDao;
import com.flixme.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserService {

	private UserDao dao = null;

	public User login(String email, String password) throws ServiceException {
		try {
			User u = dao.findByEmail(email);
			if (u == null) {
				throw new ServiceException("Invalid Email/password ");
			} else if (u.getPassword().equals(password)) {
				return u;
			} else {
				throw new ServiceException("Invalid Email/password");
			}
		} catch (DaoException e) {
			log.warn("Exception occured while calling login ", e);
			throw new ServiceException(e);
		}

	}// end method

	public User login(String email, String password, String role) throws ServiceException {
		try {
			User u = dao.findByEmail(email);
			if (u == null) {
				throw new ServiceException("Invalid Email/password ");
			} else if (u.getPassword().equals(password) && u.getRole().equalsIgnoreCase(role)) {
				return u;
			} else {
				throw new ServiceException("Invalid Email/password");
			}
		} catch (DaoException e) {
			log.warn("Exception occured while calling login ", e);
			throw new ServiceException(e);
		}

	}// end method

	public void register(User user) throws ServiceException {
		try {
			List<User> list = dao.getAll();
			for (User u : list) {
				if (u.getEmail().equalsIgnoreCase(user.getEmail())) {
					throw new ServiceException("Inalid email, please retry");
				}
			}
			dao.addNewUser(user);

		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}// end method

	public void makeAdmin(int id) {

	}

	public void updateProfile(User c) {

	}

}
