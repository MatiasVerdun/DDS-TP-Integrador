<%-- 
    Document   : UsarIndicadoresPrueba
    Created on : 21-may-2017, 16:23:38
    Author     : Tobias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="VerIndicador.jsp" %>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        
<%  
    String Indicador = (String)request.getSession().getAttribute("VerIndicadorBean");

    out.print("<p>"); 		
    out.print(Indicador); 		
    out.print("</p>");

%>  
    </body>
</html>
