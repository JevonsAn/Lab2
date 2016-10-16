<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询结果</title>
</head>
<body>
	<h1 style="text-align:center"><s:property value="name"/>所著的图书有：</h1><br/>  
	<table  align="center" border="0" style="font-size:20px"> 
	<tr>
		<td>题目</td>
		<td>删除</td>
	</tr>
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