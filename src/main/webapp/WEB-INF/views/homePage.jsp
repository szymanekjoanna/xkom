<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>

<body class="text-center" >
<jsp:include page = "header.jsp" />

<div class="container" style="margin-top: 100px">
	<div class="row justify-content-center" style="margin-bottom: 50px">
                        <div class="col-12 col-md-10 col-lg-8">
                        	<p>Wyszukaj produkty na stronie x-kom.pl:</p>
                            <form class="card card-sm">
                                <div class="card-body row no-gutters align-items-center">
                                    <div class="col-auto">
                                        <i class="fas fa-search h4 text-body"></i>
                                    </div>
                                    <!--end of col-->
                                    <div class="col">
                                        <input class="form-control form-control-lg form-control-borderless" type="search" id="itemToSearch" name="itemToSearch" placeholder="Nazwa produktu">
                                    </div>
                                    <!--end of col-->
                                    <div class="col-auto" style="margin-left: 20px">
                                        <button class="btn btn-lg btn-primary" type="submit" id="triggerETL" name="triggerETL">ETL</button>
                                    </div>
                                    <!--end of col-->
                                </div>
                            </form>
                        </div>
                        <!--end of col-->
    </div>
</div>

<form>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                    <p>Wykonaj osobne akcje:</p>
                    <button type="button" style="margin-bottom: 50px"class="btn btn-warning" id="triggerExtract" name="triggerExtract">Extract</button>
                    <button type="button" style="margin-left: 10px; margin-bottom: 50px" class="btn btn-info" id="triggerTransform" name="triggerTransform">Transform</button>
                    <button type="button" style="margin-left: 10px; margin-bottom: 50px" class="btn btn-success" id="triggerLoad" name="triggerLoad">Load</button>
            </div>
        <div class="col-md-4"></div>
        </div>
</form>


<script>
    $(function(){
        $('#triggerETL').on('click', function(event) {
            event.preventDefault();
            event.stopPropagation();
            console.log("Hello from front");
            var itemToSearch = $('input[name=itemToSearch]').val();
            console.log(itemToSearch);

            $.ajax({
                url: "/etl",
                type: "post",
                data: {itemToSearch}
            }).done(function(data){
                console.log(data)
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
                console.log(xhr);
                console.log(status);
                console.log("________________________");
                console.log(error);
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
    });

    $(function(){
        $('#triggerExtract').on('click', function(event) {
            event.preventDefault();
            event.stopPropagation();
            console.log("Hello from front");
            var itemToSearch = $('input[name=itemToSearch]').val();
            console.log(itemToSearch);

            $.ajax({
                url: "/extract",
                type: "post",
                data: {itemToSearch}
            }).done(function(data){
                console.log(data)
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
    });

    $(function(){
        $('#triggerTransform').on('click', function(event) {
            event.preventDefault();
            event.stopPropagation();
            console.log("Hello from front");
            //var itemToSearch = $('input[name=itemToSearch]').val();
            //console.log(itemToSearch);

            $.ajax({
                url: "/transform",
                type: "post",
                //data: {itemToSearch}
            }).done(function(data){
                console.log(data)
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
                console.log(xhr);
                console.log(status);
                console.log("________________________");
                console.log(error);
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
    });

    $(function(){
        $('#triggerLoad').on('click', function(event) {
            event.preventDefault();
            event.stopPropagation();
            console.log("Hello from front");
            //var itemToSearch = $('input[name=itemToSearch]').val();
            //console.log(itemToSearch);

            $.ajax({
                url: "/load",
                type: "post",
                //data: {itemToSearch}
            }).done(function(data){
                console.log(data)
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
                console.log(xhr);
                console.log(status);
                console.log("________________________");
                console.log(error);
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
    });

</script>

<script src="/static/bootstrap-notify.js"></script>

</body>
</html>