var equipmentinfo = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

    }

};

equipmentinfo.init();

function goPage(page) {
	 var searchFirst = $('#searchFirst').val().trim();
	 var searchSecond = $('#searchSecond').val().trim();
	 var searchStr = $('#searchStr').val().trim();
	 var searchDate = $('#from1').val().trim();
	 top.location.href = _uri + "?page=" + page + "&searchFirst=" + searchFirst + "&searchSecond=" + searchSecond + "&searchStr=" + searchStr + "&searchDate=" + searchDate;
}
