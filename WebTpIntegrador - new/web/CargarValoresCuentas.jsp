<!DOCTYPE html>
<html>
<body>
<head>
<style>
.file{
   height:30px;
   border-color:#00c8f8;
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
  <form enctype="multipart/form-data" action="CargarValoresCuentasControllerServlet" method="POST">
  <fieldset style="width:30%;text-align:center;background-color: rgb(245, 245, 245); border-color:#00c8f8;text-align: center; margin:auto">
 	<br>
	<br> 
    <input class="file" name="uploadedfile" id="uploadedfile" type="file" />
    <br>
    <br>
    <input class="button" type="submit" value="Subir archivo" />
    <br>
    <br>
  </fieldset>
</form>
</body>
</html>
