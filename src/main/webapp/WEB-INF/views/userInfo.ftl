<#import "/spring.ftl" as spring/>

<head lang="en">
    <title>User Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Regeneration Car Repair</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">

                <!--Menu options --!>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="http://localhost:8080/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
            </ul>
        </div>
    </div>
</nav>

<#if name??>
<h1> Welcome, ${user.firstName} ${user.lastName}</h1>

<table>
     <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Service Status</th>
        <th>Service Type</th>
        <th>Cost</th>
    </tr>
    <#list repairs as repair>
    <tr>
        <td>${repair.dayOfRepair}</td>
        <td>${repair.description}</td>
        <td>${repair.repairStatus}</td>
        <td>${repair.repairType}</td>
        <td>${repair.serviceCost}</td>
    </tr>
    </#list>
</table>


<#else>
<h1>How you came here</h1>
<p>
</#if>

</body>

