/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_Integrador.Controllers;


import TP_Integrador.DAO.UsuarioDAO;
import TP_Integrador.DTO.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matias
 */
public class CambiarClaveControllerServlet extends HttpServlet {

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
            //--- Obtiene los datos desde la Vista (CambioClave.jsp)
            String strUserName=request.getParameter("Usuario");  
            String strPassword=request.getParameter("Clave");  
            String strPasswordNew=request.getParameter("ClaveNueva");
            
            //--- Crea el objeto usuario que desde Validar
            Usuario objUsuario=new Usuario();  
            objUsuario.setUserName(strUserName);  
            objUsuario.setPassword(strPassword); 

            //--- Controla si existe el usuario en la Tabla
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean modifica = usuarioDAO.ModificarClave(objUsuario, strPasswordNew);

            //--- Determina la acción en base a la existencia
            if(modifica){
                RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");  
                rd.forward(request, response);  
            }  
            else{  
                RequestDispatcher rd=request.getRequestDispatcher("CambioClave-error.jsp");  
                rd.forward(request, response);  
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
