/**
 * enterresetpassword.js
 */
var UserResetPassword= function(){
	
	var handleUserResetPassword = function(){
		
		$('#form-resetpassword').validate({
			focusInvalid: true,
			onkeyup:false,
			success:false,
			errorElement: "h5",
			errorClass:"error",
			validClass:"success",
			rules:{
				password:{
					required:true,
					minlength: 6
				},
				password_confirmation: {
					required:true,
					minlength: 6,
					equalTo:"#password"
				}
			},
			messages:{
				password:{
					required:"必填",
					minlength:jQuery.validator.format("密码最少{0}位字符！")
				},
				password_confirmation: {
					required:"必填",
					minlength:jQuery.validator.format("密码最少{0}位字符！"),
					equalTo:"两次密码输入不一致"
				}
			},
			/* 元素失去焦点 */
			onfocusout:function(element){
				formValidation($(element));
			},
			/* 错误提示放置 */
			errorPlacement : function(error, element) {
				errorMessageShow(error, element);
			},
            /* 提交表单 */
            submitHandler: function(form) {
			    form.submit();
			    /* 禁用登录按钮  */
				Disabled($('.form-actions button[type="submit"]'),'登录中...');
			}
		});
		
	};
	
	return {
        //initiate the module
        init: function () {
        	handleUserResetPassword();
        }
    };
	
}();