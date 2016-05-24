<%-- 
    Document   : modificaoggetto
    Created on : 24-mag-2016, 20.10.55
    Author     : Alessandro Mainas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Pagina del Venditore
-->
<html>
    <head>
        <title>Venditore</title>
        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Alessandro Mainas">
        <meta name="description" content="modifica oggetti">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen">
        <link href='https://fonts.googleapis.com/css?family=Work+Sans' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <h2 class="pageid">Modifica Oggetto</h2>
        <nav class="navbar">
            <a href="login.jsp">Log in</a> 
            <a href="descrizione.jsp">Descrizione</a>
        </nav>
        <div class="page">
           
                <h3>Modifica l'oggetto selezionato:</h3>
                <div class="form_logo"></div>
                    <form method="post" action="venditore.html">
                            <div class="form-label">
                                <label for="name">Nome Prodotto</label>
                            </div>
                            <div class="form-input">
                                <input type="text" name="name" id="name">
                            </div>
                            <div class="form-label">
                                <label for="imgURL">URL Immagine</label>
                            </div>
                            <div class="form-input">
                                <input type="url" id="imgURL" name="imgURL">
                            </div>
                            <div class="form-label">
                                <label for="description">Descrizione</label>
                            </div>
                            <div class="form-input">
                                <textarea rows="4" cols="20" name="description" id="description">Inserisci Descrizione</textarea>
                            </div>
                            <div class="form-label">
                                <label for="price">Prezzo</label>
                            </div>
                            <div class="form-input">
                                <input type="number" name="price" id="price">
                            </div>
                            <div class="form-label">
                                <label for="quantity">Quantità</label>
                            </div>
                            <div class="form-input">
                                <input type="number" name="quantity" id="quantity">
                            </div>
                        <div>
                            <input type="submit" name="Modifica" value="Modifica">
                        </div>
                    </form>
                <button name="Controller" type="submit" value="controller"><a href="controller.jsp">AREA PERSONALE</a></button>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
