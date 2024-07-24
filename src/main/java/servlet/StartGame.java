package servlet;

import imp.QuizImplementation;
import imp.UserImplemention;
import model.Quiz;
import model.User;
import repo.QuizRepository;
import repo.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/startgame")
public class StartGame extends HttpServlet {

    private QuizRepository quizRepo = new QuizImplementation();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Quiz> quizzes = quizRepo.getRandomQuiz();

        HttpSession session = req.getSession();
        session.setAttribute("quizzes", quizzes);
        resp.sendRedirect("startgame.jsp");

    }
}
