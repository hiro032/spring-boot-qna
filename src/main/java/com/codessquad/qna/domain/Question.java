package com.codessquad.qna.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    private int index;
    private String title;
    private String writer;
    private String contents;

    protected Question() {

    }

    public Question(String title, String writer, String contents) {
        this.title = title;
        this.writer = writer;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public String getContents() {
        return contents;
    }

    public int getIndex() {
        return index;
    }

    public Long getId() {
        return id;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
