package com.project.Exception;

public class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException(int teamId) {
        super("Team with ID " + teamId + " not found");
    }
}
