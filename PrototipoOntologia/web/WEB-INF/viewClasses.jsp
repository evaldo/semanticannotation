<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Protótipo de ontologias</title>
        <style>
            table{
                float:left;
                border: 1px blue solid;
                border-radius: 20px;
            }
        </style>
    </head>
    <body>
        ${arq_ontologiaTxt}<p>
        ${uriTxt}
        <p>
            <p>
        <table >
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

        <table >
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


    </body>
</html>
