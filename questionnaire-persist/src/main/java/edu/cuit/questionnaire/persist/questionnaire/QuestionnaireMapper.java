package edu.cuit.questionnaire.persist.questionnaire;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.cuit.questionnaire.model.questionnaire.Questionnaire;
import edu.cuit.questionnaire.persist.BaseMapper;
import edu.cuit.questionnaire.persist.pagination.PageInfo;

/**
 * 
 * @author lixin Apr 13, 2016
 *
 */
public interface QuestionnaireMapper extends BaseMapper<Questionnaire> {
	public List<Questionnaire> findByUserId(@Param("userId") Long userId, @Param("pageInfo") PageInfo pageInfo);

	public void deleteById(Long questionnaireId);

	public List<Questionnaire> findTopPublic(@Param("pageInfo") PageInfo pageInfo);

	public long countAllPrivateByUserId(Long userId);

	public long countAllPublic();
}
