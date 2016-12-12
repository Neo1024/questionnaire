package edu.cuit.questionnaire.service.questionnaire;

import java.util.List;

import edu.cuit.questionnaire.model.questionnaire.Questionnaire;
import edu.cuit.questionnaire.persist.pagination.PageInfo;
import edu.cuit.questionnaire.service.BaseService;

/**
 * 
 * @author lixin
 * @date Apr 22, 2016
 *
 */
public interface QuestionnaireService extends BaseService {
	public void createQuestionnaire(Questionnaire questionnaire); 
	
	public Questionnaire findOne(Long id);
	
	public void update(Questionnaire questionnaire);
	
	public List<Questionnaire> findByUserId(Long userId, PageInfo pageInfo);
	
	public void deleteById(Long questionnaireId);
	
	public List<Questionnaire> findTopPublic(PageInfo pageInfo);
	
	public void publishQuestionnaire(Long questionnaireId);
}
