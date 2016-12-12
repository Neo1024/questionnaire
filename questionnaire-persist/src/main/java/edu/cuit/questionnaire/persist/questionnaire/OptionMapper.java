package edu.cuit.questionnaire.persist.questionnaire;

import edu.cuit.questionnaire.model.questionnaire.Option;
import edu.cuit.questionnaire.persist.BaseMapper;

/**
 * 
 * @author lixin
 * @date Apr 23, 2016
 *
 */
public interface OptionMapper extends BaseMapper<Option> {
	public void deleteById(Long id);
	
	public void deleteByQuestionId(Long questionId);
}
