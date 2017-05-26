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
<form action="MenuControllerServlet" method="post">
  <fieldset style="width:40%;text-align:center;background-color: rgb(245, 245, 245); border-color:#00c8f8;text-align: center; margin:auto">
    <br>
    <input class="button" type="submit"  name="cargarDatos" value="Cargar Datos en la Base">
    <br>
    <br>
    <input class="button" type="submit"  name="cargarValoresCuentas" value="Cargar Valores Cuentas">
    <br>	
    <br>
    <input class="button" type="submit"  name="consultarValores" value="Consultar Valores">
    <br>
    <br>
    <input class="button" type="submit" name="cargarMetodologia"  value="Cargar Metodologia">
    <br>
    <br>
    <input class="button" type="submit"  name="graficos" value="Visualizar Gráficos">
    <br>
    <br>
    <input class="button" type="submit"  name="analizarEmpresa" value="Analizar Empresa">
    <br>
    <br>
    <input class="button" type="submit"  name="indicadores" value="Indicadores">
    <br>
    <br>
  </fieldset>
</form>

</body>
</html>