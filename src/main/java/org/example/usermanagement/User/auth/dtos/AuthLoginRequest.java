package org.example.usermanagement.User.auth.dtos;

import lombok.Data;

@Data
public class AuthLoginRequest {
    public String username;
    public String password;
}
