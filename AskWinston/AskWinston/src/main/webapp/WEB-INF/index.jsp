<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
<title>Login</title>

</head>
<body>
	<section class="hero is-primary is-fullheight">
    <div class="hero-head">
        <div class="title has-text-centered mt-6 pt-6 is-size-1">Ask Winston</div>
        <div class="subtitle has-text-centered">Let Winston choose what you should have for dinner tonight!</div>
    </div>
    <div class="hero-body">
        <div class="container">
            <div class="columns is-centered">
                <div class="column is-5">
                    <form action="/login" method="POST" class="box">
                      <p class="title has-text-dark">Login</p>
                      
                      <div class="field">
                      	<p><c:out value="${error}" /></p>
                        <label type="email" for="email" class="label">Email</label>
                        <input type="text" id="email" name="email" class="input" placeholder="Winston@example.com"/>
                      </div>
                      <div class="field">
                          <label for="password" class="label">Password</label>
                          <input type="password" id="password" name="password" class="input" placeholder="**********"/>
                      </div>
                      <div class="field">
                        <input type="submit" value="Login" class="button is-info"/>
                      </div>
                    </form>
                </div>
                <div class="column is-5">	
                  <form:form method="POST" action="/registration" modelAttribute="user" class="box">
                  	<p class="title has-text-dark">Register</p>
                  	
                    <div class="field">
                      
                      <form:label path="name" class="label">Name:</form:label>
                      <form:errors path="name"/>
                      <form:input type="name" path="name" class="input" placeholder="Winston"/>
                    </div>
                    <div class="field">
                      <form:label path="email" class="label">Email:</form:label>
                      <form:errors path="email"/>
                      <form:input type="email" path="email" class="input" placeholder="Winston@example.com"/>
                    </div>
                    <div class="field">
                      <form:label path="password" class="label">Password:</form:label>
                      <form:errors path="password"/>
                      <form:password path="password" class="input" placeholder="**********"/>
                    </div>
                    <div class="field">
                      <form:label path="passwordConfirmation" class="label">Password Confirmation:</form:label>
                      <form:errors path="passwordConfirmation"/>
                      <form:password path="passwordConfirmation" class="input" placeholder="**********"/>
                    </div>
                    <div class="field">
                      <input type="submit" value="Register" class="button is-info"/>
                    </div>
                  </form:form>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>