package edu.cuit.questionnaire.service.answer.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cuit.questionnaire.model.answer.Answer;
import edu.cuit.questionnaire.model.answer.Sheet;
import edu.cuit.questionnaire.model.questionnaire.Question;
import edu.cuit.questionnaire.model.questionnaire.Questionnaire;
import edu.cuit.questionnaire.persist.answer.AnswerMapper;
import edu.cuit.questionnaire.persist.answer.SheetMapper;
import edu.cuit.questionnaire.persist.pagination.PageInfo;
import edu.cuit.questionnaire.service.answer.SheetService;

/**
 * 
 * @author lixin
 * @date May 10, 2016
 *
 */
@Transactional
@Service
public class SheetServiceImpl implements SheetService {

	@Resource
	private SheetMapper sheetMapper;

	@Resource
	private AnswerMapper answerMapper;

	@Override
	public void saveAnswerSheet(Sheet sheet) {
		sheetMapper.save(sheet);

		for (Answer a : sheet.getAnswers()) {
			String multipleChoice = "";
			a.setSheetId(sheet.getId());
			if (a.getType() == 1) {
				for (Integer o : a.getMultipleChoices()) {
					multipleChoice = multipleChoice + o + ",";
				}
				a.setAnswer(multipleChoice);
			}
			answerMapper.save(a);
		}
	}

	@Override
	public List<Sheet> findByQuestionnaireId(Long questionnaireId) {

		return sheetMapper.findByQuestionnaireId(questionnaireId);

	}

	@Override
	public List<Questionnaire> findQuestionnaires(Long userId, PageInfo pageInfo) {
		return sheetMapper.findQuestionnaires(userId, pageInfo);
	}

	@Override
	public List<List<Integer>> getBarChartData(List<Question> choiceQuestions, List<Sheet> sheets) {
		List<List<Integer>> barChart = new ArrayList<>();
		for (int qNo = 0; qNo < choiceQuestions.size(); qNo++) {
			List<Integer> qData = new ArrayList<>();
			for (int oNo = 0; oNo < choiceQuestions.get(qNo).getOptions().size(); oNo++) {
				int times = 0;
				for (Sheet s : sheets) {
					Answer a = s.getAnswers().get(qNo);
					// single choice
					if (a.getType() == 0) {
						if (Integer.valueOf(a.getAnswer()) == oNo) {
							times++;
						}
					} else { // multiple choice
						String[] mul = a.getAnswer().split(",");
						for (int i = 0; i < mul.length; i++) {
							if (Integer.valueOf(mul[i]) == oNo) {
								times++;
							}
						}
					}
				}
				qData.add(times);
			}
			barChart.add(qData);
		}
		return barChart;
	}

	@Override
	public List<List<Float>> getPieCharData(List<List<Integer>> barData) {
		List<List<Float>> pieData = new ArrayList<>();
		for (List<Integer> bar : barData) {
			List<Float> q = new ArrayList<>();
			int total = 0;
			for (Integer i : bar) {
				total = total + i;
			}
			for (Integer i : bar) {
				float rate = ((float) i / total) * 100;
				q.add(rate);
			}
			pieData.add(q);
		}

		return pieData;
	}

	@Override
	public List<String> getEssayQuestionAnswers(List<Sheet> sheets, List<Question> essayQuestions) {
		List<String> essayQuestionAnswers = new ArrayList<>();
		for (int i = 0; i < essayQuestions.size(); i++) {
			String ans = "";
			for (Sheet s : sheets) {
				for (Answer a : s.getAnswers()) {
					if (a.getQuestionId() == essayQuestions.get(i).getId()) {
						ans = ans + a.getAnswer() + "\n";
					}
				}
			}
			essayQuestionAnswers.add(ans);
		}
		
		return essayQuestionAnswers;
	}

}
