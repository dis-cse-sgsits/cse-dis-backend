package sgsits.cse.dis.moodle.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sgsits.cse.dis.moodle.response.QuestionData;
import sgsits.cse.dis.moodle.response.QuizData;

@Service
public interface moodleQuizService {

	List<QuizData> getQuizzesOfCourse(Long userId, Long courseId);

	List<QuestionData> getCompleteQuiz(Long userId, Long quizId);

}
