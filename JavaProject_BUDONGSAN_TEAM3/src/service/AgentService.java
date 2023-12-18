package service;

import java.util.List;

import controller.MainController;
import dao.AgentDao;
import vo.AgentVo;
import vo.MemberVo;
import vo.PropertyVo;
import vo.ReservationVo;

public class AgentService {
	//싱글톤 구현
	private static AgentService instance = null;

	private AgentService() {
		//생성자는 private으로 감싸준다
	}

	public static AgentService getInstance() {
		if (instance == null)
			instance = new AgentService();

		return instance;
	}
	AgentDao dao = AgentDao.getInstance();

	public boolean agentLogin(List<Object> param) {
		AgentVo agent = dao.agentLogin(param);
		   if(agent!=null) {
			   MainController.sessionStorage.put("agent",agent );
			   return true;
		   }
		   
		   return false;
	}

	public List<AgentVo> agentList() {
		
		return dao.agentList();
	}
	public List<ReservationVo> agentResList(String agent_no) {
		return dao.agentResList(agent_no);
	}

	public List<PropertyVo> agentProList(String agent_no) {
		return dao.agentProList(agent_no);
	}
	
	public boolean idChk(String id) {
		List<AgentVo> av = dao.getID();
		if(id.length() == 0) {
			System.out.println("아이디를 입력해 주세요!!");
			return false;
		}
		for (char ch : id.toCharArray()) {
			// 숫자 체크
			if ('0' <= ch && ch <= '9') {
			} else if ('a' <= ch && ch <= 'z') {
			} else if ('A' <= ch && ch <= 'Z') {
			} else {
				System.out.println("영문이랑, 숫자만 입력");
				return false;
			}
			if (id.length() <= 10) {
			} else {
				System.out.println("10자 이내 입력");
				return false;
			}
			for (AgentVo agentVo : av) {
				if (agentVo.getAgent_id().equals(id)) {
					System.out.println("동일한 아이디 존재");
					return false;
				}
			}

		}
		return true;
	}

	public boolean pwChk(String pw) {
		if(pw.length() == 0) {
			System.out.println("비밀번호를 입력해 주세요!!");
			return false;
		}
		for (char ch : pw.toCharArray()) {
			// 숫자 체크
			if ('0' <= ch && ch <= '9') {
			} else if ('a' <= ch && ch <= 'z') {
			} else if ('A' <= ch && ch <= 'Z') {
			} else {
				System.out.println("영문이랑, 숫자만 입력");
				return false;
			}
			if (pw.length() >= 8 && pw.length() <= 20) {
			} else {
				System.out.println("비밀번호는 8자이상 20자 이하");
				return false;
			}
		}
		return true;
	}

	public boolean cmChk(String cm) {	
		if(cm.length() == 0) {
		System.out.println("회사명을 입력해 주세요!!");
		return false;
		}
		if (cm.length() <= 20) {
		} else {
			System.out.println("스무자 이내로만 입력 가능합니다.");
			return false;
		}
		
		return true;
	}
	
	public boolean nmChk(String nm) {
		if(nm.length() == 0) {
			System.out.println("이름을 입력해 주세요!!");
			return false;
		}
		for (char ch : nm.toCharArray()) {
			if ('가' <= ch && ch <= '힣') {
			} else {
				System.out.println("이름은 한글로만 가능합니다.");
				return false;
			}
			if (nm.length() <= 20) {
			} else {
				System.out.println("스무자 이내로만 입력 가능합니다.");
				return false;
			}
		}
		return true;
	}

	public boolean telChk(String tel) {
		if (tel.matches("^01[0|1|6|7|8|9]-[0-9]{3,4}-[0-9]{4}$")) {
		} else {
			System.out.println("전화번호 형식이 올바르지 않습니다.");
			System.out.println("010-0000-0000 형식으로 입력해주세요.");
			return false;
		}
		return true;
	}
	public boolean conChk(String con) {
		if (con.length() <= 50) {
		} else {
			System.out.println("자기소개는 50글자 이내로 가능합니다.");
			return false;
		}
		return true;
	}
	
	public boolean join(List<Object> param) {
		if(dao.join(param) !=0) {
			return true;
		}
		return false;
	}
	
	public List<AgentVo> agentInfo(String agentId) {
		return dao.agentInfo(agentId);
	}

	public void agentInfoUpdate(List<Object> param, String agentId) {
		dao.agentInfoUpdate(param,agentId);
	}

	public void agentInfoDelete(String agentId) {
		dao.agentInfoDelete(agentId);
	}
}
