<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="wrapper">
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-4">
            	<div class="panel panel-default">
                	<div class="panel-heading" style="text-align:center;">
                            볼링위드 회원가입
                    </div>
                    <div class="panel-body">
						<div class="row">
							<div class="col-lg-6">
								<form role="form" method="post">
									<div class="form-group">
										<label>이름</label>
		                                <input class="form-control" placeholder="이름" name="username" id="username" type="text" autofocus>
		                                <label class="text-danger" id="label_warning_name" style="display:none; font-size:12px; color:#ff1914; margin-top:10px; margin-bottom:-10px;">필수 정보입니다.</label>
		                                <hr style="width:100%; border:1 solid #ccc;">
		                            </div>
									<div class="form-group">
										<label>아이디 (이메일)</label>
			                            <input class="form-control" placeholder="아이디 (이메일)" name="userId" id="userId" type="text" autofocus>
			                            <label class="text-danger" id="label_warning_id" style="display:none; font-size:12px; color:#ff1914; margin-top:10px; margin-bottom:-10px;">필수 정보입니다.</label>
			                            <hr style="width:100%; border:1 solid #ccc;">
		                            </div>
		                            <div class="form-group">
										<label>성별</label><br/>
		                                <label style="display:block;">
		                                	<a id="user_genderMale" class="btn btn-primary disabled" style="pointer-events:auto;">남</a>
                                        	<a id="user_genderFeMale" class="btn btn-danger disabled" style="pointer-events:auto;">여</a>
                                        	<input type="hidden" name="user_gender" id="user_gender" value=""/>
                                        </label>
                                        <label class="text-danger" id="label_warning_gender" style="display:none; font-size:12px; color:#ff1914; margin-top:10px; margin-bottom:-10px;">필수 정보입니다.</label>
                                        <hr style="width:100%; border:1 solid #ccc;">
		                            </div>
		                            <div class="form-group">
										<label>비밀번호</label>
		                                <input class="form-control" placeholder="비밀번호" name="password" id="password" type="password" value="">
		                                <label class="text-danger" id="label_warning_password" style="display:none; font-size:12px; color:#ff1914; margin-top:10px; margin-bottom:-10px;">필수 정보입니다.</label>
		                                <hr style="width:100%; border:1 solid #ccc;">
		                            </div>
		                            <div class="form-group" id="div_password_confirm">
										<label>비밀번호 재확인</label>
		                                <input class="form-control" placeholder="비밀번호 재확인" name="password_confirm" id="password_confirm" type="password" value="">
		                                <label class="text-danger" id="label_warning_password_confirm" style="display:none; font-size:12px; color:#ff1914; margin-top:10px; margin-bottom:-10px;">필수 정보입니다.</label>
		                                <hr style="width:100%; border:1 solid #ccc;">
		                            </div>
		                            <div class="checkbox" style="text-align:center;">
		                            	<a onclick="javascript:;" class="btn btn-primary" id="button_signup" name="button_signup">가입하기</a>
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
		
		$("#user_genderMale, #user_genderFeMale").on("click", function() {
			if(this.id === "user_genderMale") {
				$("#user_genderMale").attr("class", "btn btn-primary");
				$("#user_genderFeMale").attr("class", "btn btn-danger disabled");
				$("#user_gender").val("M");
			}
			else {
				$("#user_genderFeMale").attr("class", "btn btn-danger");
				$("#user_genderMale").attr("class", "btn btn-primary disabled");
				$("#user_gender").val("F");
			}
		});
		
		$("#username, #userId, #user_gender, #password, #password_confirm").focusout(function(){
			if(this.value === "") {
				$(this).next().show();
			}
			else {
				$(this).next().hide();
			}
		});
		
		$("#username, #userId, #user_gender, #password, #password_confirm").keyup(function(){
			if(this.value !== "") {
				$(this).next().hide();
			}
		});
		
		$("#button_signup").on("click", function() {
			fn_submit();
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
			$("#label_warning_password_confirm").hide();
		}
		else {
			$("#div_password_confirm").attr("class","form-group has-error");
			$("#validation_password").val(0);
			$("#label_warning_password_confirm").text("비밀번호가 일치하지 않습니다.");
			$("#label_warning_password_confirm").show();
			return false;
		}
	}
	
	function fn_validation_value() {
		var name = $("#username").val();
		var email = $("#userId").val();
		var gender = $("#user_gender").val();
		var password = $("#password").val();
		var password_confirm = $("#password_confirm").val();
		var flag_validation = true;
		
		if(name === "") {
			$("#label_warning_name").html("필수 정보입니다.");
			$("#label_warning_name").show();
			$("#username").focus();
			flag_validation = false;
		}
		else {
			if(!fn_validation_korean(name)) {
				flag_validation = false;
			}
		}
		
		if(gender === "") {
			$("#label_warning_gender").html("필수 정보입니다.");
			$("#label_warning_gender").show();
			flag_validation = false;
		}
		
		if(email === "") {
			$("#label_warning_id").html("필수 정보입니다.");
			$("#label_warning_id").show();
			$("#userId").focus();
			flag_validation = false;
		}
		else {
			if(!fn_validation_email(email)) {
				flag_validation = false;
			}
		}
		
		if(password === "") {
			$("#label_warning_password").text("필수 정보입니다.");
			$("#label_warning_password").show();
			$("#password").focus();
			flag_validation = false;
		}
		else {
			if(!fn_validation_password()) {
				flag_validation = false;
			}
		}
		
		if(password_confirm === "") {
			$("#label_warning_password_confirm").text("필수 정보입니다.");
			$("#label_warning_password_confirm").show();
			$("#password_confirm").focus();
			flag_validation = false;
		}
		
		return flag_validation;
	}
	
	function fn_validation_korean(obj) {
		var check = /[ㄱ-ㅎ\ㅏ-ㅣ\가-힣]/;
		
		if(check.test(obj) == false) {
			$("#label_warning_name").html("이름은 한글만 입력 가능합니다.");
			$("#label_warning_name").show();
			$("#username").focus();
			return false;
		}
		else {
			$("#label_warning_name").hide();
		}
		return true;
	}
	
	function fn_validation_email(obj) {
		var check = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		
		if(check.test(obj) == false) { 
			$("#label_warning_id").html("이메일 형식이 올바르지 않습니다.");
			$("#label_warning_id").show();
			$("#userId").focus();
			return false; 
		}
		else {
			$("#label_warning_id").hide();
		}
		return true;
	}
	
	function fn_validation_password() {
		var password1 = $("#password").val();
		var password2 = $("#password_confirm").val();
		var validation_password = $("#validation_password").val();
		
		if(password1 !== password2 || validation_password == 0) {
			$("#label_warning_password_confirm").text("비밀번호가 일치하지 않습니다.");
			$("#label_warning_password_confirm").show();
			$("#password_confirm").focus();
			return false;
		}
		else {
			$("#label_warning_password_confirm").hide();
		}
		return true;
	}
</script>