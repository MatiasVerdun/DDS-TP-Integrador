
<%@page import="TP_Integrador.DTO.Empresa"%>
<%@page import="TP_Integrador.DTO.*"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <style>
.form{
   height:35px;
   width:285px;
   border-color:#00c8f8;
   font-size:110%
}
.button{
    background-color: #00c8f8;
    color: white;
    height:38px; 
    width:300px;
    font-size:120%
}
.select{
   height:35px;
   width:290px;
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
    text-align: center;
}
</style>
   <form action="UsarMetodologiaEmpresasControllerServlet" method="POST">
  <fieldset style="width:40%;text-align:center;background-color: rgb(245, 245, 245); border-color:#00c8f8;text-align: center; margin:auto">
    <br>
    <br> 
    <select required class="select" name="Metodologia">
<%  
//--- Obtiene el listado de Indicadores

ArrayList<Metodologia> metodologias =(ArrayList<Metodologia>)request.getSession().getAttribute("metodologiasBean");  

for (int counter = 0; counter < metodologias.size(); counter++) { 		      
    out.print("<option value='"); 		
    out.print(metodologias.get(counter).getNombreMetodologia()); 		
    out.print("' ");
    out.print(" >"); 		
    out.print(metodologias.get(counter).getNombreMetodologia()); 		
    out.print("</option>"); 		
} 
%>
    </select>
    <br>




<br>
<br>
<input type="number" min="1900" onkeypress="return event.charCode >= 48" class="select" name="periodoDesde" placeholder="Periodo Desde" required/>
<br>
<br>
<input type="number" min="1900" onkeypress="return event.charCode >= 48" class="select" name="periodoHasta" placeholder="Periodo Hasta" required/>
<br>

    <br>
    <br>

    <input class="button" type="submit" value="Usar Metodologia" />
    <br>
    <br>
  </fieldset>
</form>
<%  

Metodologia metodologiasConCondiciones =(Metodologia)request.getSession().getAttribute("metodologiasConCondicionesBean");  
ArrayList<Empresa> empresas  = (ArrayList<Empresa>)request.getSession().getAttribute("empresasBean");
String desde = (String)request.getSession().getAttribute("desdeBean");//Integer.parseInt((String)request.getAttribute("desdeBean"));
String hasta = (String)request.getSession().getAttribute("hastaBean");//Integer.parseInt((String)request.getAttribute("hastaBean"));

if (empresas!=null && empresas.size()>0)
{
    out.print("<br/><br/>");
    out.print("<table align='center' class='table'>");
    out.print("<tr>");
        out.print("<td>");
        out.print("<b>Empresa</b>");
        out.print("</td>");
        out.print("<td>");
        out.print("<b>");
        out.print(metodologiasConCondiciones.getNombreMetodologia());
        out.print("</b>");
        out.print("</td>");
        out.print("</tr>");
    for (int counter = 0; counter < empresas.size(); counter++) { 		      
        Empresa empresaActual =empresas.get(counter);
        out.print("<tr>");
        out.print("<td>");
        out.print(empresaActual.getNombreEmpresa());
        out.print("</td>");
        out.print("<td>");
        out.print(metodologiasConCondiciones.pasaCondiciones(empresaActual,Integer.parseInt(desde), Integer.parseInt(hasta)));
        out.print("</td>");
        out.print("</tr>");
    }
    out.print("</table>");
} 
%>
</body>
</html>
