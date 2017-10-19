<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ include file="UsarIndicador.jsp" %>
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
     String valorFinal = (String)request.getSession().getAttribute("IndicadorBean");
     
     out.print("<p>"); 		
     out.print(valorFinal); 		
     out.print("</p>");
 
 %>  
  
         </div>
  </body>
 </html>