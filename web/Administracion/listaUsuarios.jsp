<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:p="http://primefaces.org/ui"
      xmlns:f="http://xmlns.jcp.org/jsf/core">
    <h:head>
        <title>SISFACCI :: Inicio de Sesión</title>
    </h:head>
    <h:body>   
        <%
            
        %>
        <h:form>
            <p:panelGrid columns="2" style="position: absolute; top: 250px; left:500px;">
                <f:facet name="header">Inicio de Sesión</f:facet>
                <h:outputText value="Usuario" />
                <p:inputText value="" />
                <h:outputText value="Contraseña" />
                <p:password value="" />
                <f:facet name="footer">
                    <p:commandButton value="Iniciar Sesión" action="" />
                </f:facet>
            </p:panelGrid>
        </h:form>
        
        <p:growl id="growl" sticky="true" showDetail="true"></p:growl>
    </h:body>
</html>
