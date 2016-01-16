/**
 * footer.js
 */
var UserSubscribe = function(){
	
	var handleUserSubscribe = function(){
		
		$('#form-footer-subscribe').validate({
			focusInvalid: true,
			onkeyup:false,
			success:false,
			onfocusout:false,
			errorElement: "h5",
			errorClass:"error",
			validClass:"success",
			rules:{
				email:{
					required:true,
					email:true
				}
			},
			messages:{
				email:{
					required:"请输入你的邮箱 每周会发送一份周报给你~",
					email:"请输入正确的邮箱地址！"
				}
			},
            /* 错误提示放置   */
            errorPlacement: function (error, element) {
            	alert(error[0].innerHTML);
            },
            /* 提交表单 */
            submitHandler: function(form) {
            	alert("「订阅周报」的功能程序员正在赶工~稍等~");
			    //form.submit();
			    /* 禁用订阅按钮  */
				//Disabled($('input[type="submit"]'),'订阅中...');
			}
		});
		
	};
	
	return {
        //initiate the module
        init: function () {
        	handleUserSubscribe();
        }
    };
	
}();