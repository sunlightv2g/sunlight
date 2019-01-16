var eventhistory = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

    },
    save : function () {
    	if($('#from1').val().trim() == ""){
    		alert("등록일을 입력해주세요.");
    		$('#from1').val("");
    		$('#from1').focus();
    		return false;
    	}
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
        		workdate: $('#from1').val(),
        		equipment: $('#equipment').val(),
        		author: $('#author').val(),
        		worker: $('#worker').val(),
        		content: $('#contents').val(),
        		result: $('#result').val(),
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

eventhistory.init();

function fncGoMonth(cYear, cMonth) {
	 top.location.href = _uri + "?cYear=" + cYear + "&cMonth=" + cMonth;
}

function getInfo(id) {
	console.log("id : " + id);
	var rstData = {};
	var data = {
    		id: $('#id').val()
    	};

    $.ajax({
        type: 'GET',
        url: "/maintenance/eventhistory/"+id,
        dataType: 'json',
        contentType:'application/json; charset=utf-8'
    }).done(function(data) {
    	$('#id').val(data.id);
		$('#from1').val(data.workdate);
		$('#equipment').val(data.equipment);
		$('#author').val(data.author);
		$('#worker').val(data.worker);
		$('#contents').val(data.content);
		$('#result').val(data.result);
		$('#remark').val(data.remark);
		
		$('#divInsert').hide();
		$('#divEdit').show();
    }).fail(function (error) {
        alert(error);
    });
        
	view_show(1);

}

function insertInfo(){
	
	$('#id').val("");
	$('#from1').val("");
	$('#equipment').val("");
	$('#author').val("");
	$('#worker').val("");
	$('#contents').val("");
	$('#result').val("");
	$('#remark').val("");
	
	$('#divInsert').show();
	$('#divEdit').hide();
	view_show(1);
	
}

function editInfo(){
	if($('#from1').val().trim() == ""){
		alert("등록일을 입력해주세요.");
		$('#from1').val("");
		$('#from1').focus();
		return false;
	}
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
    		workdate: $('#from1').val(),
    		equipment: $('#equipment').val(),
    		author: $('#author').val(),
    		worker: $('#worker').val(),
    		content: $('#contents').val(),
    		result: $('#result').val(),
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
         url: "/maintenance/eventhistory/"+id,
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



