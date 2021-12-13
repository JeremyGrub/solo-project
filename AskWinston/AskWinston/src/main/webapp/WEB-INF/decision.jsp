<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html class="has-background-warning">
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
<title>Winston's Choice</title>
</head>
<body>
	<nav class="navbar is-warning" role="navigation" aria-label="main navigation">
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
            <div class="container has-text-centered">
                <p class="title">
                    Winston says to have: <c:out value="${dinner.dinnerName}"/>
                </p>
                <p class="subtitle">
                    Choose to eat here or ask again
                </p>
                <p>
                	Hours: <c:out value="${dinner.dinnerHours}"/>
                </p>
                <p>Link: <a href="${dinner.dinnerLink}" target="_blank"><c:out value="${dinner.dinnerLink}"/></a></p>
                <br>
                <a href="/decision/choose/${dinner.id}" class="button is-info">Eat here!</a>
				<br>
                <a href="/decision" class="button is-danger m-6">Ask again</a> 
            </div>
        </div>
    </section>
</body>
</html>