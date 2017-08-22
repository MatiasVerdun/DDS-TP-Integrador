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
   <form action="UsarIndicadorControllerServlet" method="POST">
  <fieldset style="width:40%;text-align:center;background-color: rgb(245, 245, 245); border-color:#00c8f8;text-align: center; margin:auto">
    <br>
    <br> 
    <select required class="select" name="Indicador" onchange="if(this.value !== '') this.form.submit()">
        <option value="">Indicador</option>
<%  
//--- Obtiene el listado de Indicadores

ArrayList<Indicador> indicadores =(ArrayList<Indicador>)request.getSession().getAttribute("indicadoresBean");
String indicadorSeleccionado=(String)request.getSession().getAttribute("indicadorBean");

for (int counter = 0; counter < indicadores.size(); counter++) { 		      
    out.print("<option value='"); 		
    out.print(indicadores.get(counter).getNombre()); 		
    out.print("' ");

    if (indicadores.get(counter).getNombre().equals(indicadorSeleccionado))   {
        out.print("selected");
    }

    out.print(" >"); 		
    out.print(indicadores.get(counter).getNombre()); 		
    out.print("</option>"); 		
} 
%>
    </select>
    <br>
    <br>
    <%  
ArrayList<Empresa> empresas =(ArrayList<Empresa>)request.getSession().getAttribute("empresasBean"); 
if (empresas.size()>0) {
%>  
 <select required class="select" name="Empresa" onchange="if(this.value !== '') this.form.submit()">
     <option value="" disable >Empresa</option>
<%  
//--- Obtiene el listado de Empresas

 String empresaSeleccionada = (String)request.getSession().getAttribute("empresaBean");

for (int counter = 0; counter < empresas.size(); counter++) { 		      
    out.print("<option value='"); 		
    out.print(empresas.get(counter).getCodEmpresa()); 		
    out.print("' ");
      if(empresas.get(counter).getCodEmpresa().equals(empresaSeleccionada)){
          out.print("selected");
      }
    out.print(" >"); 		
    out.print(empresas.get(counter).getNombreEmpresa()); 		
    out.print("</option>"); 		
} 
}
%>
</select>
<br>
<br>
<br>
<%  
ArrayList<String> periodos =(ArrayList<String>)request.getSession().getAttribute("periodosBean");  
if (periodos.size()>0) {
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
  <input class="button" type="submit" name="usarIndicador" value="Usar Indicador">
<br>
<br>
<%  
} 
%>
  </fieldset>
</form>

</body>
</html>
