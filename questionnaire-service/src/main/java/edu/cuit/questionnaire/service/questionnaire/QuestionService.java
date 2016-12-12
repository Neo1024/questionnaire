package edu.cuit.questionnaire.service.questionnaire;

import java.util.List;

import edu.cuit.questionnaire.model.questionnaire.Question;
import edu.cuit.questionnaire.model.questionnaire.Questionnaire;
import edu.cuit.questionnaire.service.BaseService;

/**
 * 
 * @author lixin
 * @date Apr 23, 2016
 *
 */
public interface QuestionService extends BaseService {
	
	public void createQuestion(Question question);
	
	public void editQuestion(Question question);
	
	public void deleteById(Long id);
	
	public List<Question> getChoiceQuestions(Questionnaire questionnaire);
	
	public List<Question> getEssayQuestions(Questionnaire questionnaire);	
}
