var routinecheck = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

    }

};

routinecheck.init();

function goPage(page) {
	 var startDate = $('#from1').val().trim();
	 var endDate = $('#to1').val().trim();
	 top.location.href = _uri + "?page=" + page + "&startDate=" + startDate + "&endDate=" + endDate;
}
