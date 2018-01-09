<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/paging" prefix="qsx"%> 

<link rel="stylesheet" type="text/css" href="css/style.css">
<body>
	<div id="user_select">
		<form method="post" id="like_form" action="list">
			<label>用户名称：</label> <input type="text" name="user.username" autofocus>
			<button type="submit" class="select">查询</button>
		</form> 
	</div>
	<div id="list">
	<table rules="all">
		<thead>
			<tr>
				<td>编号</td>
				<td>用户名称</td>
				<td>邮箱</td>
				<td>性别</td>
				<td>创建时间</td>
				<td>更新时间</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${userPage.result }">
				<tr>
					<td>${list.id }</td>
					<td>${list.username }</td>
					<td>${list.email }</td>
					<td>${list.sex }</td>
					<td>${list.createTime }</td>
					<td>${list.updateTime }</td>
					<td><a class="compile" data-id = ${list.id }>编辑</a> <a class="delete" data-id = ${list.id }>删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	
	<!-- 数据分页 -->
	<qsx:paging pageSize="${userPage.pageSize }" totalCount="${userPage.totalCount }" pageNo="${userPage.pageNo }" url="list"/>

	</div>
	
	<script type="text/javascript" src="plugins/jquery_2.1.3.js"></script>
    <script type="text/javascript" src="plugins/jquery.form.js"></script>
    <script type="text/javascript" src="js/update.js"></script>
</body>