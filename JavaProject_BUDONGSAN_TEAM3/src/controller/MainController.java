package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import print.Print;
import service.PropertyService;
import util.ScanUtil;
import util.View;
import vo.MemberVo;
import vo.PropertyVo;

public class MainController extends Print{
	static public Map<String, Object> sessionStorage = new HashMap<>();
	
	ManagerController managerController = new ManagerController();
	MemberController memberController = new MemberController();
	AgentController agentController = new AgentController();
	
	public static void main(String[] args) {
		new MainController().start();
	}
	
	private void start() {
		View view = View.HOME;
		while (true) {
			switch (view) {
			case HOME:
				view = home();
				break;	
				
				//메인
			case PRO_SEARCH:
				view = proSearch();
				break;
			case PRO_DETAIL:
				view = proDetail();
				break;
			case MEM_LOGIN:
				view = memberController.memLogin();
				break;
			case MEM_SIGNUP:
				view = memberController.memSignup();
				
				//회원
			case MEMBER_HOME:
				view = memberController.memberHome();
				break;
			case MEM_CART:
				view = memberController.memCart();
				break;
			case MEM_RES:
				view = memberController.memRes();
				break;
			case MEM_INFO:
				view = memberController.memInfo();
				break;
			case MEM_INFO_UPDATE:
				view = memberController.memInfoUpdate();
				break;
			case PRO_INSERT:
				view = memberController.proInsert();
				break;
			case MEM_DELETE:
				view = memberController.memDelete();
				break;
			case MEM_CART_LIST:
				view = memberController.memCartList();
				break;			
			case MEM_CART_DELETE:
				view = memberController.memCartDelete();
				break;
			case MEM_RES_LIST:
				view = memberController.memResList();
				break;
			case MEM_RES_DELETE:
				view = memberController.memResDelete();
				break;
			case MEM_SALE_LIST:
				view = memberController.memSaleList();
				break;
			case MEM_BOARD_DETAIL:
				view = memberController.memBoardDetail();
				break;
				
				//공인중개사
			case AGENT_HOME:
				view = agentController.agentHome();
				break;
			case AGENT_LOGIN:
				view = agentController.agentLogin();
				break;
			case AGENT_SIGNUP:
				view = agentController.agentSignup();
				break;
			case AGENT_INFO:
				view = agentController.agentInfo();
				break;
			case AGENT_INFO_UPDATE:
				view = agentController.agentInfoUpdate();
				break;
			case AGENT_DELETE:
				view = agentController.agentDelete();
				break;
			case AGENT_RES:
				view = agentController.agentResList();
				break;
			case AGENT_LIST:
				view = agentController.agentProList();
				break;
				
				//관리자
			case MANAGER_LOGIN:
				view = managerController.managerLogin();
				break;
			case MANAGER_HOME:
				view = managerController.manager();
				break;
			case MAN_MEM_DELETE:
				view = managerController.memDelete();
				break;
			case MAN_PRO_DELETE:
				view = managerController.proDelete();
				break;
			case BOARD:
				view = managerController.board();
				break;
			case BOARD_INSERT:
				view = managerController.boardInsert();
				break;
			case BOARD_LIST:
				view = managerController.boardList();
				break;
			case BOARD_DETAIL:
				view = managerController.boardDetail();
				break;
			case BOARD_UPDATE:
				view = managerController.boardUpdate();
				break;
			case BOARD_DELETE:
				view = managerController.boardDelete();
				break;
			default:
				break;
			}
		}
	}
	
	private View DetailSelect() {
		
		String pro_no;
		while(true) {
			pro_no = ScanUtil.nextLine("상세 검색할 매물 번호를 입력하세요 >> ");
			boolean proChk = memberService.getProNum(pro_no);	
			if(proChk) break;
			
			System.out.println("매물 번호 형식에 맞게 입력해 주세요!!");
			
		}
		
		
		PropertyVo proVo = propertyService.searchDetail(pro_no);	
		
		printProDetailTitle();
		
		sessionStorage.put("proVo", proVo);
						
		
		return View.PRO_DETAIL;
	}

	private View proDetail() {
		
		PropertyVo proVo = (PropertyVo) sessionStorage.get("proVo");	
		searchDetail(proVo);
		
		proDetailMenu();
		
		int sel = ScanUtil.nextInt("메뉴 선택 >> ");
		switch(sel) {		
		case 1 :
			sessionStorage.put("a1", sel);
			return searchDetailOK();
		case 2 :
			sessionStorage.put("a1", sel);
			return searchDetailOK();
		case 3 :
			if(sessionStorage.containsKey("member")) return View.MEMBER_HOME;
			
			return View.HOME;
		default : 
			return View.PRO_DETAIL;
		}
		
	}

	private View proSearch() {	
		List<Object> searchList = new ArrayList<Object>();
		searchList = searchMenu();
		
		List<PropertyVo> searchResult = propertyService.searchListService(searchList);
		
		if(searchResult.size() == 0) {
			printProSearch();
			return View.PRO_SEARCH;
		}
		
		searchResult(searchResult);
		proSearchMenu();
		int sel = ScanUtil.nextInt("메뉴 선택 >> ");
		switch(sel) {
		case 1:
			return DetailSelect();
		case 2:
			if(sessionStorage.containsKey("member")) {
				return View.MEMBER_HOME;
			}
			else {			
				return View.HOME;
			}
		default :
			return View.PRO_SEARCH;
		}
	}


	private View home() {
		// 로딩창 추 후 작업 예정.
//		printLogining();
		printMain();
		printHome();
		int sel = ScanUtil.nextInt("메뉴 선택 >> ");
		switch(sel) {
		case 1:
			return View.PRO_SEARCH;
		case 2:
			return View.MEM_LOGIN;			
		case 3:
			return View.MEM_SIGNUP;
		case 4:
			return View.AGENT_LOGIN;
		case 5:
			return View.AGENT_SIGNUP;
		case 6:
			return View.MANAGER_LOGIN;
		default :
			return View.HOME;
		}
		
	}
	
	public View searchDetailOK() {
		MemberVo member = (MemberVo) sessionStorage.get("member");
		//로그인 확인
		if(member == null) {
			//로그인하고 다시 돌아오기
			sessionStorage.put("View", View.PRO_DETAIL);
			return View.MEM_LOGIN;
		}
		
		int selDetail = (int) sessionStorage.get("a1");
		
		if(selDetail == 1) {
			return View.MEM_CART;
		}
		else if(selDetail == 2) {
			return View.MEM_RES;
		}
		
		return null;
		
	}
	
	//검색 메뉴
	public List<Object> searchMenu() {
		String category = null, type = null, reg = null;
		List<Object> param = new ArrayList<Object>();
		
		//배열 사용
		int typeSel = ScanUtil.nextInt("검색할 매매 분류 : 1. 월세 / 2. 전세/ 3.매매");
		switch (typeSel) {
		case 1:
			type = "월세";
			break;
		case 2:
			type = "전세";
			break;
		case 3:
			type = "매매";
			break;
		default:
			break;
		}
		
		int cateSel = ScanUtil.nextInt("검색할 매물 우형 : 1. 아파트 / 2. 오피스텔 / 3. 주택");
		switch (cateSel) {
		case 1:
			category = "아파트";
			break;
		case 2:
			category = "오피스텔";
			break;
		case 3:
			category = "주택";
			break;
		default:
			break;
		}
		
		System.out.println("검색할 지역");
	    reg = ScanUtil.nextLine("지역>>");
	    
	    param.add(type);
	    param.add(category);
	    param.add(reg);
	    
	    return param;

	}
	
}
