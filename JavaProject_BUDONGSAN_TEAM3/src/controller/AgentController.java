package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import print.Print;
import util.ScanUtil;
import util.View;
import vo.AgentVo;
import vo.MemberVo;
import vo.PropertyVo;
import vo.ReservationVo;

public class AgentController extends Print {
	public static Map<String, Object> sessionStorage = MainController.sessionStorage;

	public View agentHome() {
		printAgentHome();
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.AGENT_RES;
		case 2:
			return View.AGENT_LIST;
		case 3:
			return View.AGENT_INFO;
		case 4:
			sessionStorage.clear();
			System.out.println("로그아웃 되셨습니다.");
			return View.HOME;
		default:
			return View.AGENT_HOME;
		}
	}

	public View agentInfo() {
		AgentVo agent = (AgentVo) sessionStorage.get("agent");
		String agentId = agent.getAgent_id();
		List<AgentVo> agentInfo = agentService.agentInfo(agentId);

		printAgentInfo(agentInfo);
		printAgentInfoMenu();

		int sel = ScanUtil.nextInt("메뉴 선택 >> ");
		switch (sel) {
		case 1:

			return View.AGENT_INFO_UPDATE;
		case 2:
			return View.AGENT_DELETE;
		case 3:
			return View.AGENT_HOME;
		default:
			System.out.println("잘못 입력 하셨습니다.");
			return View.AGENT_INFO;
		}
	}

	public View agentInfoUpdate() {
		AgentVo agent = (AgentVo) sessionStorage.get("agent");
		String agentId = agent.getAgent_id();

		List<AgentVo> agentInfo = agentService.agentInfo(agentId);
		printAgentInfo(agentInfo);

		List<Object> param = new ArrayList();
		
		String pass;
		String name;
		String com;
		String phone;
		String content;
		
		while (true) {
			pass = ScanUtil.nextLine("비밀번호 :");
			boolean pwPass = agentService.pwChk(pass);
			if (pwPass)
				break;
		}
		param.add(pass);
		while (true) {
			name = ScanUtil.nextLine("이름 :");
			boolean nmPass = agentService.nmChk(name);
			if (nmPass)
				break;
		}
		param.add(name);
		while (true) {
			com = ScanUtil.nextLine("회사 :");
			boolean cmPass = agentService.cmChk(com);
			if (cmPass)
				break;
		}
		param.add(com);
		while (true) {
			phone = ScanUtil.nextLine("전화번호:");
			boolean telPass = agentService.telChk(phone);
			if (telPass)
				break;
		}
		param.add(phone);

		while (true) {
			content = ScanUtil.nextLine("자기소개:");
			boolean conPass = agentService.conChk(content);
			if (conPass)
				break;
		}
		param.add(content);
		
		agentService.agentInfoUpdate(param, agentId);

		System.out.println("프로필 정보가 변경되었습니다.");
		
		return View.AGENT_INFO;
	}

	public View agentDelete() {
		AgentVo agent = (AgentVo) sessionStorage.get("agent");
		String agentId = agent.getAgent_id();
		String sel = ScanUtil.nextLine("정말 탈퇴하시겟습니까? y/n");

		if (sel.equalsIgnoreCase("y")) {
			agentService.agentInfoDelete(agentId);
			System.out.println("정상적으로 회원탈퇴 되었습니다.");
			// 로그아웃 후 홈 이동
			sessionStorage.clear();
			return View.HOME;
		} else if (sel.equalsIgnoreCase("n")) {
			return View.AGENT_HOME;
		}

		System.out.println("잘못 입력하셨습니다.");
		return View.AGENT_DELETE;
	}

	public View agentLogin() {
		printLogin();
		String id = ScanUtil.nextLine("ID   >>");
		String pass = ScanUtil.nextLine("PASS >>");

		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pass);

		boolean loginChk = agentService.agentLogin(param);
		if (!loginChk) {
			printAgentChk();
			int sel = ScanUtil.nextInt("메뉴 선택 >>");
			switch (sel) {
			case 1:
				return View.AGENT_LOGIN;
			default:
				return View.AGENT_SIGNUP;
			}
		}
		AgentVo agent = (AgentVo) sessionStorage.get("agent");
		System.out.println(agent.getAgent_name() + "님 환영합니다.");

		return View.AGENT_HOME;
	}

	public View agentResList() {
		System.out.println("방문 예약 회원 리스트");
		AgentVo agent = (AgentVo) sessionStorage.get("agent");
		
		List<ReservationVo> ResList = agentService.agentResList(agent.getAgent_no());
		printagentResList(ResList);

		
		ScanUtil.nextLine("엔터치면 홈으로 돌아감");

		return View.AGENT_HOME;
	}

	public View agentProList() {
		System.out.println("관리매물 리스트");
		AgentVo agent = (AgentVo) sessionStorage.get("agent");
		String agent_no = agent.getAgent_no();
		List<PropertyVo> proList = agentService.agentProList(agent_no);

		printagentProList(proList);

		ScanUtil.nextLine("엔터치면 홈으로 돌아감");

		return View.AGENT_HOME;
	}

	public View agentSignup() {
		printSignup();

		String id;
		String pw;
		String nm;
		String cm;
		String tel;
		String con;
		List<Object> param = new ArrayList<Object>();
		while (true) {
			id = ScanUtil.nextLine("아이디 : ");
			boolean idPass = agentService.idChk(id);
			if (idPass)
				break;
//				System.out.println("10자 이내 입력");
//				System.out.println("영문이랑, 숫자만 입력");
		}
		param.add(id);
		while (true) {
			pw = ScanUtil.nextLine("비밀번호 :");
			boolean pwPass = agentService.pwChk(pw);
			if (pwPass)
				break;
		}
		param.add(pw);
		while (true) {
			nm = ScanUtil.nextLine("이름 :");
			boolean nmPass = agentService.nmChk(nm);
			if (nmPass)
				break;
		}
		param.add(nm);
		while (true) {
			cm = ScanUtil.nextLine("회사 :");
			boolean cmPass = agentService.cmChk(cm);
			if (cmPass)
				break;
		}
		param.add(cm);
		while (true) {
			tel = ScanUtil.nextLine("전화번호:");
			boolean telPass = agentService.telChk(tel);
			if (telPass)
				break;
		}
		param.add(tel);

		while (true) {
			con = ScanUtil.nextLine("자기소개:");
			boolean conPass = agentService.conChk(con);
			if (conPass)
				break;
		}
		param.add(con);
		boolean chk = agentService.join(param);

		if (chk) {
			AgentVo av = (AgentVo) sessionStorage.get("agent");
			System.out.println("회원가입 완료");
			return View.HOME;
		} else {
			System.out.println("회원 가입에 실패하였습니다.");
			return View.AGENT_SIGNUP;
		}
	}
}
