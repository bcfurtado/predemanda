<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta charset="UTF-8">
<title>Criar PreDemanda - Oráculo</title>
  
  <!-- header -->
  <jsp:include page="../header.jsp"/>
</head>

<body>

  <!-- nav-bar -->
  <jsp:include page="../nav-bar.jsp"/>
  
  <div class="container">

    <div class="starter-template">
      <h1>Criar Pré-Demanda</h1>
      <p class="lead">Para criação da pré-demanda informe o periodo a sua realização e escolha as disciplinas disponiveis.</p>

      <form class="form-horizontal" role="form">
        <!-- Coordenador -->
        <div class="form-group">
          <label class="col-sm-2 control-label">Coordenador</label>
          <div class="col-sm-10">
            <input class="form-control" type="text" placeholder="Coordenador" disabled>
          </div>
        </div>
        <!-- Curso -->
        <div class="form-group">
          <label class="col-sm-2 control-label">Curso</label>
          <div class="col-sm-10">
            <input class="form-control" type="text" placeholder="Curso de Exemplo" disabled>
          </div>
        </div>
        <!-- Periodo da Pré Demanda -->
        <div class="form-group">
          <label class="col-sm-2 control-label" for="data-inicio">Data Inicio</label>
          <div class="col-sm-10">
            <input type="date" class="form-control" id="data-inicio" placeholder="dd/mm/yyyy" />
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-2 control-label" for="data-fim">Data Fim</label>
          <div class="col-sm-10">
            <input type="date" class="form-control" id="exampleInputEmail1" placeholder="dd/mm/yyyy" />
          </div>
        </div>
        <!-- Disciplinas -->
        <div class="form-group">
          <label class="col-sm-2 control-label" for="data-fim">Disciplinas</label>
          <div class="col-sm-10">
            <p><input type="checkbox" value=""> Engenharia de software</p>
            <p><input type="checkbox" value=""> Engenharia de software</p>
            <p><input type="checkbox" value=""> Engenharia de software</p>
            <p><input type="checkbox" value=""> Engenharia de software</p>
          </div>
        </div>
        <div class="form-group">
          <button type="submit" class="btn btn-primary">Cadastar</button>
          <button type="reset" class="btn btn-warning">Resetar</button>
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
