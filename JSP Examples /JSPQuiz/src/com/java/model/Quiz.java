package com.java.model;

public class Quiz {
	private int question;
    private int answernum;
    private int score;

    private static String[] questions = {
        "3,1,4,5",
        "1,1,2,3,5",
        "1,4,9,16,25",
        "2,3,5,7,11",
        "1,2,4,8,16"
    };

    private static int[] answers = {9, 8, 36, 13, 32};

    public Quiz() {
        question = 0;
        answernum = 0;
        score = 0;
    }

    public String getQuestion() {
        return questions[question++];
    }

    public boolean isCompleted() {
        return question == questions.length;
    }

    public void isCorrect(String answer) {
        int ans = Integer.parseInt(answer);

        if (answers[answernum] == ans) {
            score++;
        }

        answernum++;
    }

    public int getScore() {
        return score;
    }

}
