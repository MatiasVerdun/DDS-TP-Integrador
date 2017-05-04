package TP_Integrador.Controllers;

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
 * @author Victoria
 */
@WebServlet(name = "MenuControllerServlet", urlPatterns = {"/MenuControllerServlet"})
public class MenuControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if(request.getParameter("cargarCuentas")!= null){
            RequestDispatcher rd=request.getRequestDispatcher("CargarCuentas.jsp"); 
            rd.forward(request, response);
        } 
        
        if(request.getParameter("consultarValores")!= null){
            RequestDispatcher rd=request.getRequestDispatcher("ConsultarValores.jsp"); 
            rd.forward(request, response);
        } 
        if(request.getParameter("cargarMetodologia")!= null){
            RequestDispatcher rd=request.getRequestDispatcher("CargarMetodologia.jsp"); 
            rd.forward(request, response);
        } 
        if(request.getParameter("cargarIndicador")!= null){
            RequestDispatcher rd=request.getRequestDispatcher("CargarIndicador.jsp"); 
            rd.forward(request, response);
        }
        if(request.getParameter("graficos")!= null){
            RequestDispatcher rd=request.getRequestDispatcher("VisualizarGraficos.jsp"); 
            rd.forward(request, response);
        }
        if(request.getParameter("analizarEmpresa")!= null){
            RequestDispatcher rd=request.getRequestDispatcher("AnalizarEmpresa.jsp"); 
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
        return "Controlador del Menu";
    }// </editor-fold>
}
