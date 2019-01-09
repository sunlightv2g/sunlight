var login = {
    init : function () {
        var _this = this;
        $('#btn_login').on('click', function () {
            _this.userlogin();
        });
    },
    userlogin : function () {
    	if($('#loginid').val().trim() == ""){
    		alert("아이디를 입력해주세요.");
    		$('#loginid').val("");
    		$('#loginid').focus();
    		return false;
    	}
    	if($('#loginpass').val().trim() == ""){
    		alert("비밀번호를 입력해주세요.");
    		$('#loginpass').val("");
    		$('#loginpass').focus();
    		return false;
    	}
    	
        var data = {
        		userid: $('#loginid').val(),
        		userpass: $('#loginpass').val()
        	};

        $.ajax({
            type: 'POST',
            url: "/environment/userlogin",
            dataType: 'text',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(data) {
        	if(data < 1){
        		alert("아이디 또는 비밀번호를 확인해주세요.");	
        	}else{
        		history.back("-1");
        	}
        	
            //alert('등록되었습니다.');
            
            //routinecheck.list();
        }).fail(function (error) {
            alert(error);
        });
    }

};

login.init();


