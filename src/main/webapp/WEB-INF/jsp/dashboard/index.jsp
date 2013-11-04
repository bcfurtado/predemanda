<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Dashboard - Oráculo</title>

    <link href="<c:url value="/assets/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/assets/css/starter-template.css"/>" rel="stylesheet" type="text/css" />
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

  <!-- nav-bar -->
  <jsp:include page="../nav-bar.jsp" />

    <div class="container">

      <div class="starter-template">
        <h1>Bootstrap starter template</h1>
        <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p>
      </div>

    </div><!-- /.container -->

    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
    
  </body>
</html>
