package com.zelenev.data.dto;

import java.util.Objects;

public class LoginDto {

    private String login;

    private String password;

    public LoginDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginDto loginDto = (LoginDto) o;
        return Objects.equals(login, loginDto.login) && Objects.equals(password, loginDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
