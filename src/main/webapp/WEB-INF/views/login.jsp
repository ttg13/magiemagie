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


            <form:form method="post" modelAttribute="ajoutjoueur" >
              <h1><font face="fantasy">Entrez ici votre pseudo : <form:input path="pseudo" type="text" name="login"/></font></h1>



                <div class="floating-box-images"><h1>1</h1><img src="images/s1.png"  height="416" width="297" alt="description"/></div>
                <div class="floating-box-images"><h1>2</h1><img src="images/s2.png" height="416" width="297" alt="description"/></div>
                <div class="floating-box-images"><h1>3</h1><img src="images/s3.png" height="416" width="297" alt="description"/></div>
                <div class="floating-box-images"><h1>4</h1><img src="images/s4.png" height="416" width="297" alt="description"/></div>
                <div class="floating-box-images"><h1>5</h1><img src="images/s5.png" height="416" width="297" alt="description"/></div>
                <div class="floating-box-images"><h1>6</h1><img src="images/s6.png" height="416" width="297" alt="description"/></div>
                <div class="floating-box-images"><h1>7</h1><img src="images/s7.png" height="416" width="297" alt="description"/></div>
                <div class="floating-box-images"><h1>8</h1><img src="images/s8.png" height="416" width="297" alt="description"/></div>

                <h1><font face="fantasy">Quel personnage voulez vous incarner ?
                    <form:select path="typeSorciere" name="sorcieres" size="1">
                        <Option>1
                        <Option>2
                        <Option>3
                        <Option>4
                        <Option>5
                        <Option>6
                        <Option>7
                        <Option>8
                        </form:select>
                    </font> &nbsp &nbsp<input class="button" type="submit" titre="ajouter" value="Connexion"/></h1>



            </form:form>



        </div> 



    </body>
</html>
