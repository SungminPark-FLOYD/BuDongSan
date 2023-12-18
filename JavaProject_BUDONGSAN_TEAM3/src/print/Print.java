package print;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import service.AgentService;
import service.BoardService;
import service.ManagerService;
import service.MemberService;
import service.PropertyService;
import util.ScanUtil;
import vo.AgentVo;
import vo.BoardVo;
import vo.CartVo;
import vo.MemSaleVo;
import vo.MemberVo;
import vo.PropertyVo;
import vo.ReservationVo;

public class Print {

	protected MemberService memberService = MemberService.getInstance();
	protected ManagerService managerService = ManagerService.getInstance();
	protected AgentService agentService = AgentService.getInstance();
	protected PropertyService propertyService = PropertyService.getInstance();
	protected BoardService boardService = BoardService.getInstance();

	public SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	// 아트 출력
	public void printLn(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println();
		}
	}

	public void printLine(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("═");
		}
	}
	public void printLine2(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("-");
		}
	}

	public void printLineLT(int n) {
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t");
		for (int i = 0; i < n; i++) {
			System.out.print("┏");
		}
	}

	public void printLineRT(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("┓");
		}
	}

	public void printLineRB(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("┛");
		}
	}

	public void printLineLB(int n) {
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t");
		for (int i = 0; i < n; i++) {
			System.out.print("┗");
		}
	}

	public void printMain() {
		printLine(115);
		printLn(1);
		printLine(115);
		printLn(2);
		System.out.print("\t" + "\t" + "\t" + "                           (   )\r\n" + "\t" + "\t" + "\t"
				+ "                          (    )\r\n" + "\t" + "\t" + "\t" + "                           (    )\r\n"
				+ "\t" + "\t" + "\t" + "                          (    )\r\n" + "\t" + "\t" + "\t"
				+ "                            )  )\r\n" + "\t" + "\t" + "\t"
				+ "                           (  (                  /\\\r\n" + "\t" + "\t" + "\t"
				+ "                            (_)                 /  \\  /\\\r\n" + "\t" + "\t" + "\t"
				+ "                    ________[_]________      /\\/    \\/  \\\r\n" + "\t" + "\t" + "\t"
				+ "           /\\      /\\        ______    \\    /   /\\/\\  /\\/\\\r\n" + "\t" + "\t" + "\t"
				+ "          /  \\    //_\\       \\    /\\    \\  /\\/\\/    \\/    \\\r\n" + "\t" + "\t" + "\t"
				+ "   /\\    / /\\/\\  //___\\       \\__/  \\    \\/\r\n" + "\t" + "\t" + "\t"
				+ "  /  \\  /\\/    \\//_____\\       \\ |[]|     \\\r\n" + "\t" + "\t" + "\t"
				+ " /\\/\\/\\/       //_______\\       \\|__|      \\\r\n" + "\t" + "\t" + "\t"
				+ "/      \\      /XXXXXXXXXX\\                  \\\r\n" + "\t" + "\t" + "\t"
				+ "        \\    /_I_II  I__I_\\__________________\\\r\n" + "\t" + "\t" + "\t"
				+ "               I_I|  I__I_____[]_|_[]_____I\r\n" + "\t" + "\t" + "\t"
				+ "               I_II  I__I_____[]_|_[]_____I\r\n" + "\t" + "\t" + "\t"
				+ "               I II__I  I     XXXXXXX     I\r\n" + "\t" + "\t" + "\t"
				+ "            ~~~~~\"   \"~~~~~~~~~~~~~~~~~~~~~~~~");

		printLn(1);
		System.out.println("\r\n" + "\t"
				+ "██████╗░░█████╗░███████╗██████╗░███████╗░█████╗░██╗░░██╗	██████╗░░█████╗░███╗░░██╗░██████╗░\r\n"
				+ "\t"
				+ "██╔══██╗██╔══██╗██╔════╝██╔══██╗██╔════╝██╔══██╗██║░██╔╝	██╔══██╗██╔══██╗████╗░██║██╔════╝░\r\n"
				+ "\t"
				+ "██║░░██║███████║█████╗░░██║░░██║█████╗░░██║░░██║█████═╝░	██████╦╝███████║██╔██╗██║██║░░██╗░\r\n"
				+ "\t"
				+ "██║░░██║██╔══██║██╔══╝░░██║░░██║██╔══╝░░██║░░██║██╔═██╗░	██╔══██╗██╔══██║██║╚████║██║░░╚██╗\r\n"
				+ "\t"
				+ "██████╔╝██║░░██║███████╗██████╔╝███████╗╚█████╔╝██║░╚██╗	██████╦╝██║░░██║██║░╚███║╚██████╔╝\r\n"
				+ "\t"
				+ "╚═════╝░╚═╝░░╚═╝╚══════╝╚═════╝░╚══════╝░╚════╝░╚═╝░░╚═╝████████╚═════╝░╚═╝░░╚═╝╚═╝░░╚══╝░╚═════╝░");
		printLn(1);
		printLine(115);
		printLn(1);
		printLine(115);
		printLn(1);
		
		System.out.println("\t"+"\t"+"\t"+"╔════════════════════════════════════════════════════════════════╗\r\n" + 
				"\t"+"\t"+"\t"+"║     ___  ____ ____ ____ ____       ____ _  _ ___ ____ ____     ║\r\n" + 
				"\t"+"\t"+"\t"+"║     |__] |__/ |___ [__  [__        |___ |\\ |  |  |___ |__/     ║\r\n" + 
				"\t"+"\t"+"\t"+"║     |    |  \\ |___ ___] ___]       |___ | \\|  |  |___ |  \\     ║\r\n" +
				"\t"+"\t"+"\t"+"║                                                                ║\r\n"+
				"\t"+"\t"+"\t"+"╚════════════════════════════════════════════════════════════════╝");
		
		printLn(1);
		ScanUtil.nextLine("");
		
	}


	// 공통 로그인 / 회원가입 출력
	public void printLogin() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	        로  그  인		┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}

	public void printSignup() {
		System.out.println("\t회원가입 정보를 입력해주세요.");
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	        회 원 가 입		┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}
	// 메인화면 메뉴
	public void printHome() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[1]. 매물 검색		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[2]. 회원 로그인		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[3]. 회원 가입		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[4]. 공인중개사 로그인	┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[5]. 공인중개사 가입		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[6]. 관리자 로그인		┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}

	public void searchResult(List<PropertyVo> searchResult) {		

		int pageSize = 4;
		int currentPage = 1;
		
		while(true) {
			int startIndex = (currentPage - 1) * pageSize;
			
			if(startIndex < 0) {
				startIndex = 0;
			}
			
			int endIndex = Math.min(startIndex + pageSize, searchResult.size());
			List<PropertyVo> page = searchResult.subList(startIndex, endIndex);
			
			if(page.isEmpty()) {
				printLineLT(1);
				printLine(31);
				printLineRT(1);
				printLn(1);
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃    [ 더이상 검색결과가 없습니다. ]	┃");
				printLineLB(1);
				printLine(31);
				printLineRB(1);
				printLn(1);
				break;
			}
			
			for(PropertyVo pro : page) {
				String pro_no = pro.getPro_no();
				String pro_tp_name = pro.getPro_tp_name();
				String sale_name = pro.getSale_name();
				String addr = pro.getAddr();
				BigDecimal pro_size = pro.getPro_size();
				String pro_tag = pro.getPro_tag();
				String pro_price = pro.getPro_price();
				
			printLine(115);
			printLn(1);
			System.out.print("\t[ 매물번호 ]  \t" +  pro_no +  "\t\n\t" + "[ 매물분류 ]  \t" + pro_tp_name + "\t\n\t" +"[ 매매분류 ]  \t"+ sale_name + "\t\n\t" +"[  주 소   ]  \t"+ addr + "\t\n\t" +"[  크 기   ]  \t"+ pro_size
					+ "평" + "\t\n\t" + "[ 매물설명 ]  \t" + pro_tag + "\t\n\t" +"[  가 격   ]  \t"+ pro_price +" 만원"+ "\n");
			printLn(1);
			}
			printLine2(115);
			printLn(1);
			String input = ScanUtil.nextLine("\t"+"\t"+"\t"+"\t"+"\t"+"< 이전 페이지                다음페이지  > \n"+
											 "\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"        홈 x");
			
		    if(input.equalsIgnoreCase("x")) {
				break;
			}
			else if(input.equalsIgnoreCase(">") && currentPage <= searchResult.size() / 4) {
				currentPage++;
			}
			else if(input.equalsIgnoreCase("<") && currentPage > 1) {
				currentPage--;
			}
			else {
				printLineLT(1);
				printLine(31);
				printLineRT(1);
				printLn(1);
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃  [ 입력 범위 초과 다시 시도 해 주세요. ]	┃");
				printLineLB(1);
				printLine(31);
				printLineRB(1);
				printLn(1);
			}
		}
		
		printLine(115);
		printLn(3);
		
	}
	public void searchDetail(PropertyVo proVo) {

		String pro_no = proVo.getPro_no();
		String pro_tp_name = proVo.getPro_tp_name();
		String sale_name = proVo.getSale_name();
		String addr = proVo.getAddr();
		BigDecimal pro_size = proVo.getPro_size();
		String pro_tag = proVo.getPro_tag();
		String pro_price = proVo.getPro_price();
		String pro_content = proVo.getPro_content();

		printLine(115);
		printLn(1);
		System.out.print("\t[ 매물번호 ]  \t" +  pro_no +  "\t\n\t" + "[ 매물분류 ]  \t" + pro_tp_name + "\t\n\t" +"[ 매매분류 ]  \t"+ sale_name + "\t\n\t" +"[  주 소   ]  \t"+ addr + "\t\n\t" +"[  크 기   ]  \t"+ pro_size
				+ "평" + "\t\n\t" + "[ 매물설명 ]  \t" + pro_tag + "\t\n\t" +"[  가 격   ]  \t"+ pro_price +" 만원"+ "\n");
		printLn(1);
		printLine2(115);
		printLn(1);
		System.out.println("[ 내용 ] \n"+pro_content);

		// 내용 길이 자르기 1줄에 60자
//			int length = 60;
//			for(int i =0; i < pro_content.length(); i+=length) {	
//				if(i+length>pro_content.length()) 
//					System.out.println(pro_content.substring(i,pro_content.length()));
//				else
//					System.out.println(pro_content.substring(i,i+length));
//			}
		printLine(115);
		printLn(1);
	}
	
	public void printProDetailTitle() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃	상세 검색 결과		┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}

	public void proDetailMenu() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[1]. 관심 목록		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[2]. 방문 예약		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[3]. 메인 화면		┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}

	public void proSearchMenu() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[1]. 상세 검색		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[2]. 메인 화면		┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}
	
	public void printProSearch() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	검색 결과가 없습니다.		┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}
	
	// 회원
	public void printMemberLogin() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[1]. 다시 로그인		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[2]. 회원 가입		┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}

	public void printMemberHome() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[1]. 매물 검색		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[2]. 회원 정보 보기		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[3]. 방 내놓기		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[4]. 공지사항 확인		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[5]. 관심 목록 조회		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[6]. 방문 예약 조회		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[7]. 판매매물 조회		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[8]. 로그 아웃		┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}

	public void printMemInfoMenu() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[1]. 회원 정보 수정		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[2]. 회원 탈퇴		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[3]. 회원 메뉴 돌아가기	┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}

	
	/* 
	 *  Membercontroller > memCartList에 추가함
	 *  12-14
	 */
	public void printMemCartPR() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[ 회원의 관심목록 리스트. ]	┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}
	public void printMemCartList(List<CartVo> cartList) {
		
		int pageSize = 4;
		int currentPage = 1;
		
		while(true) {
			int startIndex = (currentPage - 1) * pageSize;
			
			if(startIndex < 0) {
				startIndex = 0;
			}
			
			int endIndex = Math.min(startIndex + pageSize, cartList.size());
			List<CartVo> page = cartList.subList(startIndex, endIndex);
			
			if(page.isEmpty()) {
				printLineLT(1);
				printLine(31);
				printLineRT(1);
				printLn(1);
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃    [ 더이상 검색결과가 없습니다. ]	┃");
				printLineLB(1);
				printLine(31);
				printLineRB(1);
				printLn(1);
				break;
			}
			
			for (CartVo cartVo : cartList) {
				String pro_no = cartVo.getPro_no();
				String addr = cartVo.getAddr();
				String pro_price = cartVo.getPro_price();
				String agent_name = cartVo.getAgent_name();
				String agent_phone = cartVo.getAgent_phone();
				printLine(115);
				printLn(1);
				System.out.print("\t[ 매물번호 ]  \t" +  pro_no +  "\t\n\t" + "[  주 소  ]  \t" + addr + "\t\n\t" +"[  가 격  ]  \t"+ pro_price + " 만원"+ "\n"+ "\t\n\t" +
								 "[ 공인중개사 ]  \t"+ agent_name + "\t\n\t" +"[ 공인중개사 번호 ]  \t"+ agent_phone);
				printLn(1);
				}
				printLine(115);
				printLn(1);
			String input = ScanUtil.nextLine("\t"+"\t"+"\t"+"\t"+"\t"+"< 이전 페이지                다음페이지  > \n"+
											 "\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"        홈 x");
			if(input.equalsIgnoreCase("x")) {
				break;
			}
			else if(input.equalsIgnoreCase(">") && currentPage <= cartList.size() / 4) {
				currentPage++;
			}
			else if(input.equalsIgnoreCase("<") && currentPage > 1) {
				currentPage--;
			}
			else {
				printLineLT(1);
				printLine(31);
				printLineRT(1);
				printLn(1);
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃  [ 입력 범위 초과 다시 시도 해 주세요. ]	┃");
				printLineLB(1);
				printLine(31);
				printLineRB(1);
				printLn(1);
			}
		}
		
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[1]. 관심목록 삭제		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[2]. 홈으로 돌아가기		┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}

	public void printMemResList(List<ReservationVo> resList) {
		for (ReservationVo res : resList) {
			String pro_no = res.getPro_no();
			String mem_id = res.getMem_id();
			String addr = res.getAddr();
			String pro_price = res.getPro_price();
			String agent_name = res.getAgent_name();
			String agent_phone = res.getAgent_phone();
			Date reserv_date = res.getReserv_date();
			String dateFormat = format.format(reserv_date);

			printLine(115);
			printLn(1);
			System.out.print("\t[ 매물번호 ]  \t" + pro_no + "\t\n\t"+"[ 회원아이디 ]\t"+ mem_id+"\t\n\t" + "[  주 소  ]  \t" + addr + "\t\n\t" + "[  가 격  ]  \t"
					+ pro_price + " 만원" + "\n" + "\t\n\t" + "[ 공인중개사 ]  \t" + agent_name + "\t\n\t" + "[ 공인중개사 번호 ]\t"
					+ agent_phone + "\t\n\t"+"[ 예약일자 ]\t" + dateFormat);
			printLn(1);
		}
		printLine(115);
		printLn(1);

		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "┃ 	[1]. 방문예약 취소		┃");
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "┃ 	[2]. 홈으로 돌아가기		┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}

	public void printMemSaleList(List<MemSaleVo> msv) {
		
		if(msv.isEmpty()) {
			printLineLT(1);
			printLine(31);
			printLineRT(1);
			printLn(1);
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[ 판매매물이 없습니다. ]	┃");
			printLineLB(1);
			printLine(31);
			printLineRB(1);
			printLn(1);
		}
		
		else {
			for (MemSaleVo saleList : msv) {
				String mem_nick = saleList.getMem_nick();
				String pro_no = saleList.getPro_no();
				String addr = saleList.getAddr();
				String agent_name = saleList.getAgent_name();

				printLine(115);
				printLn(1);
				System.out.print("\t[ 닉네임 ]	\t" + mem_nick + "\t\n\t"+"[ 매물번호  ]  \t"+pro_no+ "\t\n\t" +"[ 주 소  ]  \t"+ addr + "\t\n\t" +"[ 공인중개사  ]  \t"+ agent_name );
				printLn(1);
				printLine(115);
				printLn(1);
			}
		}
		
	}
	
	public void printMemMemDelete() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[1]. 회원 탈퇴		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[2]. 홈으로 돌아가기		┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}
	public void printMemInfo(MemberVo memVo) {
		String mem_id = memVo.getMem_id();
		String mem_pass = memVo.getMem_pass();
		String mem_name = memVo.getMem_name();
		String mem_nick = memVo.getMem_nick();
		String mem_phone = memVo.getMem_phone();

		System.out.println("\t"+"	회원정보 리스트");

		printLine(115);
		printLn(1);
		System.out.print("\t[ 아이디 ]  \t" + mem_id + "\t\n\t"+"[ 비밀번호  ]  \t"+mem_pass+ "\t\n\t" +"[ 이름  ]  \t"+ mem_name + "\t\n\t" + "[ 닉네임  ]  \t"+mem_nick + "\t\n\t" +"[ 연락처  ]  \t"+ mem_phone );
		printLn(1);
		printLine(115);
		printLn(1);

	}

	public void printInfoUpdate() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	 [ 회원정보 업데이트 ]	┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}

	public void printInfoUpdateMenu() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[1]. 회원정보 수정		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[2]. 회원메뉴 돌아가기	┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}

	// 관리자, 회원 공지사항 상세보기
	public void printBoardDetail(List<BoardVo> boardList) {
		for (BoardVo board : boardList) {
			int boardNo = board.getBoard_no();
			String boardTitle = board.getBoard_title();
			String boardContent = board.getBoard_content();
			String boardDate = board.getBoard_date();
			String managerNick = board.getManager_nick();
			int boardCount = board.getBoard_count();

			System.out.println("\t"+"	공지사항 상세보기");
			printLine(115);
			printLn(1);
			System.out.print("\t[ 공지사항 번호 ]\t" + boardNo + "\t\n\t"+"[  제 목  ]  \t"+boardTitle+ "\t\n\t" +"[  내 용  ]  \t"+ boardContent + "\t\n\t" + "[  날 짜  ]  \t"+boardDate + "\t\n\t" +"[ 관리자  ]  \t"+ managerNick + "\t\n\t" +"[ 조회수 ] \t"+ boardCount);
			printLn(1);
			printLine(115);
			printLn(1);
		}
	}

	// 관리자
	public void printManager() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[1]. 허위매물 삭제		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[2]. 유저 관리		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[3]. 공지사항 관리		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[4]. 로그아웃		┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}

	public void printBoard() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[1]. 공지사항 조회		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[2]. 공지사항 작성		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[3]. 공지사항 수정		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[4]. 공지사항 삭제		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[5]. 홈			┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}

	public void printBoardMenu() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[1]. 공지사항  상세 조회	┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[2]. 공지사항 작성		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[3]. 공지사항 수정		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[4]. 공지사항 삭제		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[5]. 홈			┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}

	public void printBoardList(List<BoardVo> boardList) {

		for (BoardVo board : boardList) {
			int boardNo = board.getBoard_no();
			String boardTitle = board.getBoard_title();
			String boardContnet = board.getBoard_content();
			String boardDate = board.getBoard_date();
			String managerNick = board.getManager_nick();
			int boardCount = board.getBoard_count();

			printLine(115);
			printLn(1);
			System.out.print("\t[ 공지사항 번호 ]\t" + boardNo + "\t\n\t"+"[  제 목  ]  \t"+boardTitle+ "\t\n\t" + "[  날 짜  ]  \t"+boardDate + "\t\n\t" +"[ 관리자  ]  \t"+ managerNick + "\t\n\t" +"[ 조회수 ] \t"+ boardCount);
			printLn(1);
			printLine(115);
			printLn(1);
		}
	}

	public void printMemberList(List<MemberVo> memberList) {

		int i = 1;
		for (MemberVo member : memberList) {
			String id = member.getMem_id();
			String nick = member.getMem_nick();
			String name = member.getMem_name();
			String phone = member.getMem_phone();

			printLine(115);
			printLn(1);
			System.out.print("[" + i + "]"+"\t\n\t"+"[  아이디  ]  \t"+id+ "\t\n\t" +"[ 닉네임 ]  \t"+ nick + "\t\n\t" +"[  이 름  ]  \t"+ name + "\t\n\t" +"[ 연락처  ]  \t"+ phone);
			printLn(1);
			printLine(115);
			printLn(1);

			i++;
		}
	}

	public void printagentResList(List<ReservationVo> resList) {
		
		if(resList.isEmpty()) {
			printLineLT(1);
			printLine(31);
			printLineRT(1);
			printLn(1);
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[ 예약회원이 없습니다. ]	┃");
			printLineLB(1);
			printLine(31);
			printLineRB(1);
			printLn(1);
		}
		else {
			int i = 1;
			for (ReservationVo Res : resList) {
				String memNo = Res.getMem_no();
				String memNick = Res.getMem_nick();
				String proNo = Res.getPro_no();
				Date date = Res.getReserv_date();
				String dateFormat = format.format(date);

				printLine(115);
				printLn(1);
				System.out.print("[" + i + "]"+"\t\n\t"+"[ 회원번호  ]  \t"+memNo+ "\t\n\t" +"[ 닉네임 ]  \t"+ memNick + "\t\n\t" +"[ 매물번호  ]  \t"+ proNo + "\t\n\t" +"[ 날 짜  ]  \t"+ dateFormat);
				printLn(1);
				printLine(115);
				printLn(1);


				i++;
			}
		}
		
	}

	public void printagentProList(List<PropertyVo> proList) {
		
		if(proList.isEmpty()) {
			printLineLT(1);
			printLine(31);
			printLineRT(1);
			printLn(1);
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[ 관리매물이 없습니다. ]	┃");
			printLineLB(1);
			printLine(31);
			printLineRB(1);
			printLn(1);
		}
		
		else {
			int i = 1;
			for (PropertyVo Pro : proList) {
				String proNo = Pro.getPro_no();
				String addr = Pro.getAddr();
				BigDecimal proSize = Pro.getPro_size();
				String proPrice = Pro.getPro_price();

				printLine(115);
				printLn(1);
				System.out.print("[" + i + "]"+"\t\n\t"+"[ 매물번호  ]  \t"+proNo+ "\t\n\t" +"[ 주 소 ]  \t"+ addr + "\t\n\t" +"[ 크 기  ]  \t"+ proSize + "\t\n\t" +"[ 가 격  ]  \t"+ proPrice+" 만원"+ "\n");
				printLn(1);
				printLine(115);
				printLn(1);
				i++;
			}
		}
		
	}
	
	public void printProDelete() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[1]. 상세 조회		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[2]. 뒤로 가기		┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}
	
	public void printMemDelete() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	  휴먼 계정 관리		┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}
	
	// 공인중개사
	public void printAgentInfo(List<AgentVo> agentInfo) {
		for (AgentVo Info : agentInfo) {
			String agentId = Info.getAgent_id();
			String agentName = Info.getAgent_name();
			String agentCom = Info.getAgent_com();
			String agentContent = Info.getAgent_content();
			String agentPhon = Info.getAgent_phone();

			printLine(115);
			printLn(1);
			System.out.print("\t[ 아이디 ]	\t" + agentId + "\t\n\t"+"[  이 름  ]  \t"+agentName+ "\t\n\t" + "[  회 사  ]  \t"+agentCom + "\t\n\t" +"[ 자기소개  ]  \t"+ agentContent + "\t\n\t" +"[ 연락처 ] \t"+ agentPhon);
			printLn(1);
			printLine(115);
			printLn(1);
		}
	}
	
	public void printProList(List<PropertyVo> proVo) {
		
		int pageSize = 4;
		int currentPage = 1;
		
		while(true) {
			int startIndex = (currentPage - 1) * pageSize;
			
			if(startIndex < 0) {
				startIndex = 0;
			}
			
			int endIndex = Math.min(startIndex + pageSize, proVo.size());
			List<PropertyVo> page = proVo.subList(startIndex, endIndex);
			
			if(page.isEmpty()) {
				System.out.println("더이상 검색결과가 없습니다.");
				break;
			}
			
			for(PropertyVo pro : page) {
				String pro_no = pro.getPro_no();
				String pro_tp_name = pro.getPro_tp_name();
				String sale_name = pro.getSale_name();
				String addr = pro.getAddr();
				BigDecimal pro_size = pro.getPro_size();
				String pro_tag = pro.getPro_tag();
				String pro_price = pro.getPro_price();

				printLine(115);
				printLn(1);
				System.out.print("\t[ 매물번호 ]  \t" +  pro_no +  "\t\n\t" + "[ 매물분류 ]  \t" + pro_tp_name + "\t\n\t" +"[ 매매분류 ]  \t"+ sale_name + "\t\n\t" +"[  주 소   ]  \t"+ addr + "\t\n\t" +"[  크 기   ]  \t"+ pro_size
						+ "평" + "\t\n\t" + "[ 매물설명 ]  \t" + pro_tag + "\t\n\t" +"[  가 격   ]  \t"+ pro_price +" 만원"+ "\n");
				printLn(1);
				}
				printLine2(115);
				printLn(1);
				String input = ScanUtil.nextLine("\t"+"\t"+"\t"+"\t"+"\t"+"< 이전 페이지                다음페이지  > \n"+
												 "\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"        홈 x");
				
		    if(input.equalsIgnoreCase("x")) {
				break;
			}
			else if(input.equalsIgnoreCase(">") && currentPage <= proVo.size() / 4) {
				currentPage++;
			}
			else if(input.equalsIgnoreCase("<") && currentPage > 1) {
				currentPage--;
			}
			else {
				printLineLT(1);
				printLine(31);
				printLineRT(1);
				printLn(1);
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃  [ 입력 범위 초과 다시 시도 해 주세요. ]	┃");
				printLineLB(1);
				printLine(31);
				printLineRB(1);
				printLn(1);
			}
						
		}
				
	}

	public void printAgentChk() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[1]. 다시 로그인		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃ 	[2]. 회원가입		┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}
	
	public void printAgentInfoMenu() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃	[1]. 프로필 정보 수정	┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃	[2]. 공인중개사 회원 탈퇴	┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃	[3]. 공인중개사 메뉴 돌아가기	┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}
	
	public void printAgentHome() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃	[1]. 방문 예약 회원 목록	┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃	[2]. 관리 매물 목록		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃	[3]. 프로필		┃");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃	[4]. 로그아웃		┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}
	
	public void printMemCart() {
		printLineLT(1);
		printLine(31);
		printLineRT(1);
		printLn(1);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t" + "┃	관심 목록에 등록 되엇습니다.	┃");
		printLineLB(1);
		printLine(31);
		printLineRB(1);
		printLn(1);
	}
}
