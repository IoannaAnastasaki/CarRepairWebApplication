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
             <a class='btn btn-info btn-xs' href="/admin/updateUser/${userForm.userID}"><span class="glyphicon glyphicon-edit"></span> Edit</a>
            </td>
        </tr>
    </table>
    </div>
</div>

</#if>
</body>
</html>
