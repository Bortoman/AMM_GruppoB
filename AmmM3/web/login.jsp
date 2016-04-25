<%-- 
    Document   : login
    Created on : 25-apr-2016, 12.37.59
    Author     : Alessandro Mainas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Pagina di Log In
-->
<html>
    <head>
        <title>Log in</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Alessandro Mainas">
        <meta name="description" content="Pagina dedicata al Log in">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen">
        <link href='https://fonts.googleapis.com/css?family=Work+Sans' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
         <nav class="navbar">
            <a href='descrizione.html'>Descrizione</a>
            <a href='cliente.html'>Cliente</a>
            <a href='venditore.html'>Venditore</a>
        </nav>
        <div class="page">
            <h3>Effettua l'accesso: </h3>
            <div class="form_logo"></div>
                <form method="post" action="Login">
                    <input type="hidden" name="cmd" value="login.html">
                    <div class="input_fields">
                        <div class="form-label">
                            <label for="usrname">UserName</label>
                        </div>
                        <div class="form-input">
                            <input type="text" name="usrname" id="usrname" value="">
                        </div>
                        <div class="form-label">
                            <label for="pswd">Password</label>
                        </div>
                        <div class="form-input">
                            <input type="password" name="pswd" id="pswd" value="">
                        </div>
                    </div>
                    <div class="rememberme">
                       <p>${messaggio}</p>
                        <input type="checkbox" name="rememberusername" id="rememberusername" value="1"/>
                        <label for="rememberusername">Ricordami</label>
                    </div>
                    <div>
                        <input type="submit" name="Submit" value="Log In">
                    </div>
                </form>
        </div>
        
        <jsp:include page="footer.jsp"/>
    </body>
</html>