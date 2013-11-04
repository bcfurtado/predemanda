<html>
<head>
<meta charset="UTF-8">
<title>Criar PreDemanda - Oráculo</title>

<link href="<c:url value="/assets/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/assets/css/starter-template.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/assets/css/datepicker.css"/>" rel="stylesheet" type="text/css" />

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>

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
        <ul class="nav navbar-nav navbar-right">
          <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">About <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="#">Action</a></li>
              <li><a href="#">Another action</a></li>
              <li><a href="#">Something else here</a></li>
              <li class="divider"></li>
              <li><a href="#">Separated link</a></li>
            </ul></li>
        </ul>
      </div>
      <!--/.nav-collapse -->
    </div>
  </div>
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
