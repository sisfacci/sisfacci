<%-- 
    Document   : prueba
    Created on : 17-jun-2015, 11:28:38
    Author     : PC 18
--%>

<%@page import="com.facci.Negocio.ItemMenu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.facci.Negocio.Menu"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:f="http://xmlns.jcp.org/jsf/core">
    <h:head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SISFACCI :: <%= session.getAttribute("aliasUsuario").toString() %></title>
        <meta name="viewport" content="width=device-width" />
        <link href="../Content/css/metro-bootstrap.css" rel="stylesheet"/>
        <link href="../Content/css/metro-bootstrap-responsive.css" rel="stylesheet"/>
        <link href="../Content/css/iconFont.css" rel="stylesheet"/>
        <link href="../Content/css/docs.css" rel="stylesheet"/>
        <link href="../Content/js/prettify/prettify.css" rel="stylesheet"/>
        <link href="../Content/themes/base/jquery-ui.css" rel="stylesheet"/>
        
        <!-- Load JavaScript Libraries -->
        <script src="../Content/js/jquery/jquery.min.js"></script>
        <script src="../Content/js/jquery/jquery.widget.min.js"></script>
        <script src="../Content/js/jquery/jquery.mousewheel.js"></script>
        <script src="../Content/js/prettify/prettify.js"></script>
        <script src="../Content/js/load-metro.js"></script>
        <script src="../Content/js/jquery-ui-1.8.24.js"></script>
        <script src="../Content/js/metro.min.js"></script>
    </h:head>
    <h:body class="metro" style="background-color: #efeae3">
        <header class="bg-dark">
            <div class="navigation-bar bg-gradient-lightBlue">
                <div class="navigation-bar-content container">
                    <a href="/" class="element"><span class="icon-grid-view"></span>FkWeb <sup>2.0</sup></a>
                    <span class="element-divider"></span>
                    <a class="element1 pull-menu" href="#"></a>                    
                    <%
                        List<Menu> listaMenues = new ArrayList<Menu>();   
                        if (session.getAttribute("aliasUsuario") != null) 
                            listaMenues = (List<Menu>)session.getAttribute("menu");
                    %>
                    <% if (listaMenues.stream().count() > 0)
                       { 
                    %>
                    <ul class="element-menu">
                        <% for (Menu tmp_menu : listaMenues)
                          {
                        %>
                        <li>
                            <a href="#" class="dropdown-toggle"><%= tmp_menu.Cabecera %></a>

                            <ul class="dropdown-menu dark opacity" data-role="dropdown">
                                <%
                                    for (ItemMenu tmp_enlace : tmp_menu.Enlaces)
                                    {
                                %>
                                    <li><a href="<%= tmp_enlace.getEnlace() %>"><%= tmp_enlace.getNombre() %></a></li>
                                <%
                                    }
                                %>
                            </ul>
                        </li>
                        <%}%>
                    </ul>
                    <% } %>
                    <div class="no-tablet-portrait no-phone">
                        <% 
                            if (session.getAttribute("aliasUsuario") == null)   
                            {
                        %>
                            <a class="element place-right" href="/Account/Login" title="Iniciar sesión">
                                <span class="icon-github"></span>
                            </a>
                        <%  
                            }
                            else
                            {
                        %>
                                <a runat="server" class="element place-right " href="/Account/Manage" title="Administrar">Hola,<%= session.getAttribute("aliasUsuario").toString() %>! 
                                </a><span class="element-divider place-right"></span>
                                <a runat="server" class="element place-right " href="/Account/LogOut" title="Cerrar Sesión"> <span class="icon-exit"></span>
                                </a>
                        <%  } %>
                    </div>
                </div>
            </div>
        </header>        
    </h:body>
</html>
