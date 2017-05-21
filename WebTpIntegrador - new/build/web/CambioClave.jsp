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
<form action="CambiarClaveControllerServlet" method="post">
  <fieldset style="width:12%;text-align:center;background-color: rgb(245, 245, 245); border-color:#00c8f8;text-align: center; margin:auto">
 	<br>
	<br>
    <input placeholder="Usuario" class="form" type="text" name="Usuario" value="" maxlength="15" required>
    <br>
    <br>
	<br>
    <input placeholder="Contraseña Actual" class="form" type="password" name="Clave" value="" maxlength="15" required>
    <br>
	<br>
	<br>
            <input placeholder="Contraseña Nueva" class="form" type="password" name="ClaveNueva" value="" maxlength="15" required>
    <br>
    <br>
    <input class="button" type="submit"  value="Cambiar Contraseña">
    <br>
    <br>

    <br>
  </fieldset>
</form>
</body>
</html>

