/**
 * jreply.js
 */

 console.log('start')
 
 //jquery방식 Ajax호출
 $.ajax('replyList.do?bno='+bno+'&page=1')
 .done(function(result){
	 console.log(result);
	 result.forEach((item)=> {
		 $('<li />').append(
			 $('<span />').addClass('col-sm-2').text(item.replyNo),
			 $('<span />').addClass('col-sm-5').text(item.reply),
			 $('<span />').addClass('col-sm-2').text(item.replyer),
			 $('<span />').addClass('col-sm-2').append($('<button>삭제</button>'))
			 )
		 	.appendTo($('div.content ul'));
	 });

 })
 .fail(function(err){
	 console.log(err);
 })
 
	 //삭제이벤트
	 $('div.content ul').on('click', 'button' ,function(e){
		 //$(e.target).parent().parent().remove();
		let	rno = ($(e.target).parent().parent().find('span:eq(0)').text())
		 
		 $.ajax({
			 url: 'removeReply.do',
			 data:{rno: rno},
			 method :'get',
			 dataRype : 'json'  //문자열 => 자바스크립트 객체
		 }) //삭제
		 .done(function(result){
			 if(result.retCode=='OK'){
				 $(e.target).closest('li').remove()
			 } 
		 })
		 $(e.target).closest('li').remove();
	 })
	  .fail(function(err){
	 console.log(err);
 })
 
 //등록이벤트
 $("#addReply").on('click', function(e){	
	 	 var reply = $('#reply').val(); 
	$.ajax({
		url: 'addReply.do',
		data:{bno:bno, reply: reply, replyer: logId },
		method : 'post',
		dataRype : 'json'
	})
	.done(function(result){
		if(result.retCode=='OK'){
			let item = result.retVal;
		 $('<li />').append(
			 $('<span />').addClass('col-sm-2').text(item.replyNo),
			 $('<span />').addClass('col-sm-5').text(item.reply),
			 $('<span />').addClass('col-sm-2').text(item.replyer),
			 $('<span />').addClass('col-sm-2').append($('<button>삭제</button>'))
			 )
		 	.insertAfter($('div.content ul li:eq(0)'));
	 }

 })
 .fail(function(err){
	 console.log(err);
 })
 })