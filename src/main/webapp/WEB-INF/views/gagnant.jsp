<%-- 
    Document   : _TEMPLATE
    Created on : 24 mai 2016, 09:50:06
    Author     : ajc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="CSS/style.css">
    </head>
    <body>
        <div class="contenu">

            <h1><font face="fantasy">Tu as gagné car tu es le champion ! (bravo) </h1><br><br><br><br>
         <a   class="button" href="<c:url value="/login"/>"> Faire une nouvelle partie</a><br><br><br><br>
    </div> 



</body>
</html>
