package edu.cuit.questionnaire.web.controller.answer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import edu.cuit.questionnaire.model.answer.Sheet;
import edu.cuit.questionnaire.model.questionnaire.Question;
import edu.cuit.questionnaire.model.questionnaire.Questionnaire;
import edu.cuit.questionnaire.persist.pagination.PageInfo;
import edu.cuit.questionnaire.service.answer.SheetService;
import edu.cuit.questionnaire.service.questionnaire.QuestionService;
import edu.cuit.questionnaire.service.questionnaire.QuestionnaireService;
import edu.cuit.questionnaire.web.controller.BaseController;

/**
 * 
 * @author lixin
 * @date May 11, 2016
 *
 */
@Controller
@RequestMapping("/answer")
public class AnswerController extends BaseController {

	@Resource
	private SheetService sheetService;

	@Resource
	private QuestionnaireService questionnaireService;

	@Resource
	private QuestionService questionService;

	@RequestMapping(value = "/answerList", method = RequestMethod.GET)
	public String answerList(Model model, PageInfo pageInfo) {
		List<Questionnaire> questionnaires = sheetService.findQuestionnaires(getCurrentAccount().getId(), pageInfo);
		model.addAttribute("questionnaires", questionnaires);

		return "answer/sheetList";
	}

	@RequestMapping("/detail/{questionnaireId}")
	public String answerDetail(Model model, @PathVariable("questionnaireId") Long questionnaireId) {
		Questionnaire questionnaire = questionnaireService.findOne(questionnaireId);
		List<Question> choiceQuestions = questionService.getChoiceQuestions(questionnaire);
		List<Question> essayQuestions = questionService.getEssayQuestions(questionnaire);
		List<Sheet> sheets = sheetService.findByQuestionnaireId(questionnaireId);
		List<String> essayQuestionAnswers = sheetService.getEssayQuestionAnswers(sheets, essayQuestions);

		model.addAttribute("choiceQuestions", choiceQuestions);
		model.addAttribute("essayQuestions", essayQuestions);
		model.addAttribute("questionnaire", questionnaire);
		model.addAttribute("essayQuestionAnswers", essayQuestionAnswers);
		model.addAttribute("sheets", sheets);

		return "answer/answerDetail";
	}

	@RequestMapping("/chartData/{questionnaireId}")
	@ResponseBody
	public String getChartData(@PathVariable("questionnaireId") Long questionnaireId) {
		Questionnaire questionnaire = questionnaireService.findOne(questionnaireId);
		List<Sheet> sheets = sheetService.findByQuestionnaireId(questionnaireId);
		List<Question> choiceQuestions = questionService.getChoiceQuestions(questionnaire);
		List<Question> essayQuestions = questionService.getEssayQuestions(questionnaire);
		List<List<Integer>> barData = sheetService.getBarChartData(choiceQuestions, sheets);
		List<List<Float>> pieData = sheetService.getPieCharData(barData);

		JSONObject stInfo = new JSONObject();
		stInfo.put("choiceQuestions", choiceQuestions);
		stInfo.put("essayQuestions", essayQuestions);
		stInfo.put("questionnaire", questionnaire);
		stInfo.put("sheets", sheets);
		stInfo.put("barData", barData);
		stInfo.put("pieData", pieData);

		return stInfo.toJSONString();
	}
}
