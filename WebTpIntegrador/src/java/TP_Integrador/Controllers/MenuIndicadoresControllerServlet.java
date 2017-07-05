/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_Integrador.Controllers;

import TP_Integrador.DAO.EmpresaDAO;
import TP_Integrador.DAO.IndicadorDAO;
import TP_Integrador.DTO.Empresa;
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
@WebServlet(name = "MenuIndicadoresControllerServlet", urlPatterns = {"/MenuIndicadoresControllerServlet"})
public class MenuIndicadoresControllerServlet extends HttpServlet {

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
        
        if(request.getParameter("verIndicador")!= null){
            //--- Obtiene la lista de Indicadores y la almacena para que lo tome la Vista
            IndicadorDAO indicadorDAO= new IndicadorDAO();
            ArrayList<Indicador> indicadores= indicadorDAO.ObtenerIndicadores();
            request.getSession().setAttribute("indicadoresBean",indicadores);  
            
            RequestDispatcher rd=request.getRequestDispatcher("VerIndicador.jsp"); 
            rd.forward(request, response);
        } 
        
        if(request.getParameter("usarIndicador")!= null){
  //--- Obtiene la lista de Indicadores y la almacena para que lo tome la Vista
            IndicadorDAO indicadorDAO= new IndicadorDAO();
            ArrayList<Indicador> indicadores= indicadorDAO.ObtenerIndicadores();
            request.getSession().setAttribute("indicadoresBean",indicadores);  
            //
            //--- Obtiene la lista de Empresas y la almacena para que lo tome la Vista
            EmpresaDAO empresaDAO = new EmpresaDAO();
            ArrayList<Empresa> empresas = empresaDAO.ObtenerEmpresas();
            request.getSession().setAttribute("empresasBean",empresas);  
            //
            RequestDispatcher rd=request.getRequestDispatcher("UsarIndicador.jsp"); 
            rd.forward(request, response);
        } 
        if(request.getParameter("cargarIndicador")!= null){
            RequestDispatcher rd=request.getRequestDispatcher("CargarIndicador.jsp"); 
            rd.forward(request, response);
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
