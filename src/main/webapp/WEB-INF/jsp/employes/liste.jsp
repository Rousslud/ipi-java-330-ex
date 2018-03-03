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
                    <tr>
                        <th scope="row">Matricule</th>
                        <td>Nom</td>
                        <td>Prénom</td>
                        <td><a href="">Détail</a></td>
                    </tr>
                </tbody>
            </table>
            <div class="row">
                <div class="col-lg-6">
                    <p>
                        Affichage des employés X à Y sur un total de Z</p>
                </div>
                <div class="col-lg-6">
                    <ul class="pagination">
                        <li class= "disabled">&laquo;</li>
                        <li><a href="#">Page X</a></li>
                        <li><a href="">&raquo;</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file ="../tags/footer.jsp" %>
