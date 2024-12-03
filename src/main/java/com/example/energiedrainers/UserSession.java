package com.example.energiedrainers;

public class UserSession {
    private static UserSession instance;

    private String username;  // Add other fields as needed

    private UserSession(String username) {
        this.username = username;
    }

    // Singleton instance getter
    public static UserSession getInstance(String username) {
        if (instance == null) {
            instance = new UserSession(username);
        }
        return instance;
    }

    // Clear the session
    public static void clearSession() {
        instance = null;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }
}

