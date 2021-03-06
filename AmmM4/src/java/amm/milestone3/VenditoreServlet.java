/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone3;

import amm.milestone3.Classi.OggettiInVendita;

import amm.milestone3.Classi.UtentiFactory;
import amm.milestone3.Classi.Venditore;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alessandro Mainas
 */
@WebServlet(name = "Venditore", urlPatterns = {"/venditore.html"})
public class VenditoreServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        
        
        if(request.getParameter("Submit")!=null){
            if(request.getParameter("name").isEmpty() || request.getParameter("imgURL").isEmpty() || request.getParameter("description").isEmpty() ||  request.getParameter("price").isEmpty() || request.getParameter("quantity").isEmpty())
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
            String name = request.getParameter("name");
            String imgURL = request.getParameter("imgURL");
            String description = request.getParameter("description");
            Double price = Double.parseDouble(request.getParameter("price"));
            Integer quantity = Integer.parseInt(request.getParameter("quantity"));
            
            Venditore v = new Venditore();
            v= (Venditore)session.getAttribute("venditore");
            Integer idVenditore = v.getId();
            OggettiInVendita oggetto_n = new OggettiInVendita();
            UtentiFactory.getInstance().inserisciOggetto(name, imgURL, description, price, quantity, idVenditore);
            oggetto_n.setName(name);
            oggetto_n.setDescription(description);
            oggetto_n.setImageURL(imgURL);
            oggetto_n.setPrice(price);
            oggetto_n.setQuantity(quantity);
            request.setAttribute("oggetto", oggetto_n);
            session.setAttribute("listaOggettiVenditore", UtentiFactory.getInstance().getVenditore((Integer)session.getAttribute("id")).getOggettiVenditore());//aggiornamento lista
            request.getRequestDispatcher("inserimento_confermato.jsp").forward(request, response);
        }
        if(request.getParameter("idOggettodaEliminare")!=null){
            UtentiFactory.getInstance().eliminaOggetto(Integer.parseInt(request.getParameter("idOggettodaEliminare")));
            session.setAttribute("listaOggettiVenditore", UtentiFactory.getInstance().getVenditore((Integer)session.getAttribute("id")).getOggettiVenditore());//aggiornamento lista
            request.getRequestDispatcher("controller.jsp").forward(request, response);
        }
        if(request.getParameter("idOggettodaModificare")!=null){
                Integer idOggetto = Integer.parseInt(request.getParameter("idOggettodaModificare"));
                request.setAttribute("idOggetto", idOggetto);//mi serve mantenere i dati per le prossime modifiche
                request.getRequestDispatcher("modificaoggetto.jsp").forward(request, response);
        }
        if(request.getParameter("Modifica")!=null){
            String name= UtentiFactory.getInstance().getOggetto(Integer.parseInt(request.getParameter("idOggetto"))).getName();
            String imgURL= UtentiFactory.getInstance().getOggetto(Integer.parseInt(request.getParameter("idOggetto"))).getImageURL();
            String description= UtentiFactory.getInstance().getOggetto(Integer.parseInt(request.getParameter("idOggetto"))).getDescription();
            Double price= UtentiFactory.getInstance().getOggetto(Integer.parseInt(request.getParameter("idOggetto"))).getPrice();
            Integer quantity = UtentiFactory.getInstance().getOggetto(Integer.parseInt(request.getParameter("idOggetto"))).getQuantity();
            if(!request.getParameter("name").isEmpty())
                name = request.getParameter("name");
            if(!request.getParameter("imgURL").isEmpty())
                imgURL = request.getParameter("imgURL");
            if(!request.getParameter("description").isEmpty())
                description = request.getParameter("description");
            if(!request.getParameter("price").isEmpty())
                price = Double.parseDouble(request.getParameter("price"));
            if(!request.getParameter("quantity").isEmpty())
                quantity = Integer.parseInt(request.getParameter("quantity"));
            Integer idOggetto = Integer.parseInt(request.getParameter("idOggetto"));
            UtentiFactory.getInstance().modificaOggetto(idOggetto, name, imgURL, description, price, quantity);
            session.setAttribute("listaOggettiVenditore", UtentiFactory.getInstance().getVenditore((Integer)session.getAttribute("id")).getOggettiVenditore());//aggiornamento lista
            request.getRequestDispatcher("controller.jsp").forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
