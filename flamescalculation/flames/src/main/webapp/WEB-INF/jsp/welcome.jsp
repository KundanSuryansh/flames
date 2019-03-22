<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/util.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/materialize.css">
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/materialize.min.css">
				<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/popup.css">
<!--===============================================================================================-->

<title>welcome</title>
</head>
<body>
	<%
	
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate" ); //to protect from back press in browser (HTTP 1.1)
	response.setHeader("Pragma","no-cache");// http 1.0
	response.setHeader("Expires","0"); //proxy server cache remove
	
	
	if(session.getAttribute("email")==null)
	{
		response.sendRedirect("login");
	}
	%>
	<div class="limiter">
		<div class="container-login100" style="background-image: url('${pageContext.request.contextPath}/images/heart.png');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" action="calculate">
					<span class="login100-form-title p-b-49">
						Hello,${name}<br>
						Welcome to FLAMES!
					</span>
					 <div class="wrap-input100 validate-input m-b-23" data-validate = "name is reauired">
						<span class="label-input100">Enter First Name</span>
						<input class="input100" type="text" name="name1">
						<span class="focus-input100"></span>
					</div>
					<br>
					<div>
					<center><img src='${pageContext.request.contextPath}/images/icons/hearticon.png'></center>
					</div>
					<br>

					 <div class="wrap-input100 validate-input m-b-23" data-validate = "name is reauired">
						<span class="label-input100">Enter Second Name</span>
						<input class="input100" type="text" name="name2">
						<span class="focus-input100"></span>
					</div>
					<br>
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">
								Calculate
							</button>
						</div>
					</div>
					<br>
    		<c:choose>
          <c:when test = "${result == 1}">
            <p style="color: red">can't calculate,either you have given the same name or other name has same characters.</p>
         </c:when>
         <c:when test = "${result == 0}">
          <p style="color: red">flames calculation says : ${flames}</p>
         </c:when>
           </c:choose>
				</form>
				<br>
				<a href="logout">Logout</a>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>


   
 
 	
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/popper.js"></script>
	<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/daterangepicker/moment.min.js"></script>
	<script src="${pageContext.request.contextPath}/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	<script src="${pageContext.request.contextPath}/js/materialize.js"></script>
	<script src="${pageContext.request.contextPath}/js/materialize.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/popup.js"></script>
</body>
</html>