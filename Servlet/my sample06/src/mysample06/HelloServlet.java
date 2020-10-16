package mysample06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.ObjectDto;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String sAge = req.getParameter("age");
		String fruits[] = req.getParameterValues("fruit");
		
		System.out.println(name);
		System.out.println(sAge);  
		
		int age = 0;
		if(sAge == null || sAge.trim().equals("")) {
			resp.sendRedirect("index.html");
		}
		else {
			age = Integer.parseInt(sAge);
		}
		for (int i = 0; i < fruits.length; i++) {
			System.out.println(fruits[i]);
		}
		
		ObjectDto dto = new ObjectDto(name, age, fruits);
		
		req.setAttribute("myfruit", dto);
		
		req.getRequestDispatcher("result").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}















