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
    width:190px;
    font-size:120%
}
.error {
    color: red;
    font-size:110%
}
</style>
</head>
<form action="CargarDatosControllerServlet" method="post">
  <fieldset style="width:12%;text-align:center;background-color: rgb(245, 245, 245); border-color:#00c8f8;text-align: center; margin:auto">
    <br>
    <input class="button" type="submit"  name="cargarNuevaCuenta" value="Cargar Nueva Cuenta">
    <br>	
    <br>
    <input class="button" type="submit"  name="cargarNuevaEmpresa" value="Cargar Nueva Empresa">
    <br>
  
  </fieldset>
</form>
</body>
</html>
