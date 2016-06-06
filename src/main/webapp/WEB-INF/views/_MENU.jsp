<%-- 
    Document   : _MENU
    Created on : 24 mai 2016, 09:49:48
    Author     : ajc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:choose>
    <c:when test="${utilConnecte!=null}">
        <br>
        <a href="<c:url value="/echanger"/>"> Echanger &nbsp &nbsp</a>
        <a href="<c:url value="planter"/>"> Planter &nbsp &nbsp</a>
        <a href="<c:url value="reproduire"/>"> Reproduire &nbsp &nbsp</a>
        <a href="<c:url value="nourrir"/>"> Nourrir &nbsp &nbsp</a>
        <a href="<c:url value="/logout"/>"> Déconnexion <br></a>
        <br>
        <br>
        
        <div id="sousmenu">
     
        </div>
        
        <br>
        <br>
        
        
        <br>
    </c:when>
    <c:otherwise>
        
        <br>
        <form method="post" action="<c:url value="/login"/>"/>
        <label>Login          </label>
        <input type="text" name="login"/>
        <label>Password          </label>
        <input type="password" name="pass" />
        <input type="submit" titre="ajouter" value="Connexion"/>
        <a href="<c:url value="/inscription.jsp"/>">&nbsp &nbsp inscription &nbsp &nbsp </a>
        <br>
    </form>
</c:otherwise>
</c:choose>



</ul>       

