package org.example.usermanagement.User.infrastructure;

import org.example.usermanagement.User.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
