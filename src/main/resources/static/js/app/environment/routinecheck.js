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

function goPage(page) {
	 var startDate = $('#from1').val().trim();
	 var endDate = $('#to1').val().trim();
	 top.location.href = _uri + "?page=" + page + "&startDate=" + startDate + "&endDate=" + endDate;
}
