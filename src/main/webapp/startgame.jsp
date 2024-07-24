<%@ page import="java.util.List" %>
<%@ page import="model.Quiz" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Game</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
        }

        h1{
            text-align:center;
            margin:40px 0px;
        }
        .question {
            margin:30px 0px;
        }
        .question h3 {
            margin: 0;
        }
        .answers{
            margin:10px 0px;
        }
        .answers label {
            display: block;
            margin-bottom: 10px;
        }
        .submit-button {
            display: block;
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <%
        List<Quiz> quizzes = (List) session.getAttribute("quizzes");
    %>

    <h1>Quiz Game</h1>
    <form action="quizsubmit" method="post">
        <%
            int questionNumber = 1;
            for (Quiz q : quizzes) {
        %>
                <div class="question">
                    <h3><%=questionNumber%>. <%=q.getQuestion()%></h3>
                     <input type="hidden" name="question<%=questionNumber%>" value="<%=q.getQuestion()%>">
                    <div class="answers">
                        <label><input type="radio" name="questionNo<%=questionNumber%>" value="A" required><%=q.getOptionA()%></label>
                        <label><input type="radio" name="questionNo<%=questionNumber%>" value="B"><%=q.getOptionB()%></label>
                        <label><input type="radio" name="questionNo<%=questionNumber%>" value="C"><%=q.getOptionC()%></label>
                        <label><input type="radio" name="questionNo<%=questionNumber%>" value="D"><%=q.getOptionD()%></label>
                    </div>
                </div>

          <%  questionNumber++; }    %>


        <button type="submit" class="submit-button">Submit Quiz</button>
    </form>

</body>
</html>
