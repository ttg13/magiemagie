<%-- 
    Document   : _TEMPLATE
    Created on : 24 mai 2016, 09:50:06
    Author     : ajc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="_HEAD.jsp"/>
    </head>
    <body>
        <div class="titre">
        <c:import url="_TITRE.jsp"/>
        </div>
        <div class="contenu"></div> 
        
        <div class="menu">
        <c:import url="_MENU.jsp"/>
        </div>
        <form method="post">
         <select name="sortsDispo_id">
                    <c:forEach items="${sortsDispo}" var="sort">
                        <option>${sorts}</option> 
                       
                    </c:forEach>    
        </select>
            <button class="button" type="submit" value="lancer"></button>
        </form>
        
        <div class="pied">
        <c:import url="_PIED.jsp"/>
        </div>
        
    </body>
</html>
