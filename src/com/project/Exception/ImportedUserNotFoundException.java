package com.project.Exception;

public class ImportedUserNotFoundException extends RuntimeException {
    public ImportedUserNotFoundException(int importedUserId) {
        super("Imported User with ID " + importedUserId + " not found");
    }
}