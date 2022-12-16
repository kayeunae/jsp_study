package ch08;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch08.quiz.Regist;
import ch08.quiz.RegistService;

/**
 * Servlet implementation class RegistController
 */
@WebServlet("/rcontrol")
public class RegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RegistService regiService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		regiService = new RegistService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String view = ""; //주소창 url일 될 부분
		
		if(action == null) {
			getServletContext().getRequestDispatcher("/rcontol?action=list").forward(request, response);
		} else {
			switch(action) {
			case "list"	: view = list(request, response); break;
			case "info"	: view = info(request, response); break;
			}
			
			getServletContext().getRequestDispatcher("/ch08/" + view).forward(request, response);
		}
	}
       
	//registList.jsp 뷰를 보여줄 메소드 (findAll 메소드 실행)
		private String list(HttpServletRequest request, HttpServletResponse response) {
			List<Regist> rlist = regiService.findAll();
			request.setAttribute("regist", rlist);
			return "registList.jsp";
		}
		
		//registInfo.jsp 뷰를 보여줄 메소드 (find 메소드 실행)
		private String info(HttpServletRequest request, HttpServletResponse response) {
			Regist r = regiService.find(request.getParameter("id"));
			request.setAttribute("r", r);
			return "registInfo.jsp";
		}

}
