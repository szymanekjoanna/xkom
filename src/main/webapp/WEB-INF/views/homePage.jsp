<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<mvc:annotation-driven ignoreDefaultModelOnRedirect="true" />
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>X-com ETL</title>
    <link href="<c:url value='/static/error.css'/>"  rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>


<body>
    <div align="center">

        <c:url var="url" value="/homePage" />

        <form method="post">
            Co chcesz znaleźć na stronie https://www.x-kom.pl/?
            <input type="text" name="itemToSearch">
            <br><br>
            <input type="submit" value="Extract"   formaction="/extract"  />    <br><br>
            <input type="submit" value="Transform" formaction="/transform"/> <br><br>
            <input type="submit" value="Load"      formaction="/load"/>      <br><br>
            <input type="submit" value="ETL"       formaction="/etl"/>       <br><br>  <br><br>


            <c:if test="${param.response == 'notfound'}">
                <div class="alert alert-danger">
                    <p>Nie znaleziono przedmiotu</p>
                </div>
            </c:if>
            <c:if test="${param.response == 'extractNotFinished'}">
                <div class="alert alert-danger">
                    <p>Extract nie został wykonany</p>
                </div>
            </c:if>
            <c:if test="${param.response == 'loadNotFinished'}">
                <div class="alert alert-danger">
                    <p>Transform nie został wykonany</p>
                </div>
            </c:if>
            <c:if test="${param.response == 'itemToSearchNull'}">
                <div class="alert alert-success">
                    <p>Podaj przedmiot do wyszukania</p>
                </div>
            </c:if>

            <%--<c:if test="${param.flag == 'true'}">--%>
                <%--<div class="alert alert-success">--%>
                    <%--<p>${param.response}</p>   <br><br>--%>
                    <%--Co chcesz teraz zrobić? Wybierz odpowiedni przycisk :)--%>
                <%--</div>--%>
            <%--</c:if>--%>


        </form>

        <br><br>
    </div>

    <div align="center">

    </div>

    <div align="center">
        <%--<form action="/showDatabase">      <input type="submit" value="Baza danych"/>      </form>  <br><br>--%>
        <button onclick="window.location.href='/database'">Baza danych</button> <br><br>

    </div>

</body>
</html>
