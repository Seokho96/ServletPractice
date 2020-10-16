package work02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.MemberDto;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = null;
		
			String name = req.getParameter("name");
			String age = req.getParameter("age");
			String gender = req.getParameter("gender");
			String hobby[] = req.getParameterValues("hobby"); 
		 
			
			/*
			 * System.out.println(name); System.out.println(age);
			 * System.out.println(gender);
			 */
			 
			 
			MemberDto dto = new MemberDto(name, age, gender, hobby);
			
			
			if(gender.trim().equals("남성") ) {
				req.setAttribute("mem", dto);
				
				this.forward("man", req, resp);
			}
			else if((gender.trim().equals("여성") )) { 
				session = req.getSession(true);
				
				session.setAttribute("name", name);
				session.setAttribute("age", age);
				session.setAttribute("gender", gender);
				
				for (int i = 0; i < hobby.length; i++) {
					 String shobby = hobby[i];
			       session.setAttribute("hobby", shobby);
					   }
				resp.sendRedirect("lady");
			}
  
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
   
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

















