<html>

<head>
    <title>User</title>
</head>

<body>
<#include "/navbar.ftl">

<div class="container">
    <h2> Search For a User</h2>
    <div class="row">
        <div class="col-sm-4 col-sm-offset-8">
            <form name="searchUserForm" action="/admin/findUser" method="post">
                <label> Email/Tax Number:</label><br>
                <input type="text" name="searchInput" placeholder="email or tax number"/>
                <input type="submit" value="Search">
            </form>
            <!-- /input-group -->
        </div>
        <!-- /.col-lg-6 -->
    </div>
    <!-- /.row -->

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

</body>
</html>
