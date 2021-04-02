package com.codessquad.qna.controller;

import com.codessquad.qna.domain.Question;
import com.codessquad.qna.service.QuestionService;
import com.codessquad.qna.utill.HttpSessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public String createQuestion(Question question, HttpSession session) {
        HttpSessionUtils.getLoginUser(session);
        questionService.post(question);

        return "redirect:/";
    }

    @GetMapping
    public String showQuestions(Model model) {
        model.addAttribute("questions", questionService.findAll());
        return "/index";
    }

    @GetMapping("/{id}")
    public String showQuestion(@PathVariable Long id, Model model) {
        model.addAttribute("question", questionService.findById(id));

        return "/qna/show";
    }

    @GetMapping("/{id}/form")
    public String getUpdateForm(@PathVariable Long id, Model model, HttpSession session) {
        HttpSessionUtils.getLoginUser(session);
        model.addAttribute("question", questionService.findById(id));

        return "qna/updateForm";
    }

    @PostMapping("/{id}")
    public String updateQuestion(@PathVariable Long id, Question updateQuestion) {
        Question question = questionService.findById(id);
        questionService.post(question.updateQuestion(updateQuestion));

        return "redirect:/";
    }

}
