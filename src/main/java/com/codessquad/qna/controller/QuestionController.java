package com.codessquad.qna.controller;

import com.codessquad.qna.domain.Question;
import com.codessquad.qna.repository.QuestionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionRepository questionRepository;

    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @PostMapping
    public String createQuestion(String title, String contents, String writer) {
        Question question = new Question(title, writer, contents);
        questionRepository.save(question);
        System.out.println(questionRepository.getQuestions().toString());
        return "redirect:/";
    }

    @GetMapping
    public String showQuestions(Model model) {
        model.addAttribute("questions", questionRepository.getQuestions());

        return "/index";
    }

}
