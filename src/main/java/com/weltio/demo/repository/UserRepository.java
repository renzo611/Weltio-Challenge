package com.weltio.demo.repository;

import com.weltio.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    boolean existsByEmail(String email);
    Users findByEmail(String email);
}
