package com.oryanend.checker.entities;

import java.util.Map;

public class Answer {
    private Map<String, String> answers;
    private Boolean isSameAnswer;

    public Answer() {
    }

    public Answer(Map<String, String> answers, Boolean isSameAnswer) {
        this.answers = answers;
        this.isSameAnswer = isSameAnswer;
    }

    public Map<String, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, String> answers) {
        this.answers = answers;
    }

    public Boolean getSameAnswer() {
        return isSameAnswer;
    }

    public void setSameAnswer(Boolean sameAnswer) {
        isSameAnswer = sameAnswer;
    }
}
