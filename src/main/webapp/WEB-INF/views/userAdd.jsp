<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h4>新增用户信息</h4>
<form method="post" id="form_id" action="userAdd">
	<div class="input_div">
		<label>用户名称：</label> <input type="text" name="user.username"
			placeholder="请输入您的用户名！" minlength="6" maxlength="20" required
			autofocus>
	</div>
	<div class="input_div">
		<label>登录密码：</label> <input type="password" name="user.password"
			placeholder="请输入您的密码！" minlength="6" maxlength="20" required>
	</div>
	<div class="input_div">
		<label>重复密码：</label> <input type="password" name="user.againPassword"
			placeholder="请输入您的确认密码！" minlength="6" maxlength="20" required>
	</div>
	<div class="input_div">
		<label>电子邮箱：</label> <input type="email" name="user.email"
			placeholder="请输入您的邮箱！" required>
	</div>
	<div class="radio_div">
		<label>性 别：</label> <input type="radio" name="user.sex" value="男"
			checked>男 <input type="radio" name="user.sex" value="女">女
		<hr>
	</div>
	<div class="button_div">
		<button type="submit" class="save">保存</button>　
		<button type="reset" class="reset">重置</button>　
		<button type="button" class="return_list">返回</button>
	</div>
</form>