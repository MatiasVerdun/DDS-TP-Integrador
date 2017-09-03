package Controllers;


import DAO.*;
import DTO.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ConsultarValoresControllerServlet extends HttpServlet {

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
            if(request.getParameter("consultarValores")!=null){ 
                String strCodEmpresa = request.getParameter("Empresa");
                String strPeriodo = request.getParameter("Periodo");
                ValorCuentaDAO valorCtaDAO = new ValorCuentaDAO();
                ArrayList<ValorCuenta>valoresCuentas = valorCtaDAO.ObtenerValoresCuentasFiltradoPorPeriodo(strCodEmpresa,strPeriodo);
                IndicadorDAO indicadorDAO = new IndicadorDAO();
                ArrayList<ValorIndicador> valoresIndicadores = indicadorDAO.ObtenerValoresIndicadores(strCodEmpresa,strPeriodo);
            
                request.setAttribute("valoresIndicadoresBean",valoresIndicadores);
                request.setAttribute("valoresCuentasBean",valoresCuentas);
            
                RequestDispatcher rd=request.getRequestDispatcher("ConsultarValores.jsp");  
                rd.forward(request, response);  } 
            else{
                String codEmpresa=request.getParameter("Empresa");      
                ValorCuentaDAOInterface  valorCuentaDAO = new ValorCuentaDAO();
                ArrayList<String> periodos= valorCuentaDAO.get(codEmpresa);
            //Elimino los periodos repetidos
                HashSet hs = new HashSet();
                hs.addAll(periodos);
                periodos.clear();
                periodos.addAll(hs);
            
               
                request.getSession().setAttribute("empresaBean",codEmpresa);
                request.getSession().setAttribute("periodosBean",periodos); 
                RequestDispatcher rd=request.getRequestDispatcher("ConsultarValores.jsp"); 
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