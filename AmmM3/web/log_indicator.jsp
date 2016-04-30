<%-- 
    Document   : log_indicator
    Created on : 30-apr-2016, 13.56.05
    Author     : Alessandro Mainas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="log_indicator">
    <c:if test="${ loggedIn == true}">
        <a class="droptoggle">${firstname} ${lastname}</a>
        <a id="logout" href="Logout?">Log Out</a>
    </c:if>
        <c:if test="${ loggedIn == false || loggedIn == null}">
            <p>
                Non sei loggato
            </p>
        </c:if>
</div>
