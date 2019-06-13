<%--
    Licensed to the Apache Software Foundation (ASF) under one or more
    contributor license agreements.  See the NOTICE file distributed with
    this work for additional information regarding copyright ownership.
    The ASF licenses this file to You under the Apache License, Version 2.0
    (the "License"); you may not use this file except in compliance with
    the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="language" value="${pageContext.request.locale}"/>
<fmt:setLocale value="${language}"/>

<!DOCTYPE html>
<html lang="${language}">
<head>
  <meta charset="utf-8">
  <title>Moviefun</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Le styles -->
  <link href="../assets/css/bootstrap.min.css" rel="stylesheet">
  <link href="../assets/css/open-iconic/font/css/open-iconic-bootstrap.css" rel="stylesheet">

</head>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
    <a class="navbar-brand" href="/">Detroit Mapper</a>
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/restaurants">Restaurants</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/setup">Setup</a>
    </li>
    </ul>
  </div>
</nav>

<div class="container">

  <h1>Detroit Mapper</h1>

  <h2>Seeded Database with the Following Restaurants</h2>
  <table class="table table-striped table-bordered">
    <thead>
        <tr>
          <th scope="col">Name</th>
          <th scope="col">Street Address</th>
          <th scope="col">City</th>
          <th scope="col">State</th>
          <th scope="col">Zipcode</th>
          <th scope="col">Phone #</th>
          <th scope="col">Email</th>
          <th scope="col">Cuisine</th>
          <th scope="col">Price Range</th>
        </tr>
  </thead>
    <c:forEach items="${requestScope.restaurants}" var="restaurant">
      <tr>
        <td><c:out value="${restaurant.name}"/></td>
        <td><c:out value="${restaurant.street_address}"/></td>
        <td><c:out value="${restaurant.city}"/></td>
        <td><c:out value="${restaurant.state}"/></td>
        <td><c:out value="${restaurant.pincode}"/></td>
        <td><c:out value="${restaurant.phone}"/></td>
        <td><c:out value="${restaurant.email}"/></td>
        <td><c:out value="${restaurant.cuisine}"/></td>
        <td><c:out value="${restaurant.price_range}"/></td>
      </tr>
    </c:forEach>
  </table>

    <h2>Seeded Database with the Following Apartments</h2>
    <table class="table table-striped table-bordered">
        <tr>
            <td><b>Title</b></td>
            <td><b>Artist</b></td>
            <td><b>Year</b></td>
        </tr>

        <c:forEach items="${requestScope.albums}" var="album">
            <tr>
                <td> ${album.title} </td>
                <td> ${album.artist} </td>
                <td> ${album.year} </td>
            </tr>
        </c:forEach>
    </table>


    <h2>Continue</h2>
  <a href="restaurants">Go to main app</a>
</div>
<!-- /container -->
<script src="../assets/js/popper.1.14.7.js"></script>
<script src="../assets/js/jQuery.3.4.1.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
</body>
</html>
