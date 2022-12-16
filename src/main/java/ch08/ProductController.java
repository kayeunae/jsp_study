package ch08;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/pcontrol")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//필드 객체 선언
	ProductService prodService;
	
	//init(): Servlet url 맵핑을 마치고 초기화 해주는 메소드!
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
    	//init() 메소드는 최초 요청 시 딱 한 번만 실행, 그래서 객체도 딱 한 번만 생성해서 모든 페이지(?)에서 공통적으로 사용하기 위해 init() 메소드에서 객체 생성하는 코드 작성.
		super.init(config);
		prodService = new ProductService();	//서블릿이 초기화될 때 ProductService 객체 생성
	}
    
    
    //service(): 클라이언트의 request(요청)을 받아 service 실행됨. (doGet이나 doPost로 보냄)
	@Override	//서블릿에서 실행되는 service() 메소드 !
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getParameter: 클라이언트가 요청하면 데이터를 가져옴. 여기서는 action 파라메터의 값을 얻어온다.
		String action= request.getParameter("action");
		System.out.println(action);
		String view = "";
		
		if(action == null) {
			getServletContext().getRequestDispatcher("/pcontrol?action=list").forward(request, response);
		} else {
			switch(action) {
				case "list": view = list(request, response); break;
				case "info": view = info(request, response); break;
			}
			
			getServletContext().getRequestDispatcher("/ch08/" + view).forward(request, response);
		}
	}
	
	//모든 상품의 정보를 가져오는 findAll 메소드 실행. List<>로 받음.
	private String list(HttpServletRequest request, HttpServletResponse response) {
		List<Product> plist = prodService.findAll();
		request.setAttribute("products", plist);
		return "productList.jsp";
	}
	
	//한 가지 상품의 정보를 가져오는 find 메소드를 실행. Product 객체로 받음
	private String info(HttpServletRequest request, HttpServletResponse response) {
		//id 값은 쿼리스트링 내에서 가져옴
		Product p = prodService.find(request.getParameter("id"));
		request.setAttribute("p", p);
		return "productInfo.jsp";
	}

}
