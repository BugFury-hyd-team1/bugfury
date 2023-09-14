package com.project.Dao;

import java.util.List;

import com.project.bean.User;

public interface UserDAO {
	 User getUserById(int userId);
	    List<User> getAllUsers();
	    boolean addUser(User user);
	    boolean updateUser(User user);
	    boolean deleteUser(int userId);

}
