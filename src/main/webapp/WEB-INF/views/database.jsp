<%--
  Created by IntelliJ IDEA.
  User: szyma
  Date: 25.11.2018
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<mvc:annotation-driven ignoreDefaultModelOnRedirect="true" />
<html>
<head>
<jsp:include page = "header.jsp" />
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css"/>

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
                        <td>
                            <button class="btn btn-primary btn-sm" id="generateTXT">.txt</a>
                        </td>
                        <td>
                            <button class="btn btn-info btn-sm" id="viewProduct">Edit</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            </table>
            <a class="btn btn-danger" href="/deleteDatabase" role="button">Wyczyść bazę</a>
            <a class="btn btn-danger" href="/generateCsv" role="button">Generuj .csv</a>
            </div>
    </div>
</div>

<div class="modal fade" id="laptopModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Edytuj rekord</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal body -->
            <form method="POST" id="editProductForm" name="editProductForm" >
                <div class="col-md" style="display: inline-block; width: 100%">
                    <br>
                    <div class="form-group">
                        <label>ID:</label>
                        <input type="text" class="form-control" id="id" name="id" readonly placeholder="ID">
                    </div>
                    <div class="form-group">
                        <label>Nazwa produktu:</label>
                        <input type="text" class="form-control" id="nazwaProduktu" name="nazwaProduktu" placeholder="Nazwa produktu">
                    </div>
                    <div class="form-group">
                        <label>Cena:</label>
                        <input type="text" class="form-control" id="cena" name="cena" placeholder="Cena">
                    </div>
                    <div class="form-group">
                        <label>Kategoria:</label>
                        <input type="text" class="form-control" id="kategoria" name="kategoria" placeholder="Kategoria">
                    </div>
                    <div class="form-group">
                        <label>Procesor:</label>
                        <input type="text" class="form-control" id="procesor" name="procesor" placeholder="Procesor">
                    </div>
                    <div class="form-group">
                        <label>Bateria:</label>
                        <input type="text" class="form-control" id="bateria" name="bateria" placeholder="Bateria">
                    </div>
                    <div class="form-group">
                        <label>Waga:</label>
                        <input type="text" class="form-control" id="waga" name="waga" placeholder="Waga">
                    </div>
                    <div class="form-group">
                        <label>Szerokosc:</label>
                        <input type="text" class="form-control" id="szerokosc" name="szerokosc" placeholder="Szerokosc">
                    </div>
                    <br>
                </div>
                <!-- Modal footer -->
                <div class="modal-footer">
                    <div>
                        <button class="btn btn-primary" data-toggle="modal" id="saveRow" name="saveRow">Save</button>
                    </div>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </form>
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

        $('#userTable tbody').on('click', '.btn-info', function () {

            //console.log(this);
            var row = userTable.row( $(this).parents('tr') );

            //var username = row.data()[2];
            //console.log(username);
            //console.log( row.data()[2] );

            $("#id").val(row.data()[0]);
            $("#nazwaProduktu").val(row.data()[1]);
            $("#cena").val(row.data()[2]);
            $("#kategoria").val(row.data()[3]);
            $("#procesor").val(row.data()[4]);
            $("#bateria").val(row.data()[5]);
            $("#waga").val(row.data()[6]);
            $("#szerokosc").val(row.data()[7]);

            $('#laptopModal').modal('show');

            console.log(row.data());
        });

        $(function(){
            $('#editProductForm').submit( function(event) {
                event.preventDefault();
                event.stopPropagation();
                var Product = {
                    'id': $('input[name=id]').val(),
                    'nazwaProduktu': $('input[name=nazwaProduktu]').val(),
                    'cena': $('input[name=cena]').val(),
                    'kategoria': $('input[name=kategoria]').val(),
                    'procesor': $('input[name=procesor]').val(),
                    'bateria': $('input[name=bateria]').val(),
                    'waga': $('input[name=waga]').val(),
                    'szerokosc': $('input[name=szerokosc]').val()
                };
                console.log("Hello from front");
                console.log(Product);

                $.ajax({
                    url: "/updateProduct",
                    type: "post",
                    data: {'id' : Product['id'],
                           'nazwaProduktu' : Product['nazwaProduktu'],
                           'cena' : Product['cena'],
                           'kategoria' : Product['kategoria'],
                           'procesor' : Product['procesor'],
                           'bateria' : Product['bateria'],
                           'waga' : Product['waga'],
                           'szerokosc' : Product['szerokosc'],
                          }
                }).done(function(data){
                    console.log(data);
                    document.getElementById("editProductForm").reset();

                    $('#laptopModal').modal('hide');
                    location.reload();
                    $.notify({
                        message: data
                    },{
                        placement: {
                            from: 'bottom',
                            align: 'right'
                        },
                        type: 'success'
                    });
                }).fail(function(data){

                    $.notify({
                        message: data
                    },{
                        placement: {
                            from: 'bottom',
                            align: 'right'
                        },
                        type: 'danger'
                    })
                })
            })
        })

            $('#userTable tbody').on('click', '.btn-primary', function () {

                //console.log(this);
                var row = userTable.row( $(this).parents('tr') );

                //var username = row.data()[0];

                var url = "/createTxtFile/" + row.data()[0].toString();

                $.ajax({
                    url: url,
                    type: "get"
                }).done(function(data){
                    console.log(data);


                    $.notify({
                        message: data
                    },{
                        placement: {
                            from: 'bottom',
                            align: 'right'
                        },
                        type: 'success'
                    });
                }).fail(function(data){
                    console.log(data);
                    $.notify({
                        message: data
                    },{
                        placement: {
                            from: 'bottom',
                            align: 'right'
                        },
                        type: 'danger'
                    })
                })
            });

    });





</script>
<script src="/static/bootstrap-notify.js"></script>
</body>

</html>

