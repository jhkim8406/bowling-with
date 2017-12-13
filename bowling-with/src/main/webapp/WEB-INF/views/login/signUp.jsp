<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="wrapper">
	<div id="page-wrapper">
	    <div class="row">
	        <div class="col-lg-12">
	            <h1 class="page-header">회원가입</h1>
	        </div>
	        <!-- /.col-lg-12 -->
	    </div>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						회원가입
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-6">
								<form role="form" method="post" onsubmit="return fn_submit();"> 
									<div class="form-group">
										<label>Name</label>
		                                <input class="form-control" placeholder="Name" name="username" id="username" type="text" autofocus>
		                            </div>
									<div class="form-group">
										<label>ID (EMAIL)</label>
		                                <input class="form-control" placeholder="E-mail" name="userId" id="userId" type="email" autofocus>
		                            </div>
		                            <div class="form-group">
										<label>Password</label>
		                                <input class="form-control" placeholder="Password" name="password" id="password" type="password" value="">
		                            </div>
		                            <div class="form-group" id="div_password_confirm">
										<label>Password Confirm</label>
		                                <input class="form-control" placeholder="Password" name="password_confirm" id="password_confirm" type="password" value="">
		                            </div>
		                            <div class="checkbox" style="text-align: center;">
		                            	<button onclick="javascript:;" class="btn btn-primary" id="button_signup" name="button_signup" style="margin-left:1px; align:right">Sing Up</button>
		                            </div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<input type="hidden" id="validation_password" value="0">
<script type="text/javascript">
	$(document).ready(function() {
		$("#password_confirm").keyup(function() {
			fn_compare_password();
		});
	});
	
	function fn_submit() {
		if(fn_validation_value()) {
			alert("폼 전송");
		}
		else {
			return false;
		}
	}
	
	function fn_compare_password() {
		var password1 = $("#password").val();
		var password2 = $("#password_confirm").val();
		
		if(password1 === password2) {
			$("#div_password_confirm").attr("class","form-group has-success");
			$("#validation_password").val(1);
		}
		else {
			$("#div_password_confirm").attr("class","form-group has-error");
			$("#validation_password").val(0);
			return false;
		}
	}
	
	function fn_validation_value() {
		var name = $("#username").val();
		var email = $("#userId").val();
		var password = $("#password").val();
		
		if(name === "") {
			alert("이름을 입력해주세요.");
			$("#username").focus();
			return false;
		}
		else {
			if(!fn_validation_korean(name)) {
				return false;
			}
		}
		
		if(email === "") {
			alert("아이디를 입력해주세요.");
			$("#userId").focus();
			return false;
		}
		else {
			if(!fn_validation_email(email)) {
				return false;
			}
		}
		
		if(password === "") {
			alert("비밀번호를 입력해주세요.");
			$("#password").focus();
			return false;
		}
		else {
			if(!fn_validation_password()) {
				return false;
			}
		}
		
		return true;
	}
	
	function fn_validation_korean(obj) {
		var check = /[ㄱ-ㅎ\ㅏ-ㅣ\가-힣]/;
		if(check.test(obj) == false) {
			alert("이름은 한글로 입력해주세요.");
			$("#username").focus();
			return false;
		}
		return true;
	}
	
	function fn_validation_email(obj) {
		var check = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		if(check.test(obj) == false) { 
			alert("이메일 형식이 올바르지 않습니다."); 
			$("#userId").focus();
			return false; 
		}
		return true;
	}
	
	function fn_validation_password() {
		var password1 = $("#password").val();
		var password2 = $("#password_confirm").val();
		var validation_password = $("#validation_password").val();
		
		if(password1 !== password2 || validation_password == 0) {
			alert("비밀번호를 확인 해주세요.");
			$("#password_confirm").focus();
			return false;
		}
		return true;
	}
</script>