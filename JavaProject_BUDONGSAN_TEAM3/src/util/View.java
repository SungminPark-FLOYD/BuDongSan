package util;

public enum View {
	HOME,					//기본화면
	
	//관리자 -> 공지사항
	BOARD_LIST,				//공지사항 조회
	BOARD_DETAIL,			//공지사항 상세조회
	BOARD_UPDATE,			//공지사항 수정
	BOARD_DELETE,			//공지사항 삭제
	BOARD_INSERT,			//공지사항 입력
	BOARD,
	
	//관리자 -> 회원/매물 정보 수정
	MAN_PRO_DELETE,			//허위매물 삭제
	MAN_MEM_DELETE,			//회원 상태 관리

	//메인화면 -> 검색
	PRO_SEARCH,				//검색	
	PRO_DETAIL,				//상세 조회	
	
	//회원페이지
	PRO_INSERT,				//방 내놓기	
	PRO_UPDATE,				//방 정보 변겅
	PRO_DELETE,				//방 정보 삭제
	MEM_INFO,				//회원정보출력
	MEM_INFO_UPDATE,		//회원 정보 수정
	MEM_DELETE,				//회원탈퇴
	
	//상세 검색 -> 관심등록 / 방문예약
	MEM_CART,				//관심목록 등록
	MEM_CART_DELETE,		//관심목록 취소
	MEM_CART_LIST,			//관심목록 리스트
	
	MEM_RES,				//방문예약
	MEM_RES_DELETE,			//방문예약 취소		
	MEM_RES_LIST,			//방문예약 리스트
	
	MEM_SALE_LIST,			//판매 목록
	MEM_BOARD_DETAIL,
	
	//메인화면에서 로그인 또는 방문예약/관심등록시 로그인 페이지 이동
	MEM_LOGIN,				//회원 로그인
	
	//메인화면에서 공인중개사/관리자 로그인 페이지
	AGENT_LOGIN,			//공인 중개사 로그인
	MANAGER_LOGIN,			//관리자 로그인
	
	//공인중개사 페이지에서 확인 가능
	AGENT_RES,				//방문예약 회원목록 확인?
	
	AGENT_HOME,				//공인중개사 메인화면
	MEMBER_HOME,			//회원 메인 화면
	MANAGER_HOME,			//관리자 메인 화면
	
	MEM_SIGNUP,				//회원 가입
	AGENT_SIGNUP,
	AGENT_INFO,
	AGENT_INFO_UPDATE,
	AGENT_DELETE,
	
	AGENT_LIST,;

					//관리매물 리스트
	//공인중개사 가입
	
	
}
