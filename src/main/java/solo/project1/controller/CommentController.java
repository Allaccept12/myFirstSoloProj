package solo.project1.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import solo.project1.domain.Comment;
import solo.project1.dto.CommentRequestDto;
import solo.project1.dto.CommentResponseDto;
import solo.project1.service.CommentService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment/{postId}")
    public String createCommentForm(Model model, @PathVariable String postId) {
        model.addAttribute("comments",new CommentRequestDto());
        return "comment/createCommentForm";
    }

    @PostMapping("/comment")
    public String createComment(@Validated @ModelAttribute("comments") CommentRequestDto commentRequestDto,
                                @RequestParam("postId") Long postId,
                                BindingResult result) {
        if(result.hasErrors()) {
            return "comment/createCommentForm";
        }
        commentService.createComment(commentRequestDto, postId);
        return "redirect:/";
    }

    @GetMapping("/comment/{commentId}/edit")
    public String updateCommentForm(@PathVariable Long commentId, Model model) {
        Comment comment = commentService.findById(commentId);
        CommentResponseDto commentResponseDto = CommentResponseDto.builder()
                .content(comment.getContent())
                .build();
        model.addAttribute("comment",commentResponseDto);
        return "comment/updateComment";
    }

    @PostMapping("/comment/{commentId}/edit")
    public String updateComment(@PathVariable Long commentId,
                                @Valid @ModelAttribute("comment") CommentResponseDto comment,
                                BindingResult result) {
        if(result.hasErrors()){
            return "comment/updateComment";
        }
        commentService.updateComment(comment,commentId);
        return "redirect:/";
    }


}















