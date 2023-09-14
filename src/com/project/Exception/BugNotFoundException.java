package com.project.Exception;

public class BugNotFoundException extends RuntimeException {
    public BugNotFoundException(int bugId) {
        super("Bug with ID " + bugId + " not found");
    }
}

