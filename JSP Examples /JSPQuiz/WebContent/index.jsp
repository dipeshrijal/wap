<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Quiz</title>
</head>
<body>
 <div class="form-wrapper">
            <h1>Number Quiz.</h1>

            <form action="" method="POST">

                <div>
                    <label>Your Age: <input type="text" name="age"></label>
                    <p class="error"></p>
                </div>

                <p>Your current score is ${quiz.score}.</p>

                <p>Guess the next number in the sequence!</p>

                <p>${quiz.getQuestion()},<span class="guess">?</span></p>

                <div>
                    <label>Your answer: <input type="text" name="answer"></label>
                </div>

                <div>
                    <input type="submit" value="Next">
                </div>
            </form>
        </div>
    </body>
    <style>
        .form-wrapper {
            border: 2px solid black;
            padding: 10px;
            width: 30%;            
        }
        .guess {
            color:red;
            font-weight: bold;
        } 
        .error {
            color:red;
        }
    </style>
</html>