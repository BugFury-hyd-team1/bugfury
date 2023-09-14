package com.project.Exception;

public class RolesNotFoundException extends RuntimeException {
    public RolesNotFoundException(int rolesId) {
        super("Roles with ID " + rolesId + " not found");
    }
}
