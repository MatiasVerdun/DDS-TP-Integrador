
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
   <form action="VerIndicadorControllerServlet" method="POST">
  <fieldset style="width:40%;text-align:center;background-color: rgb(245, 245, 245); border-color:#00c8f8;text-align: center; margin:auto">
    <br>
    <br> 
    <select required class="select" name="Indicador">
        <option value="">Indicador</option>
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
<br>

<input class="button" type="submit" value="Ver Indicador"/>

 <br>
 <br>
 </fieldset>
 </form>

</body>
</html>