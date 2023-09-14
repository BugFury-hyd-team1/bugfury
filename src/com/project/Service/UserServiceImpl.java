package com.project.Service;

import java.util.List;

import com.project.Dao.UserDAO;
import com.project.Exception.UserNotFoundException;
import com.project.Exception.UserServiceException;
import com.project.bean.User;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

	@Override
	public User getUserById(int userId) throws UserServiceException {
		 try {
	            User user = userDAO.getUserById(userId);
	            if (user == null) {
	                throw new UserNotFoundException(userId);
	            }
	            return user;
	        } catch (Exception e) {
	            // Handle exceptions or log errors as needed
	            e.printStackTrace();
	            throw new UserServiceException();
	        }
	}

	@Override
	public List<User> getAllUsers() throws UserServiceException {
		 try {
	            return userDAO.getAllUsers();
	        } catch (Exception e) {
	            // Handle exceptions or log errors as needed
	            e.printStackTrace();
	            throw new UserServiceException();
	        }
	}

	@Override
	public boolean addUser(User user) {
		 try {
	            // You can add validation logic here before calling the DAO
	            // For example, check if the email is unique
	            List<User> existingUsers = userDAO.getUsersByEmail(user.getEmail());
	            if (existingUsers.isEmpty()) {
	                return userDAO.addUser(user);
	            } else {
	                throw new UserServiceException();
	            }
	        } catch (Exception e) {
	            // Handle exceptions or log errors as needed
	            e.printStackTrace();
	            throw new UserServiceException();
	        }
	}


	

	@Override
	public boolean deleteUser(int userId) throws UserServiceException {
		try {
            // You can add additional logic here, such as checking if the user is associated with any projects or bugs
            return userDAO.deleteUser(userId);
        } catch (Exception e) {
            // Handle exceptions or log errors as needed
            e.printStackTrace();
            throw new UserServiceException();
        }
	}

}
