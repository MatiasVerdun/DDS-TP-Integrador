<%@page import="DAO.*"%>
<%@page import="DTO.*"%> 
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
    <select required class="select" name="Empresa" onchange="if(this.value !== '') this.form.submit()">
         <option value="">Empresa</option>
<%  
//--- Obtiene el listado de Empresas

ArrayList<Empresa> empresas =(ArrayList<Empresa>)request.getSession().getAttribute("empresasBean");  
String empresaSeleccionada = (String)request.getSession().getAttribute("empresaBean");
for (int counter = 0; counter < empresas.size(); counter++) { 		      
    out.print("<option value='"); 		
    out.print(empresas.get(counter).getCodEmpresa()); 		
    out.print("' ");

    if (empresas.get(counter).getCodEmpresa().equals(empresaSeleccionada))   {
        out.print("selected");
    }

    out.print(" >"); 		
    out.print(empresas.get(counter).getNombreEmpresa()); 		
    out.print("</option>"); 		
} 
%>
    </select>
<br>
<br>
<%  
ArrayList<String> periodos =(ArrayList<String>)request.getSession().getAttribute("periodosBean");  
if (periodos.size()<0) {
%>  
  <select required class="select" name="Periodo">
  <option value="" disabled>Periodo</option>
    <%  
       
        for (int counter = 0; counter < periodos.size(); counter++) { 		      
        
        out.print("<option value='");
        out.print(periodos.get(counter));
       out.print("' selected >");
        out.print(periodos.get(counter));
        out.print("</option>");
    }
    %>  
  </select>
  <br><br><br>
  <input class="button" type="submit" name="consultarValores" value="Consultar Valores">
<br>
<br>
<%  
} 
%>
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
        out.print(String.format("%.02f", valoresCuentas.get(counter).getValor()));
        //out.print(java.math.BigDecimal.valueOf(valoresCuentas.get(counter).getValor()));
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
        out.print(String.format("%.02f", valoresIndicadores.get(counter).getValor()));
        out.print("</td>");
        out.print("</tr>");
    } 
    
    out.print("</table>");
} 
%>
</body>
</html>

