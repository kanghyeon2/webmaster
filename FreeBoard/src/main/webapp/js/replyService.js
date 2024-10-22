/**
 * replyService.js
 * 메소드: 목록, 등록, 삭제
 */
const svc = {
	replylist(bno = 1, succeessFnc, errorFnc) { //목록
		// Ajax 호출
		fetch('replyList.do?bno=' + bno)
			.then(resolve => resolve.json())
			.then(succeessFnc)
			.catch(errorFnc)

	}
}