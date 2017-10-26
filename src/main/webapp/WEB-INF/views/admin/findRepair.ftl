<html>
<head>
    <title>Search Repair</title>
    <link rel="stylesheet" type="text/css" href="/style.css">

<body>
    <#include "/navbar.ftl">
    <h1> Search For Repairs</h1>
    <div class="container">
        <form name="searchRepairForm" action="/admin/findRepair" method="POST">
             <label><h2>Search by User or Vehicle</h2></label>
             <input type="text" name="searchInput" placeholder="Enter TaxNo/Plate number" class="form-control input-lg"/>

             <label><h2>OR Search by Time Interval</h2></label></br>
             <label><h3>Start Date:</h3></label>
             <div class="input-group registration-date-time">
                <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></span>
             <input class="form-control" name="startDate" id="startDate" type="datetime-local">
             </div>
             <label><h3>End Date:</h3></label>
             <div class="input-group registration-date-time">
               	<span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></span>
                <input class="form-control" name="endDate" id="endDate" type="datetime-local">
             </div>
             <input type="submit" value="Search" class="btn btn-info btn-lg" type="button">
        </form>
    </div>



<h2>${errorMessage!""}</h2>
<#if repairs??>

  <div class="row col-md-6 col-md-offset-2 custyle">
      <label><h3>Retrieved Repairs:</h3></label>
      <table class="table table-striped custab">
     <tr>
        <th>User tax</th>
        <th>Vehicle</th>
        <th>Date</th>
        <th>Description</th>
        <th>Service Status</th>
        <th>Service Type</th>
        <th>Cost</th>
        <th>Auctions</th>
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
        <a class='btn btn-info btn-xs' href="/admin/updateRep/${repair.repairID}"><span class="glyphicon glyphicon-edit"></span> Edit</a>
      </td>

    </tr>
    </#list>
</table>

</#if>

</body>

</html>