package com.project.Service;

import java.util.List;

import com.project.Exception.UserServiceException;
import com.project.bean.User;

public interface UserService {
	User getUserById(int userId)throws UserServiceException;
	List<User> getAllUsers()throws UserServiceException;
	boolean addUser(User user)throws UserServiceException;
	boolean updateUser(User user)throws UserServiceException;
	boolean deleteUser(int userId)throws UserServiceException;

}
