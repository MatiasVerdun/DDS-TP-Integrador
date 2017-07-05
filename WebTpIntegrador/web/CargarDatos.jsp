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
<form action="CargarDatosControllerServlet" method="post">
    <fieldset style="width:40%;text-align:center;background-color: rgb(245, 245, 245); border-color:#00c8f8;text-align: center; margin:auto">
    <br>
    <input class="button" type="submit"  name="cargarNuevasCuentas" value="Cargar Nuevas Cuentas ">
    <br>
    <br>
    <input class="button" type="submit" name="cargarNuevasEmpresas"  value="Cargar Nuevas Empresas">
    <br>
    <br>
    <input class="button" type="submit"  name="cargarNuevoIndicador" value="Cargar Nuevo Indicador">
    <br>
    <br>
  </fieldset>
</form>
</body>
</html>
