<#import "/spring.ftl" as spring/>

<head lang="en">
    <title>User Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>


<#if name??>
<h1> Welcome, ${name}</h1>

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


<p>  ${user.address}   ${repairs[1].description}<p>

<#else>
<h1>How you came here</h1>
</#if>

</body>

