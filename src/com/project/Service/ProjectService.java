package com.project.Service;

import java.util.List;

import com.project.Exception.ProjectServiceException;
import com.project.bean.Project;

public interface ProjectService {
	Project getProjectById(int projectId)throws ProjectServiceException;
	List<Project> getAllProjects()throws ProjectServiceException;
	boolean addProject(Project project)throws ProjectServiceException;

	boolean deleteProject(int projectId)throws ProjectServiceException;

}
