/**
 * applicationupdate.js
 */
var ApplicationUpdate= function(){
	
	var handleApplicationUpdate = function(){
		
		$('#form-update').validate({
			focusInvalid: true,
			onkeyup:false,
			success:false,
			errorElement: "h5",
			errorClass:"error",
			validClass:"success",
			rules:{
				name:{
					required:true,
				},
				downloadLink:{
					required:true,
					url:true
				}
			},
			messages:{
				name:{
					required:"必填"
				},
				downloadLink:{
					required:"必填",
					url:"请输入正确的网址"
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
				Disabled($('.form-actions button[type="submit"]'),'提交中...');
			}
		});
		
	};
	
	return {
        //initiate the module
        init: function () {
        	handleApplicationUpdate();
        }
    };
	
}();