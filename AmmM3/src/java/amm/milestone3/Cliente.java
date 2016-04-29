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
@WebServlet(name = "Cliente", urlPatterns = {"/Cliente"})
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
            
            if(request.getParameter("idogg")!=null){
                Integer idCliente = (Integer)session.getAttribute("id");
                Utente cliente = UtentiFactory.getInstance().getCliente(idCliente);
                OggettiInVendita oggetto = UtentiFactory.getInstance().getOggetto(Integer.parseInt(request.getParameter("idogg")));
                if( cliente.getSaldo() > oggetto.getPrice()){
                    cliente.setSaldo(cliente.getSaldo() - oggetto.getPrice());
                    request.setAttribute("pagato", "Pagamento avvenuto con successo");
                    request.setAttribute("oggetto", UtentiFactory.getInstance().getOggetto(Integer.parseInt(request.getParameter("idogg"))));
                    request.getRequestDispatcher("carrello.jsp").forward(request, response);
                }
                else{
                    request.setAttribute("pagato", "Pagamento non completato, fondi insufficienti :(");
                    request.setAttribute("oggetto", UtentiFactory.getInstance().getOggetto(Integer.parseInt(request.getParameter("idogg"))));
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
