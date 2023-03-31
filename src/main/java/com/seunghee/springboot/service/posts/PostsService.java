package com.seunghee.springboot.service.posts;

import com.seunghee.springboot.domain.posts.Posts;
import com.seunghee.springboot.domain.posts.PostsRepository;
import com.seunghee.springboot.web.dto.PostsListResponseDto;
import com.seunghee.springboot.web.dto.PostsResponseDto;
import com.seunghee.springboot.web.dto.PostsSaveRequestDto;
import com.seunghee.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor    //기본 생성자를 생성한다.
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional  //작업처리 중 하나라도 실패 시 롤백된다.
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).
                getId();
    }

    /**
     * DB에 쿼리를 날리지 않아도 되는 이유 ? JPA의 영속성 컨텍스트 때문 !
     * 영속성 컨텍스트란, 엔티티를 영구 저장하는 환경을 말한다.
     */
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)     //조회 기능만 가능 -> 조회 속도가 개선되기 때문에 조회 서비스만 사용할 때 사용하는 것이 좋다.
    public List<PostsListResponseDto> findALlDsec() {
        /**
         * postsRepository 결과로 넘어온 Posts의 stream을
         * map을 통해 PostsListResponseDto 변환 (= .map(posts -> new PostsListResponseDto(posts)))
         * List로 반환하는 메소드
         */
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
