<%@page import="TP_Integrador.DAO.EmpresaDAO"%>
<%@page import="TP_Integrador.DTO.*"%>  
<%@page import="java.util.ArrayList"%>  
<!DOCTYPE html>
<html>
<body>
<head>
<style>
.form{
   height:35px;
   width:280px;;
   border-color:#00c8f8;
   font-size:110%
}
.button{
    background-color: #00c8f8;
    color: white;
    height:38px; 
   width:300px;;
    font-size:120%
}
.select{
   height:35px;
  width:290px;;
   border-color:#00c8f8;
   font-size:110%
}
.error {
    color: red;
    font-size:110%
}
.table
{
    width:50%;
    background-color: rgb(245, 245, 245);
    border-color:#00c8f8;
    margin:auto;
}
</style>
  <form action="ConsultarValoresControllerServlet" method="POST">
  <fieldset style="width:40%;text-align:center;background-color: rgb(245, 245, 245); border-color:#00c8f8;text-align: center; margin:auto">
    <br>
    <br> 
    <select required class="select" name="Empresa">
<%  
//--- Obtiene el listado de Empresas

ArrayList<Empresa> empresas =(ArrayList<Empresa>)request.getSession().getAttribute("empresasBean");  

for (int counter = 0; counter < empresas.size(); counter++) { 		      
    out.print("<option value='"); 		
    out.print(empresas.get(counter).getCodEmpresa()); 		
    out.print("' ");
/*
    if (empresas.get(counter).getId().equals(objSeleccionZona.getId_pais()))   {
        out.print("selected");
    }
*/
    out.print(" >"); 		
    out.print(empresas.get(counter).getNombreEmpresa()); 		
    out.print("</option>"); 		
} 
%>
    </select>
    <br>
    <br>
    <input placeholder="Periodo" class="form" type="text" name="Periodo" value="" maxlength="15" >
    <br>
    <br>
    <input class="button" type="submit" value="Consultar Valores" />
    <br>
    <br>
  </fieldset>
</form>
<%  
//--- Obtiene el listado de Valores de Cuentas
ArrayList<ValorCuenta>valoresCuentas =(ArrayList<ValorCuenta>)request.getAttribute("valoresCuentasBean");  


if (valoresCuentas!=null && valoresCuentas.size()>0)
{
    out.print("<br/><br/>");
    out.print("<table class='table'>");
    for (int counter = 0; counter < valoresCuentas.size(); counter++) { 		      
        out.print("<tr>");
        out.print("<td>");
        out.print(valoresCuentas.get(counter).getCodCuenta());
        out.print("</td>");
        out.print("<td>");
        out.print(java.math.BigDecimal.valueOf(valoresCuentas.get(counter).getValor()));
        out.print("</td>");
        out.print("</tr>");
    } 
   
ArrayList<ValorIndicador>valoresIndicadores =(ArrayList<ValorIndicador>)request.getAttribute("valoresIndicadoresBean");  

    
    for (int counter = 0; counter < valoresIndicadores.size(); counter++) { 		      
        out.print("<tr>");
        out.print("<td>");
        out.print(valoresIndicadores.get(counter).getNombreIndicador());
        out.print("</td>");
        out.print("<td>");
        out.print(java.math.BigDecimal.valueOf(valoresIndicadores.get(counter).getValor()));
        out.print("</td>");
        out.print("</tr>");
    } 
    
    out.print("</table>");
} 
%>
</body>
</html>

