<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ include file="VerIndicador.jsp" %>
 <!DOCTYPE html>
 <html>
     <head>
         <style>
             #formFooter {
  background-color: #f6f6f6;
  border-top: 1px solid #dce8f1;
  padding: 25px;
  text-align: center;
  -webkit-border-radius: 0 0 10px 10px;
  border-radius: 0 0 10px 10px;
}
             </style>
     </head>
     <body>
         <div id="formFooter">
<%
  
    String indicador=(String)request.getSession().getAttribute("VerIndicadorBean");
   
    out.print("<p>");
    out.print(indicador);
    out.print("</p>");
%>
         </div>
     </body>
 </html>