package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import vo.PropertyVo;

public class PropertyDao {
	//싱글톤 구현
	private static PropertyDao instance = null;

	private PropertyDao() {
		//생성자는 private으로 감싸준다
	}

	public static PropertyDao getInstance() {
		if (instance == null)
			instance = new PropertyDao();

		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public List<PropertyVo> searchListService(List<Object> searchList) {
		String sql = "SELECT P.PRO_NO, T.PRO_TP_NAME, S.SALE_NAME, A.AGENT_NAME, P.ADDR,PRO_SIZE, P.PRO_TAG, P.PRO_PRICE\r\n" + 
				"      FROM PROPERTY P, PROPERTY_TYPE T, SALES_CATEGORY S, AGENT A\r\n" + 
				"     WHERE  P.PRO_TP_NO = T.PRO_TP_NO\r\n" + 
				"       AND S.SALE_NO = P.SALE_NO\r\n" + 
				"       AND P.AGENT_NO = A.AGENT_NO\r\n" + 
				"       AND T.PRO_TP_NAME= ? \r\n" + 
				"       AND S.SALE_NAME = ?\r\n" + 
				"       AND P.ADDR LIKE '%'||?||'%' "
				+ "		AND P.DEL_YN = 'N' ";
		
		return jdbc.selectList(sql, searchList, PropertyVo.class);
	}

	public PropertyVo searchDetail(String pro_no) {
		String sql = "SELECT P.PRO_NO, T.PRO_TP_NAME, S.SALE_NAME, A.AGENT_NAME, P.ADDR, P.PRO_SIZE, P.PRO_TAG, P.PRO_PRICE, P.PRO_CONTENT\r\n" + 
				"      FROM PROPERTY P, PROPERTY_TYPE T, SALES_CATEGORY S, AGENT A\r\n" + 
				"    WHERE  P.PRO_TP_NO = T.PRO_TP_NO\r\n" + 
				"       AND S.SALE_NO = P.SALE_NO\r\n" + 
				"       AND P.AGENT_NO = A.AGENT_NO\r\n" + 
				"       AND P.PRO_NO = '" + pro_no + "'"
			  + "		AND P.DEL_YN = 'N' ";
		return jdbc.selectOne(sql, PropertyVo.class);
	}
	
	public PropertyVo getProNO() {
		String sql = " SELECT  ('P'||TO_CHAR(SEQ_PROPERTY.NEXTVAL, 'FM009')) AS PRO_NO FROM DUAL";
		
		return jdbc.selectOne(sql, PropertyVo.class);
	}

	public void insertPro(List<Object> insertPro) {
		String sql = "INSERT INTO PROPERTY (PRO_NO, PRO_TP_NO,SALE_NO,AGENT_NO,ADDR,PRO_SIZE,PRO_TAG,PRO_CONTENT,PRO_PRICE)\r\n" + 
				"    VALUES ( ?,\r\n" + 
				"            (SELECT PRO_TP_NO FROM PROPERTY_TYPE WHERE PRO_TP_NAME= ?),\r\n" + 
				"            (SELECT SALE_NO FROM SALES_CATEGORY WHERE SALE_NAME= ? ),\r\n" + 
				"            ? ,\r\n" + 
				"            ?,\r\n" + 
				"            ?,\r\n" + 
				"            ?,\r\n" + 
				"            ?,\r\n" + 
				"            ?)";

		
		jdbc.update(sql, insertPro);
		
	}
	
	public void proDelete(String sel) {
		String sql = "    UPDATE PROPERTY\r\n" + 
				 	 "       SET DEL_YN = 'Y'\r\n" + 
				 	 "     WHERE PRO_NO = '"+sel+"'";
		jdbc.update(sql);
	}

	public void insertSale(List<Object> param) {
		String sql = " INSERT INTO MEM_SALE(MEM_SALE_NO, MEM_NO, PRO_NO, AGENT_NO)\r\n" + 
				" VALUES (SEQ_MEM_SALE.NEXTVAL, ? , ? , ?)";
		
		jdbc.update(sql, param);
		
	}
	
	public List<PropertyVo> printPro() {
		String sql = "SELECT P.PRO_NO, T.PRO_TP_NAME, S.SALE_NAME, A.AGENT_NAME, P.ADDR, PRO_SIZE, P.PRO_TAG, P.PRO_PRICE\r\n" + 
				"      FROM PROPERTY P, PROPERTY_TYPE T, SALES_CATEGORY S, AGENT A\r\n" + 
				"     WHERE P.AGENT_NO = A.AGENT_NO\r\n" + 
				"       AND P.PRO_TP_NO = T.PRO_TP_NO\r\n" + 
				"       AND S.SALE_NO = P.SALE_NO\r\n" + 
				"       AND P.DEL_YN = 'N'\r\n" + 
				"       ORDER BY 1";
		
		return jdbc.selectList(sql, PropertyVo.class);
	}
	
	public List<PropertyVo> getProNum() {
		String sql = "select pro_no\r\n" + 
				" from property";
		
		return jdbc.selectList(sql, PropertyVo.class);
	}
	
	
}
