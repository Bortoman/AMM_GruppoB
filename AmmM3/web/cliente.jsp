<%-- 
    Document   : cliente
    Created on : 25-apr-2016, 10.45.25
    Author     : Alessandro Mainas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Pagina Cliente
-->
<html>
    <head>
        <title>Cliente</title>
        <link rel="icon" href="images/electro.png">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Alessandro Mainas">
        <meta name="description" content="Pagina relativa al cliente">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen">
        <link href='https://fonts.googleapis.com/css?family=Work+Sans' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <h2 class="pageid">Cliente</h2>
        <nav class="navbar">
            <a href="login.jsp">Log in</a> 
            <a href="descrizione.jsp">Descrizione</a>
        </nav>
        <div class="page">
            
            <c:choose>
            <c:when test="${loggedIn == true && cliente.getId()==id}">
            <h3>Scegli i prodotti:</h3>
            <table> <!-- Tabella contenente i prodotto acquistabili dai clienti -->
                <tr class="intestazionetab">
                    <th>Foto</th>
                        <th>Nome</th>
                            <th>Descrizione</th>
                                <th>Prezzo</th>
                                    <th>Quantità disponibile</th>
                                        <th>Link</th>
                </tr>
                <c:forEach var="oggetto" items="${objectSale}">
                    <c:choose>
                        <c:when test="${oggetto.getId()%2 != 0}">
                            <tr class="dispari">
                        </c:when>
                            <c:otherwise>
                                <tr class="pari">
                            </c:otherwise>
                    </c:choose>
                       <td class="photo"><img title="${oggetto.getName()}" alt="Foto ${oggetto.getName()}" src="${oggetto.getImageURL()}" width="140" height="80"></td>
                        <td>${oggetto.getName()}</td>
                            <td>${oggetto.getDescription()}</td>
                                <td> $ ${oggetto.getPrice()} </td>
                                    <td class="qty"> ${oggetto.getQuantity()}</td>
                                    <td class="link"><a href="cliente.html?idOggetto=${oggetto.getId()}">Aggiungi al carrello</a></td>
                </tr>
                </c:forEach>
                
            <table class="tabellapiccola"> <!-- Tabella contenente i prodotto acquistabili dai clienti -->
                <tr class="intestazionetab">
                    <th>Foto</th>
                        <th>Nome</th>
                                <th>Prezzo</th>
                                    <th class="quantita">Quantità</th>
                                        <th>Link</th>
                </tr>
                <c:forEach var="oggetto" items="${objectSale}">
                    <c:choose>
                        <c:when test="${oggetto.getId()%2 != 0}">
                            <tr class="dispari">
                        </c:when>
                            <c:otherwise>
                                <tr class="pari">
                            </c:otherwise>
                    </c:choose>
                       <td class="photo"><img title="${oggetto.getName()}" alt="Foto ${oggetto.getName()}" src="${oggetto.getImageURL()}" width="100" height="50"></td>
                       <td>${oggetto.getName()}</td>
                                <td> $ ${oggetto.getPrice()} </td>
                                    <td class="qty"> ${oggetto.getQuantity()}</td>
                                    <td class="link"><a href="Cliente?id=${oggetto.getId()}"></a></td>
                </tr>
                </c:forEach>
            </table>
           
          </c:when>
        <c:otherwise>
            <jsp:include page="access_denied.jsp"/>
        </c:otherwise>
            
            </c:choose>
                </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
