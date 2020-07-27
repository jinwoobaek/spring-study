package com.jinwoo.springstudy.web;

import com.jinwoo.springstudy.config.auth.LoginUser;
import com.jinwoo.springstudy.config.auth.dto.SessionUser;
import com.jinwoo.springstudy.service.posts.PostsService;
import com.jinwoo.springstudy.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;


@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAll()); // findAll로 가져온걸 "posts" 라는 이름으로 넘김 (템플릿 엔진에서 사용할 수 있는 객체로 저장)

//        SessionUser user = (SessionUser) httpSession.getAttribute("user"); // @LoginUser를 생성해 주어서 해당 코드가 필요없다

        if (user != null) {
            System.out.println(user.getName());
            System.out.println(user.getEmail());
            System.out.println(user.getPicture());
            model.addAttribute("googleUserName", user.getName()); // "userName" 변수명은 윈도우 환경변수명 %USERNAME%로 인해 오류
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";

    }
}
