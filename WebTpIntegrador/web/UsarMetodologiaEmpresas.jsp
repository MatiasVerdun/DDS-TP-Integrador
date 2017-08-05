
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
/*
    if (empresas.get(counter).getId().equals(objSeleccionZona.getId_pais()))   {
        out.print("selected");
    }
*/
    out.print(" >"); 		
    out.print(metodologias.get(counter).getNombreMetodologia()); 		
    out.print("</option>"); 		
} 
%>
    </select>
    <br>




<br>
<br>
<input type="number" min="1900" onkeypress="return event.charCode >= 48" class="select" name="periodoDesde" placeholder="Periodo Desde"/>
<br>
<br>
<input type="number" min="1900" onkeypress="return event.charCode >= 48" class="select" name="periodoHasta" placeholder="Periodo Hasta"/>
<br>

    <br>
    <br>

    <input class="button" type="submit" value="Usar Metodologia" />
    <br>
    <br>
  </fieldset>
</form>
<%  

ArrayList<Metodologia> metodologiasConCondiciones =(ArrayList<Metodologia>)request.getAttribute("metodologiasConCondicionesBean");  
ArrayList<Empresa> empresas  = (ArrayList<Empresa>)request.getAttribute("empresasBean");
int desde = Integer.parseInt((String)request.getAttribute("desdeBean"));
int hasta = Integer.parseInt((String)request.getAttribute("hastaBean"));

if (empresas!=null && empresas.size()>0)
{
    out.print("<br/><br/>");
    out.print("<table class='table'>");
    for (int counter = 0; counter < empresas.size(); counter++) { 		      
        for(int c = 0; c < metodologiasConCondiciones.size();c++) {
        Empresa empresaActual =empresas.get(counter);
        out.print("<tr>");
        out.print("<td>");
        out.print(empresaActual.getNombreEmpresa());
        out.print("</td>");
        out.print("<td>");
        out.print(metodologiasConCondiciones.get(c).pasaCondiciones(empresaActual,desde,hasta));
        out.print("</td>");
        out.print("</tr>");
    } 
    }

    out.print("</table>");
} 
%>
</body>
</html>
