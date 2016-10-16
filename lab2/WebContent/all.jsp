<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>所有图书</title>
</head>
<body>
	<h2 style="text-align:center">本图书馆所有图书</h2><br/>
	<p style="text-align:center"><s:a href="Insert2">添加一本新图书</s:a></p><br/>
	<table  align="center" border="0" style="font-size:20px">
	<s:iterator value="list" status="st">
		<tr>
		<td><s:a href="Select?isbn=%{isbn}"><s:property value="title"/></s:a></td>
		<td><s:a href="Delete?isbn=%{isbn}">删除</s:a></td>
		</tr>	
	</s:iterator>
	</table>
	<br/>
	<br/>
	<p style="text-align:center"><a href="index" >返回主页</a></p><br/>
</body>
</html>