<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
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
    function addPhoto(id) {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8081/job4j_cars/upload',
            data: JSON.stringify({
                id: id
            }),
            dataType: 'json'
        }).done()
            .fail(function (err) {
                console.log(err);
            });
    }
</script>
<body>
<form action="<%=request.getContextPath()%>/create.do" method="post">
    <div class="form-group">
        <label>Описание</label>
        <input type="text" class="form-control" name="description">
    </div>
    <div class="form-group">
        <label>Цена</label>
        <input type="number"  step="0.01" class="form-control" name="price">
    </div>
    <div class="form-group">
        <label>Бренд</label>

        <select name="brand">
            <c:forEach items="${brands}" var="item">
            <option><c:out value="${item.name}"/></option>
            </c:forEach>
        </select>

    </div>
    <div class="form-group">
        <label>Кузов</label>
        <input type="text" class="form-control" name="body">
    </div>
    <div class="form-group">
        <label>Цвет</label>
        <input type="text" class="form-control" name="color">
    </div>
    <div class="form-group">
    <input type="file">
    </div>
    <button type="submit" class="btn btn-primary">Добавить объявление</button>

</form>
</body>
</html>
