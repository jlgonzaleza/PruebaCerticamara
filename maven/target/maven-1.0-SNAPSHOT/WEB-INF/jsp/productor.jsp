<%-- 
    Document   : proveedor
    Created on : 19-abr-2012, 23:12:42
    Author     : Jhon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productor</title>
    </head>
    <body>
        <jsp:include page="top.jsp"></jsp:include>
        <form method="POST" action="productor1.htm">
             <table>
            <tr>
                <td colspan="2" ><center>CREAR UN PRODUCTOR</center></td>
            </tr>
            <tr>
                <td>ID</td>
                <td><input type="text" name="id" value="${valor.idProductor}"/></td>
            </tr>
            <tr>
                <td>NOMBRE</td>
                <td><input type="text" name="nombre" value="${valor.nombre}"/></td>
            </tr>
             <tr>
                <td>TELEFONO</td>
                <td><input type="text" name="tel" value="${valor.telefono}"/></td>
            </tr>
            <tr>
                <td>DIRECCION</td>
                <td><input type="text" name="dir" value="${valor.direccion}"/></td>
            </tr>
             <tr>
                <td>EMAIL</td>
                <td><input type="text" name="email" value="${valor.mail}"/></td>
            </tr>
            
            <tr>
                <td colspan="2" ><center>
                <input type="submit" value="Enviar" />
                <input type="hidden" name="act" value="${act}">
                </center></td>
            </tr>
            </table>
            
        </form>
        <c:if test="${act}">
               <table>
            <tr>
                <td colspan="4">PRODUCTOS DEL PRODUCTOR</td>
            </tr>
            <tr>
                <td>ID</td>
                <td>NOMBRE</td>
                <td>PRECIO</td>
                <td>CANTIDAD</td>
                <td>PRODUCTOR</td>
                <td>BODEGA</td>
                <td>EDITAR</td>
                <td>ELIMINAR</td>
            </tr>
             <c:forEach items="${listaP}" var="car">
                 <c:url var="editar" value="producto1.htm?function=actualizar&id=${car.pid}" />
                 <c:url var="eliminar" value="producto1.htm?function=eliminar&id=${car.pid}" />
                 <c:url var="productor" value="productor1.htm?function=actualizar&id=${car.pidProductor}" />
                 <c:url var="bodega" value="bodega1.htm?function=actualizar&id=${car.pidBodega}" />
                 <tr>
                     
                <td>${car.pid} </td>
                <td>${car.nombre} </td>
                <td>${car.precio} </td>
                <td>${car.cantidad} </td>
                <td><a href="${productor}">${car.pidProductor} </a></td>
                <td><a href="${bodega}">${car.pidBodega} </a></td>
                <td><a href="${editar}">Editar</a></td>
                <td><a href="${eliminar}">Eliminar</a></td>
            </tr>
            </c:forEach>
            
        </table>
        </c:if>
        <hr>
        <table>
            <tr>
                <td colspan="4">PRODUCTORES</td>
            </tr>
            <tr>
                <td>ID</td>
                <td>NOMBRE</td>
                <td>TELEFONO</td>
                <td>DIRECCION</td>
                <td>EMAIL</td>
                <td>EDITAR</td>
                <td>ELIMINAR</td>
            </tr>
             <c:forEach items="${lista}" var="car">
                 <c:url var="editar" value="productor1.htm?function=actualizar&id=${car.idProductor}" />
                 <c:url var="eliminar" value="productor1.htm?function=eliminar&id=${car.idProductor}" />
                 <tr>
                     
                <td>${car.idProductor} </td>
                <td>${car.nombre} </td>
                <td>${car.telefono} </td>
                <td>${car.direccion} </td>
                <td>${car.mail} </td>
                <td><a href="${editar}">Editar</a></td>
                <td><a href="${eliminar}">Eliminar</a></td>
            </tr>
            </c:forEach>
            
        </table>
        <hr>
    </body>
</html>
