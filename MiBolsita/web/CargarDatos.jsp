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
.buttonBack{
    background-color: #00c8f8;
    color: white;
    height:38px; 
    width:40px;
    font-size:120%
    
   
}
.error {
    color: red;
    font-size:110%
}
</style>
</head>
<form action="CargarDatosControllerServlet" method="post">
    
    <fieldset style="width:40%;background-color: rgb(245, 245, 245); border-color:#00c8f8;text-align: center; margin:auto">
    <br>
    <br>
    <input class="button" type="submit"  style="text-align:center" name="cargarNuevasCuentas" value="Cargar Nuevas Cuentas " >
    <input class="buttonBack" style="align:right" type="submit"  name="atras" value="<--">
    <br>
    <br>
    <input class="button" type="submit" style="text-align:center" name="cargarNuevasEmpresas"  value="Cargar Nuevas Empresas" >
    <br>
    <br>
  </fieldset>
</form>
</body>
</html>
