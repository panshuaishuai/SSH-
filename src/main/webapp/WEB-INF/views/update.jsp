<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h4>编辑用户信息</h4>
<form method="post" id="form_update" action="updateOrSave">
	<input type="hidden" name="user.id" value="${user.id }">
	<div class="input_div">
		<label>用户名称：</label> <input type="text" name="user.username" value="${user.username }">
	</div>
	<div class="input_div">
		<label>登录密码：</label> <input type="password" name="user.password" value="${user.password }">
	</div>
	<div class="input_div">
		<label>电子邮箱：</label> <input type="email" name="user.email" value="${user.email }">
	</div>
	<div class="radio_div">
	<c:if test="${user.sex == '男' }">
		<label>性 别：</label> <input type="radio" name="user.sex" value="男"
			checked>男 <input type="radio" name="user.sex" value="女">女
			</c:if>
	<c:if test="${user.sex == '女' }">
		<label>性 别：</label> <input type="radio" name="user.sex" value="男">男 
		<input type="radio" name="user.sex" value="女" checked>女
			</c:if>
		<hr>
	</div>
	<div class="button_div">
		<button type="submit" class="save">保存</button>　
		<button type="button" class="return_list">返回</button>
	</div>
</form>