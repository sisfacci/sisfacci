<%-- 
    Document   : LogOut
    Created on : 17-jun-2015, 11:41:35
    Author     : PC 18
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.invalidate();
            //request.getRequestDispatcher("/Account/login.xhtml").include(request, response);           
            request.getRequestDispatcher("/").forward(request, response); 
        %>
    </body>
</html>
