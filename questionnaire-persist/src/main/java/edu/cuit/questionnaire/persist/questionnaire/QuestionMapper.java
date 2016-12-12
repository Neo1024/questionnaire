package edu.cuit.questionnaire.persist.questionnaire;

import edu.cuit.questionnaire.model.questionnaire.Question;
import edu.cuit.questionnaire.persist.BaseMapper;

public interface QuestionMapper extends BaseMapper<Question> {
	public void deleteById(Long id);
	
	public void deleteByQuestionnaireId(Long questionnaireId);
}
