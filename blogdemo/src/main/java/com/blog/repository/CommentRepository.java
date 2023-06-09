package com.blog.repository;
import com.blog.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Additional custom queries or methods can be defined here if needed
}
