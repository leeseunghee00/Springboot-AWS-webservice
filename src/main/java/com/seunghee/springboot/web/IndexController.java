package com.seunghee.springboot.web;

import com.seunghee.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor    //final이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성해주는 롬복 어노테이션
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {  //Model = 서버 템플릿에서 사용할 수 잇는 객체를 저장할 수 있다.
        model.addAttribute("posts", postsService.findALlDsec());
        return "index";     //index.mustache로 반환되어 view resolver가 처리하게 된다.
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
