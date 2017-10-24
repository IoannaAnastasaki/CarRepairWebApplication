
<#import "/spring.ftl" as spring/>

<html>
<head>
<title>Spring MVC Form Handling</title>
</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-sm-8 col-sm-offset-2">
            <h1>User Information</h1>
            <form action="/admin/updateUser/${updateForm.userID!""}" method="POST" name="updateForm" id="updateForm">

                <div class="form-group">
                    <label for="firstname">FirstName</label>
                    <input type="text" class="form-control" name="firstname"  value="${updateForm.firstname!""}" placeholder="firstname">
                </div>

                <div class="form-group">
                    <label for="lastname">LastName</label>
                    <input type="text" class="form-control" name="lastname"  value="${updateForm.lastname!""}" placeholder="lastname">
                </div>

                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" name="address"  value="${updateForm.address!""}" placeholder="address">
                </div>

                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" class="form-control" name="mail"  value="${updateForm.mail!""}" placeholder="mail">
                </div>

                <div class="form-group">
                    <label for="password">Userpassword</label>
                    <input type="text" class="form-control" name="password"  value="${updateForm.password!""}" placeholder="password">
                </div>


                <div class="col-sm-4">
                    <input type="radio" name="type" value="${updateForm.type!""}"> Admin<br>
                    <input type="radio" name="type" value="${updateForm.type!""}"> User

                </div>



                <tr>
                    <td colspan = "2">
                        <input type = "submit" value = "Submit"/>
                    </td>
                </tr>
                </table>

            </form>

        </body>
        </html>





<#--</form:form>-->




































<#--<#import "/spring.ftl" as spring/>-->

<#--<head>-->
    <#--<meta charset="UTF-8">-->
    <#--<title>UpdateUser Form</title>-->
    <#--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>-->
<#--</head>-->

<#--<body>-->



<#--<div class="container">-->
    <#--<form class="form-horizontal" role="form" action="/admin/updateUser/${userID}" method="POST"-->
    <#--id="updateForm" name="updateForm" >-->
        <#--<h2>Update User</h2>-->
        <#--<div class="form-group">-->
        <#--<@spring.bind "updateForm.lastname"/>-->
            <#--<label for="name" class="col-sm-3 control-label">Name</label>-->
            <#--<div class="col-sm-9">-->
                <#--<input type="text" name="lastname" id="name" placeholder="Last name" class="form-control">-->
            <#--</div>-->

        <#--</div>-->
        <#--<div class="form-group">-->
        <#--<@spring.bind "updateForm.firstname"/>-->
            <#--<label for="surname" class="col-sm-3 control-label">Surname</label>-->
            <#--<div class="col-sm-9">-->
                <#--<input type="text" name="firstname" id="surname" placeholder="First name" class="form-control">-->
            <#--</div>-->
        <#--</div>-->
        <#--<div class="form-group">-->
        <#--<@spring.bind "updateForm.taxNumber"/>-->
            <#--<label for="taxno" class="col-sm-3 control-label">Tax Number</label>-->
            <#--<div class="col-sm-9">-->
                <#--<input type="text" name="taxNumber" id="TaxNo" placeholder="123456789" class="form-control">-->
            <#--</div>-->
        <#--<#list spring.status.errorMessages as error>-->
            <#--<span>${error}</span>-->
        <#--</#list>-->
        <#--</div>-->
        <#--<div class="form-group">-->
        <#--<@spring.bind "updateForm.address"/>-->
            <#--<label for="address" class="col-sm-3 control-label">Address</label>-->
            <#--<div class="col-sm-9">-->
                <#--<input type="text" name="address" id="Address" placeholder="Street number, Town" class="form-control">-->
            <#--</div>-->
        <#--</div>-->
        <#--<div class="form-group">-->
        <#--<@spring.bind "updateForm.mail"/>-->
            <#--<label for="email" class="col-sm-3 control-label">Email</label>-->
            <#--<div class="col-sm-9">-->
                <#--<input type="text" name="mail" id="email" placeholder="user@example.com" class="form-control">-->
            <#--</div>-->
        <#--<#list spring.status.errorMessages as error>-->
            <#--<span>${error}</span>-->
        <#--</#list>-->
        <#--</div>-->
        <#--<div class="form-group">-->
        <#--<@spring.bind "updateForm.password"/>-->
            <#--<label for="password" class="col-sm-3 control-label">Password</label>-->
            <#--<div class="col-sm-9">-->
                <#--<input type="password" name="password" id="password" placeholder="password" class="form-control">-->
            <#--</div>-->
        <#--</div>-->
        <#--<div class="form-group">-->
        <#--<@spring.bind "updateForm.type"/>-->
            <#--<label class="control-label col-sm-3">Type of User</label>-->
            <#--<div class="col-sm-6">-->
                <#--<div class="row">-->
                    <#--<div class="col-sm-4">-->
                        <#--<input type="radio" name="type" value="ADMIN"> Admin<br>-->
                        <#--<input type="radio" name="type" value="USER"> User-->

                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->

        <#--<div class="form-group">-->
            <#--<div class="col-sm-9 col-sm-offset-3">-->
                <#--<button type="submit" class="btn btn-primary btn-block">Update User</button>-->
            <#--</div>-->
        <#--</div>-->
    <#--</form>-->
<#--</div>-->


<#--</body>-->
