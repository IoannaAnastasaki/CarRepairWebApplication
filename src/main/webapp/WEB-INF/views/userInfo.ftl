<#import "/spring.ftl" as spring/>

<head lang="en">
    <title>User Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<#include "/userPageNavBar.ftl">

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

