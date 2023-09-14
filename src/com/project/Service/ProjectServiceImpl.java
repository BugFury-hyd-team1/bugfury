package com.project.Service;

import java.util.List;

import com.project.Dao.ProjectDAO;
import com.project.Exception.ProjectNotFoundException;
import com.project.Exception.ProjectServiceException;
import com.project.bean.Project;

public class ProjectServiceImpl implements ProjectService {
	 private ProjectDAO projectDAO;

	    public ProjectServiceImpl(ProjectDAO projectDAO) {
	        this.projectDAO = projectDAO;
	    }


	@Override
	public Project getProjectById(int projectId) throws ProjectServiceException {
		 try {
	            Project project = projectDAO.getProjectById(projectId);
	            if (project == null) {
	                throw new ProjectNotFoundException(projectId);
	            }
	            return project;
	        } catch (Exception e) {
	            // Handle exceptions or log errors as needed
	            e.printStackTrace();
	            throw new ProjectServiceException();
	        }
	}

	@Override
	public List<Project> getAllProjects() throws ProjectServiceException {
		 try {
	            return projectDAO.getAllProjects();
	        } catch (Exception e) {
	            // Handle exceptions or log errors as needed
	            e.printStackTrace();
	            throw new ProjectServiceException();
	        }
	}

	@Override
	public boolean addProject(Project project) throws ProjectServiceException {
		try {
            // You can add validation logic here before calling the DAO
            // For example, check if the project name is unique
            List<Project> existingProjects = (List<Project>) projectDAO.getProjectById(project.getProjectId());
            if (existingProjects.isEmpty()) {
                return projectDAO.addProject(project);
            } else {
                throw new ProjectServiceException();
            }
        } catch (Exception e) {
            // Handle exceptions or log errors as needed
            e.printStackTrace();
            throw new ProjectServiceException();
        }
	}



	@Override
	public boolean deleteProject(int projectId) throws ProjectServiceException {
		 try {
	            // You can add additional logic here, such as checking if the project has associated tasks or team members
	            return projectDAO.deleteProject(projectId);
	        } catch (Exception e) {
	            // Handle exceptions or log errors as needed
	            e.printStackTrace();
	            throw new ProjectServiceException();
	        }
	}

}
