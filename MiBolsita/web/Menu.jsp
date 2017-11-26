<%@page import="DTO.Usuario"%>
<!DOCTYPE html>
<html>

<html >
<head>
  <meta charset="UTF-8">
  <title>¿Dónde invierto?</title>
      <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  
<meta name="viewport" content="width=device-width, initial-scale=1">
 
  
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
  background-color: #fff;
  color: #39ace7 ;
  padding: 10px 20px;
  text-align: center;
  font-size:x-large;
  
}

/* BASIC */

body {
  background-color: #56baed;

  font-family: "Poppins", sans-serif;
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
  width: 80%;
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

input[type=text ] , input[type=password] {
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

input[type=text]:focus , input[type=password]:focus{
  background-color: #fff;
  border-bottom: 2px solid #5fbae9;
}


input[type=text]:placeholder,input[type=password]:placeholder {
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
input[type=button]{
  background-color: #56baed;
  border: none;
  color: white;
  padding: 15px 20px;
  text-align: center;
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
<body>
  <body>
         <div id="crouton">
  <ul>
    
    <li ><a href="http://localhost:8080/MiBolsita/Login.jsp""><i class="icon-fixed-width icon-user"></i>log out</a></li>
    </ul>
    
           </div>
<div class="wrapper fadeInDown">
  <div id="formContent">
   <form action="MenuControllerServlet" method="post">
       <br>
       
    <!-- Login Form -->
    
        <input type="submit" class="fadeIn fourth"  name="cargarDatos" value="Cargar Datos">
        <input type="submit" class="fadeIn fourth"  name="indicadores" value="Indicadores">
        <input type="submit" class="fadeIn fourth"  name="metodologias" value="Metodologias">
        <input type="submit" class="fadeIn fourth"  name="cargarValoresCuentas" value="Cargar Valores ">
        <input type="submit" class="fadeIn fourth"  name="consultarValores" value="Consultar Valores">
    


       </form>
</body>
  
    <script  src="js/index.js"></script>

</body>
</html>
