<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户查询</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
    <div id="container">
        <div class="heads">
            <h2><img src="images/logo.png">　用户管理系统</h2>
            <ul class="ul_1">
                <li class="help">
                    <a href="#">退出</a>
                </li> 
                <li class="exit">
                    <a href="#">帮助</a>
                </li>
            </ul>
        </div>
        <div class="bodys">
            <div class="left_body">
                <ul class="ul_2">
                    <li>
                        <a class="ul_select">用户查询</a>
                    </li>
                    <li>
                        <a class="ul_add">用户新增</a>
                    </li>
                    <li>
                        <a class="ul_analyze">用户分析</a>
                    </li>
                </ul>
                <div id="avatar">
                    <img src="images/avatar.png">
                    <h5>当前登录用户</h5>
                </div>
            </div>
            <div class="right_body"></div>
        </div>
    </div>
    
    <script type="text/javascript" src="plugins/jquery_2.1.3.js"></script>
    <script type="text/javascript" src="plugins/jquery.form.js"></script>
    <script type="text/javascript" src="plugins/Chart.min.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
</body>

</html>