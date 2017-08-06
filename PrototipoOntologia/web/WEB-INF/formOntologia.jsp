<%-- 
    Document   : newjsp
    Created on : 23/04/2017, 10:39:39
    Author     : Filipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1> 
        <form action="listarOntologias" enctype="multipart/form-data" method="post">
        Insira o arquivo de Ontologia:
        <input type="file" name="arquivo"><p> 
         
            Insira a URI:<p>
            <input type="text" name="uri"><p>
                <input type="submit" value="Enviar">
        </form>
    </body>
</html>
