package edu.cuit.questionnaire.web.controller.answer;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cuit.questionnaire.model.answer.Sheet;
import edu.cuit.questionnaire.model.questionnaire.Question;
import edu.cuit.questionnaire.model.questionnaire.Questionnaire;
import edu.cuit.questionnaire.service.answer.SheetService;
import edu.cuit.questionnaire.service.questionnaire.QuestionService;
import edu.cuit.questionnaire.service.questionnaire.QuestionnaireService;
import edu.cuit.questionnaire.web.controller.BaseController;

/**
 * 
 * @author lixin
 * @date May 8, 2016
 *
 */
@Controller
@RequestMapping("/answering")
public class AnsweringController extends BaseController {

	@Resource
	private QuestionnaireService questionnaireService;
	
	@Resource
	private QuestionService questionService;
	
	@Resource
	private SheetService sheetService;

	@RequestMapping(method = RequestMethod.GET)
	public String toAnsweringPage(@RequestParam("questionnaireId") Long questionnaireId, Model model) {
		Questionnaire questionnaire = questionnaireService.findOne(questionnaireId);
		if (questionnaire.isPublish() == false) {
			return "redirect:/home";
		}
		List<Question> choiceQuestions = questionService.getChoiceQuestions(questionnaire);
		List<Question> essayQuestions = questionService.getEssayQuestions(questionnaire);

		model.addAttribute("questionnaire", questionnaire);
		model.addAttribute("choiceQuestions", choiceQuestions);
		model.addAttribute("essayQuestions", essayQuestions);
		model.addAttribute("user", getCurrentAccount());
		return "answer/answeringSheet";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String answering(@Valid Sheet sheet) {
		sheet.setUserId(getCurrentAccount().getId());
		sheetService.saveAnswerSheet(sheet);
		
		return "redirect:/home";
	}
}
