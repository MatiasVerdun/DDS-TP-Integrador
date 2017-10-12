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
        String id_usuario = (String) request.getSession().getAttribute("usuarioBean");
        if(request.getParameter("usarMetodologia")!= null){
            request.getSession().setAttribute("usuarioBean",id_usuario); 
            MetodologiaDAO metodologiaDAO= new MetodologiaDAO();
            ArrayList<Metodologia> metodologias= (ArrayList<Metodologia>) metodologiaDAO.filter(id_usuario);
            request.getSession().setAttribute("metodologiasBean",metodologias);  
            
            EmpresaDAO empresaDAO = new EmpresaDAO();
            ArrayList<Empresa> empresas = (ArrayList<Empresa>) empresaDAO.filter();
            request.getSession().setAttribute("empresasBean",empresas);
             
            ArrayList<String> periodos = new ArrayList<>();
            request.getSession().setAttribute("periodosBean",periodos); 
           
            RequestDispatcher rd=request.getRequestDispatcher("UsarMetodologia.jsp"); 
            rd.forward(request, response);
        } 
        if(request.getParameter("usarMetodologiaEmpresas")!= null){
           MetodologiaDAO metodologiaDAO= new MetodologiaDAO();
            ArrayList<Metodologia> metodologias= (ArrayList<Metodologia>) metodologiaDAO.filter(id_usuario);
            
            EmpresaDAO empresaDAO = new EmpresaDAO();
            ArrayList<Empresa> empresas = (ArrayList<Empresa>) empresaDAO.filter();
            
            ValorCuentaDAO valorCuentaDAO = new ValorCuentaDAO();
           ArrayList<ValorCuenta> valores = (ArrayList<ValorCuenta>) valorCuentaDAO.filter();
                
            //Cargo los periodos
                ArrayList<String> periodos= new ArrayList();
            for(int counter=0;counter<valores.size();counter++){
                periodos.add(valores.get(counter).getPeriodo());
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
            request.getSession().setAttribute("usuarioBean",id_usuario); 
            IndicadorDAO indicadorDAO= new IndicadorDAO();
            ArrayList<Indicador> indicadores= (ArrayList<Indicador>) indicadorDAO.filter(id_usuario);
             request.getSession().setAttribute("primero",true); 
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
