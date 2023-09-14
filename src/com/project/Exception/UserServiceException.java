package com.project.Exception;

public class UserServiceException extends Exception {
	public UserServiceException()
	{
		super("Failed to get user by ID");
	}

}
