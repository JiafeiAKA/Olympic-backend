package com.camt.olympic.security.user;

public class AuthResponse {
    private String token;
    private String username;
    private long userId;


    public AuthResponse(String token, String username, long userId) {
        this.token = token;
        this.username = username;
        this.userId = userId;

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


}
