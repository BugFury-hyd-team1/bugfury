package com.project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.bean.User;

public class UserDAOImpl implements UserDAO {
	 private Connection connection; // Initialize this connection

	    public UserDAOImpl(Connection co) {
	        this.connection = connection;
	    }

	@Override
	public User getUserById(int userId) {
		 String query = "SELECT * FROM users WHERE userId=?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, userId);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                return extractUserFromResultSet(resultSet);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	}

	private User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
		 int userId = resultSet.getInt("userId");
	        String name = resultSet.getString("name");
	        String email = resultSet.getString("email");
	        String userType = resultSet.getString("userType");
	        return new User(userId, name, email, userType);
	    }
	

	@Override
	public List<User> getAllUsers() {
		 List<User> userList = new ArrayList<>();
	        String query = "SELECT * FROM users";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
	             ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	                userList.add(extractUserFromResultSet(resultSet));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return userList;
	}

	@Override
	public boolean addUser(User user) {
		 if (isEmailAlreadyTaken(user.getEmail())) {
	            return false; 
	        }

	       
	        if (!isValidEmail(user.getEmail())) {
	            return false; // Invalid email format, return false
	        }

	        String query = "INSERT INTO users (name, email, userType) VALUES (?, ?, ?)";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
	            preparedStatement.setString(1, user.getName());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.setString(3, user.getUserType());
	            
	            int rowsAffected = preparedStatement.executeUpdate();
	            if (rowsAffected > 0) {
	                // Retrieve the generated user ID
	                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
	                if (generatedKeys.next()) {
	                    int generatedUserId = generatedKeys.getInt(1);
	                    user.setUserId(generatedUserId); // Set the generated user ID
	                }
	                return true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	}

	private boolean isValidEmail(String email) {
		 return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
	}

	private boolean isEmailAlreadyTaken(String email) {
		String query = "SELECT COUNT(*) FROM users WHERE email=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public boolean updateUser(User user) {
		String query = "UPDATE users SET name=?, email=?, userType=? WHERE userId=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getUserType());
            preparedStatement.setInt(4, user.getUserId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
			}

	@Override
	public boolean deleteUser(int userId) {
		String query = "DELETE FROM users WHERE userId=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
		
	}

}
