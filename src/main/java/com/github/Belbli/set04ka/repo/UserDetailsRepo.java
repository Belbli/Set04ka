package com.github.Belbli.set04ka.repo;

import com.github.Belbli.set04ka.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}
