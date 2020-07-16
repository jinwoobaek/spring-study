package com.jinwoo.springstudy.service;

import com.jinwoo.springstudy.dto.PostSaveRequestDto;
import com.jinwoo.springstudy.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PostService {

    private PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto dto){
        return postRepository.save(dto.toEntity()).getId();
    }
}
