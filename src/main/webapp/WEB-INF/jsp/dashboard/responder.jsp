<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta charset="UTF-8">
<title>Responder PreDemanda - Oráculo</title>
  
  <!-- header -->
  <%@ include file="../header.jsp" %>

</head>

<body>

  <!-- nav-bar -->
  <%@ include file="../nav-bar.jsp" %>
  <div class="container">

    <div class="starter-template">
      <h1>Responder Pré-Demanda</h1>
      <p class="lead">Escolha as disciplinas disponiveis.</p>

      <c:if test="${not empty msg }">
        <div data-dismiss="alert" class="alert alert-info"><p>${msg}</p></div>
      </c:if>
      
      <c:if test="${not empty erro }">
        <div data-dismiss="alert" class="alert alert-danger"><p>${erro}</p></div>
      </c:if>
      
      <form class="form-horizontal" role="form" action="${linkTo[DashboardController].salvarResposta}" method="post">
        <input type="hidden" id="resposta.preDemanda.id" name="resposta.preDemanda.id" value="${predemanda.id}">
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
            <input type="date" class="form-control" value="${predemanda.dataInicio}" disabled />
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-2 control-label" for="data-fim">Data Fim</label>
          <div class="col-sm-10">
            <input type="date" class="form-control" value="${predemanda.dataFim}" disabled/>
          </div>
        </div>
        <!-- Disciplinas -->
        <div class="form-group">
          <label class="col-sm-2 control-label" for="disciplinas">Disciplinas</label>
          <div class="col-sm-10">
          <table class="table table-hover">
            <tr>
              <th>#</th>
              <th>Codigo</th>
              <th>Nome</th>
            </tr>
            <c:forEach items="${disciplinas}" var="disciplina">
            <tr>
              <td><input type="checkbox" name="disciplinas[]" value="${disciplina.id}"></td>
              <td>${disciplina.codigo}</td>
              <td>${disciplina.nome}</td>
            </tr>
            </c:forEach>
            </table>
          </div>
        </div>

        <script type="text/javascript" >
        	function selectAll(val) {
        		$(':checkbox').each(function() {
                    this.checked = val;                        
        	    });
			}
        </script>
        
        <div class="form-group">
          <button type="button" class="btn btn-default" onclick="selectAll(true)">Selecionar Todos</button>
          <button type="button" class="btn btn-default" onclick="selectAll(false)">Deselecionar Todos</button>
        </div>
        <div class="form-group">
          <button type="submit" class="btn btn-primary">Responder</button>
        </div>
      </form>

    </div>




  </div>
  <!-- /.container -->

  <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
  <script src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
  <script src="<c:url value="/assets/js/bootstrap-datepicker.js"/>"></script>

</body>
</html>
