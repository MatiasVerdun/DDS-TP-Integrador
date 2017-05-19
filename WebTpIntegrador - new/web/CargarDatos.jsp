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
    <fieldset>
    <br>
    <input class="button" type="submit"  name="cargarNuevasCuentas" value="Cargar Nuevas Cuentas ">
    <br>
    <br>
    <input class="button" type="submit" name="cargarNuevasEmpresas"  value="Cargar Nuevas Empresas">
    <br>
  </fieldset>
</form>
</body>
</html>
