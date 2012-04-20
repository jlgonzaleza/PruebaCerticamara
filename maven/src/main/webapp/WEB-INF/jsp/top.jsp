<%-- 
    Document   : top
    Created on : 19-abr-2012, 23:39:44
    Author     : Jhon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:url var="bodega" value="bodega1.htm" />
        <c:url var="productor" value="productor1.htm" />
        <c:url var="producto" value="producto1.htm" />         
        <center> 
            <table>
                <tr>
                    <td><h2><a href="${bodega}">1.BODEGA</a></h2></td>
                    <td><h2><a href="${productor}">2.PRODUCTOR</a></h2></td>
                    <td><h2><a href="${productor}">3.PRODUCTO</a></h2></td>
                </tr>
            </table>
        
        </center>
                    <hr>
    </body>
</html>
