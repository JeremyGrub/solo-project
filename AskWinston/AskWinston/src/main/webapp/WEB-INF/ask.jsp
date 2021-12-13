<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html class="has-background-danger">
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
<title>Ask Winston</title>
</head>
<body>
	<nav class="navbar is-danger" role="navigation" aria-label="main navigation">
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
    <div class="columns is-vcentered has-background-danger">
        <div class="column is-flex-justify-content-center">
            <p class="title has-text-centered">Don't know what to have for dinner?</p>
            <div class="buttons are-large is-flex-direction-column">
                <a href="/decision" class="button has-background-danger-light">Ask Winston</a>
                <a href="/dinners" class="button has-background-danger-light">View/Add Options</a>
            </div>
        </div>
        <div class="column">
            <img width="650" src="/imgs/IMG_6315.jpg">
        </div>
    </div>
</body>
</html>