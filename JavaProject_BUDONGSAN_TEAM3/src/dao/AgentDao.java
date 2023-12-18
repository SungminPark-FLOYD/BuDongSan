package dao;

import java.util.List;

import util.JDBCUtil;
import vo.AgentVo;
import vo.MemberVo;
import vo.PropertyVo;
import vo.ReservationVo;

public class AgentDao {
	//싱글톤 구현
	private static AgentDao instance = null;

	private AgentDao() {
		//생성자는 private으로 감싸준다
	}

	public static AgentDao getInstance() {
		if (instance == null)
			instance = new AgentDao();

		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public AgentVo agentLogin(List<Object> param) {
		String sql = " SELECT * \r\n" + 
				" FROM AGENT\r\n" + 
				" WHERE AGENT_ID = ?\r\n" + 
				" AND AGENT_PASS = ?";
		return jdbc.selectOne(sql,param,AgentVo.class);
	}

	public List<AgentVo> agentList() {
		String sql = " select *"
				+ 	 " from agent " +
					 " where del_yn = 'N'";
				
		return jdbc.selectList(sql, AgentVo.class);
	}
	
	public List<ReservationVo> agentResList(String agent_no) {
		String sql ="    SELECT R.MEM_NO,\r\n" + 
					"           R.PRO_NO,\r\n" + 
					"           M.MEM_NICK,\r\n" + 
					"           R.RESERV_DATE\r\n" + 
					"      FROM RESERVATION R, MEMBER M\r\n" + 
					"     WHERE R.MEM_NO = M.MEM_NO"+ 
					"		AND R.DEL_YN = 'N'" + 
					"		AND R.AGENT_NO = '" + agent_no + "'";
		
		return jdbc.selectList(sql, ReservationVo.class);
	}

	public List<PropertyVo> agentProList(String agent_no) {
		String sql = "    SELECT PRO_NO,\r\n" + 
					 "           ADDR,\r\n" + 
					 "           PRO_SIZE,\r\n" + 
					 "           PRO_PRICE\r\n" + 
					 "      FROM PROPERTY\r\n" + 
					 "     WHERE AGENT_NO = '"+agent_no+"'" +
					 "		AND DEL_YN = 'N'";
		
		return jdbc.selectList(sql, PropertyVo.class);
	}
	
	public List<AgentVo> getID() {
		String sql = "select AGENT_ID from AGENT";
		return  jdbc.selectList(sql, AgentVo.class);
	}
	
	public int join(List<Object> param) {
		String sql = "insert into AGENT(AGENT_NO,\r\n" + 
				" AGENT_ID,\r\n" + 
				" AGENT_PASS,\r\n" + 
				" AGENT_NAME,\r\n" + 
				" AGENT_COM,\r\n" + 
				" AGENT_PHONE,"
				+ " AGENT_CONTENT )VALUES (('A'||TO_CHAR(SEQ_AGENT.NEXTVAL, 'FM009')), ?,?,?,?,?,?)";
		
		return jdbc.update(sql, param);
	}
	
	public List<AgentVo> agentInfo(String agentId) {
		String sql = "    SELECT AGENT_ID,\r\n" + 
				"           AGENT_NAME,\r\n" + 
				"           AGENT_COM,\r\n" + 
				"           AGENT_CONTENT,\r\n" + 
				"           AGENT_PHONE\r\n" + 
				"      FROM AGENT\r\n" + 
				"     WHERE AGENT_ID = '"+agentId+"'";
		
		return jdbc.selectList(sql, AgentVo.class);
	}

	public void agentInfoUpdate(List<Object> param, String agentId) {
		String sql = "    UPDATE AGENT\r\n" + 
				"       SET AGENT_PASS = ?,\r\n" + 
				"           AGENT_NAME = ?,\r\n" + 
				"           AGENT_COM = ?,\r\n" + 
				"           AGENT_PHONE = ?,\r\n" + 
				"           AGENT_CONTENT = ? \r\n" + 
				"     WHERE AGENT_ID = '"+agentId+"'";
		
		jdbc.update(sql, param);
	}

	public void agentInfoDelete(String agentId) {
		String sql = "    UPDATE AGENT\r\n" + 
					 "       SET DEL_YN = 'Y'\r\n" + 
					 "     WHERE AGENT_ID ='"+agentId+"'";
		jdbc.update(sql);
	}
	
	public List<AgentVo> getAgentNo() {
		String sql = " select agent_no from agent ";
		
		return jdbc.selectList(sql, AgentVo.class);
				
	}
}
