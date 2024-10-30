/**
 * replyService.js
 * 메소드: 목록, 등록, 삭제
 */
const svc = {
	replylist(param= {bno ,page}, successFnc, errorFnc) { //목록
		// Ajax 호출
		fetch('replyList.do?bno=' + param.bno + '&page=' + param.page)
			.then(resolve => resolve.json())
			.then(successFnc)
			.catch(errorFnc)

	},

	//2 삭제
	
	removeReply(rno= 1, successFnc, errorFnc){ //목록
		// Ajax 호출
		fetch('removeReply.do?rno=' + rno)
			.then(resolve => resolve.json())
			.then(successFnc)
			.catch(errorFnc)

	},
	// 3.추가
	addReply(param = {bno, reply, replyer},successFnc, errorFnc){
		// Ajax 호출
		fetch('addReply.do?bno='+param.bno+'&reply='+param.reply+'&replyer='+param.replyer)
			.then(resolve => resolve.json())
			.then(successFnc)
			.catch(errorFnc)
	},
	//4.댓글카운트
	getReplyCount(bno=1, successFnc, errorFnc){
		fetch('replyCount.do?bno=' + bno)
			.then(resolve => resolve.json())
			.then(successFnc)
			.catch(errorFnc)
	}
}