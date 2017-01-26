<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/normalize.css">
<link rel="stylesheet" href="../css/style1.css">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Login</title>
</head>
	
<body>
<div class="form">
<div class="tab-content">
<h1>Login</h1>
<form:form action="validate" method="post" modelAttribute="myUser">
	<div class="field-wrap">
	<label>Username<span class="req">*</span></label><form:input path="email" /><br>
	</div>
	<div class="field-wrap">
	<label>Password<span class="req">*</span></label><form:input path="password" /><br>
	</div>
	<button type="submit" name="b1" class="button button-block" value="submit">Login</button>
</form:form>

</div>
</div>
</body>
<script src="js/jquery.min.js" async="async"></script>
<script src="js/index.js" async="async"></script>
</html>