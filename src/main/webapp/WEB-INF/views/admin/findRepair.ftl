<html>
<head>
</head>
<body>
    <#include "/navbar.ftl">
<div class="container">
    <h2> Search For Repairs</h2>
    <div class="row">
        <div class="col-sm-4 col-sm-offset-8">
            <form name="searchRepairForm" action="/admin/findRepair" method="POST">
                <label> Search by User or Vehicle:</label><br>
                <input type="text" name="searchInput" placeholder="Tax or plate number"/></br>
                <label class="col-sm-3 control-label">Start Date</label>
                <div class="col-sm-9">
                    <input type="datetime-local" name="startDate" id="startDate" class="form-control">
                </div>
                <label class="col-sm-3 control-label">End Date</label>
                <div class="col-sm-9">
                    <input type="datetime-local" name="endDate" id="endDate" class="form-control">
                </div>
                <input type="submit" value="Search">
            </form>
            <!-- /input-group -->
        </div>
        <!-- /.col-lg-6 -->
    </div>
    <!-- /.row -->

<h2>${errorMessage!""}</h2>
<#if repairs??>
  <h3>Retrieved Repairs:</h3>
  <table>
     <tr>
        <th>User tax</th>
        <th>Vehicle</th>
        <th>Date</th>
        <th>Description</th>
        <th>Service Status</th>
        <th>Service Type</th>
        <th>Cost</th>
       <th>Buttons</th>
    </tr>
    <#list repairs as repair>
    <tr>

        <td>${repair.taxNumber}</td>
        <td>${repair.plateNumber}</td>
        <td>${repair.dayOfRepair}</td>
        <td>${repair.description}</td>
        <td>${repair.repairStatus}</td>
        <td>${repair.repairType}</td>
        <td>${repair.repaierCost}</td>
        <td>
        <button type="button" class="btn btn-xs btn-default" href="/updateRep/${repair.repairID}">Edit</button>
        <form action="/updateRep/${repair.repairID}}/delete" method="post">
          <input class="btn btn-xs btn-danger" type="submit" value="Delete"/>
        </form>
      </td>

    </tr>
    </#list>
</table>

</#if>

</body>

</html>