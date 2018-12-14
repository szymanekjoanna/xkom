
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<mvc:annotation-driven ignoreDefaultModelOnRedirect="true" />
<html>
<head>
<jsp:include page = "header.jsp" />
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css"/>
    <meta charset="utf-8">
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
</head>

<body>
<div class="card" style="margin-top: 100px">
    <h3 class="card-header text-center font-weight-bold text-uppercase py-4">Baza Danych</h3>
    <div class="card-body">

        <div id="table" class="table-editable">
            <table class="table table-bordered table-responsive-md table-striped text-center"  id="userTable" >
                <thead>
                <tr>
                    <th class="th-sm">Id
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">Produkt
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">Cena
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">Kategoria
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">Procesor
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">Bateria
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">Waga
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="th-sm">Szerokosc
                        <i class="fa fa-sort float-right" aria-hidden="true"></i>
                    </th>
                    <th class="no-sort">.txt</th>
                    <th class="no-sort">Edit</th>
                </tr>
                </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr bgcolor="#ffffff">
                        <td>${product.id}</td>
                        <td>${product.nazwaProduktu}</td>
                        <td>${product.cena}</td>
                        <td>${product.kategoria}</td>
                        <td>${product.procesor}</td>
                        <td>${product.bateria}</td>
                        <td>${product.waga}</td>
                        <td>${product.szerokosc}</td>
                        <td><a href="/createTxtFile/${product.id}">Generuj .txt</a></td>
                        <td><a href="/createTxtFile/${product.id}">Edit</a></td>
                    </tr>
                </c:forEach>
            </tbody>
            </table>

            <a class="btn btn-danger" href="/deleteDatabase" role="button">Wyczyść bazę</a>
            <a class="btn btn-danger" href="/generateCsv" role="button">Generuj .csv</a>
            </div>
    </div>
</div>


<script type="text/javascript">
    $(document).ready(function () {
        var userTable = $('#userTable').DataTable({

            "columnDefs": [ {
            "targets": 'no-sort',
            "orderable": false,
            "width": "10%"
        } ]});
        $('.dataTables_length').addClass('bs-select');

    });

</script>
</body>

</html>

