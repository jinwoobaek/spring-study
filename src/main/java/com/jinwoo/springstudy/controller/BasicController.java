package com.jinwoo.springstudy.controller;

import com.jinwoo.springstudy.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class BasicController {

    private PostService postService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("post", postService.findAllDesc());
        return "main";
    }
}
