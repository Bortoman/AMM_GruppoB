/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone3.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Alessandro Mainas
 */
public class UtentiFactory {
    /*
    // Lista Oggetti in vendita
    private ArrayList<OggettiInVendita> listaOggetti = new ArrayList<>();
    //Lista Venditori
    private ArrayList<Utente> listaVenditori = new ArrayList<>();
    //Lista Clienti
    private ArrayList<Utente> listaClienti = new ArrayList<>();
    */
    //Costruttore
    // Attributi
    // Singleton
    private static UtentiFactory singleton;
    String connectionString; 
    
    // E' l'unico metodo che restituisce il singleton. Provvede a inizializzarlo alla prima chiamata.
    // Nelle successive chiamate lo restituisce e basta.
    public static UtentiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiFactory();
        }
        return singleton;
    }
    
    /* Costruttore */
    private UtentiFactory() {

    }
    
    /* Metodi */        
    public Utente getUtente(String username, String password)
    {
        try{
            Connection conn= DriverManager.getConnection(connectionString, "mariorossi", "0");
            //sql Command
            String query = "select * from venditore where username = ? and password = ?";
            //
            PreparedStatement stmt= conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            //Esegui query
            ResultSet res = stmt.executeQuery();
            
            if(res.next())
            {
                Venditore venditore = new Venditore();
                venditore.setId(res.getInt("id"));
                venditore.setFirstName(res.getString("nome"));
                venditore.setLastName(res.getString("cognome"));
                venditore.setUsername(res.getString("username"));
                venditore.setPassword(res.getString("password"));
                venditore.setSaldo(res.getDouble("saldo"));
                // Oggetti in vendita da questo venditore
                query = "select * from oggetto_in_vendita"
                        + " where idVenditore = "+ venditore.getId();
                Statement st= conn.createStatement();
                ResultSet res2= st.executeQuery(query);
                
                while(res2.next())
                {
                    OggettiInVendita o = new OggettiInVendita();
                    o.setId(res2.getInt("id"));
                    o.setName(res2.getString("nome"));
                    o.setImageURL(res2.getString("imageURL"));
                    o.setDescription(res2.getString("descrizione"));
                    o.setPrice(res2.getDouble("prezzo"));
                    o.setQuantity(res2.getInt("quantita"));
                    venditore.getOggettiVenditore().add(o);
                }
                
                st.close();
                stmt.close();
                conn.close();
                return venditore;
            }
            
            //sql command
            query = "select * from cliente where username = ? and password = ?";
            stmt = conn.prepareStatement(query);
            //dati
            stmt.setString(1, username);
            stmt.setString(2, password);
            res = stmt.executeQuery();
            
            if (res.next())
            {
                Cliente cliente = new Cliente();
                cliente.setId(res.getInt("id"));
                cliente.setFirstName(res.getString("nome"));
                cliente.setLastName(res.getString("cognome"));
                cliente.setUsername(res.getString("username"));
                cliente.setPassword(res.getString("password"));
                cliente.setSaldo(res.getDouble("saldo"));
                
                stmt.close();
                conn.close();
                return cliente;
            }
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {
        
        }
        return null;
    }
    // Venditore
    // Dato un id restituisce il relativo venditore (se esiste un venditore con quell'id, altrimenti
    // restituisce null).
    public Utente getVenditore(int id)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "mariorossi", "0");
            // Query
            String query = "select * from venditore "
            + "where id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                Venditore current = new Venditore();
                current.setId(res.getInt("id"));
                current.setFirstName(res.getString("nome"));
                current.setLastName(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setSaldo(res.getDouble("saldo"));
                // Oggetti in vendita da questo venditore
                query = "select * from oggetto_in_vendita"
                        + " where oggetto_in_vendita.idVenditore = "+ current.getId();
                Statement st= conn.createStatement();
                ResultSet res2= st.executeQuery(query);
                
                while(res2.next())
                {
                    OggettiInVendita o = new OggettiInVendita();
                    o.setId(res2.getInt("id"));
                    o.setName(res2.getString("nome"));
                    o.setImageURL(res2.getString("imageURL"));
                    o.setDescription(res2.getString("descrizione"));
                    o.setPrice(res2.getDouble("prezzo"));
                    o.setQuantity(res2.getInt("quantita"));
                    current.getOggettiVenditore().add(o);
                }                 
                st.close();
                stmt.close();
                conn.close();
                return current;
            }   
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    
    // Restituisce la lista di tutti i venditori
    public ArrayList<Venditore> getVenditori()
    {
        ArrayList<Venditore> listaVenditori = new ArrayList<Venditore>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "mariorossi", "0");
            Statement stmt = conn.createStatement();
            String query = "select * from "
            + "venditore'";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Venditore current = new Venditore();
                current.setId(set.getInt("id"));
                current.setFirstName(set.getString("nome"));
                current.setLastName(set.getString("cognome"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                current.setSaldo(set.getDouble("saldo"));
                listaVenditori.add(current);
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaVenditori;
    }
    
    // Clienti
    // Restituisce la lista di tutti gli clienti
    public ArrayList<Cliente> getClienti()
    {
        ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "mariorossi", "0");
            Statement stmt = conn.createStatement();
            String query = "select * from cliente";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Cliente current = new Cliente();
                current.setId(set.getInt("id"));
                current.setFirstName(set.getString("nome"));
                current.setLastName(set.getString("cognome"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                current.setSaldo(set.getDouble("saldo"));
                listaClienti.add(current);
            }     
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaClienti;
    }
    
    // Dato un id restituisce il relativo cliente (se esiste uno cliente con quell'id, altrimenti
    // restituisce null).
    public Utente getCliente(int id)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "mariorossi", "0");
            String query = "select * from cliente "
            + "where id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
           
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                Cliente current = new Cliente();
                current.setId(res.getInt("id"));
                current.setFirstName(res.getString("nome"));
                current.setLastName(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setSaldo(res.getDouble("saldo"));
                
                stmt.close();
                conn.close();
                return current;
            }
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    // OggettiInVendita
    public void inserisciOggetto(String name, String imageURL, String description, Double price, Integer quantity, Integer idVenditore){
        try
        {
            Connection conn = DriverManager.getConnection(connectionString, "mariorossi", "0");
            Statement stmt = conn.createStatement();
            String query = "insert into oggetto_in_vendita(id, nome, imageURL, descrizione, prezzo, quantita, id Venditore)"
                            + " values(default, ?, ?, ?, ?, ?, ?)";
            stmt.executeQuery(query);
            stmt.close();
            
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public ArrayList<OggettiInVendita> getOggettiInVendita()
    {
        ArrayList<OggettiInVendita> lista = new ArrayList<OggettiInVendita>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "mariorossi", "0");
            Statement stmt = conn.createStatement();
            String query = "select * from "
            + "oggetto_in_vendita";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                OggettiInVendita o = new OggettiInVendita();
                    o.setId(set.getInt("id"));
                    o.setName(set.getString("nome"));
                    o.setImageURL(set.getString("imageURL"));
                    o.setDescription(set.getString("descrizione"));
                    o.setPrice(set.getDouble("prezzo"));
                    o.setQuantity(set.getInt("quantita"));
                lista.add(o);
            }
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return lista;
    }
    public OggettiInVendita getOggetto(int id)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "mariorossi", "0");
            String query = "select * from oggetto_in_vendita "
            + "where id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                OggettiInVendita o = new OggettiInVendita();
                    o.setId(res.getInt("id"));
                    o.setName(res.getString("nome"));
                    o.setImageURL(res.getString("imageURL"));
                    o.setDescription(res.getString("descrizione"));
                    o.setPrice(res.getDouble("prezzo"));
                    o.setQuantity(res.getInt("quantita"));
                
   
                stmt.close();
                conn.close();
                return o;
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
        public void Registrazione_Esame(int idCliente, int idOggettiInVendita,  int voto, String descrizione) throws SQLException
        {
            Connection conn = DriverManager.getConnection(connectionString, "alessandrocarcangiu", "0000");
            PreparedStatement updatePianodistudi = null;
            PreparedStatement updateEsamisuperati= null;
            //sql command
            String deletePianodistudi = "delete from pianodistudi where idOggettiInVendita = ? and idUtente = ?";
            String insertEsamisuperati = "insert into esami_superati(idOggettiInVendita, id Cliente, voto, descrizione) values (?,?,?,?)";
            try{
                conn.setAutoCommit(false);
                updatePianodistudi = conn.prepareStatement(deletePianodistudi);
                updateEsamisuperati = conn.prepareStatement(insertEsamisuperati);
                
                updatePianodistudi.setInt(1, idOggettiInVendita);
                updatePianodistudi.setInt(2, idCliente);
                
                updateEsamisuperati.setInt(1, idOggettiInVendita);
                updateEsamisuperati.setInt(2, idCliente);
                updateEsamisuperati.setInt(3, voto);
                updateEsamisuperati.setString(4, descrizione);
                
                int r1 = updatePianodistudi.executeUpdate();
                int r2 = updateEsamisuperati.executeUpdate();
                
                if(r1 != 1 || r2 != 1)
                {
                    conn.rollback();
                }
                conn.commit();
            }
            catch(SQLException e)
            {
                conn.rollback();
                throw e;
            }
            finally
            {
                if(updatePianodistudi != null)
                    updatePianodistudi.close();
                if(updateEsamisuperati != null)
                    updateEsamisuperati.close();
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    
    // ConnectionString
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
}
