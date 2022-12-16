package ch08;

import java.util.*;

//데이터 샘플을 제공해주는 클래스
public class ProductService {
	//DB 역할
	Map<String, Product> products = new HashMap<>();
	
	public ProductService() {
		Product p = new Product("101", "아이폰12", "애플", 1200000, "2020.12.12");
		products.put("101", p);
		
		p = new Product("102", "갤럭시20", "삼성전자", 1300000, "2021.2.2");
		products.put("102", p);
		
		p = new Product("103", "듀얼폰", "엘지", 1500000, "2021.3.2");
		products.put("103", p);
	}
	
	//모든 상품 데이터를 가져오는 메소드(select * from)
	public List<Product> findAll(){
		//values: products 에 있는 모든 데이터를 반환
		return new ArrayList<>(products.values());
	}	
	
	//id로 원하는 상품을 가져오는 메소드(select * from where id = "101")
	public Product find(String id) {
		return products.get(id);
	}
	
	
}
