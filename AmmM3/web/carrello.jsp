<%-- 
    Document   : carrello
    Created on : 28-apr-2016, 15.05.42
    Author     : Alessandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrello</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Alessandro Mainas">
        <meta name="carrello" content="carrello">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen">
        <link href='https://fonts.googleapis.com/css?family=Work+Sans' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <h2 class="pageid">Conferma Inserimento</h2>
        <nav class="navbar">
            <a href="login.jsp">Log in</a> 
            <a href="descrizione.jsp">Descrizione</a>
        </nav>
        <div class="page">
        <h3>
            Carrello
        </h3>
        <div class="recap">
            <ul>
                <li>${oggetto.getName()}</li>
                    <li><image src="${oggetto.getImageURL()}" width="300" heigth="300"></li>
                        <li>${oggetto.getDescription()}</li>
                             <li>${oggetto.getPrice()}</li>
                                 <li> ${oggetto.getQuantity()}</li>
            </ul>
                                 <button name="Submit" type="submit" value="conferma"><a href="Cliente?idogg=${oggetto.getId()}">CONFERMA ACQUISTO</a></button>
                                 <p>${pagato}</p>
        </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
