<#import "/spring.ftl" as spring/>

<head lang="en">
    <title>User Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<#if email??>
<h1> Welcome, ${email}</h1>


<p>  ${user.address}   {repairList[0].description}<p>

<#else>
<h1>How you came here</h1>
</#if>

</body>

