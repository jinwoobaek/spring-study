package com.jinwoo.springstudy.controller;

import com.jinwoo.springstudy.dto.PostSaveRequestDto;
import com.jinwoo.springstudy.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor // Lombok
public class PostController {

    private PostService postService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/post")
    public Long savePost(@RequestBody PostSaveRequestDto dto){
        return postService.save(dto);
    }
}
