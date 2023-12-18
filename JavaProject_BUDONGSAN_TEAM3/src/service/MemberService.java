package service;



import java.util.List;

import controller.MainController;
import dao.AgentDao;
import dao.MemberDao;
import dao.PropertyDao;
import vo.AgentVo;
import vo.CartVo;
import vo.MemSaleVo;
import vo.MemberVo;
import vo.PropertyVo;
import vo.ReservationVo;

public class MemberService {
	//싱글톤 구현
	private static MemberService instance = null;

	private MemberService() {
		//생성자는 private으로 감싸준다
	}

	public static MemberService getInstance() {
		if (instance == null)
			instance = new MemberService();

		return instance;
	}
	
	MemberDao dao = MemberDao.getInstance();
	PropertyDao proDao = PropertyDao.getInstance();
	AgentDao agentDao = AgentDao.getInstance();
	
	public boolean memLogin(List<Object> param) {
		MemberVo member = dao.memlogin(param);	
		
		//null체크
		if(member != null) {
			MainController.sessionStorage.put("member", member);
			return true;
		}
		
		return false;
	}

	public void updateCart(List<Object> param) {
		dao.updateCart(param);		
	}

	public List<CartVo> cartList(String mem_id) {
		
		return dao.cartList(mem_id);
	}
	
	public boolean idChk(String id) {
		List<MemberVo> mv = dao.getID();
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
			for (MemberVo memVo : mv) {
				if (memVo.getMem_id().equals(id)) {
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
				
			}			
			else {
				System.out.println("비밀번호는 8자이상 20자 이하");
				return false;
			}
		}
		return true;
	}

	public boolean nnChk(String nn) {
		if(nn.length() == 0) {
			System.out.println("닉네임을 입력해 주세요!!");
			return false;
		}
		if (nn.length() <= 20) {
		} else {
			System.out.println("닉네임은 10글자 이내로 가능합니다.");
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
	
	public boolean join(List<Object> param) {
		if(dao.join(param) !=0) {
			return true;
		}
		return false;
	}
	
	public boolean getProNum(String pro_no) {
		
		List<PropertyVo> proList = proDao.getProNum();
		
		for(PropertyVo pro : proList) {
			String pro_num = pro.getPro_no();
			
			if(pro_no.equals(pro_num)) return true;
		}
		
		
		return false;
	}
	
	public boolean getAgentNum(String agent_no) {
		List<AgentVo> agentList = agentDao.getAgentNo();
		
		for(AgentVo agent : agentList) {
			String agentNum = agent.getAgent_no();
			
			if(agent_no.equals(agentNum)) return true;
		}
		
		return false;
	}

	public void memDelete(String mem_no) {
		dao.memDelete(mem_no);
		
	}

	public List<ReservationVo> printRes(String mem_no) {
		
		return dao.printRes(mem_no);
	}
	public List<ReservationVo> printRes() {
		
		return dao.printRes();
	}

	public void deleteRes(List<Object> param) {
		dao.deleteRes(param);
		
	}

	public void deleteCart(List<Object> param) {
		dao.deleteCart(param);
		
	}

	public void updateInfo(List<Object> param) {
		dao.updateInfo(param);
		
	}

	public MemberVo memInfo(String mem_no) {
		
		return dao.memInfo(mem_no);
	}

	public void resUpdate(List<Object> dateParam) {

		
		dao.resUpdate(dateParam);
		
	}

	public List<MemSaleVo> memSaleList(String mem_no) {		
		return dao.memSaleList(mem_no);
	}
}
