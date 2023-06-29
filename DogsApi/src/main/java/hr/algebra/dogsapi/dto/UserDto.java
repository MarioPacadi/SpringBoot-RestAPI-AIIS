package hr.algebra.dogsapi.dto;

import hr.algebra.dogsapi.models.Account;

public class UserDto {

    private Long id;

    private String username;

    private String password;

    private String email;

    private int roleId;

    public UserDto() {
    }

    public UserDto(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Account getUser(){
        return new Account(this.id,this.username,this.password,this.email,this.roleId);
    }
}
