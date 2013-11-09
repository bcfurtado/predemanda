<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta charset="UTF-8">
<title>Listar PreDemandas - Oráculo</title>

<!-- header -->
<%@ include file="../header.jsp" %>
</head>

<body>

  <!-- nav-bar -->
  <%@ include file="../nav-bar.jsp" %>

  <div class="container">

    <div class="starter-template">
      <h1>Lista das Pré-Demandas</h1>
      <p class="lead">...</p>

      <c:if test="${not empty msg }">
        <div data-dismiss="alert" class="alert alert-info">
          <p>${msg}</p>
        </div>
      </c:if>

      <c:if test="${not empty erro }">
        <div data-dismiss="alert" class="alert alert-danger">
          <p>${erro}</p>
        </div>
      </c:if>

      <div class="col-sm-12">
        <table class="table table-hover">
          <tr>
            <th>Coordenador</th>
            <th>Curso</th>
            <th>Inicio</th>
            <th>Fim</th>
            <th>Criação</th>
            <th></th>
          </tr>
          <c:forEach items="${predemandas}" var="predemanda">
            <tr>
              <td>${predemanda.coordenadorNome}</td>
              <td>${predemanda.cursoNome}</td>
              <td><fmt:formatDate value="${predemanda.dataInicio}" pattern="dd/MM/yyyy"/></td>
              <td><fmt:formatDate value="${predemanda.dataFim}" pattern="dd/MM/yyyy"/></td>
              <td><fmt:formatDate value="${predemanda.dataDaCriacao}" pattern="dd/MM/yyyy"/></td>
              <td><a href="${linkTo[DashboardController].visualizar[predemanda.id]}">Visualizar</a></td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </div>


  </div>
  <!-- /.container -->

  <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
  <script src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
  <script src="<c:url value="/assets/js/bootstrap-datepicker.js"/>"></script>

</body>
</html>
