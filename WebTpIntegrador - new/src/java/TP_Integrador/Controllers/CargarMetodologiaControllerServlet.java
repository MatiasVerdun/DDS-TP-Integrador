/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_Integrador.Controllers;

import TP_Integrador.DAO.MetodologiaDAO;
import TP_Integrador.DTO.Metodologia;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vic
 */
@WebServlet(name = "CargarMetodologiaControllerServlet", urlPatterns = {"/CargarMetodologiaControllerServlet"})
public class CargarMetodologiaControllerServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
           String strNombreMetodologia=request.getParameter("nombreMetodologia"); 
           MetodologiaDAO metodologiaDAO = new MetodologiaDAO();
           Metodologia objMetodologia = new Metodologia();
           objMetodologia.setNombreMetodologia(strNombreMetodologia);
           metodologiaDAO.GuardarMetodologia(objMetodologia); 
           
           if(request.getParameter("cargarCondiciones")!= null){
            if(!"".equals(strNombreMetodologia)){
            request.setAttribute("nombreMetodologiaBean",strNombreMetodologia);
            RequestDispatcher rd=request.getRequestDispatcher("CargarMetodologiaCampos.jsp"); 
            rd.forward(request, response);
        }else {
                RequestDispatcher rd=request.getRequestDispatcher("MetodologiaNombre-error.jsp");  
                  rd.forward(request, response);
            } 
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
