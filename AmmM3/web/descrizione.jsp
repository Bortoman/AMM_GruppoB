<%-- 
    Document   : descrizione
    Created on : 25-apr-2016, 10.17.05
    Author     : Alessandro Mainas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Pagina di descrizone dei sito con elenco delle varie categorie d'acquisto
-->
<html>
    <head>
        <title>Guitarshop</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Alessandro Mainas">
        <meta name="description" content="E-commerce incentrato sulla compravendita di chitarre e accessori">
        <meta name="keywords" content="guitar, shop, music, instrument">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen">
        <link href='https://fonts.googleapis.com/css?family=Work+Sans' rel='stylesheet' type='text/css'>
    </head>
    <body>
        
        <jsp:include page="header.jsp"/>
        
        <h2 id="pageid" class="pageid">Descrizione</h2>
        <nav class="navbar"><a href="login.jsp">Log in</a></nav>
        <div class="dropdown">
            <button class="dropbtn"></button>
            <nav id="categories">
                <p>Scegli tra:</p>
                <ol> <!-- link interni alle categorie d'acquisto -->
                    <li><a href='#guitars'>Chitarre</a></li>
                    <li><a href='#amplifiers'>Amplificatori</a></li>
                    <li><a href='#accessories'>Accessori</a></li>
                    <li><a href='#pedals'>Pedaliere</a></li>
                </ol>
            </nav>
        </div>
        <!-- <div class="toplink"><a href="#top">top</a></div> -->
        <div class="sidebar">
        <p>
            Dai migliori produttori di strumenti musicali all'avanguardia a casa 
            tua in un solo click.<br/>Cosa aspetti?<br/>Definisci il tuo stile su GuitarShop!<br/>
            Acquista in tutta sicurezza, o metti in vendita i tuoi prodotti musicali.
        </p>
        </div>
        <article>
            <h2>Categorie:</h2>
            <section class="guitars">
                <div id="guitarH">
                    
                <h3 id='guitars'>Guitars</h3>
                </div>
                <p>Inforca i migliori manici, autentici pezzi da collezione messi a disposizione dai produttori più famosi.</p>
            </section>
            <section class="amplifiers">
                <div id="amplifierH">
                    
                <h3 id='amplifiers'>Amplifiers</h3>
                </div>
                <p>Scegli tra i più moderni e potenti amplificatori, porta al livello successivo le tue esibizioni con un sound avvolgente e ricco grazie ai modelli offerti da GuitarShop.</p>
            </section>
            <section class="accessories">
                <div id="accessoriesH">
                    
                <h3 id='accessories'>Accessories</h3>
                </div>
                <p>Metallo per il sound più ricercato, pelle rifinita per il comfort assoluto.</p>
            </section>
            <section class="pedals">
                <div id="pedalsH">
                    
                <h3 id='pedals'>Pedals</h3>
                </div>
                <p>Distorsione potente o sound morbido e vibrante? Costruisci il tuo stile con le migliori pedaliere per effetti!</p>
            </section>
        </article>
        <jsp:include page="footer.jsp"/>
        </body>
</html>