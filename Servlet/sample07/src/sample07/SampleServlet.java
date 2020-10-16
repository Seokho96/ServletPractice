package sample07;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.HumanDto;

@WebServlet("/sample")
public class SampleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");		
		System.out.println("SampleServlet doGet");		
		
		String name = req.getParameter("name");
		int age = Integer.parseInt( req.getParameter("age") );
		
		System.out.println("name:" + name);
		System.out.println("age:" + age);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SampleServlet doPost");
		
		HumanDto dto = (HumanDto)req.getAttribute("hman");
		
		System.out.println(dto.toString());
		
		// 다시 짐싸
		req.setAttribute("dto", dto);		
		forward("detail.jsp", req, resp);
				
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
