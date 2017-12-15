<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading" style="text-align:center;">
                    <h4 class="panel-title"><b>볼링위드<b/></h4>
                </div>
                <div class="panel-body">
                    <form role="form" id="loginForm" action="/login" method="post">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="아이디 (이메일)" name="username" id="username" type="email" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="비밀번호" name="password" id="password" type="password" value="">
                            </div>
                            <div class="checkbox">
                                <label style="font-size:12px; font-weight:bold;">
                                    <input name="remember" id="remember" type="checkbox" value="1">로그인 상태 유지
                                </label>
                            </div>
                            <div class="checkbox">
                             <!-- Change this to a button or input when using this as a form -->
                             <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
                             <button onclick="javascript:$('#loginForm').submit();" class="btn btn-primary" style="width:73%;">로그인</button>
                             <a href="/signUp" class="btn btn-primary" style="margin-left:1px; width:25%;">회원가입</a>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>