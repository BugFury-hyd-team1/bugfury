package com.project.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.project.bean.Team;
import com.project.bean.User;

public class TeamDAOImpl implements TeamDAO {
	 private Connection connection; // Initialize this connection

	    public TeamDAOImpl(Connection connection) {
	        this.connection = connection;
	    }

		@Override
		public Team getTeamById(int teamId) {
			 String query = "SELECT * FROM teams WHERE teamId=?";
		        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		            preparedStatement.setInt(1, teamId);
		            ResultSet resultSet = preparedStatement.executeQuery();
		            if (resultSet.next()) {
		                return extractTeamFromResultSet(resultSet);
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return null;
		}

		private Team extractTeamFromResultSet(ResultSet resultSet) throws SQLException {
			int teamId = resultSet.getInt("teamId");
	        String teamName = resultSet.getString("teamName");
	        
	        return new Team(teamId, teamName);
	    }
	    
	    private User getUserById(int userId) {
	        // Implement this method to retrieve a User object by userId from your database
	        // You can use a UserDAO or similar approach to fetch the user data
	        return null; // Replace with actual implementation
	    }
		

		@Override
		public List<Team> getAllTeams() {
			 List<Team> teamList = new ArrayList<>();
		        String query = "SELECT * FROM teams";
		        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
		             ResultSet resultSet = preparedStatement.executeQuery()) {
		            while (resultSet.next()) {
		                teamList.add(extractTeamFromResultSet(resultSet));
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return teamList;
		}

		@Override
		public boolean addTeam(Team team) {
			String query = "INSERT INTO teams (teamName) VALUES (?)";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, team.getTeamName());
	            
	            int rowsAffected = preparedStatement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
		}

		@Override
		public boolean updateTeam(Team team) {
			String query = "UPDATE teams SET teamName=? WHERE teamId=?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, team.getTeamName());
	            preparedStatement.setInt(2, team.getTeamId());
	            
	            int rowsAffected = preparedStatement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
		}

		@Override
		public boolean deleteTeam(int teamId) {
			String query = "DELETE FROM teams WHERE teamId=?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, teamId);
	            int rowsAffected = preparedStatement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
		}

		@Override
		public List<User> getTeamMembers(int teamId) {
			List<User> teamMembers = new ArrayList<>();
	        String query = "SELECT * FROM team_members WHERE teamId=?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, teamId);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                int userId = resultSet.getInt("userId");
	                // Retrieve User objects based on userId and add to teamMembers list
	                User user = getUserById(userId); // You need to implement this method
	                if (user != null) {
	                    teamMembers.add(user);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return teamMembers;
		}

		@Override
		public boolean addTeamMember(int teamId, User user) {
			String query = "INSERT INTO team_members (teamId, userId) VALUES (?, ?)";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, teamId);
	            preparedStatement.setInt(2, user.getUserId());
	            
	            int rowsAffected = preparedStatement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
		}

		@Override
		public boolean removeTeamMember(int teamId, User user) {
			String query = "DELETE FROM team_members WHERE teamId=? AND userId=?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, teamId);
	            preparedStatement.setInt(2, user.getUserId());
	            
	            int rowsAffected = preparedStatement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
		}

		

		
		
		

	
}
