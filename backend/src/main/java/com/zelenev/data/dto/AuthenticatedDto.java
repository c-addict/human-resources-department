package com.zelenev.data.dto;

import java.util.Objects;

public class AuthenticatedDto {

    private String login;

    private String token;

    public AuthenticatedDto(String login, String token) {
        this.login = login;
        this.token = token;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthenticatedDto that = (AuthenticatedDto) o;
        return Objects.equals(login, that.login) && Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, token);
    }
}
