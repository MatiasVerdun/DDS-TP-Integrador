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



@WebServlet(name = "MenuMetodologiaControllerServlet", urlPatterns = {"/MenuMetodologiaControllerServlet"})
public class MenuMetodologiaControllerServlet extends HttpServlet {

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
        
        if(request.getParameter("usarMetodologia")!= null){
            MetodologiaDAO metodologiaDAO= new MetodologiaDAO();
            ArrayList<Metodologia> metodologias= (ArrayList<Metodologia>) metodologiaDAO.findAll();
            request.getSession().setAttribute("metodologiasBean",metodologias);  
            EmpresaDAOInterface empresaDAO = new EmpresaDAO();
            ArrayList<Empresa> empresas = (ArrayList<Empresa>) empresaDAO.findAll();
            request.getSession().setAttribute("empresasBean",empresas);
             ArrayList<String> periodos = new ArrayList<String>();
            request.getSession().setAttribute("periodosBean",periodos); 
            RequestDispatcher rd=request.getRequestDispatcher("UsarMetodologia.jsp"); 
            rd.forward(request, response);
        } 
        if(request.getParameter("usarMetodologiaEmpresas")!= null){
           MetodologiaDAO metodologiaDAO= new MetodologiaDAO();
            ArrayList<Metodologia> metodologias= (ArrayList<Metodologia>) metodologiaDAO.findAll();
            
            ArrayList<Empresa> empresas = new ArrayList<Empresa>();
            //Cargo los periodos
                EmpresaDAOInterface empresaDAO = new EmpresaDAO();
                ArrayList<Empresa> Empresas = new ArrayList<Empresa>();
                Empresas = (ArrayList<Empresa>) empresaDAO.findAll();
                ValorCuentaDAO valorCuentaDAO = new ValorCuentaDAO();
                ArrayList<String> periodos= new ArrayList<String>();
                
                for(int counter =0;counter < Empresas.size();counter++){
                periodos.addAll(valorCuentaDAO.findAll(Empresas.get(counter).getCodEmpresa()));
                }
                
            //Elimino los periodos repetidos
                HashSet hs = new HashSet();
                hs.addAll(periodos);
                periodos.clear();
                periodos.addAll(hs);
            
            request.getSession().setAttribute("empresasBean",empresas);
            request.getSession().setAttribute("periodosBean",periodos); 
            request.getSession().setAttribute("metodologiasBean",metodologias);  
            RequestDispatcher rd=request.getRequestDispatcher("UsarMetodologiaEmpresas.jsp"); 
            rd.forward(request, response);
        } 
        if(request.getParameter("cargarMetodologia")!= null){
            
            IndicadorDAOInterface indicadorDAO= new IndicadorDAO();
            ArrayList<Indicador> indicadores= (ArrayList<Indicador>) indicadorDAO.findAll();
            
            request.getSession().setAttribute("indicadoresBean",indicadores);  
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