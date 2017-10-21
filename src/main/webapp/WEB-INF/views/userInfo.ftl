<#import "/spring.ftl" as spring/>

<head lang="en">
    <title>User Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<#if name??>
<h1> Welcome, ${name}</h1>

<#else>
<h1>How you came here</h1>
</#if>

</body>

