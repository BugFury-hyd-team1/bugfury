package com.project.Dao;

import java.util.List;

import com.project.bean.Project;

public interface ProjectDAO {
    Project getProjectById(int projectId);
    List<Project> getAllProjects();
    boolean addProject(Project project);
    boolean updateProject(Project project);
    boolean deleteProject(int projectId);
	
}
