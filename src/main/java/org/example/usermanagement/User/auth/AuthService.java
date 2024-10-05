package org.example.usermanagement.User.auth;

import org.example.usermanagement.User.auth.dtos.AuthLoginRequest;
import org.example.usermanagement.User.auth.dtos.AuthRegisterRequest;
import org.example.usermanagement.User.auth.dtos.AuthResponse;
import org.example.usermanagement.User.domain.User;
import org.example.usermanagement.User.infrastructure.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Registro de usuario
    public AuthResponse register(AuthRegisterRequest registerRequest) {
        // Verificamos si el email ya está en uso
        if (userRepository.findByEmail(registerRequest.getEmail()) != null) {
            throw new RuntimeException("Email already in use");
        }

        User user = new User();
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword()); // Sin encriptar
        user.setPhoneNumber(registerRequest.getPhoneNumber());

        User savedUser = userRepository.save(user);

        AuthResponse response = new AuthResponse();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        return response;
    }

    // Login de usuario
    public AuthResponse login(AuthLoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getUsername());
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        // Comparamos la contraseña sin encriptar
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        AuthResponse response = new AuthResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        return response;
    }
}
