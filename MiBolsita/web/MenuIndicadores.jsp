<!DOCTYPE html>
<html>
<body>
<head>
<style>
.form{
   height:30px;
   width:180px;
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
</style>
</head>
<form action="MenuIndicadoresControllerServlet" method="post">
  <fieldset style="width:40%;text-align:center;background-color: rgb(245, 245, 245); border-color:#00c8f8;text-align: center; margin:auto">
    <br>
    <br>
    <input class="button" type="submit"  name="cargarIndicador" value="Cargar Indicador">
    <br>
    <br>
    <input class="button" type="submit"  name="usarIndicador" value="Usar Indicador">
    <br>
    <br>
    <input class="button" type="submit"  name="verIndicador" value="Ver Indicador">
    <br>
    <br>
    
    <br>   
  </fieldset>
</form>

</body>
</html>