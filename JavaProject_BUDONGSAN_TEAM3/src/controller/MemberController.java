package controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import print.Print;

import util.ScanUtil;
import util.View;
import vo.AgentVo;
import vo.BoardVo;
import vo.CartVo;
import vo.MemSaleVo;
import vo.MemberVo;
import vo.PropertyVo;
import vo.ReservationVo;

public class MemberController extends Print{
	public static Map<String, Object> sessionStorage = MainController.sessionStorage;
	
	
		
	public View memberHome() {
		
		printMemberHome();
		
		int sel = ScanUtil.nextInt("메뉴 선택>> ");
		switch(sel) {
		case 1:
			return View.PRO_SEARCH;
		case 2:
			return View.MEM_INFO;
		case 3:
			return View.PRO_INSERT;
		case 4:
			return View.BOARD_LIST;
		case 5:
			return View.MEM_CART_LIST;
		case 6:
			return View.MEM_RES_LIST;
		case 7:
			return View.MEM_SALE_LIST;
		case 8:
			sessionStorage.clear();
			System.out.println("로그아웃 되었습니다.");
			return View.HOME;
		default :
			return View.MEMBER_HOME;
			
		}
		
	}
	
	public View memBoardDetail() {
		int sel = ScanUtil.nextInt("상세 조회 할 공지사항 번호 >> ");
		List<BoardVo> boardDetail = boardService.boardDetail(sel);
		printBoardDetail(boardDetail);
		ScanUtil.nextLine("이전 화면 으로 돌아가려면 엔터를 입력하세요");
		return View.MEMBER_HOME;
	}

	public View memInfoUpdate() {
		printInfoUpdate();
		MemberVo mem = (MemberVo) sessionStorage.get("member");
		String mem_no = mem.getMem_no();
		
		String pw;
		String nn;
		String nm;
		String tel;
		List<Object> param = new ArrayList<Object>();		
		while(true){
			pw = ScanUtil.nextLine("비밀번호 >> ");
			boolean pwPass = memberService.pwChk(pw);
			if(pwPass) break;
		}
		param.add(pw);
		while (true) {
			nn = ScanUtil.nextLine("닉네임 >> ");
			boolean nnPass = memberService.nnChk(nn);
			if(nnPass) break;
		}
		param.add(nn);
		while(true) {
			nm = ScanUtil.nextLine("이름 >> ");
			boolean nmPass = memberService.nmChk(nm);
			if(nmPass) break;
		}
		param.add(nm);
		while(true) {
			tel = ScanUtil.nextLine("전화번호 >> ");
			boolean telPass = memberService.telChk(tel);
			if(telPass) break;
		}
		param.add(tel);
		param.add(mem_no);
		memberService.updateInfo(param);
		
		ScanUtil.nextLine("회원 정보가 수정 되었습니다.(enter)");
		
		System.out.println("1. 회원정보 수정");
		System.out.println("2. 회원메뉴 돌아가기");
		
		int sel = ScanUtil.nextInt("메뉴 선택");
		switch (sel) {
		case 1:
			return View.MEM_INFO;
		case 2:
			return View.MEMBER_HOME;
		default:
			return View.MEM_INFO;
		}
	}
	
	public View memInfo() {
		MemberVo mem = (MemberVo) sessionStorage.get("member");
		String mem_no = mem.getMem_no();
		
		MemberVo memVo = memberService.memInfo(mem_no);

		printMemInfo(memVo);
		
		printMemInfoMenu();
		
		int sel = ScanUtil.nextInt("메뉴 선택 >> ");
		switch (sel) {
		case 1:
			return View.MEM_INFO_UPDATE;
		case 2:
			return View.MEM_DELETE;
		case 3:
			return View.MEMBER_HOME;
		default:
			return View.MEM_INFO;
		}
	}

	public View memLogin() {
		printLogin();
		String id   = ScanUtil.nextLine("ID >> ");
		String pass = ScanUtil.nextLine("pass >> ");
		
		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pass);
		
		boolean memlogin = memberService.memLogin(param);
		if(!memlogin) {
			printMemberLogin();
			int sel = ScanUtil.nextInt("메뉴 선택 : ");
			switch (sel) {
			case 1:
				return View.MEM_LOGIN;
			case 2:
				return View.MEM_SIGNUP;
			default:
				return View.MEM_LOGIN;
			}
		}
		
		MemberVo member =  (MemberVo) sessionStorage.get("member");
		
		System.out.println("\n [ "+member.getMem_name()+" ]님 환영합니다.");
		
		View view = (View) sessionStorage.get("View");
		if(view == null) return View.MEMBER_HOME;
		
		return view;
	}

	public View memCart() {
		List<Object> param = new ArrayList<Object>();
		MemberVo member = (MemberVo) sessionStorage.get("member");		 
		PropertyVo proVo = (PropertyVo) sessionStorage.get("proVo");
		
		param.add(member.getMem_no());
		param.add(proVo.getPro_no());
		
		memberService.updateCart(param);
		
		printMemCart();
		
		ScanUtil.nextLine("엔터 입력시 관심목록 리스트로 돌아감");
		
		return View.MEM_CART_LIST;
	}

	public View memCartList() {
		printMemCartPR();
		
		MemberVo member = (MemberVo) sessionStorage.get("member");	
		
		List<CartVo> cartList = memberService.cartList(member.getMem_no());
		
		printMemCartList(cartList);

		int sel = ScanUtil.nextInt("메뉴 선택>> ");
		switch (sel) {
		case 1:
			return View.MEM_CART_DELETE;
		case 2:
			return View.MEMBER_HOME;
		default:
			return View.MEM_CART_LIST;
		}
		
	}
	
	public View memCartDelete() {
		System.out.println("관심목록 삭제");
		MemberVo mem = (MemberVo) sessionStorage.get("member");
		List<Object> param = new ArrayList<Object>();
		
		String mem_no = mem.getMem_no();
		String pro_no = ScanUtil.nextLine("관심목록 삭제할 매물 번호 입력>> ");
		
		param.add(mem_no);
		param.add(pro_no);
		
		memberService.deleteCart(param);
		
		System.out.println("삭제 되었습니다.");
		ScanUtil.nextLine("엔터누르면 홈으로 감");
		return View.MEMBER_HOME;
	}

	public View memRes() {
		System.out.println("방문예약 등록");
		
		List<Object> param = new ArrayList<Object>();
		MemberVo member = (MemberVo) sessionStorage.get("member");		 
		PropertyVo proVo = (PropertyVo) sessionStorage.get("proVo");
		
		Date currentTime = new Date();
		String today = format.format(currentTime);
		List<Object> dateParam = new ArrayList<Object>();
		while(true) {
			String resDate = ScanUtil.nextLine("방문예약할 날짜를 입력해주세요 ex)2023-12-25 : ");
			
	        int compare = resDate.compareTo(today);
	        
	        if (compare < 0) {
	            System.out.println("이미 지난 날짜 입니다. 다시 입력해주세요.");
	            return View.MEM_RES;
	        }
	        
	     // 기존 예약중 입력 받은 룸넘버와 숙박 날짜와 같은 예약이 있으면 -1을 반환한다.
	        int checkBookingPossible = checkBookingPossible(resDate);

	        if(checkBookingPossible == -1){
	            System.out.println("해당 날짜는 이미 예약이 완료되었습니다.");
	            return View.MEM_RES;
	        }
	        
	        System.out.println("예약이 완료 되었습니다.");

	        String resDay = resDate.replace("-", "");
			
			dateParam.add(member.getMem_no());
			dateParam.add(proVo.getPro_no());
			dateParam.add(resDay);
			dateParam.add(proVo.getPro_no());
			
			
	        memberService.resUpdate(dateParam);
	        break;
		}
        
	
		return View.MEMBER_HOME;
	}
	
	public int checkBookingPossible(String resDate) {
		List<ReservationVo> resList = memberService.printRes();
		
        for (ReservationVo rv : resList) {
            Date d = rv.getReserv_date();
            String dayformat = format.format(d);
            if (dayformat.equals(resDate)) {
                return -1;
            }
        }
        return 1;
    }

	public View memResList() {
		MemberVo mem = (MemberVo) sessionStorage.get("member");
		String mem_no = mem.getMem_no();
		System.out.println("회원의 방문예약 리스트");
		List<ReservationVo> resList = memberService.printRes(mem_no);
		
		printMemResList(resList);
		
		int sel = ScanUtil.nextInt("메뉴 선택>> ");
		switch (sel) {
		case 1:
			return View.MEM_RES_DELETE;
		case 2:
			return View.MEMBER_HOME;
		default:
			return View.MEM_RES_LIST;
		}
	}
	
	public View memResDelete() {
		System.out.println("방문예약 취소");
		
		MemberVo mem = (MemberVo) sessionStorage.get("member");
		List<Object> param = new ArrayList<Object>();
		
		String mem_no = mem.getMem_no();		
		String pro_no = ScanUtil.nextLine("방문예약을 취소할 매물 번호를 입력하세요");
		
		param.add(mem_no);
		param.add(pro_no);
		
		
		memberService.deleteRes(param);
		
		System.out.println("취소 완료");
		
		ScanUtil.nextLine("엔터누르면 홈으로 감");
		return View.MEMBER_HOME;
	}

	public View proInsert() {
		System.out.println("매물 등록");
		
		MemberVo mem = (MemberVo) sessionStorage.get("member");
		String mem_no = mem.getMem_no();
		List<Object> insertPro = insertMenu();	
		
		propertyService.insertPro(insertPro, mem_no);
				
		
		System.out.println("매물 등록이 완료되었습니다.");
		return View.MEMBER_HOME;
	}
	
	public List<Object> insertMenu() {
		PropertyVo proVo = propertyService.getProNo();
		String pro_no = proVo.getPro_no();
		
		List<Object> param = new ArrayList<Object>();
		String type = null, category = null, agent_no = null;
		
		int tpSel;
		do {
			tpSel = ScanUtil.nextInt("1. 월세 / 2. 전세 / 3. 매매 >>");
			
			switch (tpSel) {
			case 1:
				type = "월세";
				break;
			case 2:
				type = "전세";
				break;
			case 3:
				type = "매매";
				break;
			default :
				System.out.println("다시 입력해 주세요.");
			}
		}
		while(tpSel > 3);
		
		int cateSel;
		do {
			cateSel = ScanUtil.nextInt("1. 아파트 / 2. 오피스텔 / 3. 주택");
			
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
			default :
				System.out.println("다시 입력해 주세요.");
			}
		}
		while(cateSel > 3);
		
		String addr = ScanUtil.nextLine("주소를 입력해 주세요>>");
		BigDecimal pro_size = ScanUtil.nextBig("평수를 입력해 주세요 >>"); 
		String pro_tag = ScanUtil.nextLine("간단한 설명을 작성해 주세요 >>");
		String pro_content = ScanUtil.nextLine("자세한 설명을 입력해 주세요 >> ");
		String pro_price = ScanUtil.nextLine("가격을 입력해 주세요 >>");
		
		List<AgentVo> agentList = agentService.agentList();
		
		for (AgentVo agentVo : agentList) {
			
			String agentNo = agentVo.getAgent_no();
			String agent_name = agentVo.getAgent_name();
			String agent_content = agentVo.getAgent_content();
			
			System.out.println("[" + agentNo + "]" + "\t" + agent_name + "\t" + agent_content);

		}
		
		while(true) {
			agent_no = ScanUtil.nextLine("공인중개사 번호를 선택해 주세요 >> ");			
			boolean agentChk = memberService.getAgentNum(agent_no);
			if(agentChk) break;
			
			System.out.println("해당 공인중개사는 존재하지 않습니다!!");
		}
		
		
		param.add(pro_no);
		param.add(type);
		param.add(category);
		param.add(agent_no);
		param.add(addr);
		param.add(pro_size);
		param.add(pro_tag);
		param.add(pro_content);
		param.add(pro_price);
		
		
		
		return param;
		
	}

	public View memSignup() {
		printSignup();
		String id;
		String pw;
		String nn;
		String nm;
		String tel;
		List<Object> param = new ArrayList<Object>();
		while (true) {
			id = ScanUtil.nextLine("아이디 : ");
			boolean idPass = memberService.idChk(id);
			if(idPass) break;
//				System.out.println("10자 이내 입력");
//				System.out.println("영문이랑, 숫자만 입력");
		}
		param.add(id);
		while(true){
			pw = ScanUtil.nextLine("비밀번호 :");
			boolean pwPass = memberService.pwChk(pw);
			if(pwPass) break;
		}
		param.add(pw);
		while (true) {
			nn = ScanUtil.nextLine("닉네임 :");
			boolean nnPass = memberService.nnChk(nn);
			if(nnPass) break;
		}
		param.add(nn);
		while(true) {
			nm = ScanUtil.nextLine("이름 :");
			boolean nmPass = memberService.nmChk(nm);
			if(nmPass) break;
		}
		param.add(nm);
		while(true) {
			tel = ScanUtil.nextLine("전화번호:");
			boolean telPass = memberService.telChk(tel);
			if(telPass) break;
		}
		param.add(tel);
		
		boolean chk = memberService.join(param);
		
		if(chk) {
			MemberVo uv = (MemberVo) sessionStorage.get("member");
			System.out.println("회원가입 완료");
			return View.HOME;
		}else {
			System.out.println("회원 가입에 실패하였습니다.");
			return View.MEM_SIGNUP;
		}
		
	}

	public View memDelete() {
		
		MemberVo mem = (MemberVo) sessionStorage.get("member");
		String mem_no = mem.getMem_no();
		
		printMemMemDelete();
		
		int del = ScanUtil.nextInt("메뉴 선택>> ");
		switch(del) {
		case 1:
			memberService.memDelete(mem_no);
			sessionStorage.clear();
			ScanUtil.nextLine("삭제 되었습니다. 돌아가시려면 엔터를 입력해 주세요.");
			return View.HOME;
		case 2:
			return View.MEMBER_HOME;
		default:
			return View.MEM_DELETE;
			
		}
		

	}

	public View memSaleList() {
		System.out.println("판매목록 조회");
		MemberVo mem = (MemberVo) sessionStorage.get("member");
		String mem_no = mem.getMem_no();
		
		List<MemSaleVo> msv = memberService.memSaleList(mem_no);
		
		printMemSaleList(msv);
		
		ScanUtil.nextLine("엔터누르면 홈으로 이동");
		
		return View.MEMBER_HOME;
	}
	
	


	
}
	
