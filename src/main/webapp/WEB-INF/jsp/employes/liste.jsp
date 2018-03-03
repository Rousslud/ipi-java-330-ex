<%@ page contentType="text/html;charset=UTF-8" %>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1>Liste des employÃ©s</h1>
            <div class="btn-group">
                <a href="#" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    Nouvel employÃ©
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
                        <a href="">PrÃ©nom</a>
                    </th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">Matricule</th>
                        <td>Nom</td>
                        <td>PrÃ©nom</td>
                        <td><a href="">DÃ©tail</a></td>
                    </tr>
                </tbody>
            </table>
            <div class="row">
                <div class="col-lg-6">
                    <p>
                        Affichage des employÃ©s X Ã  Y sur un total de Z</p>
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
