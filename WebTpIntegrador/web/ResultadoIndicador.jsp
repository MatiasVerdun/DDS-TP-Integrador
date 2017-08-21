<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ include file="UsarIndicador.jsp" %>
 <!DOCTYPE html>
 <html>
     <head>
     </head>
     <body>
         
 <%  
     String valorFinal = (String)request.getSession().getAttribute("IndicadorBean");
     
     out.print("<p>"); 		
     out.print(valorFinal); 		
     out.print("</p>");
 
 %>  
     </body>
 </html>