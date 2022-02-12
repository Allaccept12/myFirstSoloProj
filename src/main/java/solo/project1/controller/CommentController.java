package solo.project1.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import solo.project1.domain.Account;
import solo.project1.domain.Comment;
import solo.project1.dto.CommentRequestDto;
import solo.project1.dto.CommentResponseDto;
import solo.project1.repository.CommentRepository;
import solo.project1.repository.PostRepository;
import solo.project1.service.CommentService;
import solo.project1.service.PostService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment/{postId}")
    public String createCommentForm(Model model, @PathVariable Long postId) {
        model.addAttribute("comments",new CommentRequestDto());
        return "comment/createCommentForm";
    }

    @PostMapping("/comment")
    public String createComment(@Valid @ModelAttribute("comments") CommentRequestDto commentRequestDto,
                                @RequestParam("postId") Long postId,
                                BindingResult result) {
        if (result.hasErrors()) {
            return "comment/createCommentForm";
        }
        commentService.createComment(commentRequestDto, postId);
        return "redirect:/";
    }

}















