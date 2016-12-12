$(function () { 
	var choiceQuestions;
	var context = window.context;
	var xAxi;
	var barData;
	var pieData;
	var pie = [];
	var stInfo;
	
	// requesting data for the charts
	$.ajax({
		url: window.context + '/answer/chartData/' + window.questionnaireId,
		async: false,
		success: function(data) {
			stInfo = JSON.parse(data);
			barData = stInfo['barData'];
			pieData = stInfo['pieData'];
			choiceQuestions = stInfo['choiceQuestions'];
			console.log(stInfo);
			console.log(barData);
			console.log(pieData);
		}
	});
	
	// settings for highcharts
	for (var i = 1; i <= choiceQuestions.length; i++) {
		// set xAxis column names based on how many options the question has
		if (choiceQuestions[i-1].options.length == 2) {
			xAxi = ['选项一', '选项二'];
		}
		if (choiceQuestions[i-1].options.length == 3) {
			xAxi = ['选项一', '选项二', '选项三'];
		}
		if (choiceQuestions[i-1].options.length == 4) {
			xAxi = ['选项一', '选项二', '选项三', '选项四'];
		}
		if (choiceQuestions[i-1].options.length == 5) {
			xAxi = ['选项一', '选项二', '选项三', '选项四', '选项五'];
		}
		if (choiceQuestions[i-1].options.length == 6) {
			xAxi = ['选项一', '选项二', '选项三', '选项四', '选项五', '选项六'];
		}
		if (choiceQuestions[i-1].options.length == 7) {
			xAxi = ['选项一', '选项二', '选项三', '选项四', '选项五', '选项七'];
		}
		if (choiceQuestions[i-1].options.length == 8) {
			xAxi = ['选项一', '选项二', '选项三', '选项四', '选项五', '选项七', '选项八'];
		}
		
		var pie = [];
		var temp = pieData[i - 1];
		for (var m = 0; m < temp.length; m++) {
            pie.push({
                'name': '选项' + (m + 1),
                'y': temp[m]
            });			
		}
		
		$('#barChart-' + i).highcharts({                   //图表展示容器，与div的id保持一致
			chart: {
				type: 'column'                         //指定图表的类型，默认是折线图（line）
			},
			title: {
				text: '各选项被选择次数'      //指定图表标题
			},
			xAxis: {
				categories: xAxi   //指定x轴分组
			},
			yAxis: {
                allowDecimals: false,
                min: 0,
				title: {
					text: '次数'                  //指定y轴的标题
				}
			},
			series: [{                                 //指定数据列
				name: '选择次数',                          //数据列名
				data: barData[i-1]                        //数据
			}]
		});
		
		$('#pieChart-' + i).highcharts({
			chart: {
				plotBackgroundColor: null,
				plotBorderWidth: null,
				plotShadow: false
			},
			title: {
				text: '各选项比例'
			},
			tooltip: {
				pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
			},
			plotOptions: {
				pie: {
					allowPointSelect: true,
					cursor: 'pointer',
					dataLabels: {
						enabled: true,
						color: '#000000',
						connectorColor: '#000000',
						format: '<b>{point.name}</b>: {point.percentage:.1f} %'
					}
				}
			},
			series: [{
				type: 'pie',
				name: '选项比例',
				data : pie
//				data: [
//				       ['Firefox',   45.0],
//				       ['IE',       26.8],
//				       {
//				    	   name: 'Chrome',
//				    	   y: 12.8,
//				    	   sliced: true,
//				    	   selected: true
//				       },
//				       ['Safari',    8.5],
//				       ['Opera',     6.2],
//				       ['Others',   0.7]
//				       ]
			}]
		});
	}
});