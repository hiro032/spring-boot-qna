package com.codessquad.qna.service;

import com.codessquad.qna.domain.Question;
import com.codessquad.qna.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void registerQuestion(Question question) {
        questionRepository.save(question);
    }

    public List<Question> findQuestions(){

        return (List)questionRepository.findAll();
    }

    public Optional<Question> findQuestion(Long id){

        return questionRepository.findById(id);
    }

    public void delete(Long id) {

        questionRepository.deleteById(id);
    }
}
