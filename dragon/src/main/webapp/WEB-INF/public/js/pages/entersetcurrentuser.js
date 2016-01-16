/**
 * entersetcurrentuser.js
 */
var UserSetInfo= function(){
	
	var handleUserUpdateInfo = function(){
		
		$('#form-setcurrentuser').validate({
			focusInvalid: true,
			onkeyup:false,
			errorElement: "h5",
			errorClass:"error",
			validClass:"success",
			rules:{
				userName:{
					required:true,
					minlength: 2
				}
			},
			messages:{
				userName:{
					required:"必填",
					minlength:jQuery.validator.format("昵称最少{0}位字符！")
				}
			},
			/* 元素失去焦点 */
			onfocusout:function(element){
				formValidation($(element));
			},
            /* 错误提示放置   */
            errorPlacement: function (error, element) {          	
            	if(element.next('.help-block').length<1){
	            	var $help_block=$('<span class="help-block"></span>');
	            	$help_block.insertAfter(element);
	            }
            	error.appendTo(element.next('.help-block'));
            },
            /* 验证成功提示  */
            success: function (label,element) {
            	
            },
            /* 提交表单 */
            submitHandler: function(form) {
			    form.submit();
			    /* 禁用登录按钮  */
				Disabled($('.form-actions button[type="submit"]'),'保存中...');
			}
		});
		
	};
	
	var handleUserChangePassword = function(){
		
		$('#form-changepassword').validate({
			focusInvalid: true,
			onkeyup:false,
			success:false,
			errorElement: "h5",
			errorClass:"error",
			validClass:"success",
			rules:{
				oldpassword:{
					required:true,
					minlength: 6
				},
				newpassword:{
					required:true,
					minlength: 6
				},
				newpassword_confirmation: {
					required:true,
					minlength: 6,
					equalTo:"#newpassword"
				}
			},
			messages:{
				oldpassword:{
					required:"必填",
					minlength:jQuery.validator.format("密码最少{0}位字符！")
				},
				newpassword:{
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
				Disabled($('.form-actions button[type="submit"]'),'修改中...');
			}
		});
		
	};
	
	return {
        //initiate the module
        init: function () {
        	handleUserUpdateInfo();
        	handleUserChangePassword();
        }
    };
	
}();