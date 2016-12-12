package edu.cuit.questionnaire.persist.answer;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.cuit.questionnaire.model.answer.Sheet;
import edu.cuit.questionnaire.model.questionnaire.Questionnaire;
import edu.cuit.questionnaire.persist.BaseMapper;
import edu.cuit.questionnaire.persist.pagination.PageInfo;

/**
 * 
 * @author lixin
 * @date May 10, 2016
 *
 */
public interface SheetMapper extends BaseMapper<Sheet> {
	public List<Sheet> findByQuestionnaireId(@Param("questionnaireId") Long questionnaireId);

	public long countUserSheet(Long userId);

	/**
	 * find questionnaires which have been published and answered from an_sheet
	 * <br>
	 * 
	 * @param userId
	 * @return
	 */
	public List<Questionnaire> findQuestionnaires(@Param("userId") Long userId, @Param("pageInfo") PageInfo pageInfo);
}
