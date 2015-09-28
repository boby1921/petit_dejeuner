<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Starter Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Project name</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			</div>
		</div>

	</nav>

	<div class="container" style="padding-top: 100px;">

		<h3>Ajouter un nouveau petit Dej :</h3>
		<c:if test="${not empty error}">
			<label style="color: red;"><c:out value="${error}" /></label>
		</c:if>
		<f:form action="save.do" commandName="petitdej" method="post">
			<f:hidden path="id" />
			<div class="form-group">
				<label>Date Prevu :</label>
				<f:input path="datePetitDej" class="form-control" />
			</div>
			<div class="form-group">
				<label>Prix :</label>
				<f:input path="prix" class="form-control" />
			</div>
			<div class="form-group">
				<label>Type :</label>
				<f:select path="type" id="type" class="form-control">
					<f:option value="SUCRE">Sucré</f:option>
					<f:option value="SALE">Salé</f:option>
				</f:select>
				<%-- <f:input path="type" class="form-control" /> --%>
			</div>
		 	 <div class="form-group">
				<label>Organisateur :</label>
			<f:input path="organisateur.nom"  class="form-control" />
			<f:hidden path="organisateur.id"/>
			</div>
			<input type="submit" value="Valider" class="btn btn-default" />
		</f:form>
		<a href="list.do">List des petits dejeuner</a>

	</div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="script.js"></script>
	<script src="jquery-1.11.3.min.js"></script>

</body>
</html>