<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Login</h3>
                </div>
                <div class="panel-body">
                    <form role="form" id="loginForm" action="/login" method="post">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="E-mail" name="username" id="username" type="email" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name="password" id="password" type="password" value="">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me" style="float:right;">Remember Me
                                </label>
                            </div>
                            <div class="checkbox">
                             <!-- Change this to a button or input when using this as a form -->
                             <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
                             <button onclick="javascript:$('#loginForm').submit();" class="btn btn-primary" style="width:75%;">Login</button>
                             <button onclick="javascript:;" class="btn btn-primary" style="margin-left:1px; width:23%;">Sing Up</button>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>