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



@WebServlet(name = "CargarMetodologiaControllerServlet", urlPatterns = {"/CargarMetodologiaControllerServlet"})
public class CargarMetodologiaControllerServlet extends HttpServlet {

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
            String id_usuario = (String)request.getSession().getAttribute("usuarioBean");
            boolean primero = (boolean)request.getSession().getAttribute("primero");
            
            request.setAttribute("nombreMetodologiaBean",strNombreMetodologia);
            
            
            //ArrayList<Condicion> lista = new ArrayList();
           
            
          //--- Crea los objetos
            CondicionDAO condicionDAO = new CondicionDAO();
            MetodologiaDAO metodologiaDAO = new MetodologiaDAO();
            Metodologia metodologia = new Metodologia();
            
           
            
            metodologia.setNombreMetodologia(strNombreMetodologia);
            metodologia.setId_usuario(id_usuario);
            
        if(request.getParameter("proximaCondicion")!= null){
            ArrayList<Condicion> lista=(ArrayList)request.getSession().getAttribute("condiciones");
            Condicion objCondicion = new Condicion();
            objCondicion.setIndicador(indicador);
            objCondicion.setMetodologia(strNombreMetodologia);
            objCondicion.setMonto(numero);
            objCondicion.setTipo(condicion);
            
           lista.add(objCondicion);
            
            request.getSession().setAttribute("primero",false); 
            request.setAttribute("condiciones",lista);
            RequestDispatcher rd=request.getRequestDispatcher("CargarMetodologia.jsp"); 
            rd.forward(request, response);
            
            
        } 
        
        if(request.getParameter("finalizarCarga")!= null){ 
           
           ArrayList<Condicion> lista=(ArrayList)request.getSession().getAttribute("condiciones");
            Condicion objCondicion = new Condicion();
            objCondicion.setIndicador(indicador);
            objCondicion.setMetodologia(strNombreMetodologia);
            objCondicion.setMonto(numero);
            objCondicion.setTipo(condicion);
            
            lista.add(objCondicion);
            
  
            metodologiaDAO.saveOrUpdate(metodologia);
            lista.forEach((unaCondicion) -> {
                condicionDAO.saveOrUpdate(unaCondicion);
            });
            
            RequestDispatcher rd=request.getRequestDispatcher("Correcto.jsp"); 
            rd.forward(request, response);
        } 
        if(request.getParameter("atras")!= null){
            
            RequestDispatcher rd=request.getRequestDispatcher("MenuMetodologia.jsp"); 
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
