/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import DAO.*;
import DTO.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "CargarIndicadoresControllerServlet", urlPatterns = {"/CargarIndicadoresControllerServlet"})
public class CargarIndicadoresControllerServlet extends HttpServlet {

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
        //--- Obtiene los datos desde la Vista (CargarIndicador.jsp)
        if(request.getParameter("cargarIndicador")!=null){
            String id_usuario = (String) request.getSession().getAttribute("usuarioBean");
            String strNombreIndicador=request.getParameter("nombreIndicador");  
            String strIndicador=request.getParameter("indicador");  
          
            
        //--- Crea el objeto indicador que desde Validar
            Indicador objIndicador=new Indicador();  
            objIndicador.setNombre(strNombreIndicador);  
            objIndicador.setIndicador(strIndicador); 
            objIndicador.setId_usuario(id_usuario);
            IndicadorDAO indicadorDAO = new IndicadorDAO();
            if(objIndicador.comprobarSintaxis()){
                
                    indicadorDAO.saveOrUpdate(objIndicador);
                    RequestDispatcher rd=request.getRequestDispatcher("Correcto.jsp");  
                    rd.forward(request, response);
            } else {
                    RequestDispatcher rd=request.getRequestDispatcher("Cargar-Indicador-Error.jsp");  
                    rd.forward(request, response);  
            }
        }}
         
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
