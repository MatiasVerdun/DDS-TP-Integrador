package Controllers;


import DAO.*;
import DTO.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "UsarMetodologiaEmpresasControllerServlet", urlPatterns = {"/UsarMetodologiaEmpresasControllerServlet"})
public class UsarMetodologiaEmpresasControllerServlet extends HttpServlet {

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
           
            String strMetodologia=request.getParameter("Metodologia"); 
            String strPeriodoDesde=request.getParameter("periodoDesde");
            String strPeriodoHasta=request.getParameter("periodoHasta");
           
            Metodologia metodologia = new Metodologia();
                  Metodologia meto =   metodologia.ObtenerMetodologiaConCondiciones(strMetodologia);
            
            EmpresaDAO empresaDAO = new EmpresaDAO();
            ArrayList<Empresa> empresas = (ArrayList<Empresa>) empresaDAO.filter();
            
            
            
            request.getSession().setAttribute("empresasBean",empresas); 
            request.getSession().setAttribute("metodologiaConCondicionesBean",meto);
            request.getSession().setAttribute("desdeBean",strPeriodoDesde); 
            request.getSession().setAttribute("hastaBean",strPeriodoHasta);
          
          
            RequestDispatcher rd=request.getRequestDispatcher("UsarMetodologiaEmpresas.jsp");  
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
