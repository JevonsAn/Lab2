<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>查看图书信息</title>
</head>
<body>
	<h2 style="text-align:center">图书详细信息</h2><br/>
	<table  align="center" border="0" style="font-size:20px">
	<s:iterator value="list" status="st">
		<tr>
		<td>标题：</td>   <td><s:property value="title"/></td>
		</tr>
		<tr>
		<s:iterator value="list2" status="st">
			<td>作者： </td><td><s:property value="name"/>  </td><td><s:a href="update.action?isbn=%{isbn}&u=作者&u3=author">更新</s:a></td>
		</s:iterator></tr>
		<tr><td> 出版社：</td><td><s:property value="publisher"/> </td><td> <s:a href="update.action?isbn=%{isbn}&u=出版社&u3=publisher">更新</s:a></td></tr>
		<tr><td> 出版日期： </td><td><s:property value="publishdate"/>  </td><td> <s:a href="update.action?isbn=%{isbn}&u=出版日期&u3=publishdate">更新</s:a></td></tr>
		<tr><td> ISBN： <td> <s:property value="isbn"/> </td>
		<tr><td> 价格： <td><s:property value="price"/>   </td><td><s:a href="update.action?isbn=%{isbn}&u=价格&u3=price">更新</s:a></td></tr>
		
	</s:iterator>
	</table>
	<br/>
	<br/>
	<h2 style="text-align:center">作者详细信息</h2><br/>
	<table  align="center" border="0" style="font-size:20px">
	<s:iterator value="list2" status="st">
			<tr><td>姓名：</td><td><s:property value="name"/> </td></tr>
			<tr><td>年龄： </td><td><s:property value="age"/> </td></tr>
			<tr>
			<td>国家：  <td><s:property value="country"/> </td>
	</s:iterator>
	</table>
	<br/>
	<br/>
	<p style="text-align:center"><a href="index" style="text-align:center">返回主页</a></p><br/>
</body>
</html>