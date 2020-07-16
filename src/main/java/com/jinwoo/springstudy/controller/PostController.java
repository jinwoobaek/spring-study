package com.jinwoo.springstudy.controller;

import com.jinwoo.springstudy.dto.PostSaveRequestDto;
import com.jinwoo.springstudy.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PostController {

    private PostRepository postRepository;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld Test_sub_asdf";
    }

    @PostMapping("/post")
    public void savePost(@RequestBody PostSaveRequestDto dto){
        postRepository.save(dto.toEntity());
    }
}
