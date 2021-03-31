package com.codessquad.qna.domain;

public class Question {

    private int index;
    private String title;
    private String writer;
    private String contents;

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

    public void setIndex(int index) {
        this.index = index;
    }
}
