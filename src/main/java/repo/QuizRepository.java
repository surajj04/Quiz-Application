package repo;

import model.Quiz;

import java.util.List;

public interface QuizRepository {
    public List<Quiz> getRandomQuiz();
}
