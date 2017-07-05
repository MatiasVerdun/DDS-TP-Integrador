/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_Integrador.Controllers;

import TP_Integrador.DAO.IndicadorDAO;
import TP_Integrador.DTO.Indicador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victoria
 */
@WebServlet(name = "UsarIndicadorControllerServlet", urlPatterns = {"/UsarIndicadorControllerServlet"})
public class UsarIndicadorControllerServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
            String strIndicadorName=request.getParameter("Indicador");  
            String strEmpresa=request.getParameter("Empresa");  
            String strAnio=request.getParameter("Anio");
            
            IndicadorDAO indicadorDAO = new IndicadorDAO();

            
            String Indicador = indicadorDAO.conseguirIndicador(strIndicadorName);
            double resultadoFinal = indicadorDAO.resultadoFinal(Indicador, strEmpresa, strAnio);
            
            String total = String.valueOf(resultadoFinal);
          
            request.getSession().setAttribute("IndicadorBean",total);
            RequestDispatcher rd=request.getRequestDispatcher("UsarIndicadoresPrueba.jsp");  
            rd.forward(request, response);  
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
