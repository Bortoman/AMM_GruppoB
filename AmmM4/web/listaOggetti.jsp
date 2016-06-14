<%-- 
    Document   : listaOggetti
    Created on : 14-giu-2016, 14.08.46
    Author     : root
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="oggetto" items="${listaOggetti}">
        <json:object>
            <json:property name="name" value="${oggetto.getName()}"/>
            <json:property name="imageURL" value="${oggetto.getImageURL()}"/>
            <json:property name="quantity" value="${oggetto.getQuantity()}"/>
            <json:property name="price" value="${oggetto.getPrice()}"/>
            <json:property name="id" value="${oggetto.getId()}"/>
            <json:property name="description" value="${oggetto.getDescription()}"/>
        </json:object>
    </c:forEach>
</json:array>
