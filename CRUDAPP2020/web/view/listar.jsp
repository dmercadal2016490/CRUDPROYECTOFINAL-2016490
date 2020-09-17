<%-- 
    Document   : listar
    Created on : 16-sep-2020, 10:51:59
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
            <h1>Personas</h1>
            <a href="Controlador?accion=add">Agregar Nuevo</a>
            <table border="1">
                <thead>
                    <tr>
                        <td>Codigo Persona</td>
                        <td>DPI</td>
                        <td>Nombre</td>
                        <td>Acciones</td>
                    </tr>
                </thead>
                <%
                    PersonaDAO dao = new PersonaDAO();
                    List<Persona> listaPersona = dao.listar();
                    Iterator<Persona> iterator = listaPersona.iterator();
                    Persona per = null;
                    while(iterator.hasNext()){
                        per = iterator.next();
                %>
                <tbody>
                    <td><%=per.getCodigoPersona()%></td>
                    <td><%=per.getDpi()%></td>
                    <td><%=per.getNombrePersona()%></td>
                    <td>
                        <a href="Controlador?accion=editar&codigoPersona=<%= per.getCodigoPersona() %>">Editar</a>
                        <a href="Controlador?accion=eliminar&codigoPersona=<%= per.getCodigoPersona() %>">Eliminar</a>
                    </td>
                    <% } %>
                </tbody>
                
            </table>
        </div>
    </body>
</html>
