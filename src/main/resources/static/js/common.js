$(document).ready(function(){
  //gnb
  $('#gnb').on({
		'mouseenter focusin':function() {
			$(".gnb_bg").addClass("on").stop().animate({"height":"300px"},10);
			$("#gnb .depth2").stop().animate({"height":"360px"},10);
			$("#gnb .depth2 > li").on("mouseenter focusin", function(){
				$("#gnb .depth2 li").not(this).removeClass("on");
				$(this).addClass("on");
			});
		},'mouseleave focusout':function(){
			$("#gnb .depth2").stop().animate({"height":"61px"},10);
			$("#gnb .depth2 li").removeClass("on");
			$(".gnb_bg").removeClass("on").stop().animate({"height":"0"},50);
		}
	});
  //layout

  $(document).ready(function(){
    var selectTarget = $('.search_select select');
    selectTarget.on('blur', function(){
        $(this).parent().removeClass('focus');
    });
    selectTarget.change(function(){
        var select_name = $(this).children('option:selected').text();
        $(this).siblings('label').text(select_name);
    });
});

	//select
	var selectTarget = $('.search_select select');
    selectTarget.on('blur', function(){
        $(this).parent().removeClass('focus');
    });
    selectTarget.change(function(){
        var select_name = $(this).children('option:selected').text();
        $(this).siblings('label').text(select_name);
    });

    var selectTarget3 = $('.choice_select select');
     selectTarget3.on('blur', function(){
         $(this).parent().removeClass('focus');
     });

     // main tab
    $(".main_tabCcontent").hide();
    $(".main_tabCcontent:first").show();
    $("#mainTab a").click(function(event) {
        event.preventDefault(); //주소에 #숨김
        $(this).parent().addClass("current");
        $(this).parent().siblings().removeClass("current");
        var tab = $(this).attr("href");
        $(".main_tabCcontent").not(tab).css("display", "none");
        $(tab).fadeIn();
    });
    // main tab
   $(".main_tabCcontent2").hide();
   $(".main_tabCcontent2:first").show();
   $("#mainTab2 a").click(function(event) {
       event.preventDefault(); //주소에 #숨김
       $(this).parent().addClass("current");
       $(this).parent().siblings().removeClass("current");
       var tab = $(this).attr("href");
       $(".main_tabCcontent2").not(tab).css("display", "none");
       $(tab).fadeIn();
   });
    //sub tab1
    $(".tab_content1").hide();
    $(".tab_content1:first").show();
    $("#tab1 a").click(function(event) {
        event.preventDefault(); //주소에 #숨김
        $(this).parent().addClass("current");
        $(this).parent().siblings().removeClass("current");
        var tab = $(this).attr("href");
        $(".tab_content1").not(tab).css("display", "none");
        $(tab).fadeIn();
    });
    //sub tab2
    $(".tab_content2").hide();
    $(".tab_content2:first").show();
    $("#tab2 a").click(function(event) {
        event.preventDefault(); //주소에 #숨김
        $(this).parent().addClass("active");
        $(this).parent().siblings().removeClass("active");
        var tab = $(this).attr("href");
        $(".tab_content2").not(tab).css("display", "none");
        $(tab).fadeIn();
    });
});

//loacation
jQuery(function($){
    // Common
    var select_root = $('div.fake_select');
    var select_value = $('.my_value');
    var select_a = $('div.fake_select>ul>li>a');
    var select_input = $('div.fake_select>ul>li>input[type=radio]');
    var select_label = $('div.fake_select>ul>li>label');
    // Radio Default Value
    $('div.my_value').each(function(){
        var default_value = $(this).next('.i_list').find('input[checked]').next('label').text();
        $(this).append(default_value);          });

    // Line
    select_value.bind('focusin',function(){$(this).addClass('outLine');});
    select_value.bind('focusout',function(){$(this).removeClass('outLine');});
    select_input.bind('focusin',function(){$(this).parents('div.fake_select').children('div.my_value').addClass('outLine');});
    select_input.bind('focusout',function(){$(this).parents('div.fake_select').children('div.my_value').removeClass('outLine');});
    // Show
    function show_option(){
        $(this).parents('div.fake_select:first').toggleClass('open');
    }
    // Hover
    function i_hover(){
        $(this).parents('ul:first').children('li').removeClass('hover');
        $(this).parents('li:first').toggleClass('hover');
    }
    // Hide
    function hide_option(){
        var t = $(this);
        setTimeout(function(){
            t.parents('div.fake_select:first').removeClass('open');
        }, 1);
    }
    // Set Input
    function set_label(){
        var v = $(this).next('label').text();
        $(this).parents('ul:first').prev('.my_value').text('').append(v);
        $(this).parents('ul:first').prev('.my_value').addClass('selected');
    }
    // Set Anchor
    function set_anchor(){
        var v = $(this).text();
        $(this).parents('ul:first').prev('.my_value').text('').append(v);
        $(this).parents('ul:first').prev('.my_value').addClass('selected');
    }
    // Anchor Focus Out
    $('*:not("div.fake_select a")').focus(function(){
        $('.a_list').parent('.fake_select').removeClass('open');
    });
    select_value.click(show_option);
    select_root.removeClass('open');
    select_root.mouseleave(function(){$(this).removeClass('open');});
    select_a.click(set_anchor).click(hide_option).focus(i_hover).hover(i_hover);
    select_input.change(set_label).focus(set_label);
    select_label.hover(i_hover).click(hide_option);
});

//popup
function view_show(num,flag,that) {
    $("body").addClass("ofHidden"); // css로 body 스크롤 없애기
    var left = (( $(window).width() - $("#dispay_view"+num).width()) / 2 );
    var top = (( $(window).height() - $("#dispay_view"+num).height()) / 2 );
    $("#dispay_view"+num).css({'left':left,'top':top, 'position':'fixed'});
    document.getElementById("dispay_view"+num).style.display = "block";
    document.getElementById("js-popup-bg").style.display = "block";
    if(flag == "join"){
  	  $('#divUserRole').hide();
  	  $('#userInsert').show();
  	  $('#userEdit').hide();
  	  $('#btnUseridChk').show();
  	  
	  $('#id').val("");
	  $('#userid').val("");
	  $('#username').val("");
	  $('#userrole').val("");
	  $('#userpart').val(""); 
	  $('#userhp').val("");
	  $('#usertel').val("");
	  $('#useremail').val("");
	  $('#usersms').val("");
	  
    }else if(flag == "edit"){
      $('#divUserRole').show();
	  $('#userInsert').hide();
	  $('#userEdit').show();
	  $('#btnUseridChk').hide();
	  
	  var td = that.children;
	  $('#id').val(td[0].textContent);
	  $('#userid').val(td[1].textContent);
	  $('#username').val(td[2].textContent);
	  $('#userrole').val(td[3].textContent);
	  $('#userpart').val(td[4].textContent); 
	  $('#userhp').val(td[5].textContent);
	  $('#usertel').val(td[6].textContent);
	  $('#useremail').val(td[7].textContent);
	  $(this).prop('checked', false);
	  if(td[8].textContent == "Y"){
		  $("input:radio[name='usersms']:radio[value='Y']").prop('checked', true); // 선택하기  
	  }else{
		  $("input:radio[name='usersms']:radio[value='N']").prop('checked', true); // 선택하기
	  }
	  
    }
    return false;
 }
function view_hide(num,flag) {
  $("body").removeClass("ofHidden");
  document.getElementById("dispay_view"+num).style.display = "none";
  document.getElementById("js-popup-bg").style.display = "none";
  return false;
}

$(function(){
    $('#js-popup-bg').click(function(){
        $("body").removeClass("ofHidden");
        $('.js-popup').css("display","none");
        $(this).css("display","none");
      });
});
 
// 팝업 드래그(jquery ui 파일이 연결되어 있어야함.)
//$( ".dispay_view1" ).draggable();
 
/*윈도우팝업 공통 class로 닫기 처리 - 닫기버튼에 window_close 추가*/
$(function(){
    $('.window_close').click(function(){
        window.open('about:blank', '_self').close();
    })
});

$(function() {
    var dates = $( "#from1, #to1" ).datepicker({
        changeMonth: true,
        changeYear: true,
        showOn: "button",
        buttonImage: "/images/sub/icon_calendar.gif",
        buttonImageOnly: true,
        onSelect: function( selectedDate ) {
            var option = this.id == "from1" ? "minDate" : "maxDate",
            instance = $( this ).data( "datepicker" ),
            date = $.datepicker.parseDate(
                instance.settings.dateFormat ||
                $.datepicker._defaults.dateFormat,
                selectedDate, instance.settings );
            dates.not( this ).datepicker( "option", option, date );
        }
    });
});

var _uri;
_uri = document.location.href.split("?")[0];

function setChk(){
	$('#useridchk').val("");
}

function checkId(){
	if($('#userid').val().trim() == ""){
		alert("아이디를 입력해주세요.");
		$('#userid').val("");
		$('#userid').focus();
		return false;
	}
	var data = {
			userid: $('#userid').val()
    	};

    $.ajax({
        type: 'POST',
        url: "/environment/useridchk",
        dataType: 'text',
        contentType:'application/json; charset=utf-8',
        data: JSON.stringify(data)
    }).done(function(data) {
    	if(data > 0){
    		alert("이미 사용중인 아이디 입니다.");
    		setChk();
    	}else{
    		alert("사용 가능한 아이디 입니다.");
    		$('#useridchk').val("Y");
    	}
    }).fail(function (error) {
    	alert(error);
    });
}

function userRegist(){
	
	if($('#userid').val().trim() == ""){
		alert("아이디를 입력해주세요.");
		$('#userid').val("");
		$('#userid').focus();
		return false;
	}
	if($('#userpass').val().trim() == ""){
		alert("비밀번호를 입력해주세요.");
		$('#userpass').val("");
		$('#userpass').focus();
		return false;
	}
	if($('#userpassre').val().trim() == ""){
		alert("비밀번호 재확인을 입력해주세요.");
		$('#userpassre').val("");
		$('#userpassre').focus();
		return false;
	}
	if($('#userpass').val().trim() != $('#userpassre').val().trim()){
		alert("비밀번호가 다릅니다. 다시 입력해주세요.");
		$('#userpassre').val("");
		$('#userpassre').focus();
		return false;
	}
	if($('#username').val().trim() == ""){
		alert("이름을 입력해주세요.");
		$('#username').val("");
		$('#username').focus();
		return false;
	}
	
	if($('#useridchk').val().trim() == ""){
		alert("아이디 중복체크를 해주세요.");
		$('#userid').focus();
		return false;
	}
	
	var data = {
			userid: $('#userid').val(),
			userpass: $('#userpass').val(),
			username: $('#username').val(),
			userrole: $('#userrole').val(),
			userpart: $('#userpart').val(),
			userhp: $('#userhp').val(),
			usertel: $('#usertel').val(),
			useremail: $('#useremail').val(),
			usersms: $('input[name="usersms"]:checked').val()
    	};

    $.ajax({
        type: 'POST',
        url: "/environment/userinfo",
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

function userEdit(){
	
	if($('#userid').val().trim() == ""){
		alert("아이디를 입력해주세요.");
		$('#userid').val("");
		$('#userid').focus();
		return false;
	}
	if($('#username').val().trim() == ""){
		alert("이름을 입력해주세요.");
		$('#username').val("");
		$('#username').focus();
		return false;
	}
	
	var data = {
			id: $('#id').val(),
			userid: $('#userid').val(),
			userpass: $('#userpass').val(),
			username: $('#username').val(),
			userrole: $('#userrole').val(),
			userpart: $('#userpart').val(),
			userhp: $('#userhp').val(),
			usertel: $('#usertel').val(),
			useremail: $('#useremail').val(),
			usersms: $('input[name="usersms"]:checked').val()
	};
	
	$.ajax({
		type: 'PUT',
		url: "/environment/userinfo",
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

function userDelete(){
	var id = $('#id').val();
	console.log("id : " + id);
    if(!confirm("정말 삭제하시겠습니까? 삭제된 데이터는 복구 하실 수 없습니다.")){
    	return false;
    }
    $.ajax({
    	 type: 'DELETE',
         url: "/environment/userinfo/"+id,
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

function logout(){
	$.ajax({
		type: 'POST',
		url: "/environment/userlogout",
		dataType: 'text',
		contentType:'application/json; charset=utf-8',
	}).done(function(data) {
		//alert(data);
		location.reload();
	}).fail(function (error) {
		alert(error);
	});
	
}