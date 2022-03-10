package com.flixme.dao;

public class DaoException extends Exception {

	private static final long serialVersionUID = 6903637373939743485L;

	public DaoException() {
		super();
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

}
