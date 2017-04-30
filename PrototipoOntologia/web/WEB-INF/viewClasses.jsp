<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Protótipo de ontologias</title>
    </head>
    <body>
        <h1></h1>
            <table border="1px" cellspacing=0>
                <thead>
                    <tr>
                        <th>Nome das classes</th>
                    </tr>

                </thead>
                <tbody>
                    <c:forEach var="classe" items="${ClassesOnt}">
                        <tr>

                            <td><button onclick="location.href = 'listarOntologias?nomeClasse=${classe}'">${classe}</button></td>

                        </tr>
                    </c:forEach>  

                </tbody>
            </table>
            <div float="right">
                <table border="1px" cellspacing=0 >
                    <thead>
                        <tr>
                            <th>Sub-classes</th>
                        </tr>

                    </thead>
                    <tbody>
                        <c:forEach var="k" items="${SubClassesOnt}">
                            <tr>
                                <td>${k}</td>

                            </tr>
                        </c:forEach>  

                    </tbody>
                </table>
            </div>

    </body>
</html>
