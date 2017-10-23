<html>

<head>
    <title>Owner</title>
</head>

<body>

<div class="container">
    <h2> Search For a User</h2>
    <div class="row">
        <div class="col-sm-4 col-sm-offset-8">
            <form name="searchUserForm" action="/admin/findUser" method="post">
                <label> Email/Tax Number:</label><br>
                <input type="text" name="searchInput" placeholder="email or password"/>
                <input type="submit" value="Search">
            </form>
            <!-- /input-group -->
        </div>
        <!-- /.col-lg-6 -->
    </div>
    <!-- /.row -->
<#if userForm??>
  <h3>Retrieved user:</h3>
  TaxNumber: ${userForm.taxNumber} </br>
  Name: ${userForm.lastName} </br>
  Surname: ${userForm.firstName} </br>
  Address: ${userForm.address} </br>
  Email: ${userForm.email} </br>
  Password: ${userForm.password} </br>
  Type: ${userForm.type}</br>
  <button type="button" class="btn btn-xs btn-default" href="/edit/${userForm.userID}">Edit</button>
  <form action="/edit/${userForm.userID}/delete" method="post">
  <input class="btn btn-xs btn-danger" type="submit" value="Delete"/>

<#else>
    <h2> No User found </h2>
</#if>

</body>
</html>
