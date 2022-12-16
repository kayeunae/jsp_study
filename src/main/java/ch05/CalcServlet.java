package ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request: 클라이언트가 요청한(보낸) 내용들이 담겨있다.
		
		//int형으로 변경 (getParameter는 String형이기 때문!)
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));
		System.out.println("n1: " + n1);
		System.out.println("n2: " + n2);
		
		//연산자는 문자열 형태로 받아옴
		String op = request.getParameter("op");
		System.out.println("op: " + op);
		
		//연산의 결과를 담을 변수
		long result = 0;
		
		switch(op) {
			case "+" : result = n1 + n2; break;
			case "-" : result = n1 - n2; break;
			case "*" : result = n1 * n2; break;
			case "/" : result = n1 / n2; break;
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append("<!doctype html><html><head><title>Hello World Servlet</title></head><body>")
		.append("계산결과: "+ result +"</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//post 방식으로 전달받아서 doPost 실행
	//아래의 doPost는 doGet으로 보내기 때문에 실질적으로는 doGet에서 코드가 실행됨
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
