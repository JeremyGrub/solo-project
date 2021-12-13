<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html class="has-background-info">
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
<title>New Option</title>
</head>
<body>
<nav class="navbar is-info" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
      <a class="navbar-item" href="/ask">
          <img src="/imgs/winstonGogglesEmote22222 copy.png" alt="Winston with goggles logo" width="220" height="112">
      </a>
  </div>
  <div class="navbar-menu">
      <div class="navbar-end">
          <a href="/logout" class="navbar-item">Logout</a>
      </div>
  </div>
</nav>
<section class="hero is-fullheight-with-navbar">
  <div class="hero-body">
  	<div class="container has-text-centered is-centered">
	   <div class="columns">
  		 <div class="column is-one-half">
	      	<p class="title">Add New Dinner Option</p>
	        <form:form action="/dinners/create" method="post" modelAttribute="newDinner">
	          <div class="field">
	            <form:label class="label" path="dinnerName">Restaurant:</form:label>
	            <form:errors path="dinnerName"/>
	            <form:input class="input" path="dinnerName"/>
	          </div>
	          
	          <div class="field">
	            <form:label class="label" path="dinnerHours">Hours:</form:label>
	            <form:errors path="dinnerHours"/>
	            <form:input class="input" path="dinnerHours"/>
	          </div>
	            
	          <div class="field">
	            <form:label class="label" path="dinnerLink">Link:</form:label>
	            <form:errors path="dinnerLink"/>
	            <form:input class="input" path="dinnerLink"/>
	          </div>
	            
	            <form:input type="hidden" value="${userId}" path="user"/>
	            
	            <input class="button" type="submit" value="Submit"/>
	        </form:form>
	  	</div>
      </div>
  	</div>
  </div>
</section>
</body>
</html>