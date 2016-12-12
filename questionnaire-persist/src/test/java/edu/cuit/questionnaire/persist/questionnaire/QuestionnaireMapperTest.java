package edu.cuit.questionnaire.persist.questionnaire;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import edu.cuit.questionnaire.model.questionnaire.Option;
import edu.cuit.questionnaire.model.questionnaire.Question;
import edu.cuit.questionnaire.model.questionnaire.Questionnaire;
import edu.cuit.questionnaire.persist.UnitTestBase;

public class QuestionnaireMapperTest extends UnitTestBase {

	@Resource
	private QuestionnaireMapper questionnaireMapper;
	
	@Test
	public void findById() {
		Questionnaire questionnaire = questionnaireMapper.findById(5L);
		System.out.println(questionnaire.toString());
		for (Question q : questionnaire.getQuestions()) {
			System.out.println("\n" + q.toString());
			for (Option o : q.getOptions()) {
				System.out.println(o.toString());
			}
		}
	}
	
	@Test
	public void findByUserId() {
		List<Questionnaire> questionnaires = questionnaireMapper.findByUserId(1L);
		for (Questionnaire q : questionnaires) {
			System.out.println(q.toString());
		}
	}

}
