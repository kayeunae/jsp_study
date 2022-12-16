package ch08.quiz;

import java.util.*;

public class RegistService {
	Map<String, Regist>	regist = new HashMap<>();
	
	public RegistService() {
		Regist r = new Regist("101", "김지우", "서울시", "silver", "010-1111-1111");
		regist.put("101", r);
		
		r = new Regist("102", "홍길동", "인천시", "gold", "010-2222-2222");
		regist.put("102", r);
		
		r = new Regist("103", "율곡", "김포시", "vip", "010-3333-3333");
		regist.put("103", r);	
	}
	
	//모든 고객 정보를 가져오는 메소드
	public List<Regist> findAll() {
		return new ArrayList<>(regist.values());
	}
	
	//id로 원하는 고객을 가져오는 메소드
	public Regist find(String id) {
		return regist.get(id);
	}
}
