<html>

<head>
    <title>Search User</title>
    <link rel="stylesheet" type="text/css" href="/style.css">
</head>

<body>
<#include "/navbar.ftl">


    <div class="container">
       <form name="searchUserForm" action="/admin/findUser" method="post">
         <label> <h2> Search For a User</h2></label>
         <input type="text" name="searchInput" placeholder="search with email/taxNo" class="form-control input-lg"/>
         <input type="submit" value="Search" class="btn btn-info btn-lg" type="button">
       </form>
    </div>
<h2>${errorMessage!""}</h2>
<#if userForm??>

<div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
    <table class="table table-striped custab">
    <thead>
    <a href="#" class="btn btn-primary btn-xs pull-right"><b>+</b> Add new categories</a>
        <tr>
            <th>Tax Number</th>
            <th>Name</th>
            <th>Sirname</th>
            <th>Address</th>
            <th>Email</th>
            <th>Password</th>
            <th>Type</th>
            <th class="text-center">Action</th>
        </tr>
    </thead>
        <tr>
            <td>${userForm.taxNumber}</td>
            <td>${userForm.lastName}</td>
            <td>${userForm.firstName}</td>
            <td>${userForm.address}</td>
            <td>${userForm.email}</td>
            <td>${userForm.password}</td>
            <td>${userForm.type}</td>
            <td class="text-center">
                <a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a>
                <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a>
            </td>
        </tr>
    </table>
    </div>
</div>

</#if>

<!--
<h2>${errorMessage!""}</h2>
<#if userForm??>

<div class="btn-toolbar">
    <button class="btn btn-primary" type="button" class="btn btn-xs btn-default" href="/updateUser/${userForm.userID}">Edit</button>
    <form action="/updateUser/${userForm.userID}}/delete" method="post">
          <input class="btn btn-xs btn-danger" type="submit" value="Delete"/>
      </form>

</div>

<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>Tax Number</th>
          <th>Name</th>
          <th>Sirname</th>
          <th>Address</th>
          <th>Email</th>
          <th>Password</th>
          <th>Type</th>
          <th style="width: 80px;"></th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>${userForm.taxNumber}</td>
          <td>${userForm.lastName}</td>
          <td>${userForm.firstName}</td>
          <td>${userForm.address}</td>
          <td>${userForm.email}</td>
          <td>${userForm.password}</td>
          <td>${userForm.type}</td>
          <td>
              <a href="user.html"><i class="icon-pencil"></i></a>

          </td>
          <td><a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a></td>
        </tr>

      </tbody>
    </table>
</div>
<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Delete Confirmation</h3>
    </div>
    <div class="modal-body">
        <p class="error-text">Are you sure you want to delete the user?</p>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
        <button class="btn btn-danger" data-dismiss="modal">Delete</button>
    </div>
</div>


</#if>

<h2>${errorMessage!""}</h2>
<#if userForm??>
  <h3>Retrieved user:</h3>
  TaxNumber: ${userForm.taxNumber} </br>
  Name:      ${userForm.lastName} </br>
  Surname:   ${userForm.firstName} </br>
  Address:   ${userForm.address} </br>
  Email:     ${userForm.email} </br>
  Password:  ${userForm.password} </br>
  Type:      ${userForm.type}</br>
  </br>
  <button type="button" class="btn btn-xs btn-default" href="/updateUser/${userForm.userID}">Edit</button>
  <form action="/updateUser/${userForm.userID}}/delete" method="post">
      <input class="btn btn-xs btn-danger" type="submit" value="Delete"/>
  </form>

</#if>
-->
</body>
</html>
