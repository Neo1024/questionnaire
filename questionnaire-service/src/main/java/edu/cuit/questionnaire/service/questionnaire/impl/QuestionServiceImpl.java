package edu.cuit.questionnaire.service.questionnaire.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cuit.questionnaire.model.questionnaire.Option;
import edu.cuit.questionnaire.model.questionnaire.Question;
import edu.cuit.questionnaire.model.questionnaire.Questionnaire;
import edu.cuit.questionnaire.persist.questionnaire.OptionMapper;
import edu.cuit.questionnaire.persist.questionnaire.QuestionMapper;
import edu.cuit.questionnaire.service.questionnaire.QuestionService;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

	@Resource
	private QuestionMapper questionMapper;

	@Resource
	private OptionMapper optionMapper;

	@Override
	public void createQuestion(Question question) {
		questionMapper.save(question);

		// if the question is choice-question(single choice and multiple)
		if (question.getType() == 0 || question.getType() == 1) {
			for (Option o : question.getOptions()) {
				if (o.getTitle() != null && o.getTitle() != "") {
					o.setQuestionId(question.getId());
					optionMapper.save(o);
				}
			}
		}
	}

	@Override
	public void editQuestion(Question question) {
		questionMapper.update(question);
		if (question.getType() == 0 || question.getType() == 1) {
			for (Option o : question.getOptions()) {
				if (o.getTitle() != null && o.getTitle() != "") {
					o.setQuestionId(question.getId());
					if (o.getId() != null) {
						optionMapper.update(o);
					} else {
						optionMapper.save(o);
					}
				} else {
					if (o.getId() != null) {
						optionMapper.deleteById(o.getId());
					}
				}

			}
		}

	}

	@Override
	public void deleteById(Long id) {
		questionMapper.deleteById(id);
		optionMapper.deleteByQuestionId(id);
	}

	@Override
	public List<Question> getChoiceQuestions(Questionnaire questionnaire) {
		List<Question> choiceQuestions = new ArrayList<>();
		for (Question q : questionnaire.getQuestions()) {
			if (q.getType() == 0 || q.getType() == 1) {
				choiceQuestions.add(q);
			}
		}
		return choiceQuestions;
	}

	@Override
	public List<Question> getEssayQuestions(Questionnaire questionnaire) {
		List<Question> essayQuestions = new ArrayList<>();
		for (Question q : questionnaire.getQuestions()) {
			if (q.getType() == 2) {
				essayQuestions.add(q);
			}
		}
		return essayQuestions;
	}

}
