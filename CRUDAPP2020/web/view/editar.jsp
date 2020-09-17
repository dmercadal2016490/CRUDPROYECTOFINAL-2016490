<%-- 
    Document   : editar
    Created on : 16-sep-2020, 10:52:15
    Author     : FAMILIA GARCIA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <%
              PersonaDAO nuevaPersonaDAO = new PersonaDAO();
              int codPersona = Integer.parseInt((String)request.getAttribute("codPer"));
              Persona nuevaPersona = (Persona)nuevaPersonaDao.list(codPersona);
            %>
        <h1>Modificar Persona</h1>
        <form action="Controlador">
            DPI:<br>
            <input type="text" name="txtDPI" value="<%=nuevaPersona.getDPI()%>"><br>
            Nombres:<br>
            <input type="text" name="txtNombre" value="<%=nuevaPersona.getNombrePersona()%>"><br><br>
            <input type="hidden" name="txtCodigoPersona" value="<%=nuevaPersona.getCodigoPersona()%>"><br>
            <input type="submit" name="accion" value="Actualizar"><br><br>
         <form/>
       <div/>
       
    </body>
</html>
