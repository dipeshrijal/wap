<%-- 
    Document   : index
    Created on : Jul 31, 2017, 5:12:18 PM
    Author     : dipesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Number Quiz</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="form-wrapper">
            <h1>Number Quiz.</h1>
            
            <p class="guess">${errorAll}</p>

            <form action="" method="POST">

                <div>
                    <label>Your Age: <input type="text" name="age" value="${age}"></label>
                    <p class="guess">${error}</p>
                </div>

                <p>Your current score is ${quiz.score}.</p>
                
                <p>Attempts: ${quiz.attempts} / 3</p>

                <p>Guess the next number in the sequence!</p>

                <p>${quiz.getQuestion()},<span class="guess">?</span></p>

                <div>
                    <label>Your answer: <input type="text" name="answer"></label>
                    <p class="guess">${message}</p>
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
        }
    </style>
</html>

