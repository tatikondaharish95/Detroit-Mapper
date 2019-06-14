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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
    <form class="form-inline my-2 my-lg-0">
    <div class="form-group mr-sm-2">
        <select class="form-control form-control-sm" name="field">
          <option value="name">Name</option>
          <option value="city">City</option>
          <option value="state">State</option>
          <option value="bhk"></option>
          <option value="price">Price ($|$$|$$$)</option>
        </select>
    </div>
     <input class="form-control form-control-sm mr-sm-2" type="search" name="key" size="20">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>

<div class="container">

  <h1>Detroit Mapper</h1>
  <div class="dropdown">
    <button type="button" class="btn btn-primary-outline dropdown-toggle" data-toggle="dropdown">
        Add Restaurant
    </button>
    <form class="dropdown-menu p-4" action="restaurants" method="post">
        <div class="form-row">
        <div class="form-group col-4">
          <label for="inputName">Name</label>
          <input type="text" name="name" class="form-control" id="inputName" placeholder="Name">
        </div>
        <div class="form-group col-4">
          <label for="inputEmail4">Email</label>
          <input type="email" name="email" class="form-control" id="inputEmail4" placeholder="Email">
        </div>
          <div class="form-group col-4">
            <label for="inputPhone">Phone</label>
            <input type="tel" name="phone" class="form-control" id="inputPhone" placeholder="Phone">
          </div>
        </div>
        <div class="form-group">
          <label for="inputAddress">Address</label>
          <input type="text" name="street_address" class="form-control" id="inputAddress" placeholder="1234 Main St">
        </div>
        <div class="form-row">
          <div class="form-group col-6">
            <label for="inputCity">City</label>
            <input type="text" name="city" class="form-control" id="inputCity">
          </div>
          <div class="form-group col-4">
            <label for="inputState">State</label>
            <input type="text" name="state" class="form-control" id="inputState">
          </div>
          <div class="form-group col-2">
            <label for="inputZip">Zip</label>
            <input type="text" pattern="[0-9]{5}" name="pincode" class="form-control" id="inputZip">
          </div>
        </div>
        <div class="form-row">
            <div class="form-group col-6">
                <label for="inputCuisine">Cuisine</label>
                <input type="text" name="bhk_1" class="form-control" id="inputCuisine">
            </div>
             <div class="form-group col-6">
                            <label for="inputCuisine">Cuisine</label>
                            <input type="text" name="bhk_2" class="form-control" id="inputCuisine">
            </div>
            <div class="form-group col-6">
                                        <label for="inputCuisine">Cuisine</label>
                                        <input type="text" name="bhk_3" class="form-control" id="inputCuisine">
            </div>
            <div class="form-group col-6">
                <label for="inputPriceRange">Price Range</label>
                <input type="text" name="price" class="form-control" id="inputPriceRange">
            </div>
        </div>
        <button type="submit" name="action" value="Add" class="btn btn-primary">Add</button>
      </form>
  </div>

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
          <th scope="col">bhk_1</th>
          <th scope="col">bhk_2</th>
          <th scope="col">bhk_3</th>
          <th scope="col">Price</th>
          <th scope="col">Delete?</th>
        </tr>
  </thead>
    <tbody>
    <c:forEach items="${appartments}" var="restaurant">
      <tr>
        <td><c:out value="${appartment.name}"/></td>
        <td><c:out value="${appartment.street_address}"/></td>
        <td><c:out value="${appartment.city}"/></td>
        <td><c:out value="${appartment.state}"/></td>
        <td><c:out value="${appartment.pincode}"/></td>
        <td><c:out value="${appartment.phone}"/></td>
        <td><c:out value="${appartment.email}"/></td>
        <td><c:out value="${appartment.bhk_1}"/></td>
        <td><c:out value="${appartment.bhk_2}"/></td>
        <td><c:out value="${appartment.bhk_3}"/></td>
        <td><c:out value="${appartment.price}"/></td>
        <td><a href="?action=Remove&id=${appartment.id}">
                <span class="oi oi-trash" title="trash icon" aria-hidden="true"></span>
            </a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <c:if test="${count > 0}">
    <c:if test="${page > 1}">
      <a href="<c:url value="appartments"><c:param name="page" value="${page - 1}"/><c:param name="field" value="${field}"/><c:param name="key" value="${key}"/></c:url>">&lt; Prev</a>&nbsp;
    </c:if>
    Showing records ${start} to ${end} of ${count}
    <c:if test="${page < pageCount}">
      &nbsp;<a href="<c:url value="appartments"><c:param name="page" value="${page + 1}"/><c:param name="field" value="${field}"/><c:param name="key"
                                                                                                                                        value="${key}"/></c:url>">Next &gt;</a>
    </c:if>
  </c:if>
</div>
<!-- /container -->
<script src="../assets/js/popper.1.14.7.js"></script>
<script src="../assets/js/jQuery.3.4.1.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
</body>
</html>
