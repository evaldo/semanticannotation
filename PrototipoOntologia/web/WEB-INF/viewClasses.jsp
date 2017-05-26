<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Protótipo de ontologias</title>
    </head>
    <body>
        <c:forEach var="k" items="${ClassesOnt}">${k}
        </c:forEach>  
    </body>
</html>
