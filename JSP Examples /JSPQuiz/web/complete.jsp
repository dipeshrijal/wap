<%-- 
    Document   : complete
    Created on : Aug 1, 2017, 4:17:53 PM
    Author     : dipesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Number Quiz</title>
    </head>
    <div class="form-wrapper">
            <h1>Number Quiz.</h1>

            <p class="guess">Your total score is ${quiz.score}.</p>
            <p class="guess">Your grade is ${quiz.computeGrade()}</p>
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
