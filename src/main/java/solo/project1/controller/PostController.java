package solo.project1.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import solo.project1.domain.Account;
import solo.project1.dto.CreatePostRequestDto;
import solo.project1.dto.PostDetailResponseDto;
import solo.project1.dto.PostListResponseDto;
import solo.project1.dto.UpdatePostRequestDto;
import solo.project1.service.PostService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;

    @GetMapping("/post/new")
    public String createPostForm(Model model) {
        model.addAttribute("post",new CreatePostRequestDto());
        return "post/createPost";
    }

    @PostMapping("/post/new")
    public String createPost(@Valid @ModelAttribute("post") CreatePostRequestDto postRequestDto,
                             BindingResult result) {
        if(result.hasErrors()){
            return "post/createPost";
        }
        postService.createPost(postRequestDto);
        return "redirect:/";
    }

    @GetMapping("/posts")
    public String viewPosts(Model model) {
        List<Account> allPost = postService.findAll();
        model.addAttribute("posts", allPost.stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList()));
        return "post/viewPosts";
    }

    @GetMapping("/post/{postId}/view")
    public String viewPost(@PathVariable Long postId,Model model) {
        List<Account> findPost = postService.findByPost(postId);
        model.addAttribute("post", findPost.stream()
                .map(PostDetailResponseDto::new)
                .collect(Collectors.toList()));
        return "post/viewDetailPost";
    }

    @GetMapping("/post/{postId}/edit")
    public String updatePostForm(@PathVariable Long postId, Model model) {
        Account post = postService.findById(postId);
        PostListResponseDto postDto = PostListResponseDto.builder()
                .post(post)
                .build();
        model.addAttribute("post",postDto);
        return "post/updatePost";
    }
    @PostMapping("/post/{postId}/edit")
    public String updatePost(@PathVariable Long postId, @Valid @ModelAttribute("post") UpdatePostRequestDto updatePostRequestDto, BindingResult result) {
        if(result.hasErrors()){
            return "post/updatePost";
        }
        postService.updatePost(postId,updatePostRequestDto);
        return "redirect:/posts";
    }




}
