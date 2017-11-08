package Controllers;


import DAO.*;
import DTO.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
           
           if(request.getParameter("usarIndicador")!=null){ 
            String strIndicadorName=request.getParameter("Indicador");  
            String strEmpresa=request.getParameter("Empresa");  
            String strAnio=request.getParameter("Periodo");
            IndicadorDAO indicadorDAO = new IndicadorDAO();
            Indicador indicador =indicadorDAO.get(strIndicadorName);
        
            ValorIndicadorDAO valorIndicadorDAO = new ValorIndicadorDAO();
            ValorIndicador valorIndicador = new ValorIndicador();
            
            //Todos los valoresIndicadores 
            ArrayList<ValorIndicador> valoresIndicador = (ArrayList<ValorIndicador>) valorIndicadorDAO.filter();
             double resultadoFinal= valorIndicador.obtenerValor(valoresIndicador, strEmpresa, strIndicadorName, strAnio);
            

            //double resultadoFinal = indicador.resultadoFinal(strEmpresa, strAnio); //Antes de la entrega 6.
            
            
            String total = String.format("%.02f", resultadoFinal);
            
            request.getSession().setAttribute("IndicadorBean",total);
            RequestDispatcher rd=request.getRequestDispatcher("ResultadoIndicador.jsp");  
            rd.forward(request, response); 
          }
           
           else{
            String strIndicadorName=request.getParameter("Indicador");  
            String codEmpresa=request.getParameter("Empresa");  
            String id_usuario = (String) request.getSession().getAttribute("usuarioBean");
            
           EmpresaDAO empresaDAO= new EmpresaDAO();
           
            ValorIndicadorDAO valorIndicadorDAO = new ValorIndicadorDAO();
            ArrayList<ValorIndicador> valores= (ArrayList<ValorIndicador>) valorIndicadorDAO.filterId(id_usuario);
            ArrayList<Empresa> empresas= new ArrayList();
            

            //Elimino los periodos repetidos
            ArrayList<String> periodos= new ArrayList();
            for(int counter=0;counter<valores.size();counter++){
                periodos.add(valores.get(counter).getPeriodo());
                Empresa empresa = empresaDAO.get(valores.get(counter).getCodEmpresa());
                empresas.add(empresa);
            }
            
           
          
            HashSet hs = new HashSet();
            hs.addAll(periodos);
            periodos.clear();
            periodos.addAll(hs);
            hs.clear();
            hs.addAll(empresas);
            empresas.clear();
            empresas.addAll(hs);
            request.getSession().setAttribute("empresaBean",codEmpresa);
            request.getSession().setAttribute("indicadorBean",strIndicadorName); 
            request.getSession().setAttribute("empresasBean",empresas);
            request.getSession().setAttribute("periodosBean",periodos); 
            RequestDispatcher rd=request.getRequestDispatcher("UsarIndicador.jsp"); 
            rd.forward(request, response);
           }
           
           
           
           
           if(request.getParameter("atras")!= null){
            
            RequestDispatcher rd=request.getRequestDispatcher("MenuIndicadores.jsp"); 
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
