/**
 * 
 */
$(document).ready(function(){
//	selectboxCity();
//	selectZoneByCityId();
		
	var sid = url_query('sid');
	
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
			$('#address').val(data.address);
			$('#workingday').val(data.workingday);	
			
			initInterestCheckbox(data);
			initCitySelectbox(data);
		}
	});	
	
	//保存按鈕
	$('#singinBtn').click(function(){
	var editData = {
		sid:sid,
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
		var result = "";
		$('input[name=interestCheckbox]').filter(':checked').each(function(index,element){
			if(result.length>0){
				result+=","+$(element).val();
			}else{
				result=$(element).val();
			}
		});
		return result;
	}
		
	console.info(editData);
		$.ajax({
			contentType : "application/json",
			url : "/editMemeber",
			data:JSON.stringify(editData),
			method : "POST",
			success : function(data) {
				console.info(data);
				alert("成功修改資料");				
			}
		});
	});
	
	//返回按鈕
	$('#returnBtn').click(function(){
		history.back();
	});	
	
});

//找全部興趣的checkbox
function initInterestCheckbox(userInfo){
		$.ajax({
			contentType : "application/json",
			url : "/selectAllInterests",
			method : "GET",
			success : function(data) {
				$(data).each(function(index,element){
					var newCheckbox = $('<input type="checkbox" name="interestCheckbox">');
					newCheckbox.val(element.value);
					var span = $('<span>');
					span.text(element.desc);				
					$('#interestCheckboxDiv').append(newCheckbox).append(span);
				});	
				console.info(userInfo);
				if(userInfo.interests==null){
					return;
				}else{
				var interestArray = userInfo.interests.split(',')
				$('input[name=interestCheckbox]').each(function(index,element){
					$(interestArray).each(function(indexC,elementC){
						if($(element).val()==elementC){
							$(element).prop('checked',true);
						}
					})
				})
			}
		}
			
	});
		
	
	
}
//查全部縣市下拉式選單
function initCitySelectbox(userInfo){
	$.ajax({
		contentType : "application/json",
		url : "/selectCity",
		method : "GET",
		success : function(data) {
			$(data).each(function(index,element){
				var newCityOption = $('<option>');
				newCityOption.val(element.oid);
				newCityOption.text(element.name);				
				$('#citySelectbox').append(newCityOption);
			});
			$('#citySelectbox').val(userInfo.cityId);
			selectZoneByCityId(userInfo.zoneId);
			

		}
		
	});
}

//依使用者選城市找區域	
function selectZoneByCityId(userZone){
	var cityOid = $('#citySelectbox').val();
	console.info(typeof cityOid);
	$.ajax({
		contentType : "application/json",
		url : "/selectZoneByCityId",
		data:{
			cityOid:cityOid
		},
		method : "GET",
		success : function(data) {		
			$(data).each(function(index,element){
				var newCityOption = $('<option>');
				newCityOption.val(element.oid);
				newCityOption.text(element.name);				
				$('#zoneSelectbox').append(newCityOption);
			});
			$('#zoneSelectbox').val(userZone);
			
		}
	});		
}	

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