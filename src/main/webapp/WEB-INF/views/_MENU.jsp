<%-- 
    Document   : _MENU
    Created on : 24 mai 2016, 09:49:48
    Author     : ajc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>




<div class="dashboard">Dashboard</div>
<br>

<div class="floating-box-main"><img src="images/ailes.png"  height="222" width="158" alt="description"/>Quantité :1</div>
<div class="floating-box-main"><img src="images/bave.png"  height="222" width="158" alt="description"/>Quantité :1</div>
<div class="floating-box-main"><img src="images/lapis.png"  height="222" width="158" alt="description"/>Quantité :1</div>
<div class="floating-box-main"><img src="images/sang.png"  height="222" width="158" alt="description"/>Quantité :1</div>
<div class="floating-box-main"><img src="images/unic.png"  height="222" width="158" alt="description"/>Quantité :1</div>
<div class="floating-box-main">
    <a  class="button" href="<c:url value="/launch"/>"> Lancer la partie !</a><br><br><br><br>
    <a  class="button" href="<c:url value="/lancersort"/>"> Lancer un sort</a><br><br><br><br>
<a  class="button" href="<c:url value="/Passer le tour"/>"> Passer le tour</a><br><br><br>
</div>




<div id="sousmenu">

</div>

