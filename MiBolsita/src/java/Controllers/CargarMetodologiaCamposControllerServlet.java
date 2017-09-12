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



@WebServlet(name = "CargarMetodologiaCamposControllerServlet", urlPatterns = {"/CargarMetodologiaCamposControllerServlet"})
public class CargarMetodologiaCamposControllerServlet extends HttpServlet {

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
          //--- Obtiene los datos desde la Vista (CargarIndicador.jsp)
            
            String strNombreMetodologia =request.getParameter("nombreMetodologia");  
            String condicion =request.getParameter("condicion");  
            String indicador = request.getParameter("Indicador");
            String numero = request.getParameter("monto");
            request.setAttribute("nombreMetodologiaBean",strNombreMetodologia);
            
          //--- Crea los objetos
            CondicionDAO condicionDAO = new CondicionDAO();
            Condicion objCondicion = new Condicion();
            objCondicion.setMonto(numero);
            objCondicion.setIndicador(indicador);
          
        if(request.getParameter("proximaCondicion")!= null){
            objCondicion.setIndicador(indicador);
            objCondicion.setMetodologia(strNombreMetodologia);
            objCondicion.setMonto(numero);
            objCondicion.setTipo(condicion);
            condicionDAO.saveOrUpdate(objCondicion);
            RequestDispatcher rd=request.getRequestDispatcher("CargarMetodologiaCampos.jsp"); 
            rd.forward(request, response);
            
            
        } 
        
        if(request.getParameter("finalizarCarga")!= null){ 
            objCondicion.setIndicador(indicador);
            objCondicion.setMetodologia(strNombreMetodologia);
            objCondicion.setMonto(numero);
            objCondicion.setTipo(condicion);
            condicionDAO.saveOrUpdate(objCondicion);
            RequestDispatcher rd=request.getRequestDispatcher("Menu.jsp"); 
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