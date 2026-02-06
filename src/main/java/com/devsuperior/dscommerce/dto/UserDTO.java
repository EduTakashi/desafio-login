package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String birthDate;
    private String password;

    private List<String> roles = new ArrayList<>();

    private UserDTO(){}

    public UserDTO(User entity){
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        phone = entity.getPhone();
        birthDate = entity.getBirthDate().toString();
        password = entity.getPassword();
        entity.getRoles().forEach(role -> this.roles.add(role.getAuthority()));
    }

    public Long getId() {
        return id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
