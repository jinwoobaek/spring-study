package com.jinwoo.springstudy.repository;

import com.jinwoo.springstudy.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface PostRepository extends JpaRepository<Post, Long> {

    /*
    * 실제로 위 코드는 SpringDataJpa에서 제공하는 기본 메소드만으로 해결할 수 있지만,
    * 굳이 @Query를 쓴 이유는, SpringDataJpa에서 제공하지 않는 메소드는
    * 위처럼 쿼리로 작성해도 되는것을 보여주기 위함
    */
    @Query("SELECT p " +
            "FROM Post p " +
            "ORDER BY p.id DESC")
    Stream<Post> findAllDesc();

}