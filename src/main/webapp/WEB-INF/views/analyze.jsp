<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="right" class="right">
	<div style="width: 300px; height: 300px; float: left;">
		<canvas id="userGenderChartCanvas"></canvas>
	</div>
	<div style="width: 500px; height: 450px; float: left;">
		<canvas id="userCreateChartCanvas"></canvas>
	</div>
</div>
<script type="text/javascript" src="plugins/jquery_2.1.3.js"></script>
<script type="text/javascript" src="plugins/jquery.form.js"></script>
<script type="text/javascript" src="plugins/Chart.min.js"></script>
<script type="text/javascript">
	// 饼状图参数
	var userGenderChartConfig = {
		type : 'pie',
		data : {
			labels : ${userGenderData.names },
			datasets : [ {
				data : ${userGenderData.values},
				backgroundColor : [ "#FF6384", "#36A2EB" ]
			} ]
		},
		options : {
			title : {
				display : true,
				text : '用户性别分布统计'
			},
			responsive : true
		}
	};

	// 折线图参数
	var userCreateChartConfig = {
		type : 'line',
		data : {
			labels : ${userCreateData.names},
			datasets : [ {
				label : "创建日期",
				fill : false,
				data : ${userCreateData.values}
			} ]
		},
		options : {
			title : {
				display : true,
				text : '用户创建日期统计'
			},
			responsive : true
		}
	};

	$(function() {
		//生成饼状图
		var userGenderChartCtx = document.getElementById("userGenderChartCanvas").getContext("2d");
		var userGenderChartCanvas = new Chart(userGenderChartCtx, userGenderChartConfig);
		//生成折线图
		var userCreateChartCtx = document.getElementById("userCreateChartCanvas").getContext("2d");
		var userCreateChartCanvas = new Chart(userCreateChartCtx, userCreateChartConfig);
	});
</script>
