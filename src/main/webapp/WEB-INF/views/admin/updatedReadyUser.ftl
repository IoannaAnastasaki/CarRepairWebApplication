<#import "/spring.ftl" as spring/>

<head>
    <meta charset="UTF-8">
    <title>UpdateUser Form</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>

<body>



<div class="container">
    <form class="form-horizontal" role="form" action="/admin/updatedReadyUser/${userID}" method="POST"
          id="updatedReadyUserForm" name="updatedReadyUserForm" >
        <h2>Update User</h2>
        <div class="form-group">
        <@spring.bind "newUserForm.lastname"/>
            <label for="name" class="col-sm-3 control-label">Name</label>
            <div class="col-sm-9">
                <input type="text" name="lastname" id="name" placeholder="Last name" class="form-control">
            </div>

        </div>
        <div class="form-group">
        <@spring.bind "newUserForm.firstname"/>
            <label for="surname" class="col-sm-3 control-label">Surname</label>
            <div class="col-sm-9">
                <input type="text" name="firstname" id="surname" placeholder="First name" class="form-control">
            </div>
        </div>
        <div class="form-group">
        <@spring.bind "newUserForm.taxNumber"/>
            <label for="taxno" class="col-sm-3 control-label">Tax Number</label>
            <div class="col-sm-9">
                <input type="text" name="taxNumber" id="TaxNo" placeholder="123456789" class="form-control">
            </div>
        <#list spring.status.errorMessages as error>
            <span>${error}</span>
        </#list>
        </div>
        <div class="form-group">
        <@spring.bind "newUserForm.address"/>
            <label for="address" class="col-sm-3 control-label">Address</label>
            <div class="col-sm-9">
                <input type="text" name="address" id="Address" placeholder="Street number, Town" class="form-control">
            </div>
        </div>
        <div class="form-group">
        <@spring.bind "newUserForm.mail"/>
            <label for="email" class="col-sm-3 control-label">Email</label>
            <div class="col-sm-9">
                <input type="text" name="mail" id="email" placeholder="user@example.com" class="form-control">
            </div>
        <#list spring.status.errorMessages as error>
            <span>${error}</span>
        </#list>
        </div>
        <div class="form-group">
        <@spring.bind "newUserForm.password"/>
            <label for="password" class="col-sm-3 control-label">Password</label>
            <div class="col-sm-9">
                <input type="password" name="password" id="password" placeholder="password" class="form-control">
            </div>
        </div>
        <div class="form-group">
        <@spring.bind "newUserForm.type"/>
            <label class="control-label col-sm-3">Type of User</label>
            <div class="col-sm-6">
                <div class="row">
                    <div class="col-sm-4">
                        <input type="radio" name="type" value="ADMIN"> Admin<br>
                        <input type="radio" name="type" value="USER"> User

                    </div>
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
                <button type="submit" class="btn btn-primary btn-block">Update User</button>
            </div>
        </div>
    </form>
</div>


</body>
