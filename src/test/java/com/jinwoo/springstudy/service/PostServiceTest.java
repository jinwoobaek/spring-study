package com.jinwoo.springstudy.service;

import com.jinwoo.springstudy.dto.PostMainResponseDto;
import com.jinwoo.springstudy.dto.PostSaveRequestDto;
import com.jinwoo.springstudy.entity.Post;
import com.jinwoo.springstudy.repository.PostRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @After
    public void cleanup() {

        postRepository.deleteAll();

    }

    @Test
    public void Dto데이터가_post테이블에_저장된다() {
        //given
        PostSaveRequestDto dto = PostSaveRequestDto.builder()
                .author("jinwoo@gmail.com")
                .content("테스트")
                .title("테스트 타이틀")
                .build();

        //when
        postService.save(dto);

        //then
        Post post = postRepository.findAll().get(0);
        assertThat(post.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(post.getContent()).isEqualTo(dto.getContent());
        assertThat(post.getTitle()).isEqualTo(dto.getTitle());
    }

    @Test
    public void 조회_쿼리_결과값_확인() {
        //when
        List<PostMainResponseDto> dtoList = postService.findAllDesc();

        //then
        Assert.assertThat(dtoList.get(0).getTitle(), is("테스트2"));
        Assert.assertThat(dtoList.get(1).getTitle(), is("테스트1"));
    }
}