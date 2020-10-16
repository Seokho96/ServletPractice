package sample07;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.HumanDto;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	System.out.println("HelloServlet doPost");
		req.setCharacterEncoding("utf-8");
				
		String name = req.getParameter("name");
		int age = Integer.parseInt( req.getParameter("age") );
		
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		
		/*
		// Get
		String ename = URLEncoder.encode(name);	// 한글일 경우만
		resp.sendRedirect("sample?name=" + ename + "&age=" + age);
		*/
		
		HumanDto dto = new HumanDto(name, age);
		req.setAttribute("hman", dto);
		
	//	RequestDispatcher dispatcher = req.getRequestDispatcher("sample");
	//	dispatcher.forward(req, resp);	// post -> post
		
		this.forward("sample", req, resp);
		
	}
	
	public void forward(String linkname, HttpServletRequest req, HttpServletResponse resp) {
		RequestDispatcher dispatcher = req.getRequestDispatcher(linkname);
		try {
			dispatcher.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}






