<%-- 
    Document   : producto
    Created on : 19-abr-2012, 23:48:31
    Author     : Jhon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prodcuto</title>
    </head>
    <body>
        <jsp:include page="top.jsp"></jsp:include>
        <form method="POST" action="producto1.htm">
             <table>
            <tr>
                <td colspan="2" ><center>CREAR UN PRODUCTO</center></td>
            </tr>
            <tr>
                <td>ID</td>
                <td><input type="text" name="id" value="${valor.pid}"/></td>
            </tr>
            <tr>
                <td>NOMBRE</td>
                <td><input type="text" name="nombre" value="${valor.nombre}"/></td>
            </tr>
             <tr>
                <td>PRECIO</td>
                <td><input type="text" name="precio" value="${valor.precio}"/></td>
            </tr>
            <tr>
                <td>CANTIDAD</td>
                <td><input type="text" name="cant" value="${valor.cantidad}"/></td>
            </tr>
             <tr>
                <td>PRODUCTOR</td>
                <td><select id="prod" name="prod" >
                        <c:forEach items="${listaP}" var="car">
                            <option value="${car.idProductor}">${car.nombre}</option>
                        </c:forEach></select>
                </td>
            </tr>
            <tr>
                <td>BODEGA</td>
                <td><select id="bode" name="bode">
                        <c:forEach items="${listaB}" var="car">
                            <option value="${car.codigo}">${car.codigo}</option>
                        </c:forEach></select></td>
            </tr>
            
            <tr>
                <td colspan="2" ><center>
                <input type="submit" value="Enviar" />
                <input type="hidden" name="act" value="${act}">
                </center></td>
            </tr>
            </table>
            
        </form>
        
        <hr>
        <table>
            <tr>
                <td colspan="4">PRODUCTOS</td>
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
             <c:forEach items="${lista}" var="car">
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
        <hr>
    </body>
</html>
