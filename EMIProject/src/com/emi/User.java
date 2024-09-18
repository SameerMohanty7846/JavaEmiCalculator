package com.emi;

public class User {
    private String userId;
    private String name;
    private boolean isAdmin;

    // Private constructor to prevent direct object creation
    private User(String userId, String name, boolean isAdmin) {
        this.userId = userId;
        this.name = name;
        this.isAdmin = isAdmin;
    }

    // Helper method for creating User objects
    public static User createUser(String userId, String name, boolean isAdmin) {
        return new User(userId, name, isAdmin);
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name + ", Is Admin: " + isAdmin;
    }
}
