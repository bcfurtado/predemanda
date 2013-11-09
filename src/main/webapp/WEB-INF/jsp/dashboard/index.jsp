<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Dashboard - Oráculo</title>
  
    <%@ include file="../header.jsp" %>
    
  </head>

  <body>

  <!-- nav-bar -->
  <%@ include file="../nav-bar.jsp" %>
    <div class="container">

      <div class="starter-template">
        <h1>Bem Vindo</h1>
        <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p>
        
        <c:if test="${not empty msg }">
          <div data-dismiss="alert" class="alert alert-info"><p>${msg}</p></div>
        </c:if>
        <c:if test="${not empty erro }">
          <div data-dismiss="alert" class="alert alert-danger"><p>${erro}</p></div>
        </c:if>

      </div>
  
    </div><!-- /.container -->

    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
    
  </body>
</html>
