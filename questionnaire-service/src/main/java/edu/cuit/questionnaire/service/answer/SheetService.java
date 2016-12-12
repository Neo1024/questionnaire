package edu.cuit.questionnaire.service.answer;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.cuit.questionnaire.model.answer.Sheet;
import edu.cuit.questionnaire.model.questionnaire.Question;
import edu.cuit.questionnaire.model.questionnaire.Questionnaire;
import edu.cuit.questionnaire.persist.pagination.PageInfo;
import edu.cuit.questionnaire.service.BaseService;

/**
 * 
 * @author lixin
 * @date May 10, 2016
 *
 */
public interface SheetService extends BaseService {
	public void saveAnswerSheet(Sheet sheet);
	
	public List<Sheet> findByQuestionnaireId(Long questionnaireId);
	
	/**
	 * find questionnaires which have been published and answered
	 * <br>
	 * 
	 * @param userId
	 * @return
	 */
	public List<Questionnaire> findQuestionnaires(@Param("userId") Long userId, @Param("pageInfo") PageInfo pageInfo);
	
	public List<List<Integer>> getBarChartData(List<Question> choiceQuestions, List<Sheet> sheets);
	
	public List<List<Float>> getPieCharData(List<List<Integer>> barData);
	
	public List<String> getEssayQuestionAnswers(List<Sheet> sheets, List<Question> essayQuestions);
}
