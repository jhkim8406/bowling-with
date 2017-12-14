<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading" style="text-align:center;">
                    <h3 class="panel-title">볼링위드 로그인</h3>
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
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me" style="float:right;">로그인 상태 유지
                                </label>
                            </div>
                            <div class="checkbox">
                             <!-- Change this to a button or input when using this as a form -->
                             <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
                             <button onclick="javascript:$('#loginForm').submit();" class="btn btn-primary" style="width:73%;">로그인</button>
                             <button onclick="javascript:;" class="btn btn-primary" style="margin-left:1px; width:25%;">회원가입</button>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>