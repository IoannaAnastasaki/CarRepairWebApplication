<#import "/spring.ftl" as spring/>

<head lang="en">
    <title>Login to CarRepair</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="/icecode.css">
</head>
<body>
    <h1 class="welcome ">Welcome to CarRepair Web App</h1>
    <div class="container">

        <div class="card card-container">
        <h2 class='login_title text-center'>Login</h2>
        <hr>

            <form action="/login" method="POST" id="loginForm" name="loginForm" class="form-signin">
                <span id="reauth-email" class="reauth-email"></span>
                <p class="input_title">Email</p>
                <input type="text" name="email" id="inputEmail" class="login_box" placeholder="user@carrepair.com" required autofocus>
                <p class="input_title">Password</p>
                <input type="password" name="password" id="inputPassword" class="login_box" placeholder="******" required>

                <button class="btn btn-lg btn-primary" type="submit">Login</button>
            </form><!-- /form -->
        </div><!-- /card-container -->
    </div><!-- /container -->
<!--
    <div class="logo"></div>
        <div class="form">
		<div>
			<h1>Login to Your Account</h1><br>
		</div>
		<form action="/login" method="POST" id="loginForm" name="loginForm">
                <label for="email">Email</label>
                <input type="text" name="email" id="email" placeholder="email" autocomplete="off"/>
                <label for="password">Password</label>
                <input type="password" name="password" id="password" placeholder="password"/>

                <button type="submit">Login</button>
            </form>
		</div>

-->

<script src="https://use.typekit.net/ayg4pcz.js"></script>
<script>try{Typekit.load({ async: true });}catch(e){}</script>
</body>