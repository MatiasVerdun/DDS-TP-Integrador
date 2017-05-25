<!DOCTYPE html>
<html>
<body>
<head>
<style>
.form{
   height:30px;
   width:290px;
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
.error {
    color: red;
    font-size:110%
}
</style>
</head>
<form action="GuardarDatosEmpresasControllerServlet" method="post">
  <fieldset style="width:40%;text-align:center;background-color: rgb(245, 245, 245); border-color:#00c8f8;text-align: center; margin:auto">
 	<br>
	<br>
    <input placeholder="Codigo Empresa" class="form" type="text" name="codEmpresa" value="" maxlength="15" >
    <br>
    <br>
	<br>
    <input placeholder="Nombre Empresa" class="form" type="text" name="nombreEmpresa" value="" maxlength="15" >
    <br>
	<br>
	<br>
    <input class="button" type="submit"  value="CargarEmpresa">
    <br>
    <br>
  
  </fieldset>
</form>
</body>
</html>