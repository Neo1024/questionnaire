$(function(){
	$('.btn-questionnaire-edit').click(function () {
		var questionnaireId = $(this).parent('div').data('id');
		window.location.href = window.context + "/private/questionnaire/edit/" + questionnaireId;
//        $.ajax({
//            type: "GET",
//            async: false,
//            url: window.context + "/private/questionnaire/edit/" + questionnaireId
//        });
	});
	$('.btn-questionnaire-detail').click(function () {
		var questionnaireId = $(this).parent('div').data('id');
		window.location.href = window.context + "/private/questionnaire/detail/" + questionnaireId;
	});
	
//	$('.btn-questionnaire-delete').click(function () {
//		var questionnaireId = $(this).parent('div').data('id');
//		window.location.href = window.context + "/private/questionnaire/deletion?questionnaireId=" + questionnaireId;
//	});
	$('#confirm-questionnaire-deletion').on('show.bs.modal', function (event) {
		var questionnaireId = $(event.relatedTarget).parent().parent().data('questionnaireid');
		console.log(questionnaireId);
		$('#confirm-questionnaire-deletion #deletion-questionnaire-id').val(questionnaireId);
	});	
	
	$('#confirm-questionnaire-publish').on('show.bs.modal', function (event) {
		var questionnaireId = $(event.relatedTarget).parent().parent().data('questionnaireid');
		console.log(questionnaireId);
		$('#confirm-questionnaire-publish #publish-questionnaire-id').val(questionnaireId);
	});
});