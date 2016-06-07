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
        <form:form modelAttribute="mesSorts" method="post">
                 <label>Quels sort souhaites vous lancez</label><br>
                 <form:radiobutton path="sort" value="HYPNOSE" /><label>Hypnose</label><br>
                 <form:radiobutton path="sort"  value="INVISIBILITE"/><label>Invisibilité</label>
                  <br>
                 <form:radiobutton  path="sort"  value="FILTREAMOUR"/><label>Filtre d amour</label>
                  <br>
                 <form:radiobutton  path="sort"  value="DIVINATION"/><label>Divination</label>
                 
                 <%--<form:select path="joueurCible"  items="${joueurCible}" itemLabel="pseudo" itemValue="id" path="id"/>--%>
                 
                 <%--<form:select path="carteCible"  items="${carteCible}" itemLabel="Typecarte" itemValue="id" path="id"/>--%>
                 
                 
                  <br>
                 <input type="submit" value="Valider"/>
            </form:form>
                 
        
        <div class="pied">
        <c:import url="_PIED.jsp"/>
        </div>
        
    </body>
</html>
