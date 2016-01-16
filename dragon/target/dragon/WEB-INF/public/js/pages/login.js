/**
 * login.js
 */
var UserLogin = function(){
	
	var handleUserLogin = function(){
		
		$('#form-login').validate({
			focusInvalid: true,
			onkeyup:false,
			success:false,
			errorElement: "h5",
			errorClass:"error",
			validClass:"success",
			rules:{
				email:{
					required:true,
					email:true
				},
				password:{
					required:true,
					minlength:6
				}
			},
			messages:{
				email:{
					required:"必填",
					email:"请输入合法的邮箱地址！"
				},
				password:{
					required:"必填",
					minlength:jQuery.validator.format("密码最少{0}位字符！")
				}
			},
			/* 元素失去焦点 */
			onfocusout:function(element){
				formValidation($(element));
			},
            /* 错误提示放置   */
            errorPlacement: function (error, element) {
            	errorMessageShow(error,element);
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
        	handleUserLogin();
        }
    };
	
}();