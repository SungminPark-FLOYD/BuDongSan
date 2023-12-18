package dao;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import util.JDBCUtil;
import vo.CartVo;
import vo.MemSaleVo;
import vo.MemberVo;
import vo.ReservationVo;

public class MemberDao {
	//싱글톤 구현
	private static MemberDao instance = null;

	private MemberDao() {
		//생성자는 private으로 감싸준다
	}

	public static MemberDao getInstance() {
		if (instance == null)
			instance = new MemberDao();

		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public MemberVo memlogin(List<Object> param) {
		String sql = " select * from member\r\n" + 
				 " where mem_id = ? \r\n" + 
				 " and mem_pass = ? "
				 + "and del_yn = 'N'";
	
		return jdbc.selectOne(sql,param, MemberVo.class);
	}

	
	public void updateCart(List<Object> param) {
		String sql = " INSERT INTO CART (MEM_NO,PRO_NO,CART_NO)\r\n" + 
					 " VALUES (?,?,SEQ_CART.NEXTVAL)";
		
		jdbc.update(sql, param);
	}

	public List<CartVo> cartList(String mem_id) {
		String sql = "SELECT C.PRO_NO,"
				+ "	 	    C.MEM_NO,\r\n" + 
				"           P.ADDR,\r\n" + 
				"           P.PRO_PRICE,\r\n" + 
				"           A.AGENT_NAME,\r\n" + 
				"           A.AGENT_PHONE\r\n" + 
				"      FROM  CART C, PROPERTY P, AGENT A, MEMBER M\r\n" + 
				"     WHERE C.MEM_NO=M.MEM_NO\r\n" + 
				"       AND C.PRO_NO=P.PRO_NO\r\n" + 
				"       AND P.AGENT_NO=A.AGENT_NO\r\n" + 
				"       AND C.MEM_NO= '" + mem_id + "'"
			  + "		AND C.DEL_YN = 'N' ";
		
		return jdbc.selectList(sql, CartVo.class);
	}
	
	public List<MemberVo> getID() {
		String sql = "select mem_id from member";
		return  jdbc.selectList(sql, MemberVo.class);
	}
	
	public int join(List<Object> param) {
		String sql = "insert into MEMBER(MEM_NO,\r\n" + 
				" MEM_ID,\r\n" + 
				" MEM_PASS,\r\n" + 
				" MEM_NICK,\r\n" + 
				" MEM_NAME,\r\n" + 
				" MEM_PHONE )"
			  + " VALUES (('M'||TO_CHAR(SEQ_MEMBER.NEXTVAL, 'FM009')), ?,?,?,?,?)";
		
		return jdbc.update(sql, param);
	}
	
	public void memDelete(String mem_no) {
		String sql = "    UPDATE MEMBER\r\n" + 
				 	 "       SET DEL_YN = 'Y'\r\n" + 
				 	 "     WHERE MEM_NO = '"+mem_no+"'";
		jdbc.update(sql);
	}

	public List<ReservationVo> printRes(String mem_no) {
		String sql = "SELECT R.PRO_NO,                    \r\n" + 
				"        M.MEM_ID,\r\n" + 
				"        P.ADDR,  \r\n" + 
				"        P.PRO_PRICE, \r\n" + 
				"        A.AGENT_NAME,\r\n" + 
				"        A.AGENT_PHONE,\r\n" + 
				"        R.RESERV_DATE\r\n" + 
				" FROM RESERVATION R, PROPERTY P, AGENT A, MEMBER M \r\n" + 
				" WHERE R.MEM_NO=M.MEM_NO \r\n" + 
				" AND R.PRO_NO=P.PRO_NO\r\n" + 
				" AND P.AGENT_NO=A.AGENT_NO\r\n" + 
				" AND R.MEM_NO= '" + mem_no + "'"
				+ " AND R.DEL_YN = 'N' ";
		
		return jdbc.selectList(sql, ReservationVo.class);
	}
	public List<ReservationVo> printRes() {
		String sql = "SELECT R.PRO_NO,                    \r\n" + 
				"        M.MEM_ID,\r\n" + 
				"        P.ADDR,  \r\n" + 
				"        P.PRO_PRICE, \r\n" + 
				"        A.AGENT_NAME,\r\n" + 
				"        A.AGENT_PHONE,\r\n" + 
				"        R.RESERV_DATE\r\n" + 
				" FROM RESERVATION R, PROPERTY P, AGENT A, MEMBER M \r\n" + 
				" WHERE R.MEM_NO=M.MEM_NO \r\n" + 
				" AND R.PRO_NO=P.PRO_NO\r\n" + 
				" AND P.AGENT_NO=A.AGENT_NO\r\n" + 
				" AND R.DEL_YN = 'N' ";
		
		return jdbc.selectList(sql, ReservationVo.class);
	}

	public void deleteRes(List<Object> param) {
		String sql = "    UPDATE RESERVATION\r\n" + 
			 	 "       SET DEL_YN = 'Y'\r\n" + 
			 	 "     WHERE MEM_NO = ? "
			 	 + "   AND   PRO_NO = ? ";
		
		jdbc.update(sql, param);
		
	}

	public void deleteCart(List<Object> param) {
		String sql = "    UPDATE CART\r\n" + 
			 	 "       SET DEL_YN = 'Y'\r\n" + 
			 	 "     WHERE MEM_NO = ? "
			 	 + "   AND   PRO_NO = ? ";
		
		jdbc.update(sql, param);
		
	}

	public void updateInfo(List<Object> param) {
		String sql = " update member\r\n" + 
				" set mem_pass = ?,\r\n" + 
				"    mem_nick = ?,\r\n" + 
				"    mem_name = ?,\r\n" + 
				"    mem_phone = ?\r\n" + 
				" where mem_no = ?";
		jdbc.update(sql, param);
		
	}

	public MemberVo memInfo(String mem_no) {
		String sql = " select mem_id, mem_pass, mem_name, mem_phone, mem_nick\r\n" + 
				" from member\r\n" + 
				" where mem_no = '" + mem_no + "'";
		return jdbc.selectOne(sql, MemberVo.class);
	}

	public void resUpdate(List<Object> dateParam) {
		String sql = " INSERT INTO RESERVATION ( RESERV_NO, MEM_NO, PRO_NO, RESERV_DATE, AGENT_NO)\r\n" + 
				"    VALUES (SEQ_RESERVATION.NEXTVAL, ?,?,TO_DATE(?)\r\n" + 
				"    ,(SELECT AGENT_NO FROM PROPERTY WHERE PRO_NO = ?))";
		
		jdbc.update(sql,dateParam);
		
	}

	public List<MemSaleVo> memSaleList(String mem_no) {
		String sql = "select m.mem_nick,\r\n" + 
				"        s.pro_no,\r\n" + 
				"        p.addr,\r\n" + 
				"        a.agent_name\r\n" + 
				" from mem_sale s, member m, property p, agent a\r\n" + 
				" where s.mem_no=m.mem_no\r\n" + 
				" and s.pro_no=p.pro_no\r\n" + 
				" and s.agent_no=a.agent_no\r\n" + 
				" and s.mem_no = '" + mem_no + "'" +
				" and p.del_yn = 'N'";
		
		return jdbc.selectList(sql, MemSaleVo.class);
	}

	
	public List<MemberVo> getMemNo() {
		String sql = " select mem_nick from member";
		
		return jdbc.selectList(sql, MemberVo.class);
	}
	
}
