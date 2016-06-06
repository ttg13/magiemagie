<%-- 
    Document   : _HEAD
    Created on : 24 mai 2016, 09:48:42
    Author     : ajc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="CSS/style.css" rel="stylesheet" type="text/css"/>
<script src="JS/jquery-2.2.4.js" type="text/javascript"></script>


<script lang="javascript">
    
    function raffrai(){
        $('#sousmenu').load('raff');
        
    }
    
    $(function(){
        
        setInterval(raffrai, 1000);
        raffrai();
    });
    
    </script>