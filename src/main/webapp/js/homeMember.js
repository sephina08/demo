/**
 * 
 */
$(document).ready(function(){
	selectMember();
	deleteMember();
	$('#siginBtn').click(function(){
		addMember();
		
	})
	

//勾選刪除可以連動的checkbox		
	$('#allDeleteCheckbox').click(function() {
		if ($('#allDeleteCheckbox').prop('checked')) {
	        $('input[name=deleteCheckbox]').each(function(index, element) {
					$(element).prop('checked', true);
				});							
					} else {
						$('input[name=deleteCheckbox]').each(function(index, element) {
								$(element).prop('checked',false);
							});
								}
							})	



});

//刪除按鈕	
function deleteMember(){
	$('#deleteButton').click(function(){
		var deleteCheckbox = $('input[name=deleteCheckbox]').filter(':checked').length;
		if(deleteCheckbox<=0){
			alert("請勾選需刪除資料");
		}
		else{
			var dataArray = [];
			$('input[name=deleteCheckbox]').filter(':checked').each(function(index,element){	
				/**
				 * 後端是陣列,所以要先轉成陣列
				 * 利用index把value塞進去
				 */
				dataArray[index] = $(element).val();
			});
			console.info(dataArray);
			console.info(typeof dataArray);
			alert("是否確定刪除資料?");
			$.ajax({
				contentType : "application/json",
				url : "/deleteMember",
				data:JSON.stringify(dataArray),
				method : "POST",
				success : function(data) {
					console.info(data);
					alert("成功刪除資料");				
					basicSelect();
				 //$('#selectBtn').trigger('click'); //去觸發假的click事件
				}
			});
		}	
	});

	
}

//查詢按鈕	
function selectMember(){
	$('#selectBtn').click(basicSelect);
}


function basicSelect(){
	var data = {
		sid : $('#sid').val(),
		name : $('#name').val(),
		phone : $('#phone').val(),
		workingDay : $('#workingDay').val()
	};
	
	$.ajax({
		contentType : "application/json",
		url : "/selectDataByCondition",
		method : "POST",
		data : JSON.stringify(data),
		// 请求成功后的回调函数 data为json格式
		success : function(data) {
			//data array -> check return type from the controller of spring MVC
			console.info(data);
			$('#tableBody').empty();
			$(data).each(function(idx,data){
				$('#tableBody').append(
					"<tr id='"+data.sid+"'>"
				   +"<td><input type='checkbox' name='deleteCheckbox' value='"+data.sid+"'></td>"
				   +"<td>"+data.sid+"</td>"
				   +"<td>"+data.name+"</td>"
				   +"<td>"+data.phone+"</td>"
				   +"<td>"+data.birthday+"</td>"
				   +"<td>"+data.workingday+"</td>"
				   +"<td><div><a href='/selectMemberPage?sid="+data.sid+"'>查看</div></td>"
				   +"<td align='center'><img class='pencil' src=\"/image/PEN.png\"/></td>"
				   +"</tr>"
				);
			})
			$('.delData').show();
			
			$('#tableBody').on("click",'img.pencil',function(){
				var currentTr = this.parentNode.parentNode;//this:是img呼叫,找父母(td),找父母(tr)
				var currentId = $(currentTr).prop("id");//prop:屬性,一個參數是取值,爾個參數是給值
				location.href = "/editMemberPage?sid="+currentId;
			});
		}

	})
	
}



function addMember(){
	location.href = "/createMemberPage";
}



