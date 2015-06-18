<%@page import="com.facci.entity.Usuario"%>
<%@include file="../SiteMaster.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="http://localhost:8084/SISFACCI/Content/css/metro-bootstrap.css" rel="stylesheet"/>
        <link href="http://localhost:8084/SISFACCI/Content/css/metro-bootstrap-responsive.css" rel="stylesheet"/>
        <link href="http://localhost:8084/SISFACCI/Content/css/iconFont.css" rel="stylesheet"/>
        <link href="http://localhost:8084/SISFACCI/Content/css/docs.css" rel="stylesheet"/>
        <link href="http://localhost:8084/SISFACCI/Content/js/prettify/prettify.css" rel="stylesheet"/>
        <link href="http://localhost:8084/SISFACCI/Content/themes/base/jquery-ui.css" rel="stylesheet"/>
        
        <!-- Load JavaScript Libraries -->
        <script src="http://localhost:8084/SISFACCI/Content/js/funciones.js"></script>
        <script src="http://localhost:8084/SISFACCI/Content/js/jquery/jquery.min.js"></script>
        <script src="http://localhost:8084/SISFACCI/Content/js/jquery/jquery.widget.min.js"></script>
        <script src="http://localhost:8084/SISFACCI/Content/js/jquery/jquery.mousewheel.js"></script>
        <script src="http://localhost:8084/SISFACCI/Content/js/prettify/prettify.js"></script>
        <script src="http://localhost:8084/SISFACCI/Content/js/load-metro.js"></script>
        <script src="http://localhost:8084/SISFACCI/Content/js/jquery-ui-1.8.24.js"></script>
    </head>
    
    <h:body class="metro">        
        <br/>
        <div id="body" class="container">
            <section class="content-wrapper main-content clear-fix">
                <div class="example">
                <fieldset>
                    <legend>Información del Usuario</legend>
                    <input type="hidden" id="id" value="${login.idUsuario}"/>
                    <h:form>
                        <div class="grid">
                            <div class="row">
                                <div class="span6">
                                    <label class="size3 place-left">Username</label>
                                    <div class="input-control text size3 place-left" data-role="input-control">
                                        <input class="input-control text bd-grayLight" readonly="true" value="${login.username}" />
                                    </div>
                                    <label class="size3 place-left">Nombres</label>
                                    <div class="input-control text size3 place-left" data-role="input-control">                                
                                        <input id="txtNombres" ReadOnly="true" maxlength="300" value="${login.nombre}"/>
                                    </div>
                                    <label class="size3 place-left">Identificación</label>
                                    <div class="input-control text size3 place-left" data-role="input-control">
                                        <input id="txtIdentificacion" ReadOnly="true" maxlength="300" value="${login.identificacion}"/>
                                    </div>
                                    <label class="size3 place-left">Contraseña</label>
                                    <div class="input-control text size3 place-left" data-role="input-control">
                                        <input id="txtContrasena"  type="password" maxlength="300" value="${login.password}"/>
                                    </div>
                                    <label class="size3 place-left">Confirmar Contraseña</label>
                                    <div class="input-control text size3 place-left" data-role="input-control">
                                        <input id="txtConfirmaContrasena" type="password" maxlength="300" value="${login.password2}"/>
                                    </div>
                                </div>
                                <div class="span6">
                                    <label class="size3 place-left">Dirección</label>
                                    <div class="input-control text size3 place-left" data-role="input-control">
                                        <input id="txtDireccion" maxlength="300" value="${login.direccion}"/>
                                    </div>
                                     <label class="size3 place-left">Teléfono</label>
                                    <div class="input-control text size3 place-left" data-role="input-control">
                                        <input id="txtTelefono" onKeyPress="return NumCheck(event, this, false)" maxlength="15" value="${login.telefono}"/>
                                    </div>
                                    <label class="size3 place-left">Email</label>
                                    <div class="input-control text size3 place-left" data-role="input-control">
                                        <input id="txtEmail" type="email" maxlength="300" value="${login.email}"/>
                                    </div>

                                    <input type="submit" value="Guardar Cambios" class="btn success" onclick="${login.manageControl()}" />
                                </div>
                            </div>
                        </div> 
                    </h:form>
                </fieldset>
            </div>
            </section>
        </div>        
    </h:body>
</html>
