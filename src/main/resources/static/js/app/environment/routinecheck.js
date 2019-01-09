var routinecheck = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        

    },
    save : function () {
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
            top.location.href=_uri;
            //routinecheck.list();
        }).fail(function (error) {
            alert(error);
        });
    }

};

routinecheck.init();

function goPage(page) {
	 var startDate = $('#from1').val();
	 var endDate = $('#to1').val();
	 top.location.href = _uri + "?page=" + page + "&startDate=" + startDate + "&endDate=" + endDate;
}
