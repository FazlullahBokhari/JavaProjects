package com.blog.repository;

import com.blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // Additional custom queries or methods can be defined here if needed
}
