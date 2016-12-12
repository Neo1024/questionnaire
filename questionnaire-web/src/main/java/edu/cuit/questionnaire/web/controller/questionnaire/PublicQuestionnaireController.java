package edu.cuit.questionnaire.web.controller.questionnaire;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.cuit.questionnaire.model.questionnaire.Question;
import edu.cuit.questionnaire.model.questionnaire.Questionnaire;
import edu.cuit.questionnaire.persist.pagination.PageInfo;
import edu.cuit.questionnaire.service.questionnaire.QuestionService;
import edu.cuit.questionnaire.service.questionnaire.QuestionnaireService;
import edu.cuit.questionnaire.web.controller.BaseController;

/**
 * 
 * @author lixin
 * @date Apr 21, 2016
 *
 */
@Controller
@RequestMapping("/public")
public class PublicQuestionnaireController extends BaseController {
	
	@Resource
	private QuestionnaireService questionnaireService;

	@Resource
	private QuestionService questionService;
	
	@RequestMapping(value = "/topQuestionnaire", method = RequestMethod.GET)
	public String topQuestionnaire(Model model, PageInfo pageInfo) {
		List<Questionnaire> topQuestionnaires = questionnaireService.findTopPublic(pageInfo);
		model.addAttribute("questionnaires", topQuestionnaires);
		
		return "questionnaire/topQuestionnaireList";
	}
	
	@RequestMapping(value = "/detail/${id}")
	public String publicDetail(@PathVariable("id") Long questionnaireId, Model model) {
		Questionnaire questionnaire = questionnaireService.findOne(questionnaireId);
		List<Question> choiceQuestions = questionService.getChoiceQuestions(questionnaire);
		List<Question> essayQuestions = questionService.getEssayQuestions(questionnaire);

		model.addAttribute("questionnaire", questionnaire);
		model.addAttribute("choiceQuestions", choiceQuestions);
		model.addAttribute("essayQuestions", essayQuestions);
		model.addAttribute("user", getCurrentAccount());
		return "questionnaire/questionnaireDetail";
	}
}
