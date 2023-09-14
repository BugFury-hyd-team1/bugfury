package com.project.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {
    private int projectId;
    private String projectName;
    private String description;
    private Date startDate;
    private ProjectStatus status;
    private List<User> teamMembers;

    // Constructor
    public Project(int projectId, String projectName, String description, Date startDate, ProjectStatus status) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.description = description;
        this.startDate = startDate;
        this.status = status;
        this.teamMembers = new ArrayList<>();
    }

    // Getters and setters
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public List<User> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<User> teamMembers) {
        this.teamMembers = teamMembers;
    }

    // Add a team member to the project
    public void addTeamMember(User user) {
        teamMembers.add(user);
    }

    // Remove a team member from the project
    public void removeTeamMember(User user) {
        teamMembers.remove(user);
    }

    // Enum to represent project status (In-progress or completed)
    public enum ProjectStatus {
        IN_PROGRESS, COMPLETED
    }
}
