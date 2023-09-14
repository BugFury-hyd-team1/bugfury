package com.project.Dao;

import java.util.List;

import com.project.bean.Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {
	 private Connection connection; // Initialize this connection

	    public ProjectDAOImpl(Connection connection) {
	        this.connection = connection;
	    }

	@Override
	public Project getProjectById(int projectId) {
		 String query = "SELECT * FROM projects WHERE projectId=?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, projectId);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                return extractProjectFromResultSet(resultSet);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	}

	private Project extractProjectFromResultSet(ResultSet resultSet) throws SQLException {
		 int projectId = resultSet.getInt("projectId");
	        String projectName = resultSet.getString("projectName");
	        String description = resultSet.getString("description");
	        java.sql.Date startDate = resultSet.getDate("startDate");
	        Project.ProjectStatus status = Project.ProjectStatus.valueOf(resultSet.getString("status"));
	        
	        return new Project(projectId, projectName, description, startDate, status);
	    }
			

	@Override
	public List<Project> getAllProjects() {
		 List<Project> projectList = new ArrayList<>();
	        String query = "SELECT * FROM projects";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
	             ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	                projectList.add(extractProjectFromResultSet(resultSet));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return projectList;
	}

	@Override
	public boolean addProject(Project project) {
		String query = "INSERT INTO projects (projectName, description, startDate, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setDate(3, new java.sql.Date(project.getStartDate().getTime()));
            preparedStatement.setString(4, project.getStatus().toString());
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public boolean updateProject(Project project) {
		String query = "UPDATE projects SET projectName=?, description=?, startDate=?, status=? WHERE projectId=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setDate(3, new java.sql.Date(project.getStartDate().getTime()));
            preparedStatement.setString(4, project.getStatus().toString());
            preparedStatement.setInt(5, project.getProjectId());
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public boolean deleteProject(int projectId) {
		 String query = "DELETE FROM projects WHERE projectId=?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, projectId);
	            int rowsAffected = preparedStatement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
		
	}


	

}
