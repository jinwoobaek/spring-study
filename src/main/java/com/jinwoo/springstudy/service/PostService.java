package com.jinwoo.springstudy.service;

import com.jinwoo.springstudy.dto.PostMainResponseDto;
import com.jinwoo.springstudy.dto.PostSaveRequestDto;
import com.jinwoo.springstudy.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostService {

    private PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto dto) {
        return postRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true) // 읽기 전용 설정을 통해 속도 향상, CUD 에서는 적용 X, 오로지 R만
    public List<PostMainResponseDto> findAllDesc() {
        return postRepository.findAllDesc()
                .map(PostMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
