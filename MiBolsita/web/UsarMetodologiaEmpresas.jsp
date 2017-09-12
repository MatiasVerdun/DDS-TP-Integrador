<%@page import="DAO.*"%>
<%@page import="DTO.*"%>
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
    width:370px;
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
        <option value="" > Metodologia </option>
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
<%  
ArrayList<String> periodos =(ArrayList<String>)request.getSession().getAttribute("periodosBean");  
%>  
  <select required class="select" name="periodoDesde">
  <option value="" >Periodo Desde </option>
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
  <br>
  <br>
  <select required class="select" name="periodoHasta">
  <option value="" >Periodo Hasta </option>
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
<br>
<br>
  <input class="button" type="submit" name="usarMetodologiaEmpresas" value="Usar Metodologia en todas las Empresas">

    <br>
    <br>

  
  </fieldset>
</form>

<%  

Metodologia metodologiasConCondiciones =(Metodologia)request.getSession().getAttribute("metodologiasConCondicionesBean");  
ArrayList<Empresa> empresas  = (ArrayList<Empresa>)request.getSession().getAttribute("empresasBean");
String strDesde = (String)request.getSession().getAttribute("desdeBean");
String strHasta = (String)request.getSession().getAttribute("hastaBean");

if (metodologiasConCondiciones != null ){
  
    int desde = Integer.parseInt(strDesde);
    int hasta = Integer.parseInt(strHasta);
    if(desde <= hasta){
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
        out.print(metodologiasConCondiciones.pasaCondiciones(empresaActual,desde, hasta));
        out.print("</td>");
        out.print("</tr>");
    }
    out.print("</table>");}
    else{
        out.print("<font color='red'>Revise los periodos ingresados </font>");
    }
} 
%>

</body>
</html>
