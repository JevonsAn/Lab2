<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>更改图书信息</title>
</head>
<body>
	<h2 style="text-align:center">更改图书信息：</h2>	
	<br/>
	
	<form action="update2" style="text-align:center">
		<s:property value="u"/>:
		<input type="text" name="u2"/><br/><br/>
		<input type="submit" value="提交">
	</form>
	
	<br/>
	<p style="text-align:center">(出版日期必须严格按照日期格式填写，如1995-1-1)</p>
	<p style="text-align:center"><a href="index" style="text-align:center">返回主页</a></p><br/>
</body>
</html>