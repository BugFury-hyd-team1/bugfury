package com.project.Dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.bean.Bug;


public class BugDAOImpl implements BugDAO {
    private Connection connection; // Initialize this connection

    public BugDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Bug getBugById(int bugId) {
        String query = "SELECT * FROM bugs WHERE bugId=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, bugId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return extractBugFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	private Bug extractBugFromResultSet(ResultSet resultSet)throws SQLException {
		 int bugId = resultSet.getInt("bugId");
	        String description = resultSet.getString("description");
	        Bug.BugStatus status = Bug.BugStatus.valueOf(resultSet.getString("status"));
	        Bug.BugSeverity severity = Bug.BugSeverity.valueOf(resultSet.getString("severity"));
	        Bug.BugPriority priority = Bug.BugPriority.valueOf(resultSet.getString("priority"));
	        int reportedById = resultSet.getInt("reportedBy");
	        int assignedToId = resultSet.getInt("assignedTo");
	        Date createdDate = resultSet.getDate("createdDate");
	        Date lastUpdatedDate = resultSet.getDate("lastUpdatedDate");
	        Date dueDate = resultSet.getDate("dueDate");
	        String comments = resultSet.getString("comments");
	        
	        // You should retrieve User objects for reportedBy and assignedTo based on their IDs
	        
	        return new Bug(bugId, description, status, severity, priority, null, null, createdDate, lastUpdatedDate, dueDate, comments);
	}

	@Override
	public List<Bug> getAllBugs() {
		 List<Bug> bugList = new ArrayList<>();
	        String query = "SELECT * FROM bugs";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
	             ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	                bugList.add(extractBugFromResultSet(resultSet));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return bugList;
	}

	@Override
	public boolean addBug(Bug bug) {
		String query = "INSERT INTO bugs (description, status, severity, priority, reportedBy, assignedTo, " +
                "createdDate, lastUpdatedDate, dueDate, comments) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, bug.getDescription());
            preparedStatement.setString(2, bug.getStatus().toString());
            preparedStatement.setString(3, bug.getSeverity().toString());
            preparedStatement.setString(4, bug.getPriority().toString());
            preparedStatement.setInt(5, bug.getReportedBy().getUserId());
            preparedStatement.setInt(6, bug.getAssignedTo().getUserId());
            preparedStatement.setDate(7, new java.sql.Date(bug.getCreatedDate().getTime()));
            preparedStatement.setDate(8, new java.sql.Date(bug.getLastUpdatedDate().getTime()));
            preparedStatement.setDate(9, (bug.getDueDate() != null) ? new java.sql.Date(bug.getDueDate().getTime()) : null);
            preparedStatement.setString(10, bug.getComments());
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

	}

	@Override
	public boolean updateBug(Bug bug) {
		  String query = "UPDATE bugs SET description=?, status=?, severity=?, priority=?, reportedBy=?, assignedTo=?, " +
	                "createdDate=?, lastUpdatedDate=?, dueDate=?, comments=? WHERE bugId=?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, bug.getDescription());
	            preparedStatement.setString(2, bug.getStatus().toString());
	            preparedStatement.setString(3, bug.getSeverity().toString());
	            preparedStatement.setString(4, bug.getPriority().toString());
	            preparedStatement.setInt(5, bug.getReportedBy().getUserId());
	            preparedStatement.setInt(6, bug.getAssignedTo().getUserId());
	            preparedStatement.setDate(7, new java.sql.Date(bug.getCreatedDate().getTime()));
	            preparedStatement.setDate(8, new java.sql.Date(bug.getLastUpdatedDate().getTime()));
	            preparedStatement.setDate(9, (bug.getDueDate() != null) ? new java.sql.Date(bug.getDueDate().getTime()) : null);
	            preparedStatement.setString(10, bug.getComments());
	            preparedStatement.setInt(11, bug.getBugId());
	            
	            int rowsAffected = preparedStatement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	}

	@Override
	public boolean deleteBug(int bugId) {
		 String query = "DELETE FROM bugs WHERE bugId=?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, bugId);
	            int rowsAffected = preparedStatement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	   
	}

    

