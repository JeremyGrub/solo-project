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
<title>Dinner Options</title>
</head>
<body class="has-text-centered pt-4">
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
  <p class="title">Dinner Options</p>
  <table class="table is-bordered is-striped is-hoverable mx-auto is-vcentered">
    <thead>
      <tr>
        <th>Restaurant</th>
        <th>Hours</th>
        <th>Link</th>
        <th>Times Chosen</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${dinner}" var="dinner">
      	<tr>
        	<td><a href="/dinners/dinner/${dinner.id}"><c:out value="${dinner.dinnerName}"/></a></td>
        	<td><c:out value="${dinner.dinnerHours}"/></td>
        	<td><a href="${dinner.dinnerLink}" target="_blank"><c:out value="${dinner.dinnerLink}"/></a></td>
        	<td><c:out value="${dinner.whoChose.size()}"/></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <a href="/dinners/new">
  	<button class="button has-background-success">Add Option</button>
  </a>
</body>
</html>