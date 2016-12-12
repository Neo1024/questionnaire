package edu.cuit.questionnaire.service.questionnaire.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cuit.questionnaire.model.questionnaire.Questionnaire;
import edu.cuit.questionnaire.persist.pagination.PageInfo;
import edu.cuit.questionnaire.persist.questionnaire.QuestionMapper;
import edu.cuit.questionnaire.persist.questionnaire.QuestionnaireMapper;
import edu.cuit.questionnaire.service.questionnaire.QuestionnaireService;

/**
 * 
 * @author lixin
 * @date Apr 22, 2016
 *
 */
@Service
@Transactional
public class QuestionnaireServiceImpl implements QuestionnaireService {

	@Resource
	private QuestionnaireMapper questionnaireMapper;
	
	@Resource
	private QuestionMapper questionMapper;
	
	@Override
	public void createQuestionnaire(Questionnaire questionnaire) {
		questionnaireMapper.save(questionnaire);
	}

	@Override
	public Questionnaire findOne(Long id) {
		return questionnaireMapper.findById(id);
	}

	@Override
	public void update(Questionnaire questionnaire) {
		questionnaireMapper.update(questionnaire);
		
	}

	@Override
	public List<Questionnaire> findByUserId(Long userId, PageInfo pageInfo) {
		long totalRows = questionnaireMapper.countAllPrivateByUserId(userId);
		pageInfo.setTotalRows(totalRows);
		return questionnaireMapper.findByUserId(userId, pageInfo);
	}

	@Override
	public void deleteById(Long questionnaireId) {
		questionnaireMapper.deleteById(questionnaireId);
	}

	@Override
	public List<Questionnaire> findTopPublic(PageInfo pageInfo) {
		long totalRows = questionnaireMapper.countAllPublic();
		pageInfo.setTotalRows(totalRows);
		List<Questionnaire> topQuestionnaires = questionnaireMapper.findTopPublic(pageInfo);
		
		return topQuestionnaires;
	}

	@Override
	public void publishQuestionnaire(Long questionnaireId) {
		Questionnaire questionnaire = questionnaireMapper.findById(questionnaireId);
		questionnaire.setPublish(true);
		questionnaireMapper.update(questionnaire);
	}

}
