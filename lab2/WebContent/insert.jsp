<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加新图书</title>
</head>
<body>
	<h2>要添加的图书信息：</h2>
	<br/>
	<form action="Insert" style="font-size:20px">
		题目：<input type="text" name="title"/><br/>
		作者：<input type="text" name="name"/><br/>
		出版社：<input type="text" name="publisher"/><br/>
		出版日期：<input type="text" name="publishdate"/>(必须严格按照日期格式填写，如1995-1-1)<br/>
		ISBN：<input type="text" name="isbn"/><br/>
		价格：<input type="text" name="price"/>（可不填）<br/><br/>
		<input type="submit" value="提交">
	</form>
	
	<br/>
	<p style="text-align:left"><a href="index" >返回主页</a></p><br/>
</body>
</html>