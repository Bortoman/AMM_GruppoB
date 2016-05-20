/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.esercitazione2.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Alessandro
 */
public class UtentiFactory {
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
            Connection conn= DriverManager.getConnection(connectionString, "alessandrocarcangiu", "0000");
            //sql Command
            String query = "select * from professore where username = ? and password = ?";
            //
            PreparedStatement stmt= conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            //Esegui query
            ResultSet res = stmt.executeQuery();
            
            if(res.next())
            {
                Professore professore = new Professore();
                professore.setId(res.getInt("id"));
                professore.setNome(res.getString("nome"));
                professore.setCognome(res.getString("cognome"));
                professore.setUsername(res.getString("username"));
                professore.setPassword(res.getString("password"));
                professore.setOrario_ricevimento(res.getString("orario_ricevimento"));
                // Corsi assegnati
                query = "select * from materia join materie_assegnate on materie_assegnate.idMateria = materia.id"
                        + " where materie_assegnate.idProfessore = "+professore.getId();
                Statement st= conn.createStatement();
                ResultSet res2= st.executeQuery(query);
                
                while(res2.next())
                {
                    Materia m = new Materia();
                    m.setId(res2.getInt("id"));
                    m.setNome(res2.getString("nome"));
                    professore.getCorsiAssegnati().add(m);
                }
                
                st.close();
                stmt.close();
                conn.close();
                return professore;
            }
            
            //sql command
            query = "select * from studente where username = ? and password = ?";
            stmt = conn.prepareStatement(query);
            //dati
            stmt.setString(1, username);
            stmt.setString(2, password);
            res = stmt.executeQuery();
            
            if (res.next())
            {
                Studente studente = new Studente();
                studente.setId(res.getInt("id"));
                studente.setNome(res.getString("nome"));
                studente.setCognome(res.getString("cognome"));
                studente.setUsername(res.getString("username"));
                studente.setPassword(res.getString("password"));
                studente.setMatricola(res.getInt("matricola"));
                
                stmt.close();
                conn.close();
                return studente;
            }
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {
        
        }
        return null;
    }
    // Professore
    // Dato un id restituisce il relativo professore (se esiste un professore con quell'id, altrimenti
    // restituisce null).
    public Utente getProfessore(int id)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "alessandrocarcangiu", "0000");
            // Query
            String query = "select * from professore "
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
                Professore current = new Professore();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setOrario_ricevimento(res.getString("orario_ricevimento"));
                // Corsi assegnati 
                query = "select materia.id, materia.nome from materia "
                        + "join materie_assegnate "
                        + "on materia.id = materie_assegnate.idMateria "
                        + "where materie_assegnate.idProfessore="+current.getId();
                Statement st = conn.createStatement();
                ResultSet res2 = st.executeQuery(query);
                while(res2.next())
                {
                    Materia m = new Materia();
                    m.setId(res2.getInt("id"));
                    m.setNome(res2.getString("nome"));
                    current.corsiAssegnati.add(m);
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
    
    // Restituisce la lista di tutti i professori
    public ArrayList<Professore> getProfessori()
    {
        ArrayList<Professore> listaProfessori = new ArrayList<Professore>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "alessandrocarcangiu", "0000");
            Statement stmt = conn.createStatement();
            String query = "select * from "
            + "professore'";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Professore current = new Professore();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setCognome(set.getString("cognome"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                current.setOrario_ricevimento(set.getString("orario_ricevimento"));
                listaProfessori.add(current);
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaProfessori;
    }
    
    // Studenti
    // Restituisce la lista di tutti gli studenti
    public ArrayList<Studente> getStudenti()
    {
        ArrayList<Studente> listaStudenti = new ArrayList<Studente>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "alessandrocarcangiu", "0000");
            Statement stmt = conn.createStatement();
            String query = "select * from studente";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Studente current = new Studente();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setCognome(set.getString("cognome"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                current.setMatricola(set.getInt("matricola"));
                listaStudenti.add(current);
            }     
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaStudenti;
    }
    
    // Dato un id restituisce il relativo studente (se esiste uno studente con quell'id, altrimenti
    // restituisce null).
    public Utente getStudente(int id)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "alessandrocarcangiu", "0000");
            String query = "select * from studente "
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
                Studente current = new Studente();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setMatricola(res.getInt("matricola"));
                
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
    // Materia
    // Restituisce la lista di tutte le materie
    public ArrayList<Materia> getMaterie()
    {
        ArrayList<Materia> lista = new ArrayList<Materia>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "alessandrocarcangiu", "0000");
            Statement stmt = conn.createStatement();
            String query = "select * from "
            + "materia'";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Materia current = new Materia();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                lista.add(current);
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
    // Dato un id restituisce la relativa materia
    public Materia getMateria(String nome)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "alessandrocarcangiu", "0000");
            String query = "select * from materia "
            + "where nome = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setString(1, nome);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                Materia current = new Materia();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
   
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
        public void Registrazione_Esame(int idStudente, int idMateria,  int voto, String descrizione) throws SQLException
        {
            Connection conn = DriverManager.getConnection(connectionString, "alessandrocarcangiu", "0000");
            PreparedStatement updatePianodistudi = null;
            PreparedStatement updateEsamisuperati= null;
            //sql command
            String deletePianodistudi = "delete from pianodistudi where idMateria = ? and idUtente = ?";
            String insertEsamisuperati = "insert into esami_superati(idMateria, id Studente, voto, descrizione) values (?,?,?,?)";
            try{
                conn.setAutoCommit(false);
                updatePianodistudi = conn.prepareStatement(deletePianodistudi);
                updateEsamisuperati = conn.prepareStatement(insertEsamisuperati);
                
                updatePianodistudi.setInt(1, idMateria);
                updatePianodistudi.setInt(2, idStudente);
                
                updateEsamisuperati.setInt(1, idMateria);
                updateEsamisuperati.setInt(2, idStudente);
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
