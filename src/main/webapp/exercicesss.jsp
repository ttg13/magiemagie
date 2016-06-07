<%-- 
    Document   : exercicesss
    Created on : 7 juin 2016, 14:51:07
    Author     : ajc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="JS/jquery-2.2.4.js" type="text/javascript"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script lang="javascript">
            function changet(){
                $('#titre').html($('#ntitre').val());
            }
            </script>
            
        <title>JSP Page</title>
    </head>
    <body>
        <input type="text" id="ntitre"/>
        <input onclick="changet();" type="button" id="bouton" value="modifier titre allleeezzzz"/>
        <div id="titre">***ZONE DE TITRE****</div>
    </body>
</html>
