<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ include file="VerIndicador.jsp" %>
 <!DOCTYPE html>
 <html>
     <head>
     </head>
     <body>
         
<%
  
    String indicador=(String)request.getSession().getAttribute("VerIndicadorBean");
   
    out.print("<p>");
    out.print(indicador);
    out.print("</p>");
%>
 
     </body>
 </html>