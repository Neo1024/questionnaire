$(function() {
	// set data for the choice-question edition modal
	$('#modal-question-edition').on('show.bs.modal', function (event) {
		document.getElementById("question-edition").reset();
		var questionElement = $(event.relatedTarget).parent().parent('.question-title').
							parent('.div-question-content');
		var questionId = questionElement.data('id');
		var questionTitle = questionElement.data('title');
		var optionsLength = questionElement.data('length');
		var type = questionElement.data('type');
		console.log(type);
		$('#modal-question-edition #edition-question-id').val(questionId);
		$('#modal-question-edition #edition-question-title').val(questionTitle);
		if (type == 0) {
			console.log('this is single choice');
			$('#modal-question-edition #edition-radio-single').attr('checked', true);
		} else {
			console.log('this is multiple choice');
			$('#modal-question-edition #edition-radio-multiple').attr('checked', true);
		}
		

		for (var i = 1; i <= optionsLength; i++) {
			var optionIdSelector = '#modal-question-edition #edition-option-id-' + i;
			var optionTitleSelector = '#modal-question-edition #edition-option-title-' + i;
			var optionIndex = '.option-item-' + i;
			var optionId = $(event.relatedTarget).parent().parent('.question-title').
						parent('.div-question-content').children('.option-list').children(optionIndex).data('id');
			var optionTitle = $(event.relatedTarget).parent().parent('.question-title').
						parent('.div-question-content').children('.option-list').children(optionIndex).data('title');
			$(optionIdSelector).val(optionId);
			$(optionTitleSelector).val(optionTitle);
		}
	});
	
	// set data for the choice-question deletion modal
	$('#modal-question-deletion').on('show.bs.modal', function (event) {
		var questionElement = $(event.relatedTarget).parent().parent('.question-title').
		parent('.div-question-content');
		var questionId = questionElement.data('id');
		console.log(questionId);
		$('#modal-question-deletion #deletion-question-id').val(questionId);
	});
	
	// set data for the essay-question edition modal
	$('#modal-essay-question-edition').on('show.bs.modal', function (event) {
		document.getElementById("essay-question-edition").reset();
		var questionElement = $(event.relatedTarget).parent().parent('.question-title').
		parent('.div-question-content');
		var questionId = questionElement.data('id');
		var questionTitle = questionElement.data('title');
		console.log(questionId + questionTitle);
		$('#modal-essay-question-edition #edition-question-id').val(questionId);
		$('#modal-essay-question-edition #edition-question-title').val(questionTitle);
	});
	
	// set data for the essay-question deletion modal
	$('#modal-essay-question-deletion').on('show.bs.modal', function (event) {
		var questionElement = $(event.relatedTarget).parent().parent('.question-title').
		parent('.div-question-content');
		var questionId = questionElement.data('id');
		console.log(questionId);
		$('#modal-essay-question-deletion #deletion-question-id').val(questionId);
	});
});
