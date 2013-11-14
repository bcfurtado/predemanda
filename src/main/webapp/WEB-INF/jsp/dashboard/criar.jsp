<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta charset="UTF-8">
<title>Criar PreDemanda - Oráculo</title>
  
  <!-- header -->
  <%@ include file="../header.jsp" %>

</head>

<body>

  <!-- nav-bar -->
  <%@ include file="../nav-bar.jsp" %>
  <div class="container">

    <div class="starter-template">
      <h1>Criar Pré-Demanda</h1>
      <p class="lead">Para criação da pré-demanda informe o periodo a sua realização e escolha as disciplinas disponiveis.</p>

      <c:if test="${not empty msg }">
        <div data-dismiss="alert" class="alert alert-info"><p>${msg}</p></div>
      </c:if>
      
      <c:if test="${not empty erro }">
        <div data-dismiss="alert" class="alert alert-danger"><p>${erro}</p></div>
      </c:if>
      
      <form class="form-horizontal" role="form" action="${linkTo[DashboardController].criar}" method="post">
        <!-- Coordenador -->
        <div class="form-group">
          <label class="col-sm-2 control-label">Coordenador</label>
          <div class="col-sm-10">
            <input class="form-control" type="text" placeholder="${sessaoWeb.pessoa.nome}" disabled>
          </div>
        </div>
        <!-- Curso -->
        <div class="form-group">
          <label class="col-sm-2 control-label">Curso</label>
          <div class="col-sm-10">
            <input class="form-control" type="text" placeholder="${curso.nomeCurso}" disabled>
          </div>
        </div>
        <!-- Periodo da Pré Demanda -->
        <div class="form-group">
          <label class="col-sm-2 control-label" for="data-inicio">Data Inicio</label>
          <div class="col-sm-10">
            <input type="date" class="form-control" id="preDemanda.dataInicio" name="preDemanda.dataInicio" placeholder="dd/mm/yyyy" />
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-2 control-label" for="data-fim">Data Fim</label>
          <div class="col-sm-10">
            <input type="date" class="form-control" id="preDemanda.dataFim" name="preDemanda.dataFim" placeholder="dd/mm/yyyy" />
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
          <button type="submit" class="btn btn-primary">Cadastar</button>
        </div>
      </form>

    </div>




  </div>
  <!-- /.container -->

  <%@ include file="../footer.jsp" %>

</body>
</html>
