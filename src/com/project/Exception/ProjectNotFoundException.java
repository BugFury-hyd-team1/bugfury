package com.project.Exception;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(int projectId) {
        super("Project with ID " + projectId + " not found");
    }
}
