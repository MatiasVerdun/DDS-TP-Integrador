package Controllers;


import DAO.*;
import DTO.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



/**
 *
 * @author Victoria
 */
@WebServlet(name = "CargarValoresCuentasControllerServlet", urlPatterns = {"/CargarValoresCuentasControllerServlet"})
@MultipartConfig
public class CargarValoresCuentasControllerServlet extends HttpServlet {

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
        PrintWriter out=response.getWriter(); 
        
        //--- Obtiene los datos desde la Vista (CargarCuentas.jsp)
       if(request.getParameter("subirArchivo")!= null){
        
        final Part filePart = request.getPart("uploadedfile");
        InputStream filecontent = filePart.getInputStream();
        String linea;
        BufferedReader reader=new BufferedReader(new InputStreamReader(filecontent));
        linea=reader.readLine();
        if(linea != null){
        while( linea !=null){
                String[] arreglo_datos = linea.split(",");
                ValorCuenta valorCuentaLinea = new ValorCuenta();
                EmpresaDAO empresa = new EmpresaDAO();
                CuentaDAO cuenta = new CuentaDAO();
                
                String codigoEmpresa = arreglo_datos[0];
                String codigoCuenta = arreglo_datos[2];
                
                valorCuentaLinea.setCodEmpresa(codigoEmpresa);
                valorCuentaLinea.setPeriodo(arreglo_datos[1]);  
                valorCuentaLinea.setCodCuenta(codigoCuenta);
                valorCuentaLinea.setValor(Double.parseDouble(arreglo_datos[3]));

                if(empresa.exists(codigoEmpresa) && cuenta.exists(codigoCuenta) ){
                ValorCuentaDAO valorCuenta = new ValorCuentaDAO();
                valorCuenta.saveOrUpdate(valorCuentaLinea);
                } else{RequestDispatcher rd=request.getRequestDispatcher("EmpresaCuenta-error.jsp");  
                  rd.forward(request, response);}
            linea = reader.readLine();
          }
           RequestDispatcher rd=request.getRequestDispatcher("Menu.jsp");  
           rd.forward(request, response); 
        } else {RequestDispatcher rd=request.getRequestDispatcher("Archivo-Error.jsp");  
                rd.forward(request, response); }
  
     }
    if(request.getParameter("atras")!= null){
            
            RequestDispatcher rd=request.getRequestDispatcher("Correcto.jsp"); 
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
