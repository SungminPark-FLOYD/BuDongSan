package service;

import java.util.List;

import controller.ManagerController;
import dao.ManagerDao;
import dao.MemberDao;
import vo.AgentVo;
import vo.ManagerVo;
import vo.MemberVo;

public class ManagerService {
	//싱글톤 구현
	private static ManagerService instance = null;

	private ManagerService() {
		//생성자는 private으로 감싸준다
	}

	public static ManagerService getInstance() {
		if (instance == null)
			instance = new ManagerService();

		return instance;
	}
	
	ManagerDao dao = ManagerDao.getInstance();
	MemberDao memDao = MemberDao.getInstance();
	
	public boolean managerLogin(List<Object> param) {
		ManagerVo login = dao.managerLogin(param);
		
		if(login != null) {
			ManagerController.sessionStorage.put("manager", login);
			return true;
		}
		return false;
	}
	
	public void memDelete(String sel) {
		dao.memDelete(sel);
	}

	public List<MemberVo> memList() {
		return dao.memList();
	}
	
	public boolean getMemNo(String mem_no) {
		
		List<MemberVo> memList = memDao.getMemNo();
		
		for(MemberVo mem : memList) {
			String memNum = mem.getMem_nick();
			
			if(mem_no.equals(memNum)) return true;
		}
		
		return false;
	}
}
