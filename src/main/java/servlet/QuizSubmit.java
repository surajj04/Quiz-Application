package servlet;

import model.Quiz;
import model.UserQuiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/quizsubmit")
public class QuizSubmit extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Quiz> quizzes = (List<Quiz>) session.getAttribute("quizzes");

        List<UserQuiz> userQuizs = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            UserQuiz quiz = new UserQuiz();
            quiz.setQuestion(req.getParameter("question" + i));
            quiz.setAnswer(req.getParameter("questionNo" + i));

            userQuizs.add(quiz);
        }

        int score = 0;

        for (Quiz q : quizzes) {
            for (UserQuiz quiz : userQuizs) {
                if (quiz.getQuestion().equals(q.getQuestion()) && quiz.getAnswer().equals(q.getCorrectAnswer())) {
                    score++;
                }
            }
        }

        HttpSession session1 = req.getSession();
        session1.setAttribute("score", score);

        resp.sendRedirect("score.jsp");

    }
}
