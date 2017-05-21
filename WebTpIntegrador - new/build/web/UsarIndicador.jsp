
<%@page import="TP_Integrador.DTO.Empresa"%>
<%@page import="TP_Integrador.DTO.Indicador"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <style>
.form{
   height:35px;
   width:170px;
   border-color:#00c8f8;
   font-size:110%
}
.button{
    background-color: #00c8f8;
    color: white;
    height:38px; 
    width:190px;
    font-size:120%
}
.select{
   height:35px;
   width:180px;
   border-color:#00c8f8;
   font-size:110%
}
.error {
    color: red;
    font-size:110%
}
</style>
   <form action="UsarIndicadorControllerServlet" method="POST">
  <fieldset style="width:12%;text-align:center;background-color: rgb(245, 245, 245); border-color:#00c8f8;text-align: center; margin:auto">
    <br>
    <br> 
    <select required class="select" name="Indicador">
<%  
//--- Obtiene el listado de Indicadores

ArrayList<Indicador> indicadores =(ArrayList<Indicador>)request.getSession().getAttribute("indicadoresBean");  

for (int counter = 0; counter < indicadores.size(); counter++) { 		      
    out.print("<option value='"); 		
    out.print(indicadores.get(counter).getNombre()); 		
    out.print("' ");
/*
    if (empresas.get(counter).getId().equals(objSeleccionZona.getId_pais()))   {
        out.print("selected");
    }
*/
    out.print(" >"); 		
    out.print(indicadores.get(counter).getNombre()); 		
    out.print("</option>"); 		
} 
%>
    </select>
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
<input placeholder="Año" class="form" type="text" name="Anio" value="" maxlength="15" required>

    <br>
    <input class="button" type="submit" value="Usar Indicador" />
    <br>
    <br>
  </fieldset>
</form>

</body>
</html>
