/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.model;

/**
 *
 * @author dipesh
 */
public class Quiz {

    private int count;
    private int attempts;
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
        count = 0;
        attempts = 0;
        score = 0;
    }

    public String getQuestion() {
        return questions[count];
    }

    public boolean isCompleted() {
        return count == questions.length;
    }

    public String isCorrect(String answer) {
        int ans = Integer.parseInt(answer);
        
        String message = null;
        
        attempts++;

        if (attempts == 1) {
            if (answers[count] == ans) {
                score += 10;
                count++;
                attempts = 0;
            } else {
                return "You have 2 attempts left";
            }
            
            
        }

        if (attempts == 2) {
            if (answers[count] == ans) {
                score += 5;
                count++;
                attempts = 0;
            }
            
            else {
                return "You have 1 attempts left";
            }
        }

        if (attempts == 3) {
            if (answers[count] == ans) {
                score += 2;
            }
            message = "The answer was " + answers[count] + ".";
            count++;
            attempts = 0;  
        }
        return message;
    }

    public int getScore() {
        return score;
    }
    
    public int getAttempts() {
        return attempts;
    }
    
    public boolean isValidAge(String age) {
        int valid = Integer.parseInt(age);
        
        return valid > 4 && valid < 100;
    }
    
    public String computeGrade() {
        if (score >= 45)  return "A";
        else if(score >=35 && score <= 44) return "B";
        else if(score >=25 && score <= 34) return "C";
        else return "NC";
    }

}
