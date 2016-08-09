<%-- 
    Document   : index
    Created on : Jul 22, 2016, 12:16:18 PM
    Author     : Anghel Leonard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hibernate OGM via Java Persistence API, Spring 4</title>
    </head>
    <body>        
        <h1>Hibernate OGM via Java Persistence API, Spring 4</h1>
        <form method="get" action="${pageContext.request.contextPath}/storeln">
            <input type="submit" value="Generate Lucky Number"/>
        </form>
    </body>
</html>
