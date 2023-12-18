package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import print.Print;
import util.ScanUtil;
import util.View;
import vo.BoardVo;
import vo.ManagerVo;
import vo.MemberVo;
import vo.PropertyVo;

public class ManagerController extends Print{
	
	public static Map<String, Object> sessionStorage = MainController.sessionStorage;
	
	public View memDelete() {
		printMemDelete();
		List<MemberVo> memberList = managerService.memList();
		printMemberList(memberList);
		
		String mem_no;
		while(true) {
			mem_no = ScanUtil.nextLine("휴먼계정으로 변경 할 회원닉네임 입력 >> ");		
			boolean memChk = managerService.getMemNo(mem_no);
			if(memChk) break;
			
			System.out.println("해당 닉네임은 존재하지 않습니다!!");
		}
		
		managerService.memDelete(mem_no);
		System.out.printf(" [ %s ] 의 회원이 휴먼계정으로 전환되었습니다.\n",mem_no);
		return View.MANAGER_HOME;
	}
	
	public View proDelete() {
		List<PropertyVo> proVo = propertyService.printPro();
		sessionStorage.put("proList", proVo);
		printProList(proVo);
		
		printProDelete();
		int sel = ScanUtil.nextInt("메뉴선택 >> ");		
		switch(sel) {
		case 1:
			return DetailSelect();
		case 2:
			return View.MANAGER_HOME;
		default :
			return View.PRO_DELETE;				
		}
		
	}
	
	private View DetailSelect() {
		String pro_no;
		while(true) {
		    pro_no = ScanUtil.nextLine("상세 검색할 매물 번호를 입력하세요>> ");
			boolean proChk = memberService.getProNum(pro_no);
			System.out.println("매물번호 형식에 맞게 입력해 주세요!!");
			
			if(proChk) break;
		}
			
		PropertyVo proVo = propertyService.searchDetail(pro_no);		
		System.out.println("상세 검색 결과");	
		searchDetail(proVo);	
		String yn = ScanUtil.nextLine("정말 삭제하시겠습니까?(Y/N)");		
		while(true) {
			if(yn.equalsIgnoreCase("y")) {
				propertyService.proDelete(pro_no);			
				System.out.printf(" [ %s ] 번의 허위매물이 삭제되었습니다.\n",pro_no);
				break;
			}
			else if(yn.equalsIgnoreCase("n")) return View.MANAGER_HOME;
			
			else if(!yn.equalsIgnoreCase("y") || !yn.equalsIgnoreCase("n")) {
				yn = ScanUtil.nextLine("다시 입력 해 주세요!!(Y/N)");
			}
		}
		
		
		ScanUtil.nextLine("돌아가려면 엔터를 입력하세요.");
		
		return View.MANAGER_HOME;
		
	}
	
	public View boardDelete() {
		List<BoardVo> boardList = boardService.boardList();
		printBoardList(boardList);
		int sel = ScanUtil.nextInt("삭제 할 공지사항 번호 입력 >> ");
		boardService.boardDelete(sel);
		System.out.printf("[ %d ] 번의 공지사항이 삭제되었습니다.\n",sel);
		return View.BOARD;
	}
	public View boardUpdate() {
		List<BoardVo> boardList = boardService.boardList();
		printBoardList(boardList);
		int sel = ScanUtil.nextInt("수정 할 공지사항 번호 입력 >> ");
		
		List<Object> param = new ArrayList();
		String title = ScanUtil.nextLine("제목 >> ");
		String content = ScanUtil.nextLine("내용 >> ");
		
		param.add(title);
		param.add(content);
		boardService.boardUpdate(param,sel);
		
		System.out.printf("공지사항이 수정되었습니다.\n");
		
		return View.BOARD;
	}
	// 매니저 공지사항 상세보기
	public View boardDetail() {
		int sel = ScanUtil.nextInt("상세 조회 할 공지사항 번호 >> ");
		List<BoardVo> boardDetail = boardService.boardDetail(sel);
		printBoardDetail(boardDetail);
		ScanUtil.nextLine("이전 화면 으로 돌아가려면 엔터를 입력하세요");
		return View.BOARD;
	}
	
	public View boardList() {
		List<BoardVo> boardList = boardService.boardList();
		printBoardList(boardList);
		
		if(!sessionStorage.containsKey("manager")) {
			return View.MEM_BOARD_DETAIL;
			
		}else if(sessionStorage.containsKey("manager")) {
			printBoardMenu();
			int sel = ScanUtil.nextInt("메뉴 입력 >> ");
			
			switch (sel) {
			case 1:
				return View.BOARD_DETAIL;
			case 2:
				return View.BOARD_INSERT;
			case 3:
				return View.BOARD_UPDATE;
			case 4:
				return View.BOARD_DELETE;
			case 5:
				return View.MANAGER_HOME;
			default:
				System.out.println("잘못 입력하셨습니다.");
				return View.BOARD;
			}
		}
		return null;
	}
	public View boardInsert() {
		System.out.println("공지사항 입력 [ 작성중 ]");
		List<Object> param = new ArrayList();
		String title = ScanUtil.nextLine("제목 >> ");
		String content = ScanUtil.nextLine("내용 >> ");
		
		ManagerVo manager = (ManagerVo) sessionStorage.get("manager");
		String manager_no = manager.getManager_no();
		String manager_nick = manager.getManager_nick();
		
		param.add(manager_no);
		param.add(manager_nick);
		param.add(title);
		param.add(content);
		
		boardService.boardInsert(param);
		
		System.out.println("공지사항이 등록되었습니다.");
		
		return View.BOARD;
	}


	public View board() {
		printBoard();
		int sel = ScanUtil.nextInt("메뉴 입력 >> ");
		
		switch (sel) {
		case 1:
			return View.BOARD_LIST;
		case 2:
			return View.BOARD_INSERT;
		case 3:
			return View.BOARD_UPDATE;
		case 4:
			return View.BOARD_DELETE;
		case 5:
			return View.MANAGER_HOME;
		default:
			System.out.println("잘못 입력하셨습니다.");
			return View.BOARD;
		}
	}
	public View manager() {
		printManager();
		int sel = ScanUtil.nextInt("메뉴선택 >> ");
		switch (sel) {
		case 1:
			return View.MAN_PRO_DELETE;
		case 2:
			return View.MAN_MEM_DELETE;
		case 3:
			return View.BOARD;
		case 4:
			// 관리자가 작성한 모든 내용 삭제
			sessionStorage.clear();
			return View.HOME;
		default:
			System.out.println("잘못 입력하셨습니다.");
			return View.MANAGER_HOME;
		}
	}
	public View managerLogin() {
		List<Object> param = new ArrayList();
		printLogin();
		String id = ScanUtil.nextLine("ID 입력 >> ");
		String pass = ScanUtil.nextLine("PASS 입력 >> ");
		param.add(id);
		param.add(pass);
		
		managerService.managerLogin(param);
		
		
		ManagerVo manager = (ManagerVo) sessionStorage.get("manager");
		
		if(manager != null) {
			return View.MANAGER_HOME;
		}else {
			System.out.println("아이디 또는 비밀번호를 잘못 입력하셨습니다.");
			return View.MANAGER_LOGIN;
		}
	}
}
