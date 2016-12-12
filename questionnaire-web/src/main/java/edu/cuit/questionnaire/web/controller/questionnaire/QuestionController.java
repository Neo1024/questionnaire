package edu.cuit.questionnaire.web.controller.questionnaire;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cuit.questionnaire.model.questionnaire.Question;
import edu.cuit.questionnaire.service.questionnaire.QuestionService;
import edu.cuit.questionnaire.web.controller.BaseController;

/**
 * 
 * @author lixin
 * @date Apr 23, 2016
 *
 */
@Controller
@RequestMapping("/question")
public class QuestionController extends BaseController {
	
	@Resource
	private QuestionService questionService;
	
	@RequestMapping(value = "/creation", method = RequestMethod.POST)
	public String createQuestion(@RequestParam("questionnaireId") Long questionnaireId, 
			@Valid Question question) {
		question.setQuestionnaireId(questionnaireId);
		questionService.createQuestion(question);
		return "redirect:/private/questionnaire/edit/" + questionnaireId;
	}
	
	@RequestMapping(value = "/edition", method = RequestMethod.POST)
	public String editQuestion(@RequestParam("questionnaireId") Long questionnaireId, 
			@Valid Question question) {
		question.setQuestionnaireId(questionnaireId);
		questionService.editQuestion(question);
		return "redirect:/private/questionnaire/edit/" + questionnaireId;
	}
	
	@RequestMapping(value = "/deletion", method = RequestMethod.POST)
	public String deletQuestion(@RequestParam("questionnaireId") Long questionnaireId, 
			@RequestParam Long questionId) {
		questionService.deleteById(questionId);
		return "redirect:/private/questionnaire/edit/" + questionnaireId;
	}
}
