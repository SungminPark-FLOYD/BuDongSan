package service;

import java.util.List;

import dao.BoardDao;
import vo.BoardVo;

public class BoardService {
	//싱글톤 구현
	private static BoardService instance = null;

	private BoardService() {
		//생성자는 private으로 감싸준다
	}

	public static BoardService getInstance() {
		if (instance == null)
			instance = new BoardService();

		return instance;
	}
	
	BoardDao dao = BoardDao.getInstance();
	
	public void boardDelete(int sel) {
		dao.boardDelete(sel);
	}

	public void boardUpdate(List<Object> param, int sel) {
		dao.boardUpdate(param,sel);
	}
	public List<BoardVo> boardList() {
		return dao.boardList();
	}

	public void boardInsert(List<Object> param) {
		dao.boardInsert(param);
	}
	
	public List<BoardVo> boardDetail(int sel) {
		return dao.boardDetail(sel);
	}
}
