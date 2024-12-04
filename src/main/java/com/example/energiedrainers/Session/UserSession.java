package com.example.energiedrainers.Session;

public class UserSession {
    private static UserSession instance;

    private String username;  // Add other fields as needed
    private String email;

    private UserSession(String username, String email)
    {
        this.username = username;
        this.email = email;
    }

    // Singleton instance getter
    public static UserSession getInstance(String username, String email) {
        if (instance == null) {
            instance = new UserSession(username, email);
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

