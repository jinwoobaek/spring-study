package com.jinwoo.springstudy.repository;

import com.jinwoo.springstudy.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}