<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>查询作者</title>
</head>
<body>
   <form action="SearchAuthor" style="text-align:center">
      <%-- --%>
      <label for="name">请输入要查询的作者姓名</label><br/>
      <input type="text" name="name"/>
      <input type="submit" value="查询"/>
   </form>
   <p style="text-align:center"><a href="index" >返回主页</a></p><br/>
</body>
</html>