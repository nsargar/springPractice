<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>


<title>Insert title here</title>
</head>
<body>

<form:form method="post">
<c:forEach items="${selectedBrands}" var="item">

<div class="row resultlist">
	<div class="col-lg-12">
		<div class="col-lg-4">
		<h1>${item.name}</h1>
		</div>
		<div class="col-lg-4">
		<h1>${item.address} , ${item.contactMobile} </h1>
		</div>
		<div class="col-lg-4">
		<button type="submit" class="btn btn-success" 	name="selected"	value="${item.id}">Book Service</button>
		</div>
	</div>
</div>

</c:forEach>
</form:form>






<a href="main/validate"> click here to validate</a><br>
<a href="main/register"> click here to register</a>



</body>
</html>

