<!-- This is the start of header -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://bootswatch.com/5/quartz/bootstrap.min.css" rel="stylesheet">

<meta charset="UTF-8">
<title>Flixme: Movie Review & Rating</title>
</head>
<body>

	<div class="alert alert-primary">
		<div class="container">
			<h1>Flixme Movie Review & Rating</h1>

		
			
		</div>
	</div>
	
	<div class="container">
		<a class="btn btn-link" href="./">Home</a>
		
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c"%>
		
		<c:choose>
			<c:when test="${sessionScope.loggedInUser==null}">
				<a class="btn btn-primary" href="./login">Login</a>
				<a class="btn btn-primary" href="./register">Register</a>
			</c:when>

			<c:otherwise>
				<a class="btn btn-primary" href="./">Welcome ${sessionScope.loggedInUser.name} </a>
				<a class="btn btn-primary" href="./profile">View/Edit profile</a>
				<a class="btn btn-primary" href="./check-balance">Check Balance</a>
				<a class="btn btn-primary" href="./get-movies-list">Movie List</a>
				<a class="btn btn-primary" href="./search-movies">search movies</a>
				
				
				<c:choose>
					<c:when test="${sessionScope.loggedInUser.role == 'admin'}">
						<a class="btn btn-primary" href="./add-movie">Add Movies</a>
					</c:when>
					<c:otherwise>
					
					</c:otherwise>
				</c:choose>
				<a class="btn btn-link" href="./logout">Logout</a>
			</c:otherwise>
		</c:choose>
		<!--<a class="btn btn-link" href="./about-us">About us</a> -->
		<hr />
	</div>
	
	<div class="container">
	
<!-- This is the end of header -->