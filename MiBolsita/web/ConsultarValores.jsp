<%@page import="DAO.*"%>
<%@page import="DTO.*"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>�D�nde invierto?</title>
  
  
  <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  
  
  
      <meta name="viewport" content="width=device-width, initial-scale=1"> <!?Con esto garantizamos que se vea bien en dispositivos m�viles?> 

 
  
</head>
<style>
@import url('https://fonts.googleapis.com/css?family=Poppins');
@import "compass/css3";

@import url(https://fonts.googleapis.com/css?family=Roboto);
@import url(//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css);


* {
    font-family: sans-serif;
}

#crouton ul {
    margin: 0;
    padding: 0;
    overflow: hidden;
    width: 100%;
    list-style: none;
}

#crouton li {
    float: left;
    margin: 0 10px;
}

#crouton a {
    background: #ddd;
  padding: .7em 1em;
  float: left;
  text-decoration: none;
  color: #444;
  text-shadow: 0 1px 0 rgba(255,255,255,.5);
  position: relative;
}

#crouton li:first-child a {
    border-top-left-radius: 5px;
    border-bottom-left-radius: 5px;
}

#crouton li:last-child a {
    border-top-right-radius: 5px;
    border-bottom-right-radius: 5px;
}

#crouton a:hover {
    background: #99db76;
}

#crouton li:not(:first-child) > a::before {
    content: "";
    position: absolute;
    top: 50%;
    margin-top: -1.5em;   
    border-width: 1.5em 0 1.5em 1em;
    border-style: solid;
    border-color: #ddd #ddd #ddd transparent;
    left: -1em;
}

#crouton li:not(:first-child) > a:hover::before {
    border-color: #99db76 #99db76 #99db76 transparent;
}

#crouton li:not(:last-child) > a::after {
  content: "";
  position: absolute;
  top: 50%;
  margin-top: -1.5em;   
  border-top: 1.5em solid transparent;
  border-bottom: 1.5em solid transparent;
  border-left: 1em solid #ddd;
  right: -1em;
}

#crouton li:not(:last-child) > a:hover::after {
    border-left-color: #99db76;
}

input[type=button]{
  border: none;
  background-color: #ffffff;
  color: #39ace7 ;
  padding: 10px 20px;
  text-align: center;
  font-size:large;
  
}

/* BASIC */

html {
  background-color: #56baed;
}
body {
  font-family: "Poppins", sans-serif;
  background-color: #56baed;
  height: 100vh;
}

a {
  color: #92badd;
  display:inline-block;
  text-decoration: none;
  font-weight: 400;
}

h2 {
  text-align: center;
  font-size: 16px;
  font-weight: 600;
  text-transform: uppercase;
  display:inline-block;
  margin: 40px 8px 10px 8px; 
  color: #cccccc;
}



/* STRUCTURE */

.wrapper {
  display: flex;
  align-items: center;
  flex-direction: column; 
  justify-content: center;
  width: 100%;
  min-height: 100%;
  padding: 20px;
}

#formContent {
  -webkit-border-radius: 10px 10px 10px 10px;
  border-radius: 10px 10px 10px 10px;
  background: #fff;
  padding: 30px;
  width: 90%;
  max-width: 450px;
  position: relative;
  padding: 0px;
  -webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
  box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
  text-align: center;
}

#formFooter {
  background-color: #f6f6f6;
  border-top: 1px solid #dce8f1;
  padding: 25px;
  text-align: center;
  -webkit-border-radius: 0 0 10px 10px;
  border-radius: 0 0 10px 10px;
}



/* TABS */

h2.inactive {
  color: #cccccc;
}

h2.active {
  color: #0d0d0d;
  border-bottom: 2px solid #5fbae9;
}



/* FORM TYPOGRAPHY*/

 input[type=submit], input[type=reset]  {
  background-color: #56baed;
  border: none;
  color: white;
  padding: 15px 80px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  text-transform: uppercase;
  font-size: 13px;
  -webkit-box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
  box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
  -webkit-border-radius: 5px 5px 5px 5px;
  border-radius: 5px 5px 5px 5px;
  margin: 5px 20px 40px 20px;
  -webkit-transition: all 0.3s ease-in-out;
  -moz-transition: all 0.3s ease-in-out;
  -ms-transition: all 0.3s ease-in-out;
  -o-transition: all 0.3s ease-in-out;
  transition: all 0.3s ease-in-out;
}

 input[type=submit]:hover, input[type=reset]:hover  {
  background-color: #39ace7;
}

 input[type=submit]:active, input[type=reset]:active  {
  -moz-transform: scale(0.95);
  -webkit-transform: scale(0.95);
  -o-transform: scale(0.95);
  -ms-transform: scale(0.95);
  transform: scale(0.95);
}

input[type=text ],input[type=password ],select[class=select] {
  background-color: #f6f6f6;
  border: none;
  color: #0d0d0d;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 5px;
  width: 85%;
  border: 2px solid #f6f6f6;
  -webkit-transition: all 0.5s ease-in-out;
  -moz-transition: all 0.5s ease-in-out;
  -ms-transition: all 0.5s ease-in-out;
  -o-transition: all 0.5s ease-in-out;
  transition: all 0.5s ease-in-out;
  -webkit-border-radius: 5px 5px 5px 5px;
  border-radius: 5px 5px 5px 5px;
}

input[type=text]:focus,input[type=password]{
  background-color: #fff;
  border-bottom: 2px solid #5fbae9;
}



input[type=text]:placeholder ,input[type=password]:placeholder {
  color: #cccccc;
}




/* ANIMATIONS */

/* Simple CSS3 Fade-in-down Animation */
.fadeInDown {
  -webkit-animation-name: fadeInDown;
  animation-name: fadeInDown;
  -webkit-animation-duration: 1s;
  animation-duration: 1s;
  -webkit-animation-fill-mode: both;
  animation-fill-mode: both;
}

@-webkit-keyframes fadeInDown {
  0% {
    opacity: 0;
    -webkit-transform: translate3d(0, -100%, 0);
    transform: translate3d(0, -100%, 0);
  }
  100% {
    opacity: 1;
    -webkit-transform: none;
    transform: none;
  }
}

@keyframes fadeInDown {
  0% {
    opacity: 0;
    -webkit-transform: translate3d(0, -100%, 0);
    transform: translate3d(0, -100%, 0);
  }
  100% {
    opacity: 1;
    -webkit-transform: none;
    transform: none;
  }
}

/* Simple CSS3 Fade-in Animation */
@-webkit-keyframes fadeIn { from { opacity:0; } to { opacity:1; } }
@-moz-keyframes fadeIn { from { opacity:0; } to { opacity:1; } }
@keyframes fadeIn { from { opacity:0; } to { opacity:1; } }

.fadeIn {
  opacity:0;
  -webkit-animation:fadeIn ease-in 1;
  -moz-animation:fadeIn ease-in 1;
  animation:fadeIn ease-in 1;

  -webkit-animation-fill-mode:forwards;
  -moz-animation-fill-mode:forwards;
  animation-fill-mode:forwards;

  -webkit-animation-duration:1s;
  -moz-animation-duration:1s;
  animation-duration:1s;
}

.fadeIn.first {
  -webkit-animation-delay: 0.4s;
  -moz-animation-delay: 0.4s;
  animation-delay: 0.4s;
}

.fadeIn.second {
  -webkit-animation-delay: 0.6s;
  -moz-animation-delay: 0.6s;
  animation-delay: 0.6s;
}

.fadeIn.third {
  -webkit-animation-delay: 0.8s;
  -moz-animation-delay: 0.8s;
  animation-delay: 0.8s;
}

.fadeIn.fourth {
  -webkit-animation-delay: 1s;
  -moz-animation-delay: 1s;
  animation-delay: 1s;
}

/* Simple CSS3 Fade-in Animation */
.underlineHover:after {
  display: block;
  left: 0;
  bottom: -10px;
  width: 0;
  height: 2px;
  background-color: #56baed;
  content: "";
  transition: width 0.2s;
}

.underlineHover:hover {
  color: #0d0d0d;
}

.underlineHover:hover:after{
  width: 100%;
}



/* OTHERS */

*:focus {
    outline: none;
} 

#icon {
  width:60%;
}

* {
  box-sizing: border-box;
}
</style>
    </select>
    
   
  <body>
      
         <div id="crouton">
  <ul>
    <li ><a href="http://localhost:8080/MiBolsita/Menu.jsp""><i class="icon-fixed-width icon-home"></i>home</a></li>
    <li ><a href="http://localhost:8080/MiBolsita/Login.jsp""><i class="icon-fixed-width icon-user"></i>log out</a></li>
    </ul>
    
           </div>
<div class="wrapper">
  <div id="formContent">
   <form action="ConsultarValoresControllerServlet" method="POST">
 

    <div align="right">
        <button type="button" class="btn btn-default" onclick="history.back()"  name="atras"> <span class="glyphicon glyphicon-chevron-left" ></span> </button>
       </div>
   
   
  <select required class="select" name="Empresa" onchange="if(this.value !== '') this.form.submit()">
         <option value="">Empresa</option>
<%  
//--- Obtiene el listado de Empresas

ArrayList<Empresa> empresas =(ArrayList<Empresa>)request.getSession().getAttribute("empresasBean");  
String empresaSeleccionada = (String)request.getSession().getAttribute("empresaBean");
for (int counter = 0; counter < empresas.size(); counter++) { 		      
    out.print("<option value='"); 		
    out.print(empresas.get(counter).getCodEmpresa()); 		
    out.print("' ");

    if (empresas.get(counter).getCodEmpresa().equals(empresaSeleccionada))   {
        out.print("selected");
    }

    out.print(" >"); 		
    out.print(empresas.get(counter).getNombreEmpresa()); 		
    out.print("</option>"); 		
} 
%>
    </select>

<br>
<br>
<%  
ArrayList<String> periodos =(ArrayList<String>)request.getSession().getAttribute("periodosBean");  
if (periodos.size()>0) {
%>  
  <select required class="select" name="Periodo">
  <option value="" disabled>Periodo</option>
    <%  
       
        for (int counter = 0; counter < periodos.size(); counter++) { 		      
        
        out.print("<option value='");
        out.print(periodos.get(counter));
       out.print("' >");
        out.print(periodos.get(counter));
        out.print("</option>");
    }
    %>  
  </select>
  <br><br>
 
<br>
<br>
  <input class="button" type="submit" name="consultarValores" value="Consultar Valores">
<br>
<br>
<%  
} 
%>
    

  </fieldset>
    <div id="formFooter">
         

        
</form>
<%  
//--- Obtiene el listado de Valores de Cuentas

ArrayList<ValorCuenta>valoresCuentas =(ArrayList<ValorCuenta>)request.getAttribute("valoresCuentasBean");  


if (valoresCuentas!=null && valoresCuentas.size()>0)
{
    out.print("<br/>");
    out.print("<table class='table table-striped' >");
   
    out.print("<tr>");
        out.print("<td>");
        out.print("<b>Cuenta</b>");
        out.print("</td>");
        out.print("<td>");
        out.print("<b>Valor</b>");
        out.print("</td>");
    out.print("</tr>");
       
    for (int counter = 0; counter < valoresCuentas.size(); counter++) { 		      
        
        out.print("<tr>");
        out.print("<td>");
        out.print(valoresCuentas.get(counter).getCodCuenta());
        out.print("</td>");
        out.print("<td>");
        out.print(String.format("%.02f", valoresCuentas.get(counter).getValor()));
        //out.print(java.math.BigDecimal.valueOf(valoresCuentas.get(counter).getValor()));
        out.print("</td>");
        out.print("</tr>");
        
    } 
    
    out.print("</table>"); }
 /*   
ArrayList<ValorIndicador>valoresIndicadores =(ArrayList<ValorIndicador>)request.getAttribute("valoresIndicadoresBean");  

   
    for (int counter = 0; counter < valoresIndicadores.size(); counter++) { 		      
        out.print("<tr>");
        out.print("<td>");
        out.print(valoresIndicadores.get(counter).getNombreIndicador());
        out.print("</td>");
        out.print("<td>");
        out.print(String.format("%.02f", valoresIndicadores.get(counter).getValor()));
        //out.print(java.math.BigDecimal.valueOf(valoresIndicadores.get(counter).getValor()));
        out.print("</td>");
        out.print("</tr>");
    } 
    
    
} */





%>
</div>
</body>

     <script src="http://code.jquery.com/jquery.js"></script>

    <script src="js/bootstrap.min.js"></script>
</html>

