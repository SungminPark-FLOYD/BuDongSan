package dao;

import java.util.List;

import util.JDBCUtil;
import vo.ManagerVo;
import vo.MemberVo;

public class ManagerDao {
	//싱글톤 구현
	private static ManagerDao instance = null;

	private ManagerDao() {
		//생성자는 private으로 감싸준다
	}

	public static ManagerDao getInstance() {
		if (instance == null)
			instance = new ManagerDao();

		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public ManagerVo managerLogin(List<Object> param) {
		String sql = "    SELECT * \r\n" + 
					 "      FROM MANAGER\r\n" + 
					 "     WHERE MANAGER_ID = ? \r\n" + 
					 "       AND MANAGER_PASS = ? ";
		
		return jdbc.selectOne(sql, param, ManagerVo.class);
	}
	
	public void memDelete(String sel) {
		String sql = "    UPDATE MEMBER \r\n" + 
			 	 	 "       SET DEL_YN = 'Y'\r\n" + 
			 	 	 "     WHERE MEM_NICK = '"+sel+"'";
		jdbc.update(sql);
	}

	public List<MemberVo> memList() {
		String sql = "    SELECT * FROM MEMBER \r\n" + 
					 "     WHERE DEL_YN = 'N'";
		return jdbc.selectList(sql, MemberVo.class);
	}
	

}
