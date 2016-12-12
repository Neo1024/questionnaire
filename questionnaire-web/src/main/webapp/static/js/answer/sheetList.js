$(function(){
	$('.btn-questionnaire-detail').click(function () {
		var questionnaireId = $(this).parent().data('questionnaireid');
		window.location.href = window.context + "/answer/detail/" + questionnaireId;
	});
	
	$('#confirm-sheet-deletion').on('show.bs.modal', function (event) {
		var questionnaireId = $(event.relatedTarget).parent().data('questionnaireid');
		$('#confirm-sheet-deletion #deletion-sheet-id').val(questionnaireId);
	});
});