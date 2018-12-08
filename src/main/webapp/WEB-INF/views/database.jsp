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
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Database</title>
    <link href="<c:url value='/static/error.css'/>"  rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>

<body>

    <div>
        <button onclick="window.location.href='/homePage'">Powrót</button> <br><br>
        <form action="/deleteDatabase">      <input type="submit" value="Wyczyść bazę"/>  </form>  <br>
        <form action="/generateCsv">     <input type="submit" value="Generuj .csv"/>  </form>  <br><br>
    </div>

    <div align="center">
        <table border="1">
            <thead>
                <th>L.p</th>
                <th>Produkt</th>
                <th>Cena</th>
                <th>Kategoria</th>
                <th>Procesor</th>
                <th>Bateria</th>
                <th>Waga</th>
                <th>Szerokosc</th>
                <th></th>
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
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <form action="/updateProduct" method="post" enctype="application/x-www-form-urlencoded">
                    <td><input type="text" name="id"></td>
                    <td><input type="text" name="nazwaProduktu"></td>
                    <td><input type="text" name="cena"></td>
                    <td><input type="text" name="kategoria"></td>
                    <td><input type="text" name="procesor"></td>
                    <td><input type="text" name="bateria"></td>
                    <td><input type="text" name="waga"></td>
                    <td><input type="text" name="szerokosc"></td>
                    <td><input type="submit" value="update"></td>
                </form>
            </tfoot>
        </table>
    </div>



</body>

</html>

