package com.project.bean;

import java.util.List;

public class Team {
    private int teamId;
    private User projectManager;
    private List<User> developers;
    private User tester;
    private String teamName;

   
	public Team(int teamId, User projectManager, List<User> developers, User tester) {
        this.teamId = teamId;
        this.projectManager = projectManager;
        this.developers = developers;
        this.tester = tester;
    }

    public Team(int teamId, String teamName) {
		this.teamId=teamId;
		this.teamName=teamName;
	}
    public Team() {
		// TODO Auto-generated constructor stub
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public User getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(User projectManager) {
        this.projectManager = projectManager;
    }

    public List<User> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<User> developers) {
        this.developers = developers;
    }

    public User getTester() {
        return tester;
    }

    public void setTester(User tester) {
        this.tester = tester;
    }
}
