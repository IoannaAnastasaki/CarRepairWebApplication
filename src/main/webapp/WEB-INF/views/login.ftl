<#import "/spring.ftl" as spring/>

<head lang="en">
    <title>Login to CarRepair</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

    <h1>Welcome to CarRepair Web app</h1>

    <div>
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
	</div>

</body>