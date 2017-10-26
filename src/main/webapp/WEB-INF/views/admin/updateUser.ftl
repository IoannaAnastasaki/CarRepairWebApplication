
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
            <form action="/admin/updateUser/${updateForm.userId!""}" method="POST" name="updateForm" id="updateForm">

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


                <div class="form-group">
                    <label for="password">taxNumber</label>
                    <input type="text" class="form-control" name="taxNumber"  value="${updateForm.taxNumber!""}" placeholder="taxNumber">
                </div>

                <div class="col-sm-4">
                    <label for="password">Type of User</label>
                    <input type="text" class="form-control" name="type"  value="${updateForm.type!""}" placeholder="type">
                </div>

                <tr>
                    <td colspan = "2">
                        <input type = "submit" value = "Save"/>
                    </td>
                </tr>
                </table>

            </form>

            <form action="/admin/deleteUser/${updateForm.userId!""}" method="post">
                            <div class="btn-group" role="group" id="deleteUser">
                            <#--<button type="button" class="btn btn-default btn-sm"
                                    onclick="window.location.href='/admin/deleteUser/${updateForm.userId}'">Edit
                            </button>-->
                            <#--<button type="button" class="btn btn-default">Default</button>-->
                                <button type="submit" class="btn btn-danger btn-sm" name="delete" onclick="myFunction()">
                                    Delete
                                </button>


                                <p id="deleteUser"></p>

                                <script>
                                    function myFunction() {
                                        var txt;
                                        if (confirm("You are going to delete a user. Are you sure?") == true) {
                                            return $deleteUser;
                                        } else {
                                            close();
                                        }
                                    }
                                </script>
                            </div>
                        </form>


        </div>
    </div>
</div>

        </body>
        </html>
