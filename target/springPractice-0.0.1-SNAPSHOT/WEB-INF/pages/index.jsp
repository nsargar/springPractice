<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="validate.jsp" method="post">

username:<input type="text" name="username" required="required"></input>
password:<input type="text" name="password" required="required"></input>
<input type="submit" name="b1" value="submit"></input>

To register click<a href="register.jsp"> here</a>.........!
</form>




</body>
</html>