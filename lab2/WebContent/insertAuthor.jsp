<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加新图书</title>
</head>
<body>
	请补充作者信息：
	<br/>
	<form action="Insert3">
		作者：<s:property value="name"/><br/>
		年龄：<input type="text" name="age"/>（可不填）<br/>
		国家：<input type="text" name="country"/>（可不填）<br/>
		<input type="submit" value="提交">
	</form>
	
	<br/>
	<p><a href="index">返回主页</a></p><br/>
</body>
</html>