<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>游戏测试地址输入页面</title>
</head>
<body>
<h1>登录成功</h1>

<span style="color: red">配置相关游戏测试信息</span>

<form action="/gameUrl" method="get">
    修改游戏测试地址(空为模拟测试页):
    <input type="text" style="width:500px" name="url" value="http://localhost:8181/farmer/index.html"><br/>
    游戏系统逻辑地址(gameLogic接口)：<input type="text" style="width:500px" name="gurl" value="http://localhost:8181/testurl"><br/>
    游戏系统消息地址(gameMsg接口)： <input type="text" style="width:500px" name="murl" value="http://localhost:8181/testurl"><br/>
    测试页面(TEST)或测试系统(GAME)：<input type="text" style="width:500px" name="stype" value="TEST"><br/>
    <input type="submit" value="确定">
</form>
</body>
</html>