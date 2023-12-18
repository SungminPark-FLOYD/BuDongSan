package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.PropertyDao;
import vo.PropertyVo;

public class PropertyService {
	//싱글톤 구현
	private static PropertyService instance = null;

	private PropertyService() {
		//생성자는 private으로 감싸준다
	}

	public static PropertyService getInstance() {
		if (instance == null)
			instance = new PropertyService();

		return instance;
	}
	
	PropertyDao dao = PropertyDao.getInstance();

	public List<PropertyVo> searchListService(List<Object> searchList) {
		
		return dao.searchListService(searchList);
	}

	public PropertyVo searchDetail(String pro_no) {
		
		return dao.searchDetail(pro_no);
	}
	
	

	public void insertPro(List<Object> insertPro, String mem_no) {
		//판매 매물 업데이트
		List<Object> param = new ArrayList<Object>();
		String pro_no = (String) insertPro.get(0);		
		String agent_no = (String) insertPro.get(3);
		
		param.add(mem_no);
		param.add(pro_no);
		param.add(agent_no);
		
		dao.insertPro(insertPro);
		dao.insertSale(param);
		
	}
	
	public void proDelete(String sel) {
		dao.proDelete(sel);
	}
	
	public PropertyVo getProNo() {		
		return dao.getProNO();
	}

	public List<PropertyVo> printPro() {
		return dao.printPro();
	}
	
	
}
