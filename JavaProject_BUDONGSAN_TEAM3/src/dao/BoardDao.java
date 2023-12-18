package dao;

import java.util.List;

import util.JDBCUtil;
import vo.BoardVo;

public class BoardDao {
	//싱글톤 구현
	private static BoardDao instance = null;

	private BoardDao() {
		//생성자는 private으로 감싸준다
	}

	public static BoardDao getInstance() {
		if (instance == null)
			instance = new BoardDao();

		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public void boardDelete(int sel) {
		String sql = "    UPDATE BOARD\r\n" + 
					 "       SET DEL_YN = 'Y'\r\n" + 
					 "     WHERE BOARD_NO = "+sel;
		jdbc.update(sql);
	}

	public void boardUpdate(List<Object> param, int sel) {
		String sql = "    UPDATE BOARD\r\n" + 
					 "       SET BOARD_TITLE = ?, \r\n" + 
					 "           BOARD_CONTENT = ?,  \r\n" +
					 "			 BOARD_DATE = SYSDATE \r\n" + 
					 "     WHERE BOARD_NO = "+sel;
		jdbc.update(sql,param);
	}

	public List<BoardVo> boardList() {
		String sql = "    SELECT BOARD_NO,\r\n" + 
					 "           BOARD_TITLE,\r\n" + 
					 "           BOARD_CONTENT,\r\n" + 
					 "           TO_CHAR(BOARD_DATE, 'YYYY-MM-DD') AS BOARD_DATE,\r\n" + 
					 "           MANAGER_NICK,\r\n" + 
					 "           BOARD_COUNT\r\n" + 
					 "      FROM BOARD\r\n" + 
					 "     WHERE DEL_YN = 'N'"
					 + "   ORDER BY 6 DESC";
		
		return jdbc.selectList(sql, BoardVo.class);
	}

	public void boardInsert(List<Object> param) {
		String sql = "    INSERT INTO BOARD\r\n" + 
					 "    ( BOARD_NO, MANAGER_NO, MANAGER_NICK , BOARD_TITLE , BOARD_CONTENT )\r\n" + 
					 "    VALUES\r\n" + 
					 "    ( SEQ_BOARD.NEXTVAL, ?, ?, ?, ? )";
		jdbc.update(sql,param);
	}
	
	public List<BoardVo> boardDetail(int sel) {
		String sql = "    SELECT BOARD_NO,\r\n" + 
					 "           BOARD_TITLE,\r\n" + 
					 "           BOARD_CONTENT,\r\n" + 
					 "           MANAGER_NICK,\r\n" + 
					 "           TO_CHAR(BOARD_DATE, 'YYYY-MM-DD') AS BOARD_DATE,\r\n" + 
					 "           BOARD_COUNT\r\n" + 
					 "      FROM BOARD\r\n" + 
					 "     WHERE DEL_YN = 'N'\r\n" + 
					 "       AND BOARD_NO = "+sel;
		
		
		return jdbc.selectList(sql, BoardVo.class);
	}
	
	public void boardCountUp(int sel) {
		String countUp = "    UPDATE BOARD\r\n" + 
				 "       SET BOARD_COUNT = BOARD_COUNT + 1\r\n" + 
				 "     WHERE BOARD_NO = "+sel;
		
		jdbc.update(countUp);
	}
	
	
}
