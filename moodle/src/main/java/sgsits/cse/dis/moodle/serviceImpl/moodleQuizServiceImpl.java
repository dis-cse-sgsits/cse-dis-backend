package sgsits.cse.dis.moodle.serviceImpl;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.moodle.exception.NotFoundException;
import sgsits.cse.dis.moodle.model.MoodleCourse;
import sgsits.cse.dis.moodle.model.MoodleQuestion;
import sgsits.cse.dis.moodle.model.MoodleQuestionAnswers;
import sgsits.cse.dis.moodle.model.MoodleQuestionAttemptSteps;
import sgsits.cse.dis.moodle.model.MoodleQuestionAttempts;
import sgsits.cse.dis.moodle.model.MoodleQuiz;
import sgsits.cse.dis.moodle.model.MoodleQuizAttempts;
import sgsits.cse.dis.moodle.model.MoodleQuizSlots;
import sgsits.cse.dis.moodle.repo.MoodleCourseRepo;
import sgsits.cse.dis.moodle.repo.MoodleQuestionAnswersRepo;
import sgsits.cse.dis.moodle.repo.MoodleQuestionAttemptStepsRepo;
import sgsits.cse.dis.moodle.repo.MoodleQuestionAttemptsRepo;
import sgsits.cse.dis.moodle.repo.MoodleQuestionRepo;
import sgsits.cse.dis.moodle.repo.MoodleQuizAttemptsRepo;
import sgsits.cse.dis.moodle.repo.MoodleQuizRepo;
import sgsits.cse.dis.moodle.repo.MoodleQuizSlotsRepo;
import sgsits.cse.dis.moodle.response.QuestionData;
import sgsits.cse.dis.moodle.response.QuizData;
import sgsits.cse.dis.moodle.service.moodleQuizService;

@Component
public class moodleQuizServiceImpl implements moodleQuizService, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MoodleCourseRepo moodleCourseRepo;
	@Autowired
	private MoodleQuizRepo moodleQuizRepo;
	@Autowired
	private MoodleQuizAttemptsRepo moodleQuizAttemptsRepo;
	@Autowired
	private MoodleQuizSlotsRepo moodleQuizSlotsRepo;
	@Autowired
	private MoodleQuestionRepo moodleQuestionRepo;
	@Autowired
	private MoodleQuestionAnswersRepo moodleQuestionAnswersRepo;
	@Autowired
	private MoodleQuestionAttemptsRepo moodleQuestionAttemptsRepo;
	@Autowired
	private MoodleQuestionAttemptStepsRepo moodleQuestionAttemptStepsRepo;
	

	@Override
	public List<QuizData> getQuizzesOfCourse(Long userId, Long courseId, String userType) throws NotFoundException {
		List<QuizData> allQuizzes = new ArrayList<QuizData>();
		
		if(!userType.equals("student"))
            throw new  NotFoundException("Invalid User Type");
		
		List<MoodleCourse> course = moodleCourseRepo.findAllById(courseId);
		List<MoodleQuiz> quizList = moodleQuizRepo.findByCourse(courseId);
		
		for (MoodleQuiz quiz : quizList) {				
			List<MoodleQuizAttempts> studDetailsOfQuiz = moodleQuizAttemptsRepo.findAllByQuizAndUseridOrderByAttemptDesc(quiz.getId(), userId);
			
			if (!studDetailsOfQuiz.isEmpty()) {
				String dateOfCreation = getDateFromUnixDate(quiz.getTimemodified());
				
				allQuizzes.add(new QuizData(courseId,
						course.get(0).getIdnumber(),
						course.get(0).getFullname(),
						quiz.getId(),
						quiz.getName(),
						"attempted",
						studDetailsOfQuiz.get(0).getSumgrades(),
						quiz.getSumgrades()));
			}else {
				String dateOfCreation = getDateFromUnixDate(quiz.getTimemodified());
				allQuizzes.add(new QuizData(courseId,
						course.get(0).getIdnumber(),
						course.get(0).getFullname(),
						quiz.getId(),
						quiz.getName(),
						"Not Attempted",
						0D,
						quiz.getSumgrades()));
			}
		}
		
		return allQuizzes;
	}
	
	@Override
	public List<QuestionData> getCompleteQuiz(Long userId, Long quizId, String userType) throws NotFoundException {
		List<QuestionData> allQuestions = new ArrayList<QuestionData>();
		
		if(!userType.equals("student"))
            throw new  NotFoundException("Invalid User Type");
		
		MoodleQuiz quiz = moodleQuizRepo.findAllById(quizId);
		
		List<MoodleQuizSlots> allQuestionIds = moodleQuizSlotsRepo.findAllByQuizid(quizId);
		if (!allQuestionIds.isEmpty()) {
			for (MoodleQuizSlots questionId : allQuestionIds) {
				MoodleQuestion question = moodleQuestionRepo.findAllById(questionId.getQuestionid());
				
				List<MoodleQuestionAnswers> optionsDetailed = moodleQuestionAnswersRepo.findAllByQuestion(questionId.getQuestionid());
				List<String> options = new ArrayList<String>();
				for (MoodleQuestionAnswers option : optionsDetailed) {
					options.add(option.getAnswer());
				}
				
				// user answer and correct answer logic
				List<MoodleQuizAttempts> quizAttemptsOfStudent = moodleQuizAttemptsRepo.findAllByQuizAndUseridOrderByAttemptDesc(quizId, userId);
				if (!quizAttemptsOfStudent.isEmpty()) {
					Long questionUsageId = quizAttemptsOfStudent.get(0).getUniqueid();
					MoodleQuestionAttempts questionAttempt = moodleQuestionAttemptsRepo.findAllByQuestionidAndQuestionusageid(questionId.getQuestionid(), questionUsageId);
					
					List<MoodleQuestionAttemptSteps> questionAttemptDetails = moodleQuestionAttemptStepsRepo.findAllByUseridAndQuestionattemptidOrderBySequencenumberDesc(userId, questionAttempt.getId());
					
					allQuestions.add(new QuestionData(quizId,
														quiz.getName(),
														question.getQuestiontext(),
														question.getQtype(),
														options,
														questionAttempt.getRightanswer(),
														questionAttempt.getResponsesummary(),
														questionAttemptDetails.get(0).getFraction(),
														question.getDefaultmark(),
														question.getPenalty(),
														questionAttemptDetails.get(0).getState(),
														questionId.getSlot(),
														quizAttemptsOfStudent.get(0).getState()));
				}
			}
		}
		
		return allQuestions;
	}
	
	public String getDateFromUnixDate(Long unixDate) {
		Date date = new Date(unixDate*1000);
		
		Format formatter = new SimpleDateFormat("dd/MM/yyyy");
	    String stringDate = formatter.format(date);
	    return stringDate;
	}

}