<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form modelAttribute="datecheckboxmodel" method="post">

${selectedsp.name}&nbsp&nbsp&nbsp&nbsp${selectedsp.address}<form:checkbox path="ispd"/><form:input path="aldate"/>

<button type="submit" value="" name="selected"  >Place Request</button> <br>

</form:form>



All Previous requests:<br>
<c:forEach items="${allrequests}" var="item">

Request id:${item.id}&nbsp&nbsp&nbsp&nbspDated:${item.allottdate}<br>


</c:forEach>






 






















To register click<a href="index.jsp"> here </a>to navigate to home page...........!





</body>
</html>