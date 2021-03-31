package com.codessquad.qna.repository;

import com.codessquad.qna.domain.Question;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionRepository {
    List<Question> questions = new ArrayList<>();

    public void save(Question question) {
        question.setIndex(questions.size() + 1);
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Question findByIndex(int index) {

        return questions.get(index - 1);
    }
}
