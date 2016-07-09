/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function ()
{
    $("#filtra").keyup(function ()
    {
        // Preleva il valore
        var text = $("#filtra").val();

        $.ajax(
                {
                    url: "filter.json",
                    data: {
                        cmd: "search",
                        text: text
                    },
                    dataType: 'json',
                    success: function (data, state) {
                        aggiornaListaOggetti(data);//funzione chiamata in caso di successo
                    },
                    error: function (data, state) {
                    }
                });
        function aggiornaListaOggetti(listaOggetti)
        {


            if (listaOggetti.length !== 0) {
                $(".pari").empty();
                $(".dispari").empty();

                // per ogni oggetto che rispetta la query
                for (var oggetto in listaOggetti)//passato in request dalla servlet Filter.java
                {

                    // riga per la tabella
                    var tr = document.createElement("tr");
                    if (listaOggetti[oggetto].id % 2 === 0)
                        tr.setAttribute("class", "pari");
                    else
                        tr.setAttribute("class", "dispari");

                    // colonna per l'immagine 
                    var td = document.createElement("td");
                    td.setAttribute("class", "photo");
                    var img = document.createElement("img");
                    img.setAttribute("title", listaOggetti[oggetto].name);//dai campi name del vettore json
                    img.setAttribute("src", listaOggetti[oggetto].imageURL);
                    img.setAttribute("alt", listaOggetti[oggetto].name);
                    img.setAttribute("width", 140);
                    img.setAttribute("height", 80);
                    td.appendChild(img);
                    tr.appendChild(td);

                    // colonna per il nome
                    var td = document.createElement("td");
                    var txt = document.createTextNode(listaOggetti[oggetto].name);
                    td.appendChild(txt);
                    tr.appendChild(td);


                    //colonna per la descrizione
                    var td = document.createElement("td");
                    var txt = document.createTextNode(listaOggetti[oggetto].description);
                    td.appendChild(txt);
                    tr.appendChild(td);

                    // colonna per il prezzo
                    var td = document.createElement("td");
                    td.setAttribute("class", "price");
                    var txt = document.createTextNode(listaOggetti[oggetto].price + "$");
                    td.appendChild(txt);
                    tr.appendChild(td);

                    // colonna per la quantità
                    var td = document.createElement("td");
                    td.setAttribute("class", "qty");
                    var txt = document.createTextNode(listaOggetti[oggetto].quantity);
                    td.appendChild(txt);
                    tr.appendChild(td);

                    // colonna per il link all'acquisto
                    var td = document.createElement("td");
                    td.setAttribute("class", "link");
                    var a = document.createElement("a");
                    a.setAttribute("href", "cliente.html?idOggetto=" + listaOggetti[oggetto].id);
                    a.innerHTML = 'Aggiungi al carrello';
                    td.appendChild(a);
                    tr.appendChild(td);
                    // inserisce la riga appena creata nella tabella
                    document.getElementById("table").appendChild(tr);

                    // riga per la tabella piccola
                    var trp = document.createElement("tr");
                    if (listaOggetti[oggetto].id % 2 === 0)
                        trp.setAttribute("class", "pari");
                    else
                        trp.setAttribute("class", "dispari");

                    // colonna per l'immagine 
                    var tdp = document.createElement("td");
                    tdp.setAttribute("class", "photo");
                    var imgp = document.createElement("img");
                    imgp.setAttribute("title", listaOggetti[oggetto].name);//dai campi name del vettore json
                    imgp.setAttribute("src", listaOggetti[oggetto].imageURL);
                    imgp.setAttribute("alt", listaOggetti[oggetto].name);
                    imgp.setAttribute("width", 40);
                    imgp.setAttribute("height", 20);
                    tdp.appendChild(imgp);
                    trp.appendChild(tdp);

                    // colonna per il nome
                    var tdp = document.createElement("td");
                    var txtp = document.createTextNode(listaOggetti[oggetto].name);
                    tdp.appendChild(txtp);
                    trp.appendChild(tdp);

                    // colonna per il prezzo
                    var tdp = document.createElement("td");
                    td.setAttribute("class", "price");
                    var txtp = document.createTextNode(listaOggetti[oggetto].price + "$");
                    tdp.appendChild(txtp);
                    trp.appendChild(tdp);

                    // colonna per la quantità
                    var tdp = document.createElement("td");
                    tdp.setAttribute("class", "qty");
                    var txtp = document.createTextNode(listaOggetti[oggetto].quantity);
                    tdp.appendChild(txtp);
                    trp.appendChild(tdp);

                    // colonna per il link all'acquisto
                    var tdp = document.createElement("td");
                    td.setAttribute("class", "link");
                    var ap = document.createElement("a");
                    ap.setAttribute("href", "cliente.html?idOggetto=" + listaOggetti[oggetto].id);
                    tdp.appendChild(ap);
                    trp.appendChild(tdp);
                    // inserisce la riga appena creata nella tabella
                    document.getElementById("tabellapiccola").appendChild(trp);


                }



            } else {
                $(".pari").empty();
                $(".dispari").empty();
                var txt = document.getElementById("objnotfound");//stampo l'errore se la lista torna vuota
                txt.innerHTML = 'Oggetto non trovato :(';
            }
        }
    });
});

