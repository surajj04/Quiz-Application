package imp;

import data.Jdbc;
import model.Quiz;
import repo.QuizRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizImplementation implements QuizRepository {

    private Jdbc jdbc = new Jdbc();

    @Override
    public List<Quiz> getRandomQuiz() {
        List<Quiz> quizzes = new ArrayList<>();
        try {
            Connection con = jdbc.getCon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM programming_questions ORDER BY RAND() LIMIT 10");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Quiz quiz = new Quiz();
                quiz.setId(rs.getInt(1));
                quiz.setQuestion(rs.getString(2));
                quiz.setOptionA(rs.getString(3));
                quiz.setOptionB(rs.getString(4));
                quiz.setOptionC(rs.getString(5));
                quiz.setOptionD(rs.getString(6));
                quiz.setCorrectAnswer(rs.getString(7));
                quiz.setCategory(rs.getString(8));
                quiz.setLevel(rs.getString(9));
                quizzes.add(quiz);
            }

        } catch (Exception e) {

        }
        return quizzes;
    }
}
