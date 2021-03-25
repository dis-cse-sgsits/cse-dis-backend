package sgsits.cse.dis.moodle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.moodle.constants.QuizURLConstants;
import sgsits.cse.dis.moodle.jwt.JwtResolver;
import sgsits.cse.dis.moodle.response.QuestionData;
import sgsits.cse.dis.moodle.response.QuizData;
import sgsits.cse.dis.moodle.service.moodleQuizService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path ="/quiz")
public class MoodleQuizController {
	private JwtResolver jwtResolver = new JwtResolver();
	
	@Autowired
	private moodleQuizService moodleQuizServiceImpl;
	
	@ApiOperation(value = "Get Quizzes Of Course", response = QuizData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = QuizURLConstants.GET_QUIZZES_OF_COURSE, produces = "application/json")
	public ResponseEntity<List<QuizData>> getQuizzesOfCourse(@PathVariable("userid") Long userId, @PathVariable("courseid") Long courseId)
	{
		return new ResponseEntity<List<QuizData>>(moodleQuizServiceImpl.getQuizzesOfCourse(userId, courseId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Complete Quiz", response = QuestionData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = QuizURLConstants.GET_COMPLETE_QUIZ, produces = "application/json")
	public ResponseEntity<List<QuestionData>> getCompleteQuiz(@PathVariable("userid") Long userId, @PathVariable("quizid") Long quizId)
	{
		return new ResponseEntity<List<QuestionData>>(moodleQuizServiceImpl.getCompleteQuiz(userId, quizId), HttpStatus.OK);
	}
}
