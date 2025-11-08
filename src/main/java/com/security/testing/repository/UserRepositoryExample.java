package com.security.testing.repository;

import com.security.testing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Приклад вирішення SQL-Injection
 */
public interface UserRepositoryExample extends JpaRepository<User, Long> {

}
