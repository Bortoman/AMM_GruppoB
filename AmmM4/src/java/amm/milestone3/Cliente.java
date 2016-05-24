/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone3;

import amm.milestone3.Classi.OggettiInVendita;
import amm.milestone3.Classi.Utente;
import amm.milestone3.Classi.UtentiFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alessandro
 */
@WebServlet(name = "Cliente", urlPatterns = {"/cliente.html"})
public class Cliente extends HttpServlet {

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
            
            if(request.getParameter("idOggetto")!=null){
            Integer idOggetto = Integer.parseInt(request.getParameter("idOggetto"));
            request.setAttribute("oggetto", UtentiFactory.getInstance().getOggetto(idOggetto));
            request.getRequestDispatcher("carrello.jsp").forward(request, response);
            }
            if(request.getParameter("idoggVenduto")!=null){
                Integer idCliente = (Integer)session.getAttribute("id");
                Integer idOggettoVenduto = Integer.parseInt(request.getParameter("idoggVenduto"));
                int result=0;
                        try {
                            result=UtentiFactory.getInstance().Compra(idCliente, idOggettoVenduto);
                        } catch (SQLException ex) {
                            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                        }   
                switch(result){
                    case 2:
                        request.setAttribute("pagato", "Pagamento non completato, disponibilità esaurita!");
                        request.setAttribute("oggetto", UtentiFactory.getInstance().getOggetto(Integer.parseInt(request.getParameter("idoggVenduto"))));
                        request.getRequestDispatcher("carrello.jsp").forward(request, response);
                        break;
                    case 1:
                        request.setAttribute("pagato", "Pagamento avvenuto con successo");
                        request.setAttribute("oggetto", UtentiFactory.getInstance().getOggetto(Integer.parseInt(request.getParameter("idoggVenduto"))));
                        request.getRequestDispatcher("carrello.jsp").forward(request, response);
                        break;
                    case 3:
                        request.setAttribute("pagato", "Pagamento non completato, fondi insufficienti :(");
                        request.setAttribute("oggetto", UtentiFactory.getInstance().getOggetto(Integer.parseInt(request.getParameter("idoggVenduto"))));
                        request.getRequestDispatcher("carrello.jsp").forward(request, response);
                        break;
                    default:
                        request.setAttribute("pagato", "Pagamento non completato, errore di transazione");
                        request.setAttribute("oggetto", UtentiFactory.getInstance().getOggetto(Integer.parseInt(request.getParameter("idoggVenduto"))));
                        request.getRequestDispatcher("carrello.jsp").forward(request, response);
                }
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
