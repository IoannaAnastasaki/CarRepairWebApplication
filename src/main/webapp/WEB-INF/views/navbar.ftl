<#import "/spring.ftl" as spring/>
<html>
<head>

    <title>NavBar</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


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


                <li><span></span></li>
                <li><a href="/admin/findUser"><span class="glyphicon glyphicon-search"></span> Users</a></li>
                <li><a href="/admin/findRepair/"><span class="glyphicon glyphicon-search"></span> Repairs</a></li>

                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/admin/createUser"><span class="glyphicon glyphicon-plus"></span> Add User</a></li>
                <li><a href="/admin/createRepair"><span class="glyphicon glyphicon-plus"></span> Add User Service</a></li>
                <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
            </ul>
        </div>
    </div>
</nav>




</body>



</body>
</html>