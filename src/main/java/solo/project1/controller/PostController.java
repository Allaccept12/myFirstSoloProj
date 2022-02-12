package solo.project1.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import solo.project1.domain.Account;
import solo.project1.dto.CreatePostRequestDto;
import solo.project1.dto.PostResponseDto;
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
    public String createPost(@Valid @ModelAttribute("post") CreatePostRequestDto postRequestDto, BindingResult result) {
        if(result.hasErrors()){
            return "post/createPost";
        }
        postService.createPost(postRequestDto);
        return "redirect:/";
    }

    @GetMapping("/posts")
    public String viewPost(Model model) {
        List<Account> allPost = postService.findAll();
        log.info("확인");
        model.addAttribute("posts", allPost.stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList()));
        return "post/viewPosts";
    }





}
