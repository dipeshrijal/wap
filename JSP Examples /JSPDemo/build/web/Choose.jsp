<%-- 
    Document   : Choose
    Created on : Aug 1, 2017, 8:57:53 PM
    Author     : dipesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choose</title>
    </head>
    <body>
        <form method='post' action='ChooseServlet'>
            <p>Is JSP cool?</p>
            <input type='radio' value='1' ${firstchoice.getYesCheck()} name='radioJSPCool'><span>Yes</span><br/>
            <input type='radio' value='0' ${firstchoice.getNoCheck()} name='radioJSPCool'><span>No</span><br/>
            <input type='submit' name='btnSubmit' value='Submit'/>
            <p>Is JSF way cool?</p>
            <input type='radio' value='1' ${secondchoice.getYesCheck()} name='JSFwayCool'><span>Yes</span><br/>
            <input type='radio' value='0' ${secondchoice.getNoCheck()} name='JSFwayCool'><span>No</span><br/>
            <input type='submit' name='btnSubmit' value='Submit'/>
            <p>Is the moon made of cheese?</p>
            <input type='radio' value='1' ${thirdchoice.getYesCheck()} name='moonCheese'><span>Yes</span><br/>
            <input type='radio' value='0' ${thirdchoice.getNoCheck()} name='moonCheese'><span>No</span><br/>
            <input type='submit' name='btnSubmit' value='Submit'/>
        </form>
    </body>
</html>
