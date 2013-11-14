<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Dashboard - Oráculo</title>
  
    <%@ include file="../header.jsp" %>
    
  </head>

  <body>

  <!-- nav-bar -->
  <%@ include file="../nav-bar.jsp" %>
    <div class="container">

      <div class="starter-template">
        <h1>Bem Vindo</h1>
        
        <c:if test="${not empty msg }">
          <div data-dismiss="alert" class="alert alert-info"><p>${msg}</p></div>
        </c:if>
        <c:if test="${not empty erro }">
          <div data-dismiss="alert" class="alert alert-danger"><p>${erro}</p></div>
        </c:if>

        <p class="lead">Pré-Demandas Abertas</p>
        
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
            <c:forEach items="${predemandasAbertas}" var="predemanda">
              <tr>
                <td>${predemanda.coordenadorNome}</td>
                <td>${predemanda.cursoNome}</td>
                <td><fmt:formatDate value="${predemanda.dataInicio}" pattern="dd/MM/yyyy"/></td>
                <td><fmt:formatDate value="${predemanda.dataFim}" pattern="dd/MM/yyyy"/></td>
                <td><fmt:formatDate value="${predemanda.dataDaCriacao}" pattern="dd/MM/yyyy"/></td>
                <c:choose>
                 <c:when test="${sessaoWeb.aluno}">
                  <td><a href="${linkTo[DashboardController].responder[predemanda.id]}">Responder</a></td>
                 </c:when>
                 <c:otherwise>
                  <td><a href="${linkTo[DashboardController].visualizar[predemanda.id]}">Visualizar</a></td>
                 </c:otherwise>
                </c:choose>
              </tr>
            </c:forEach>
          </table>
        </div>
          
        <p class="lead">Pré-Demandas Fechadas</p>
          
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
            <c:forEach items="${predemandasFechadas}" var="predemanda">
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
  
    </div><!-- /.container -->l

    <%@ include file="../footer.jsp" %>
    
  </body>
</html>
