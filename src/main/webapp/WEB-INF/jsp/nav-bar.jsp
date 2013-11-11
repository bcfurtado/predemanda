  <div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand">Oráculo</a>
      </div>
      <div class="collapse navbar-collapse">
        <c:if test="${sessaoWeb.logado}">
        <ul class="nav navbar-nav">
          <li class="active"><a href="${linkTo[DashboardController].index}">Inicio</a></li>
          <c:if test="${sessaoWeb.coordenador}">
            <li><a href="${linkTo[DashboardController].criar}">Criar Pré-Demanda</a></li>
            <li><a href="${linkTo[DashboardController].listar}">Listar Pré-Demanda</a></li>
          </c:if>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">${sessaoWeb.pessoa.nome} <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="${linkTo[IndexController].logout}">Sair</a></li>
            </ul></li>
        </ul>
        </c:if>
      </div>
    </div>
  </div>
