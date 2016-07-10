<%-- 
    Document   : footer
    Created on : 25-apr-2016, 10.25.07
    Author     : Alessandro Mainas
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<footer>
    <p>
        <a href="http://jigsaw.w3.org/css-validator/check/referer">
            <img style="border:0;width:88px;height:31px"
                src="http://jigsaw.w3.org/css-validator/images/vcss"
                alt="CSS Valido!" />
        </a>
    </p>
    <c:if test="${ loggedIn == true}">
        <p class="saldo"> Saldo: $ ${saldo}</p>
    </c:if>
    
</footer>
