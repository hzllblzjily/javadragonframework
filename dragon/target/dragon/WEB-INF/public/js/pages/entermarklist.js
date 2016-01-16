/**
 * entermarklist.js
 */
var EnterMarkList = function(){
	
	var handleAddMark = function(){
		
		$('#form-add-mark').validate({
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
				markcategoryids:{
					required:true
				}
			},
			messages:{
				name:{
					required:"必填"
				},
				markcategoryids:{
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
            	markcategoryids();
			    form.submit();
			    /* 禁用确认按钮  */
				Disabled($('.modal-footer input[type="submit"]'),'保存中...');
			}
		});
		
	};
	
	var handleEditMark = function(){
		
		$('#form-edit-mark').validate({
			focusInvalid: true,
			onkeyup:false,
			success:false,
			errorElement: "h5",
			errorClass:"error",
			validClass:"success",
			rules:{
				name:{
					required:true
				}
			},
			messages:{
				name:{
					required:"必填",
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
        	handleAddMark();
        	handleEditMark();
        }
    };
	
}();

function markcategoryids(){
	var markcategoryids='';
	var $markcategoryids=$('.markcategory-container li');
	for(var i=0;i<$markcategoryids.length;i++){
		var flag=$markcategoryids.eq(i).find('.mark').get(0).checked;
		if(flag){
			var id=$markcategoryids.eq(i).find('.mark').attr('id').replace('mark_','');
			markcategoryids+=id+',';
		}
	}
	if(markcategoryids!=''){
		markcategoryids.substring(0,markcategoryids.length-1);
	}
	$('#markcategoryids').val(markcategoryids);
}