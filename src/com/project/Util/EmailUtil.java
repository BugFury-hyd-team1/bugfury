package com.project.Util;

import java.util.regex.Pattern;

public class EmailUtil {
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }

    // Add more email-related utility methods here
}
