<%-- 
    Document   : fluxoOntologia
    Created on : 14/09/2017, 18:33:04
    Author     : maicon
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>#</th>            
                </tr>
            </thead>
            <tbody>
                <tr>


                    <c:forEach var="i" begin="1" end="10" step="1">
                        <td><c:out value="${i}" /></td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>

        <div class="dropdown-menu">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <a class="dropdown-item" href="#">Something else here</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Separated link</a>
        </div>
    </body>
</html>
