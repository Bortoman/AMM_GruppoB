<%-- 
    Document   : controller
    Created on : 24-mag-2016, 19.49.23
    Author     : Alessandro Mainas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conferma Inserimento</title>
        <link rel="icon" href="images/electro.png">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Alessandro Mainas">
        <meta name="controller" content="E-commerce incentrato sulla compravendita di chitarre e accessori">
        <meta name="keywords" content="guitar, shop, music, instrument">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen">
        <link href='https://fonts.googleapis.com/css?family=Work+Sans' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <h2 class="pageid">Controller</h2>
        <nav class="navbar">
            <a href="login.jsp">Log in</a> 
            <a href="descrizione.jsp">Descrizione</a>
        </nav>
        <div class="page">
        <h3>
            Lista dei tuoi articoli
        </h3>
        <table> <!-- Tabella contenente i prodotto acquistabili dai clienti -->
                <tr class="intestazionetab">
                    <th>Foto</th>
                        <th>Nome</th>
                            <th>Descrizione</th>
                                <th>Prezzo</th>
                                    <th>Elimina</th>
                                        <th>Modifica</th>
                </tr>
                <c:forEach var="oggetto" items="${listaOggettiVenditore}">
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
                            <td> $ ${oggetto.getPrice()} </td>
                                <td class="qty"> ${oggetto.getQuantity()}</td>
                                <td><a href="venditore.html?idOggettodaEliminare=${oggetto.getId()}">Elimina</a></td>
                                <td><a href="venditore.html?idOggettodaModificare=${oggetto.getId()}">Modifica</a></td>
                </tr>
                </c:forEach>
        </table>
                
            <table class="tabellapiccola"> <!-- Tabella contenente i prodotto acquistabili dai clienti -->
                <tr class="intestazionetab">
                    <th>Foto</th>
                        <th>Nome</th>
                                <th>Prezzo</th>
                                    <th class="quantita">Quantità</th>
                                        <th>Link</th>
                </tr>
                <c:forEach var="oggetto" items="${venditore.getOggettiVenditore()}">
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
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>