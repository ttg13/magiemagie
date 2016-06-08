<%-- 
    Document   : _MENU
    Created on : 24 mai 2016, 09:49:48
    Author     : ajc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:forEach items="${players}" var="players" >
    <div class="post-container">                
        <div class="post-thumb"><img src="images/s${players.typeSorciere}.png"  height="200" width="142"></div>
        <div class="post-content">
            <p>${players.pseudo} <br> Nombre de cartes: ??? <br> Mort ?->${players.perdu==true}
            </p></div>
    </div>
</c:forEach>



<div class="dashboard">Dashboard</div>
<br>

<div class="floating-box-main"><img src="images/ailes.png"  height="222" width="158" alt="description"/>Quantité: ${souriscount}</div>
<div class="floating-box-main"><img src="images/bave.png"  height="222" width="158" alt="description"/>Quantité: ${bavecount}</div>
<div class="floating-box-main"><img src="images/lapis.png"  height="222" width="158" alt="description"/>Quantité: ${lapiscount}</div>
<div class="floating-box-main"><img src="images/sang.png"  height="222" width="158" alt="description"/>Quantité: ${sangcount}</div>
<div class="floating-box-main"><img src="images/unic.png"  height="222" width="158" alt="description"/>Quantité: ${cornecount}</div>
<div class="floating-box-main">

    <c:choose>
        <c:when test="${partielancee!=true}">
            <a  onclick="callback();" class="button" href="<c:url value="/launch"/>"> Lancer la partie !</a><br><br><br><br>
        </c:when>
        <c:otherwise>
            <c:choose>
                <c:when test="${joueur.marqueurMain==true}">
                    <a  class="button" href="<c:url value="/lancersort"/>"> Lancer un sort</a><br><br><br><br>
                    <a  class="button" href="<c:url value="/passer"/>"> Passer le tour</a><br><br><br>
                </c:when>
                <c:otherwise>
                    <a  class="buttonoff" href="<c:url value=""/>"> Lancer un sort</a><br><br><br><br>
                    <a  class="buttonoff" href="<c:url value=""/>"> Passer le tour</a><br><br><br>
                </c:otherwise>
            </c:choose>
        </c:otherwise>
    </c:choose>
</div>


<div class="floating-box-action-zone">

    <form:form modelAttribute="mesSorts" method="post">
        <label>Quels sort souhaites vous lancez</label><br>
        <form:radiobutton path="sort" value="HYPNOSE" /><label>Hypnose</label><br>
        <form:radiobutton path="sort"  value="INVISIBILITE"/><label>Invisibilité</label>
        <br>
        <form:radiobutton  path="sort"  value="FILTREAMOUR"/><label>Filtre d amour</label>
        <br>
        <form:radiobutton  path="sort"  value="DIVINATION"/><label>Divination</label>
        <br>
        <form:select path="joueurCible"  items="${joueurCible}" itemLabel="pseudo" itemValue="pseudo" />
        <br>
        <form:select path="carteCible"  items="${carteCible}" itemLabel="Typecarte" itemValue="Typecarte" />


        <%--<form:select path="carteCible"  items="${carteCible}" itemLabel="Typecarte" itemValue="id" path="id"/>--%>


        <br>
        <input type="submit" value="Valider"/>
    </form:form>
</div>


