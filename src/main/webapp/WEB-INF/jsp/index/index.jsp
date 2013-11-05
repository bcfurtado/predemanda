<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta charset="UTF-8">
<title>Home - Oráculo</title>

<!-- header -->
<jsp:include page="../header.jsp"></jsp:include>

</head>

<body>

  <!-- nav-bar -->
  <div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Oráculo</a>
      </div>
      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">Inicio</a></li>
          <li><a href="#contact">Contato</a></li>
        </ul>
        <c:if test="${sessaoWeb.logado}">
        <ul class="nav navbar-nav navbar-right">
          <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">${sessaoWeb.pessoa.nome} <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="#">Action</a></li>
              <li><a href="#">Another action</a></li>
              <li><a href="#">Something else here</a></li>
              <li class="divider"></li>
              <li><a href="${linkTo[IndexController].logout}">Logout</a></li>
            </ul></li>
        </ul>
        </c:if>
      </div>
    </div>
  </div>

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
  <jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
