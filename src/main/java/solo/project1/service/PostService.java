package solo.project1.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solo.project1.domain.Account;
import solo.project1.dto.CreatePostRequestDto;
import solo.project1.dto.UpdatePostRequestDto;
import solo.project1.repository.CommentRepository;
import solo.project1.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void createPost(CreatePostRequestDto postRequestDto) {
        Account post = Account.builder()
                .title(postRequestDto.getTitle())
                .name(postRequestDto.getName())
                .content(postRequestDto.getContent())
                .build();
        postRepository.save(post);

    }

    public List<Account> findAll() {
        return Optional.of(postRepository.findAll()).orElseThrow(NullPointerException::new);
    }

    public List<Account> findByPost(Long postId) {
        return postRepository.findPostWithAllComment(postId).orElseThrow(NullPointerException::new);
    }

    @Transactional
    public void updatePost(Long postId, UpdatePostRequestDto updatePostRequestDto) {
        Account post = postRepository.findById(postId).orElseThrow(NullPointerException::new);
        post.updatePost(updatePostRequestDto);
    }
    @Transactional
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    public Account findById(Long postId) {
        return postRepository.findById(postId).orElseThrow(NullPointerException::new);
    }


}
