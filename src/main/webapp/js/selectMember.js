/**
 * 查看頁面
 */
$(document).ready(function(){
	selectboxCity();
	interestCheckbox();

//初始化區域下拉式選單
	$.ajax({
		contentType : "application/json",
		url : "/selectZone",
		method : "GET",
		success : function(data) {
			console.info(data);
		$(data).each(function(index,element){
			var newOption = $('<option>')
			newOption.val(element.oid);
			newOption.text(element.name);
			$('#zoneSelectbox').append(newOption)		
		});	
			
		}
	});	
//取得url的sid	
	function url_query( query ) {
	    query = query.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
	    var expr = "[\\?&]"+query+"=([^&#]*)";
	    var regex = new RegExp( expr );
	    var results = regex.exec( window.location.href );
	    if ( results !== null ) {
	        return results[1];
	    } else {
	        return false;
	    }
	}
		
	var sid=url_query('sid');
	console.info(sid);
	$.ajax({
		contentType : "application/json",
		url : "/selectById",
		data:{
			sid:sid
		},
		method : "GET",
		success : function(data) {
			console.info(data);
			$('#name').val(data.name);
			$('#birthday').val(data.birthday);
			$('input[name=gender]').each(function(index,element){
				if($(element).val()==data.gender){
					$(element).prop('checked',true);
				}
			})
			$('#email').val(data.email);
			$('#phone').val(data.phone);
			$('#citySelectbox').val(data.cityId);
			$('#zoneSelectbox').val(data.zoneId);
			$('#address').val(data.address);
//	        SimpleDateFormat sdf = new SimpleDateFormat(data.workingday);
//			$('#workingday').val(sdf);	
			var interestArray = data.interests.split(',')
			$('input[name=interestCheckbox]').each(function(index,element){
				$(interestArray).each(function(indexC,elementC){
					if($(element).val()==elementC){
						$(element).prop('checked',true);
						$('input[name=interestCheckbox]').prop('disabled',true)
					}
					
				})
			})
		}
	});	
//返回按鈕	
$('#returnBtn').click(function(){
	history.back();
});
});