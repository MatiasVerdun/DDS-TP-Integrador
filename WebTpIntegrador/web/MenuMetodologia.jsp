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
<form action="MenuMetodologiaControllerServlet" method="post">
  <fieldset style="width:40%;text-align:center;background-color: rgb(245, 245, 245); border-color:#00c8f8;text-align: center; margin:auto">
    <br>
    <input class="button" type="submit"  name="cargarMetodologia" value="Cargar Metodologia">
    <br>
    <br>
    <input class="button" type="submit"  name="usarMetodologia" value="Usar Metodologia">
    <br>
    <br>
  </fieldset>
</form>

</body>
</html>
