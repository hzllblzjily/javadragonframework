/**
 * screenshotupdate.js
 */
var ScreenshotUpdate= function(){
	
	var handleScreenshotUpdate = function(){
		
		$('#form-update').validate({
			focusInvalid: true,
			onkeyup:false,
			success:false,
			errorElement: "h5",
			errorClass:"error",
			validClass:"success",
			rules:{
				version:{
					required:true
				}
			},
			messages:{
				version:{
					required:"必填"
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
            	checked_mark_update();
			    form.submit();
			    /* 禁用登录按钮  */
				Disabled($('.form-actions button[type="submit"]'),'提交中...');
			}
		});
		
	};
	
	return {
        //initiate the module
        init: function () {
        	handleScreenshotUpdate();
        }
    };
	
}();