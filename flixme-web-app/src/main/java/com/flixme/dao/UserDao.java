package com.flixme.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.flixme.entity.User;

public interface UserDao {

	@Transactional(readOnly = false)
	public void addNewUser(User user) throws DaoException;

	public User findById(Integer Id) throws DaoException;

	@Transactional(readOnly = false)
	public void updateUser(User user) throws DaoException;

	@Transactional(readOnly = false)
	public void updateBalance(User user) throws DaoException;

	// query Operations
	public User findByEmail(String email) throws DaoException;

	public List<User> getAll() throws DaoException;

	public List<User> findByCountry(String country) throws DaoException;

}
