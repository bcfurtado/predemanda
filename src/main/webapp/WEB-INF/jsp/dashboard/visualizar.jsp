<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta charset="UTF-8">
<title>Visualizar PreDemanda - Oráculo</title>
  
  <!-- header -->
  <%@ include file="../header.jsp" %>

</head>

<body>

  <!-- nav-bar -->
  <%@ include file="../nav-bar.jsp" %>
  <div class="container">

    <div class="starter-template">
      <h1>Visualizar Pré-Demanda</h1>
      <p class="lead">...</p>

      <c:if test="${not empty msg }">
        <div data-dismiss="alert" class="alert alert-info"><p>${msg}</p></div>
      </c:if>
      
      <c:if test="${not empty erro }">
        <div data-dismiss="alert" class="alert alert-danger"><p>${erro}</p></div>
      </c:if>
      
      <form class="form-horizontal" role="form">
        <!-- Coordenador -->
        <div class="form-group">
          <label class="col-sm-2 control-label">Coordenador</label>
          <div class="col-sm-10">
            <input class="form-control" type="text" placeholder="${predemanda.coordenadorNome}" disabled>
          </div>
        </div>
        <!-- Curso -->
        <div class="form-group">
          <label class="col-sm-2 control-label">Curso</label>
          <div class="col-sm-10">
            <input class="form-control" type="text" placeholder="${predemanda.cursoNome}" disabled>
          </div>
        </div>
        <!-- Periodo da Pré Demanda -->
        <div class="form-group">
          <label class="col-sm-2 control-label" for="data-inicio">Data Inicio</label>
          <div class="col-sm-10">
            <input type="date" class="form-control" value="<fmt:formatDate value="${predemanda.dataInicio}" pattern="dd/MM/yyyy"/>" disabled/>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-2 control-label" for="data-fim">Data Fim</label>
          <div class="col-sm-10">
            <input type="date" class="form-control" value="<fmt:formatDate value="${predemanda.dataFim}" pattern="dd/MM/yyyy"/>" disabled/>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-2 control-label" for="data-fim">Data Criação</label>
          <div class="col-sm-10">
            <input type="date" class="form-control" value="<fmt:formatDate value="${predemanda.dataDaCriacao}" pattern="dd/MM/yyyy"/>" disabled/>
          </div>
        </div>
        <!-- Disciplinas -->
        <div class="form-group">
          <label class="col-sm-2 control-label" for="disciplinas">Disciplinas</label>
          <div class="col-sm-10">
          <table class="table table-hover">
            <tr>
              <th>Codigo</th>
              <th>Nome</th>
            </tr>
            <c:forEach items="${disciplinas}" var="disciplina">
            <tr>
              <td>${disciplina.codigo}</td>
              <td>${disciplina.nome}</td>
            </tr>
            </c:forEach>
            </table>
          </div>
        </div>

      </form>

    </div>




  </div>
  <!-- /.container -->

  <%@ include file="../footer.jsp" %>

</body>
</html>
