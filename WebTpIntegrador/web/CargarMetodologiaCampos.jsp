<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="TP_Integrador.DTO.Indicador"%>

<html>
<body>
<head>
<style>
.form{
   height:30px;
   width:290px;
   border-color:#00c8f8;
   font-size:110%;
}
.button{
    background-color: #00c8f8;
    color: white;
    height:38px; 
    width:300px;;
    font-size:120%
}
.error {
    color: red;
    font-size:110%
}
.check {
   text-align: left;
}
.select{
   height:35px;
   width:250px;
   border-color:#00c8f8;
   font-size:110%
}
</style>
</head>
<form action="CargarMetodologiaCamposControllerServlet" method="post">
  <fieldset style="width:40%;text-align:center;background-color: rgb(245, 245, 245); border-color:#00c8f8;text-align: center; margin:auto">
<br>
    <input name ="nombreMetodologia" class="form" readonly="true"
           
           <%
            out.print("value='"); 		
            out.print(request.getAttribute("nombreMetodologiaBean")); 		
            out.print("' ");
            out.print(" >"); 		
           %>

    <br>
    <fieldset style="width:40%;text-align:left; margin:auto;float: left; border: 0;">
        <input name ="condicion" class = "check" type="radio"  onclick="handleClick('Monto')" value="menorA" checked=true> menorA<br>
    <input name ="condicion" class = "check" type="radio"  onclick="handleClick('Monto')" value="mayorA"> mayorA<br>
    <input name ="condicion" class = "check" type="radio"  onclick="handleClick('Cantidad de periodos')" value="creciente"> creciente<br>
    <input name ="condicion" class = "check" type="radio"  onclick="handleClick('Cantidad de periodos')" value="decreciente"> decreciente<br>
    <input name ="condicion" class = "check" type="radio"  onclick="handleClick('Cantidad de periodos')" value="consistente"> consistente<br>
    </fieldset>
    <br>
   
    <script>
    function handleClick(texto) {
    //document.getElementById("monto").disabled = bool;
      document.getElementById("monto").placeholder=texto;   
      }
     </script>
    
    <select required class="select" name="Indicador">
<%  
//--- Obtiene el listado de Indicadores

ArrayList<Indicador> indicadores =(ArrayList<Indicador>)request.getSession().getAttribute("indicadoresBean");  

for (int counter = 0; counter < indicadores.size(); counter++) { 		      
    out.print("<option value='"); 		
    out.print(indicadores.get(counter).getNombre()); 		
    out.print("' ");
    out.print(" >"); 		
    out.print(indicadores.get(counter).getNombre()); 		
    out.print("</option>"); 		
} 
%>
</select>
<br>
<br>
<input type="number" min="0" onkeypress="return event.charCode >= 48" class="select" name="monto" placeholder="Monto" id="monto" required />

<br>

<br>
<input class="button" type="submit" name="proximaCondicion" value="Proxima Condicion"/>
<br>
<br>
<input class="button" type="submit"  name="finalizarCarga" value="Finalizar Carga">
</fieldset>
</form>
</body>
</html>
