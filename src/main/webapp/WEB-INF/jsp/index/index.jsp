<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta charset="UTF-8">
<title>Home - Oráculo</title>

<!-- header -->
<%@ include file="../header.jsp" %>

</head>

<body>

  <!-- nav-bar -->
  <%@ include file="../nav-bar.jsp" %>
  
  <div class="container">

    <div class="starter-template">
      <h1>Bem Vindo</h1>

      <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
          <div class="account-wall">
            <h2>Login</h2>
            <form class="form-signin" action="${linkTo[IndexController].autenticar }" method="post">
              <input id="email" name="email" type="text" class="form-control" placeholder="Email" required autofocus>
              <input id="senha" name="senha" type="password" class="form-control" placeholder="Senha" required>
              <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
            </form>
          </div>
          <c:if test="${not empty erro}"><p>${erro}</p></c:if>
        </div>
      </div>

    </div>




  </div>
  <!-- /.container -->

  <!-- footer -->
  <%@ include file="../footer.jsp" %>

</body>
</html>
