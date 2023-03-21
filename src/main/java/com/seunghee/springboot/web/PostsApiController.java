package com.seunghee.springboot.web;

import com.seunghee.springboot.service.posts.PostsService;
import com.seunghee.springboot.web.dto.PostsResponseDto;
import com.seunghee.springboot.web.dto.PostsSaveRequestDto;
import com.seunghee.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor    //final로 선언된 필드의 생성자를 생성한다.
@RestController             //Json 형태로 데이터를 반환한다.
public class PostsApiController {
    private final PostsService postsService;

    /* save - @PostMapping */
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    /* update - @PutMapping */
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id,
                       @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    /* find - @GetMapping */
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
