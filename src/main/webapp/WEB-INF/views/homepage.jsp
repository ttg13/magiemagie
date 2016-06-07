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
        <script src="JS/jquery-2.2.4.js" type="text/javascript"></script>
        <script lang="javascript">
            
            function loadinfos() {
                $('#zone_ajax').load("ajax_partienondemarree_ou_plateau");
            }
            
            $(function(){
                
                setInterval(loadinfos, 1000);
            });
        </script>
        <link rel="stylesheet" type="text/css" href="CSS/style.css">
    </head>
    <body>
        <div id="zone_ajax">
        </div> 
    </body>
</html>
