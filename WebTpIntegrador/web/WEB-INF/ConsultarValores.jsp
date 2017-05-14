<!DOCTYPE html>
<html>
<body>
<head>
<style>
.form{
   height:35px;
   width:170px;
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
.select{
   height:35px;
   width:180px;
   border-color:#00c8f8;
   font-size:110%
}
.error {
    color: red;
    font-size:110%
}
</style>
  <form action="ConsultarValoresControllerServlet" method="POST">
  <fieldset style="width:12%;text-align:center;background-color: rgb(245, 245, 245); border-color:#00c8f8;text-align: center; margin:auto">
    <br>
    <br> 
    <select required class="select" name="Empresa">
    <br>
    <br>
    <br>
    <br>
    <input placeholder="Periodo" class="form" type="text" name="Periodo" value="" maxlength="15" >
    <br>
    <br>
    <input class="button" type="submit" value="Consultar Valores" />
    <br>
    <br>
  </fieldset>
</form>
</body>
</html>

