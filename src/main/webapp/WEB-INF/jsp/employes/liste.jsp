<%@ page import="org.springframework.data.domain.Page" %>
<%@ page import="com.ipiecoles.java.java330.model.Employe" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file ="../tags/header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1>Liste des employés</h1>
            <div class="btn-group">
                <a href="#" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    Nouvel employé
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="/employes/new/technicien">Technicien</a></li>
                    <li><a href="/employes/new/commercial">Commercial</a></li>
                    <li><a href="/employes/new/manager">Manager</a></li>
                </ul>
            </div>
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th scope="col">
                        Matricule <a href=""><span class="glyphicon glyphicon-chevron-up"></span></a>
                    </th>
                    <th scope="col">
                        Nom <a href=""><span class="glyphicon glyphicon-chevron-down"></span></a>
                    </th>
                    <th scope="col">
                        <a href="">Prénom</a>
                    </th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="empl" items="${listePagination}">
                        <tr>
                            <th scope="row">${empl.matricule}</th>
                            <td>${empl.nom}</td>
                            <td>${empl.prenom}</td>
                            <td><a href="/employes/${empl.id}">Détails</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="row">
                <div class="col-lg-6">
                    <p>
                        Affichage des employés ${start} à ${end} sur un total de ${total}</p>
                </div>
                <div class="col-lg-6">
                    <ul class="pagination">
                        <c:choose>
                            <c:when test="${!hasPrevious}">
                                <li>
                                    <a href ="">&laquo;</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="/employes?page=${previousPage}&size=${sizeActuel}&sortProperty=${sortPropertyActuel}&sortDirection=${sortDirectionActuel}"}>
                                        &laquo;
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                        <li><a href="#">Page ${pageActuel}</a></li>
                        <c:choose>
                            <c:when test="${!hasNext}">
                                <li>
                                    <a href="">&raquo;</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="/employes?page=${nextPage}&size=${sizeActuel}&sortProperty=${sortPropertyActuel}&sortDirection=${sortDirectionActuel}">
                                        &raquo;
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file ="../tags/footer.jsp" %>
