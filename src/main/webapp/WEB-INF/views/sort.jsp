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
    </head>
    <body>
        <div class="contenu"></div> 
        
        <form:form modelAttribute="mesSorts" method="post">
                 <label>Quels sort souhaites vous lancez</label><br>
                 <form:radiobutton path="sort" value="HYPNOSE" /><label>Hypnose</label><br>
                 <form:radiobutton path="sort"  value="INVISIBILITE"/><label>Invisibilité</label>
                  <br>
                 <form:radiobutton  path="sort"  value="FILTREAMOUR"/><label>Filtre d amour</label>
                  <br>
                 <form:radiobutton  path="sort"  value="DIVINATION"/><label>Divination</label>
                 <br>
                  <form:radiobutton  path="sort"  value="SOMMEILPROFOND"/><label>Sommeil profond</label>
                 <br>
                <form:select path="joueurCible"  items="${joueurCible}" itemLabel="pseudo" itemValue="pseudo" />
                 <br>
               <form:select path="carteCible"  items="${carteCible}" itemLabel="Typecarte" itemValue="Typecarte" />
                 
                 
                 <%--<form:select path="carteCible"  items="${carteCible}" itemLabel="Typecarte" itemValue="id" path="id"/>--%>
                 
                 
                  <br>
                  <input class="button" type="submit" value="Valider"/>
                  
            </form:form>
                 
        
        
    </body>
</html>
