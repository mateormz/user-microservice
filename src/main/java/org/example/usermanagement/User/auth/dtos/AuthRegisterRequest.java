package org.example.usermanagement.User.auth.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthRegisterRequest {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String phoneNumber;
}
