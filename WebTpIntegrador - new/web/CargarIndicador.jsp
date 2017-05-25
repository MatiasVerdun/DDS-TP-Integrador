<!DOCTYPE html>
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
</style>
</head>
<form action="CargarIndicadoresControllerServlet" method="post">
  <fieldset style="width:40%;text-align:center;background-color: rgb(245, 245, 245); border-color:#00c8f8;text-align: center; margin:auto">
    <br>
    <input placeholder="Nombre" class="form" type="text" name="nombreIndicador" value="" maxlength="15" >
    <br>	
    <br>
    <input placeholder="Indicador" class="form" type="text" name="indicador" value="" maxlength="200" >
    <br>
    <br>
    <input class="button" type="submit"  name="cargarIndicador" value="Cargar Indicador">
  
  </fieldset>
</form>
</body>
</html>
