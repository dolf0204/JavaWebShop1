<%-- 
    Document   : registrationConfirmed
    Created on : Mar 17, 2020, 2:27:02 PM
    Author     : RudolfGumzej
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmed</title>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

         <script src="registrationConfirmed.js"></script>
    </head>
    <body>
           <%@include file="header.jsp" %>;
        <h1 id="helloUser">Username already exists, please enter another username </h1>
           <%@include file="footer.jsp" %>;
    </body>
</html>
