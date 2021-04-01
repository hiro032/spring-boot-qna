package com.codessquad.qna.service;

import com.codessquad.qna.domain.Question;
import com.codessquad.qna.exception.NotFoundEntityException;
import com.codessquad.qna.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void post(Question question) {
        questionRepository.save(question);
    }

    public Question findById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException("유효하지 않는 Question id입니다"));
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }
}
