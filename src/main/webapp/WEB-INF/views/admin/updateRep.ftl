
<#import "/spring.ftl" as spring/>

<html>
<head>
   <title>Edit Page</title>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
       <link rel="stylesheet" type="text/css" href="/style.css">
       <link rel="stylesheet" type="text/css" href="/style.css">
</head>

<body>
<#include "/navbar.ftl">
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

           <form action="/admin/deleteRep/${repairForm.repairID!""}" method="post">
                           <div class="btn-group" role="group" id="deleteRepair">

                               <button type="submit" class="btn btn-danger btn-sm" name="delete" onclick="myFunction()">
                                   Delete
                               </button>


                               <p id="deleteRepair"></p>

                               <script>
                                   function myFunction() {
                                       var txt;
                                       if (confirm("You are going to delete a service. Are you sure?") == true) {
                                           return $deleteRepair;
                                       } else {
                                           close();
                                       }
                                   }
                               </script>
                           </div>
                       </form>




</body>
</html>
