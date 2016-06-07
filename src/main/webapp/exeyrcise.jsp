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
            
            function callback() {
  setTimeout(loadinfos, 1000);
}
            function loadinfos(){
                $('#sort').load("majvariables");
                
                //$.get('ajax_sort');
                
            }
            </script>
            
        <title>JSP Page</title>
    </head>
    <body>

        <input onclick="loadsort();" type="button" id="bouton" value="LANCER UN SORT"/>
        <div id="sort">***ZONE DE TITRE****</div>
    </body>
</html>
