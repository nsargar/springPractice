<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


<link rel="stylesheet" href="../css/bootstrap.min.css">

<!--  <script src="js/jquery.min.js"></script>-->
<script src="js/bootstrap.min.js"></script> 
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">


<!-- Latest compiled JavaScript -->
<link rel="stylesheet" href="css/style.css">


<script src="js/index.js"></script>
<!--<script src="js/arrow.js"></script>-->
<script src="js/jquery.validate.min.js"></script>
<script src="js/loginvalidate.js"></script>
<script src="js/registervalidate.js"></script>

<title>Book Service</title>
</head>


<body>

<!--  <header>
  <nav>
    <span class="movetext" >MotoServ</span>
    <img class="links" src="images/skull.png"> 
    <a href="bookService" class="active">Home</a>
    <a href="validate">Login</a>
    <a href="register">Register</a>
    <a href="#portion2">Contact Us</a>
   

  </nav>
</header>-->
 <nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">MotoServ</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#bookService">Home</a></li>
        <li><a href="#portion1">Why Us</a></li>
        <li><a href="#portion2">Contact Us</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li>
        <c:if test="${empty loggedUser}">
        <a href="#register" data-toggle="modal" data-target="#register">Register</a></c:if></li>
        
        <c:if test="${empty loggedUser}">
        <li><a href="#login" data-toggle="modal" data-target="#login">Login</a></li></c:if>
      <c:if test="${not empty loggedUser}">
        <li><a href="logout"  >Logout(${loggedUser.customerName})</a></li></c:if>
      </ul>
    </div>
  </div>
</nav>

<!-- Login Modal -->
<div class="modal fade" id="login">
	<div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
          <h4 class="modal-title">Login</h4>
        </div>
         <form:form method="post" action="main/validate" modelAttribute="myUser" id="loginvalidate">
        <div class="modal-body">
         
          <div class="form-group">
    		<label for="exampleInputEmail1">Email address</label>
    		<form:input path="email" cssClass="form-control" placeholder="Email-ID" id="email"/>
    		
  		  </div>
		  <div class="form-group">
		  	<label for="password">Password</label>
			<form:password  cssClass="form-control" id="password" placeholder="Password"  path="password"/>
		  </div>
		  
          <!--  <p class="text-right"><a href="#">Forgot password?</a></p> -->
        </div>
        
        <div class="modal-footer">
        <input type="submit" value="submit" class="btn btn-primary" />
          <a href="#" data-dismiss="modal" class="btn">Close</a>
           
           
        <!--    <a href="validate" class="btn btn-primary">Login</a>  -->
        
        
        </div>
        </form:form>
      </div>
    </div>
</div>
<!-- Register Modal -->
<div class="modal fade" id="register">
	<div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
          <h4 class="modal-title">Register</h4>
        </div>
        <form:form method="post" modelAttribute="myUser" id="registervalidate" action="main/register">
        <div class="modal-body">
       
          <div class="form-group">
    		<label>Email*</label>
    		<form:input cssClass="form-control" id="email" placeholder="Enter email"  path="email" ></form:input>
  		  </div>
		  <div class="form-group">
		  	<label>Password*</label>
			<form:password cssClass="form-control" id="password" placeholder="Password"  path="password"/>
		  </div>
		 
		  <div class="form-group">
		  	<label>Name*</label>
			<form:input cssClass="form-control"  id="customerName" placeholder="Full Name" path="customerName"/>
		  </div>
		  <div class="form-group">
		  	<label>Address*</label>
			<form:input cssClass="form-control"  id="address" placeholder="Enter Your Address" path="address"/>
		  </div>
		  <div class="form-group">
		  	<label>City*</label>
			<form:input cssClass="form-control" id="city" placeholder="Your City" path="city"/>
		  </div>
		  <div class="form-group">
		  	<label>Contact Number*</label>
			<form:input cssClass="form-control" id="mobileNumber" placeholder="Enter Phone Number" path="mobileNumber"/>
		  </div>
          
        </div>
        <div class="modal-footer">
         <input type="submit" value="submit" class="btn btn-primary" />
          <a href="#" data-dismiss="modal" class="btn">Close</a>
         <!-- <a href="#" class="btn btn-primary">Login</a>-->
        </div>
        </form:form>
      </div>
    </div>
</div>




<div class=upperclass>
<div class="home">
<div class="container">
<div class="jumbotron">
	<h2>Welcome to MotoServ</h2>
	<h3>One stop solution for all your automobile service needs. Discover trusted service 
	providers for your four wheeler to conveniently book a service online.  </h3>
</div>
<div class="row hsearch">
<div class="col-lg-12 fltr">
<form:form method="post" modelAttribute="brandService" >

<div class="col-sm-3 loc">

<form:select path="city" cssClass="btn btn-default dropdown-toggle ">
   <form:option value="NONE" label="Select Area" />
   <form:options items="${centerList}" />
</form:select>
</div>


<div class="col-sm-3 mod">
<form:select path="brand" cssClass="btn btn-default dropdown-toggle">
   <form:option value="NONE" label="Select Brand"/>
   <form:options items="${brands}" />
</form:select>
</div>
<div class="col-sm-3 fin">
<form:select path="serviceType" cssClass="btn btn-default dropdown-toggle">
   <form:option value="NONE" label="Service Type"/>
   <form:options items="${servicetypes}" />
</form:select>
</div>
<div class="col-sm-3">
<button type="submit" class="btn btn-success" value="submit"><span class="glyphicon glyphicon-search"></span> Search</button>
</div>
</form:form>
		
</div>       
</div>
</div>
		<div class="arrow bounce"></div>
</div>
		
</div>					
		
	

<div class="portion">
  <h2>Why Us</h2>
</div>

<div id="portion1" class="info">
  
  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Debitis nobis ut dicta quisquam officia deleniti, amet. Obcaecati atque, cumque quae culpa ad hic commodi provident pariatur, iure nobis voluptatibus laborum amet temporibus quia, dolores veritatis, repellendus consectetur. Ut ullam officiis minus quod assumenda facere quaerat, esse, magni, aliquid culpa vero.</p>

</div>

<div class="portion two">
  <h2>Contact Us</h2>
</div>

<div id="portion2" class="info">
  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Tempora pariatur voluptate laboriosam impedit praesentium sed, nihil, dignissimos et minima recusandae quaerat enim consectetur. Molestiae assumenda distinctio, rem nostrum dolores repellendus.</p>
 
</div>


	

</body>
</html>














