var routinecheck = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        

    },
    save : function () {
    	
    	if($('#equipment').val().trim() == ""){
    		alert("설비명을 입력해주세요.");
    		$('#equipment').val("");
    		$('#equipment').focus();
    		return false;
    	}
    	if($('#author').val().trim() == ""){
    		alert("등록자를 입력해주세요.");
    		$('#author').val("");
    		$('#author').focus();
    		return false;
    	}
    	if($('#worker').val().trim() == ""){
    		alert("작업자를 입력해주세요.");
    		$('#worker').val("");
    		$('#worker').focus();
    		return false;
    	}
    	if($('#contents').val().trim() == ""){
    		alert("작업상세를 입력해주세요.");
    		$('#contents').val("");
    		$('#contents').focus();
    		return false;
    	}
    	
        var data = {
        		period: $('#period').val(),
        		weektime: $('#weektime').val(),
        		equipment: $('#equipment').val(),
        		worker: $('#worker').val(),
        		content: $('#contents').val(),
        		author: $('#author').val(),
        		remark: $('#remark').val()
        	};

        $.ajax({
            type: 'POST',
            url: _uri,
            dataType: 'text',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('등록되었습니다.');
            top.location.reload();
            //routinecheck.list();
        }).fail(function (error) {
            alert(error);
        });
    }

};


routinecheck.init();


function insertInfo(){
	
	$('#id').val("");
	$('#period').val("");
	$('#weektime').val("");
	$('#equipment').val("");
	$('#author').val("");
	$('#worker').val("");
	$('#contents').val("");
	$('#remark').val("");
	
	$('#divInsert').show();
	$('#divEdit').hide();
	view_show(1);
	
}


function getInfo(id, that) {
	
	$('#divInsert').hide();
	$('#divEdit').show();
	  
	var td = that.children;
	$('#id').val(td[0].textContent);
	$('#period').val(td[1].textContent);
	$('#weektime').val(td[2].textContent);
	$('#equipment').val(td[3].textContent);
	$('#author').val(td[4].textContent); 
	$('#worker').val(td[5].textContent);
	$('#contents').val(td[6].textContent);
	$('#remark').val(td[7].textContent);
	        
	view_show(1);

}

function editInfo(){
	if($('#equipment').val().trim() == ""){
		alert("설비명을 입력해주세요.");
		$('#equipment').val("");
		$('#equipment').focus();
		return false;
	}
	if($('#author').val().trim() == ""){
		alert("등록자를 입력해주세요.");
		$('#author').val("");
		$('#author').focus();
		return false;
	}
	if($('#worker').val().trim() == ""){
		alert("작업자를 입력해주세요.");
		$('#worker').val("");
		$('#worker').focus();
		return false;
	}
	if($('#contents').val().trim() == ""){
		alert("작업상세를 입력해주세요.");
		$('#contents').val("");
		$('#contents').focus();
		return false;
	}
	
	var data = {
			id: $('#id').val(),
			period: $('#period').val(),
    		weektime: $('#weektime').val(),
    		equipment: $('#equipment').val(),
    		worker: $('#worker').val(),
    		content: $('#contents').val(),
    		author: $('#author').val(),
    		remark: $('#remark').val()
    	};
	
    $.ajax({
        type: 'PUT',
        url: _uri,
        dataType: 'text',
        contentType:'application/json; charset=utf-8',
        data: JSON.stringify(data)
    }).done(function() {
        alert('수정되었습니다.');
        top.location.reload();
        //routinecheck.list();
    }).fail(function (error) {
        alert(error);
    });
}

function deleteInfo(){
	var id = $('#id').val();
	console.log("id : " + id);
    if(!confirm("정말 삭제하시겠습니까? 삭제된 데이터는 복구 하실 수 없습니다.")){
    	return false;
    }
    $.ajax({
    	 type: 'DELETE',
         url: "/environment/routinecheck/"+id,
        dataType: 'text',
        contentType:'application/json; charset=utf-8'
    }).done(function() {
        alert('삭제되었습니다.');
        top.location.reload();
        //routinecheck.list();
    }).fail(function (error) {
        alert(error);
    });
}

function goPage(page) {
	 var startDate = $('#from1').val().trim();
	 var endDate = $('#to1').val().trim();
	 top.location.href = _uri + "?page=" + page + "&startDate=" + startDate + "&endDate=" + endDate;
}
