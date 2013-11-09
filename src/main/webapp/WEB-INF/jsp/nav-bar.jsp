  <div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand">Or�culo</a>
      </div>
      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
          <li class="active"><a href="${linkTo[DashboardController].index}">Inicio</a></li>
          <li><a href="${linkTo[DashboardController].criar}">Criar Pr�-Demanda</a></li>
          <li><a href="${linkTo[DashboardController].listar}">Listar Pr�-Demanda</a></li>
        </ul>
        <c:if test="${sessaoWeb.logado}">
        <ul class="nav navbar-nav navbar-right">
          <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">${sessaoWeb.pessoa.nome} <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="#">Action</a></li>
              <li class="divider"></li>
              <li><a href="${linkTo[IndexController].logout}">Sair</a></li>
            </ul></li>
        </ul>
        </c:if>
      </div>
    </div>
  </div>
