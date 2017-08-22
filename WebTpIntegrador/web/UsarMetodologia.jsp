
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
   <form action="UsarMetodologiaControllerServlet" method="POST">
  <fieldset style="width:40%;text-align:center;background-color: rgb(245, 245, 245); border-color:#00c8f8;text-align: center; margin:auto">
    <br>
    <br> 
    <select required class="select" name="Metodologia" >
        <option value="">Metodologia</option>
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
if (periodos.size()>0) {
%>  
  <select required class="select" name="periodoDesde">
  <option value="" disabled>Periodo Desde </option>
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
  <br><br>
  <select required class="select" name="periodoHasta">
  <option value="" disabled>Periodo Hasta </option>
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
  <input class="button" type="submit" name="usarMetodologia" value="Usar Metodologia">
<br>
<br>
<%  
} 
%>
    <br>
    <br>
  </fieldset>
    
</form>

</body>
</html>
