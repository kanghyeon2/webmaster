<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src='./dist/index.global.js'></script>
<script>
   let eventData=[];

    document.addEventListener('DOMContentLoaded', async function() { // async 함수가 있어야 await 실행가능
    var calendarEl = document.getElementById('calendar');
	
    // Ajax 호출
    //new Promise(function(){}, function(){})
    // 프라미스 객체가 반환될 때 await 수행코드 -> 그 다음 코드 실행
    let resolve = await fetch('eventList.do')
	let result=	await resolve.json();	//.then(resolve => resolve.json())
 	eventData = result;					//.then(result => {
 										//eventData = result;
 										//})
 										// .catch(err => console.log(err));
     console.log(result); 		
    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      initialDate: '2024-10-24',
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectMirror: true,

      select: function(arg) {
        var title = prompt('Event Title:');
        if (title) {
        	console.log(arg);
        	//title, start, end값
        	//start of 화면출력
        	console.log(title)
       fetch('addEvent.do?title='+ title +'&start='+arg.startStr+'&end='+arg.endStr)
		.then(resolve => resolve.json())
      		.then(result => {
        	if(result.retCode == 'OK'){
        	alert('굿')
		          	calendar.addEvent({
		            title: title,
		            start: arg.start,
		            end: arg.end,
		            allDay: arg.allDay
		          }) //end of 화면출력
      		}else if(result.retCode =='FAIL'){
      			alert('실패')
      		}
        })
            .catch(err => console.log(err));
        }
        calendar.unselect()
      },
     
      eventClick: function(arg) { 
    	  console.log(arg.event._def.title);
    	  
    		 if (confirm('Are you sure you want to delete this event?')) {
         	 arg.event.remove()
    	  fetch('removeEvent.do?title=' + arg.event._def.title)
    	  .then(resolve => resolve.json())
    	  		.then(result => {
    		  	if(result.retCode == 'OK'){
    		  		alert('완');
    	 		}else if(result.retCode =='FAIL'){
    			alert('실패')
    	 		}
    	  })

        .catch(err => console.log(err))
    		 }
      },
      editable: true,
      dayMaxEvents: true, // allow "more" link when too many events
      events: eventData
    });

    calendar.render();//화면출력
      		})
      		


</script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 1100px;
	margin: 0 auto;
}
</style>
</head>
<body>

	<div id='calendar'></div>

</body>
</html>
