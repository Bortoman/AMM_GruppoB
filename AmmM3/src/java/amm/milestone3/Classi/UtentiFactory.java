/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone3.Classi;

import java.util.ArrayList;

/**
 *
 * @author Alessandro Mainas
 */
public class UtentiFactory {
    private static UtentiFactory singleton;
    public static UtentiFactory getInstance(){
        if (singleton == null){
            singleton = new UtentiFactory();
        }
        return singleton;
    }
    
    // Lista Oggetti in vendita
    private ArrayList<OggettiInVendita> listaOggetti = new ArrayList<>();
    //Lista Venditori
    private ArrayList<Utente> listaVenditori = new ArrayList<>();
    //Lista Clienti
    private ArrayList<Utente> listaClienti = new ArrayList<>();
    
    //Costruttore
    public UtentiFactory(){
        
        //Oggetti
        OggettiInVendita oggetto_1 = new OggettiInVendita();
        oggetto_1.setId(0);
        oggetto_1.setName("Gibson EDS-DoubleneckCustom");
        oggetto_1.setDescription("Gibson EDS-Doubleneck Custom, l'originale due-in-uno della Gibson ricreata da Gibson Custom curata in ogni suo dettaglio, in versione Heritage Cherry.");
        oggetto_1.setImageURL("images/EDSDoubleneck.jpg");
        oggetto_1.setPrice(6499);
        oggetto_1.setQuantity(1);
        listaOggetti.add(oggetto_1);
        
        OggettiInVendita oggetto_2 = new OggettiInVendita();
        oggetto_2.setId(1);
        oggetto_2.setName("Gibson Flying V Custom");
        oggetto_2.setDescription("Gibson Flying V Custom, rivisitazione futuristica della versione anni 50, in versione Black Beauty Custom.");
        oggetto_2.setImageURL("images/GibsonFlyingV.jpg");
        oggetto_2.setPrice(5399);
        oggetto_2.setQuantity(1);
        listaOggetti.add(oggetto_2);
     
        OggettiInVendita oggetto_3 = new OggettiInVendita();
        oggetto_3.setId(2);
        oggetto_3.setName("Gibson Les Paul");
        oggetto_3.setDescription("La Les Paul Standard 1959 50° Anniversario rifinita con Heritage Cherry Sunburst");
        oggetto_3.setImageURL("images/GibsonLesPaul.jpg");
        oggetto_3.setPrice(8504);
        oggetto_3.setQuantity(3);
        listaOggetti.add(oggetto_3);
        
        OggettiInVendita oggetto_4 = new OggettiInVendita();
        oggetto_4.setId(3);
        oggetto_4.setName("Gibson Hummingbir Koa Elite");
        oggetto_4.setDescription("Uno dei più iconici modelli, fatta a mano con spettacolare koa AAA, fronte dietro e lati.");
        oggetto_4.setImageURL("images/GibsonHKE.jpg");
        oggetto_4.setPrice(4499);
        oggetto_4.setQuantity(3);
        listaOggetti.add(oggetto_4);
        
        OggettiInVendita oggetto_5 = new OggettiInVendita();
        oggetto_5.setId(4);
        oggetto_5.setName("Fender Stratocaster");
        oggetto_5.setDescription("American Custom Stratocaster 2016 Chocolate Sunburst");
        oggetto_5.setImageURL("images/Fender_strato.jpg");
        oggetto_5.setPrice(4499);
        oggetto_5.setQuantity(2);
        listaOggetti.add(oggetto_5);
        
        OggettiInVendita oggetto_6 = new OggettiInVendita();
        oggetto_6.setId(5);
        oggetto_6.setName("Marshall JVM205H");
        oggetto_6.setDescription("Il British-built, completamente valvolare 50 Watt JVM205H, 2 canali.");
        oggetto_6.setImageURL("images/MARSHJVM205H.jpg");
        oggetto_6.setPrice(1499);
        oggetto_6.setQuantity(5);
        listaOggetti.add(oggetto_6);
        
        OggettiInVendita oggetto_7 = new OggettiInVendita();
        oggetto_7.setId(6);
        oggetto_7.setName("Marshall 1960A");
        oggetto_7.setDescription("Il British-built, svasato, 4x12\" speakers per un totale di 300W, 2 canali.");
        oggetto_7.setImageURL("images/M1960A.jpg");
        oggetto_7.setPrice(899);
        oggetto_7.setQuantity(5);
        listaOggetti.add(oggetto_7);
        
        OggettiInVendita oggetto_8 = new OggettiInVendita();
        oggetto_8.setId(7);
        oggetto_8.setName("Marshall 1960B");
        oggetto_8.setDescription("Il British-built, 4x12\" speakers per un totale di 300W, 2 canali.");
        oggetto_8.setImageURL("images/M1960A.jpg");
        oggetto_8.setPrice(899);
        oggetto_8.setQuantity(8);
        listaOggetti.add(oggetto_8);
        
        OggettiInVendita oggetto_9 = new OggettiInVendita();
        oggetto_9.setId(8);
        oggetto_9.setName("Marshall JH-1 JACKHAMMER");
        oggetto_9.setDescription("Pedale Marshall, distorsione energica, ma sound naturale e realistico.");
        oggetto_9.setImageURL("images/M1960A.jpg");
        oggetto_9.setPrice(79);
        oggetto_9.setQuantity(10);
        listaOggetti.add(oggetto_9);
        
        //Clienti
        Cliente cliente_1 = new Cliente();
        cliente_1.setId(1);
        cliente_1.setFirstName("Mario");
        cliente_1.setLastName("Rossi");
        cliente_1.setSaldo(90000.0);
        cliente_1.setPassword("0");
        cliente_1.setUsername("mariorossi");
        listaClienti.add(cliente_1);
        
        Cliente cliente_2 = new Cliente();
        cliente_2.setId(0);
        cliente_2.setFirstName("Bianca");
        cliente_2.setLastName("Veronesi");
        cliente_2.setSaldo(9000);
        cliente_2.setPassword("b_Veronesi93");
        cliente_2.setUsername("biancavero");
        listaClienti.add(cliente_2);
        
        //Venditori
        Venditore venditore_1 = new Venditore();
        venditore_1.setId(2);
        venditore_1.setFirstName("Fernando");
        venditore_1.setLastName("Luiz");
        venditore_1.setPassword("l_Fernando2");
        venditore_1.setUsername("fluiz");
        listaVenditori.add(venditore_1);
        
        Venditore venditore_2 = new Venditore();
        venditore_2.setId(4);
        venditore_2.setFirstName("Chiara");
        venditore_2.setLastName("Matterport");
        venditore_2.setPassword("m_chiara3");
        venditore_2.setUsername("chiaramatter");
        listaVenditori.add(venditore_2);
    }
    /* Metodi */

    /**
     *
     * @return lista Venditori
     */
    public ArrayList<Utente> getVenditoreList(){
        return listaVenditori;
    }
    public Utente getVenditore(int id){
        for(Utente u : listaVenditori){
            if(u.getId() == id)
                return u;
        }
        return null;
    }
    public ArrayList<Utente> getClienteList(){
        return listaClienti;
    }
    public Utente getCliente(int id){
        for(Utente u : listaClienti){
            if(u.getId() == id)
                return u;
        }
        return null;
    }
    public ArrayList<OggettiInVendita> getOggettiList(){
        return listaOggetti;
    }
    public OggettiInVendita getOggetto(int id){
        for(OggettiInVendita o : listaOggetti){
            if(o.getId() == id)
                return o;
        }
        return null;
    }
    public void aggiungiOggetto(OggettiInVendita o){
        listaOggetti.add(o);
    }
    public ArrayList<Utente> getUserList(){
        ArrayList<Utente> listaUtenti = new ArrayList<>();
        
        listaUtenti.addAll(listaVenditori);
        listaUtenti.addAll(listaClienti);
        
        return listaUtenti;
    }
    
}
