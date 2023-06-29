package hr.algebra.dogsapi.dto;

import com.sun.istack.NotNull;

public class LoginUserDto {

    @NotNull
    public String username;

    @NotNull
    private String password;



    public LoginUserDto() {
    }

    public LoginUserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
