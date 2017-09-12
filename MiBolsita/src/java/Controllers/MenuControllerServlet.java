package Controllers;

import DAO.*;
import DTO.*;
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
        String id_usuario = (String) request.getSession().getAttribute("usuarioBean");
        if(request.getParameter("cargarDatos")!= null){
            RequestDispatcher rd=request.getRequestDispatcher("CargarDatos.jsp"); 
            rd.forward(request, response);
        } 
        
        if(request.getParameter("indicadores")!= null){
            request.getSession().setAttribute("usuarioBean",id_usuario); 
            RequestDispatcher rd=request.getRequestDispatcher("MenuIndicadores.jsp"); 
            rd.forward(request, response);
        }
        
        if(request.getParameter("cargarValoresCuentas")!= null){
            RequestDispatcher rd=request.getRequestDispatcher("CargarValoresCuentas.jsp"); 
            rd.forward(request, response);
        } 
         if(request.getParameter("metodologia")!= null){
            request.getSession().setAttribute("usuarioBean",id_usuario); 
            RequestDispatcher rd=request.getRequestDispatcher("MenuMetodologia.jsp"); 
            rd.forward(request, response);
        } 
        
        if(request.getParameter("consultarValores")!= null){
            //--- Obtiene la lista de Empresas y la almacena para que lo tome la Vista
            EmpresaDAO empresaDAO = new EmpresaDAO();
            ArrayList<Empresa> empresas = (ArrayList<Empresa>) empresaDAO.filter();
            ArrayList<String> periodos = new ArrayList<String>();
            request.getSession().setAttribute("usuarioBean",id_usuario); 
            request.getSession().setAttribute("periodosBean",periodos); 
            request.getSession().setAttribute("empresasBean",empresas);  
            //
            RequestDispatcher rd=request.getRequestDispatcher("ConsultarValores.jsp"); 
            rd.forward(request, response);
        } 
        if(request.getParameter("cargarMetodologia")!= null){
            RequestDispatcher rd=request.getRequestDispatcher("CargarMetodologia.jsp"); 
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
