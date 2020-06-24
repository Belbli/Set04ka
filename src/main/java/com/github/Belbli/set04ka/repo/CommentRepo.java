package com.github.Belbli.set04ka.repo;

import com.github.Belbli.set04ka.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
