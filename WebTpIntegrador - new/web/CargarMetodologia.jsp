<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="TP_Integrador.DTO.Empresa"%>
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
   width:290px;
   border-color:#00c8f8;
   font-size:110%
}
</style>
</head>


<form action="CargarMetodologiaControllerServlet" method="post">
  <fieldset style="width:40%;text-align:center;background-color: rgb(245, 245, 245); border-color:#00c8f8;text-align: center; margin:auto">
    <br>
    
<input placeholder="Nombre" class="form" type="text" name="nombreMetodologia" value="" maxlength="500" >
    <br>	
    <br>
    <br>
 <input class="button" type="submit" name="cargarCondiciones" value="Cargar Condiciones"/>
    <br>

</fieldset>
</form>
</body>
</html>


