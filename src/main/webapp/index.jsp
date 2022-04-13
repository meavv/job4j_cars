<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>TODO</title>
</head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
    $(document).ready(function() {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/cars/index',
            dataType: 'json'
        }).done()
            .fail(function (err) {
            console.log(err);
        });
    });
</script>
<body>

<div class="container">
    <a style="float: right" class="nav-link" href="<%=request.getContextPath()%>/logout.do"> <c:out value="${user.name}"/>  | Выйти</a>
    <a style="float: left" class="nav-link" href="<%=request.getContextPath()%>/login.jsp"> Войти</a>
    <a style="float: left" class="nav-link" href="<%=request.getContextPath()%>/create.jsp"> Добавить объявление </a>

    <br>
    Объявление:
    <ul id="descriptionList">
        <form>
            <table class="table" frame="vsides">
                <tr>
                    <th scope="col">Описание</th>
                    <th scope="col">Фото</th>
                    <th scope="col">Модель</th>
                    <th scope="col">Кузов</th>
                    <th scope="col">Цвет</th>
                    <th scope="col">Автор</th>
                </tr>
                <c:forEach items="${items}" var="item">
                    <tr>
                        <td>
                            <c:out value="${item.description}"/>
                        </td>
                        <td>
                            <img src="<c:url value='/download?name=${item.id}.jpg'/>" width="100px" height="100px"/>
                        </td>
                        <td>
                            <c:out value="${item.car.brand}"/>
                        </td>
                        <td>
                            <c:out value="${item.car.body}"/>
                        </td>
                        <td>
                            <c:out value="${item.car.color}"/>
                        </td>
                        <td>
                            <c:out value="${item.author.name}"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </ul>
</div>
</body>

</html>