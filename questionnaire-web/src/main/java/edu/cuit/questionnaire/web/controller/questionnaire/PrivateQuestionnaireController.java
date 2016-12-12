package edu.cuit.questionnaire.web.controller.questionnaire;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
@RequestMapping("/private")
public class PrivateQuestionnaireController extends BaseController {

	@Resource
	private QuestionnaireService questionnaireService;

	@Resource
	private QuestionService questionService;

	@RequestMapping(value = "/myQuestionnaire", method = RequestMethod.GET)
	public String myQuestionnaireList(Model model, PageInfo pageInfo) {
		List<Questionnaire> questionnaires = questionnaireService.findByUserId(getCurrentAccount().getId(), pageInfo);
		model.addAttribute("questionnaires", questionnaires);

		return "questionnaire/myQuestionnaireList";
	}

	@RequestMapping(value = "/questionnaire/creation", method = RequestMethod.POST)
	public String createQuestionnaire(Questionnaire questionnaire) {
		questionnaire.setUser(getCurrentAccount());
		questionnaireService.createQuestionnaire(questionnaire);

		return "redirect:/private/questionnaire/edit/" + questionnaire.getId();
	}

	@RequestMapping(value = "/questionnaire/edit/{questionnaireId}", method = RequestMethod.GET)
	public String toEdtiQuestionnaire(Model model, @PathVariable Long questionnaireId) {
		Questionnaire questionnaire = questionnaireService.findOne(questionnaireId);
		List<Question> choiceQuestions = questionService.getChoiceQuestions(questionnaire);
		List<Question> essayQuestions = questionService.getEssayQuestions(questionnaire);

		model.addAttribute("questionnaire", questionnaire);
		model.addAttribute("choiceQuestions", choiceQuestions);
		model.addAttribute("essayQuestions", essayQuestions);

		return "questionnaire/editQuestionnaire";
	}

	@RequestMapping(value = "/questionnaire/edit", method = RequestMethod.POST)
	public String editQuestionnaire(@Valid Questionnaire questionnaire) {
		questionnaire.setUser(getCurrentAccount());
		questionnaireService.update(questionnaire);
		return "redirect:/private/questionnaire/edit/" + questionnaire.getId();
	}

	@RequestMapping(value = "/questionnaire/detail/{questionnaireId}")
	public String questionnaireDetail(@PathVariable Long questionnaireId, Model model) {
		Questionnaire questionnaire = questionnaireService.findOne(questionnaireId);
		List<Question> choiceQuestions = questionService.getChoiceQuestions(questionnaire);
		List<Question> essayQuestions = questionService.getEssayQuestions(questionnaire);

		model.addAttribute("questionnaire", questionnaire);
		model.addAttribute("choiceQuestions", choiceQuestions);
		model.addAttribute("essayQuestions", essayQuestions);
		model.addAttribute("user", getCurrentAccount());

		return "questionnaire/questionnaireDetail";
	}

	@RequestMapping(value = "/questionnaire/deletion")
	public String deleteQuestionnaire(@RequestParam("questionnaireId") Long questionnaireId) {
		questionnaireService.deleteById(questionnaireId);
		return "redirect:/private/myQuestionnaire";
	}
	
	@RequestMapping(value = "/questionnaire/publish")
	public String publishQuestionnaire(@RequestParam("questionnaireId") Long questionnaireId) {
		questionnaireService.publishQuestionnaire(questionnaireId);
		return "redirect:/answering?questionnaireId=" + questionnaireId;
	}

}
