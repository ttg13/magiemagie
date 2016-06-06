<%-- 
    Document   : _TEMPLATE
    Created on : 24 mai 2016, 09:50:06
    Author     : ajc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <c:import url="_HEAD.jsp"/>
        <link rel="stylesheet" type="text/css" href="CSS/style.css">
    </head>
    <body>
        <div class="titre">
            <c:import url="_TITRE.jsp"/>
        </div>

        <div class="contenu">


            <div class="floating-box">adversaire1 </div>
            <div class="floating-box">adversaire2 </div>
            <div class="floating-box">adversaire3 </div>
            <div class="floating-box">adversaire4 </div>
            <div class="floating-box">adversaire5 </div>
            <div class="floating-box">adversaire6 </div>
            <div class="floating-box">adversaire7 </div>


        </div> 
        <img src="images/s1.png" alt="Photo de montagne"  />
        <div class="menu">
            <c:import url="_MENU.jsp"/>
        </div>

        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>

    </body>
</html>
