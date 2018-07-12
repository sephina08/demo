/**
 * 
 */
$(document).ready(function(){

//依使用者選城市找區域
	$('#citySelectbox').change(function(){
		if($('#citySelectbox').val()==0){
			rebuildZone([])
			return;
		}
		var data = {
				cityOid : $('#citySelectbox').val()
		};
		
		$.ajax({
			contentType : "application/json",
			url : "/selectZoneByCityId",
			data:data,
			method : "GET",
			success : function(data) {
				console.info(data);
				rebuildZone(data)
			}
		});	
	});	

	
	//依使用者選城市找區域(下拉式選單塞值)
	function rebuildZone(data){
		$('#zoneSelectbox').empty();
		var newZoneOption = $('<option>');
		newZoneOption.text("--請選擇--");
		newZoneOption.val("0");
		$('#zoneSelectbox').append(newZoneOption);
		$(data).each(function(index,element){
			var newCityOption = $('<option>');
			newCityOption.val(element.oid);
			newCityOption.text(element.name);				
			$('#zoneSelectbox').append(newCityOption);
		});
	}	
	

});

//查全部縣市下拉式選單
function selectboxCity(){
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
		}
		
	});
}

//找全部興趣的checkbox
function interestCheckbox(){
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
		}
		
	});
}

