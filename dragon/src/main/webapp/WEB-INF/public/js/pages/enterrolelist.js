/**
 * enterrolelist.js
 */
var EnterRoleList = function(){
	
	var handleAddAdministrator = function(){
		
		$('#form-add-administator').validate({
			focusInvalid: true,
			onkeyup:false,
			success:false,
			errorElement: "h5",
			errorClass:"error",
			validClass:"success",
			rules:{
				name:{
					required:true
				},
				level:{
					required:true,
					digits:true,
					range:[1,99]
				}
			},
			messages:{
				name:{
					required:"必填",
				},
				level:{
					required:"必填",
					digits:"请输入整数！",
					range:jQuery.validator.format("Level必须在{0}~{1}之间！")
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
			    /* 禁用确认按钮  */
				Disabled($('.modal-footer input[type="submit"]'),'保存中...');
			}
		});
		
	};
	
	return {
        //initiate the module
        init: function () {
        	handleAddAdministrator();
        }
    };
	
}();