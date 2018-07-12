/**
 * 
 */
$(document).ready(function(){
	selectboxCity();
	interestCheckbox();

	
	//勾選全部可以連動興趣的checkbox	
	$('#allCheckbox').click(function(){
		if($('#allCheckbox').prop('checked')){
			$('input[name=interestCheckbox]').each(function(index,element){
				$(element).prop('checked',true);
			});
		}else{
			$('input[name=interestCheckbox]').each(function(index,element){
				$(element).prop('checked',false);
			
			});
		}
	});

//保存按鈕
	$('#singinBtn').click(function() {	
//檢驗必填欄位是否有值		
		var invalidArray = [];
		var cityId = $('#citySelectbox').val();
		var zoneId = $('#zoneSelectbox').val();
		var name= $('#name').val();
		if(cityId==0||zoneId==0){		
			$('#singinFaildId').html('地址不可為空值!');
			return;
		}if(name.trim()==null||name.trim()==''){
			$('#singinFaildId').html('名字不可為空值!');
			invalidArray.push("#name");
			return;
		}
		// 如果有值就跳錯誤
		if (invalidArray.length > 0) {
			$(invalidArray).each(function(index,element){
				$(element).addClass('invalid-input');
			})
			$('#errorMessage').show();
			//$(invalidArray[invalidArray.length - 1]).focus();
			return false;
		}
	
		var singinData = {
			name:$('#name').val(),
			birthday:$('#birthday').val(),
			gender:$('input[name=gender]').filter(':checked').val(),
			email:$('#email').val(),
			phone:$('#phone').val(),
			workingday:$('#workingday').val(),
			cityId:$('#citySelectbox').val(),
			zoneId:$('#zoneSelectbox').val(),
			address:$('#address').val(),
			interests:interestResult()		
		}
		
		
		function interestResult(){
			var data = '';
			$('input[name=interestCheckbox]').filter(':checked').each(function(index,element){				
				if(data.length>0){
					data+=","+$(element).val();
				}else{
					data=$(element).val();
				}
			})
			return data;
		}
				
		console.info(singinData);
		$.ajax({
			contentType : "application/json",
			url : "/insertMember",
			data:JSON.stringify(singinData),
			method : "POST",
			success : function(data) {
				console.info(data);
				alert("建立資料成功");
			}
		});		
	});
//返回上一頁
	$('#returnBtn').click(function() {
	   history.back();
	});	
});	
