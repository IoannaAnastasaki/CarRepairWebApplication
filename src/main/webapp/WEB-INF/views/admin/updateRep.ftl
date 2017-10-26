
<#import "/spring.ftl" as spring/>

<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-sm-8 col-sm-offset-2">
            <h1>Repair Information</h1>
            <form action="/admin/updateRep/${repairForm.repairID!""}" method="POST" name="repairForm" id="repairForm">

                <div class="form-group">
                    <label for="description">Description</label>
                    <input type="text" class="form-control" name="description"  value="${repairForm.description!""}" placeholder="description">
                </div>

                <div class="form-group">
                    <label for="repairStatus">RepairStatus</label>
                    <input type="text" class="form-control" name="repairStatus"  value="${repairForm.repairStatus!""}" placeholder="repairStatus">
                </div>

                <div class="form-group">
                    <label for="repairType">RepairType</label>
                    <input type="text" class="form-control" name="repairType"  value="${repairForm.repairType!""}" placeholder="repairType">
                </div>

                <div class="form-group">
                    <label for="plateNumber">plateNumber</label>
                    <input type="text" class="form-control" name="plateNumber"  value="${repairForm.plateNumber!""}" placeholder="plateNumber">
                </div>


                <div class="form-group">
                    <label for="dayOfRepair">Date of repair</label>
                    <input type="datetime-local" class="form-control" name="dayOfRepair"  value="${repairForm.dayOfRepair!""}" placeholder="dayOfRepair">
                </div>


                <div class="form-group">
                    <label for="serviceCost">serviceCost</label>
                    <input type="text" class="form-control" name="serviceCost"  value="${repairForm.serviceCost!""}" placeholder="serviceCost">
                </div>




                <tr>
                    <td colspan = "2">
                        <input type = "submit" value = "Save"/>
                    </td>
                </tr>
                </table>

            </form>

            <form action="/admin/deleteRepair/${repairForm.repairID!""}" method="post">
                <div class="btn-group" role="group">
                <#--<button type="button" class="btn btn-default btn-sm"
                        onclick="window.location.href='/admin/deleteUser/${updateForm.userId}'">Edit
                </button>-->
                <#--<button type="button" class="btn btn-default">Default</button>-->
                    <button type="submit" class="btn btn-danger btn-sm" name="delete">
                        Delete
                    </button>
                </div>
            </form>

</body>
</html>
