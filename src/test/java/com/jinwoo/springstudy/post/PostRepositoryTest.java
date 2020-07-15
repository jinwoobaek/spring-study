package com.jinwoo.springstudy.post;

import com.jinwoo.springstudy.entity.Post;
import com.jinwoo.springstudy.repository.PostRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @After
    public void cleanup() {

        postRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        postRepository.save(Post.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("jinwoo@gmail.com")
                .build());

        //when
        List<Post> postList = postRepository.findAll();

        //then
        Post post = postList.get(0);
        assertThat(post.getTitle(), is("테스트 게시글"));
        assertThat(post.getContent(), is("테스트 본문"));
    }

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.now();
        postRepository.save(Post.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("back3946@gmail.com")
                .build());
        //when
        List<Post> postsList = postRepository.findAll();

        //then
        Post posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
}
