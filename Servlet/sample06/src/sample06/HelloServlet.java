
package sample06;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ObjectDto;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String sAge = req.getParameter("age");
		
		System.out.println("name:" + name);
		System.out.println("age:" + sAge);
		
		int age = 0;
		if(sAge == null || sAge.trim().equals("")) {
			resp.sendRedirect("index.html");
		}else {
			age = Integer.parseInt(sAge);
		}
		
		String fruits[] = req.getParameterValues("fruit");
		for (int i = 0; i < fruits.length; i++) {
			System.out.println(fruits[i]);
		}
		
		// servlet(java) -> servlet(java)
		// servlet(java) -> jsp
		
		// ResultServlet으로 이동
	//	resp.sendRedirect("result");
		
		
		// 데이터 모으기
		ObjectDto dto = new ObjectDto(name, age, fruits);
		
		// 짐싸!
		req.setAttribute("myfruit", dto);
				
	//	RequestDispatcher dispatch = req.getRequestDispatcher("result");
	//	dispatch.forward(req, resp);
				
		// 잘가
		req.getRequestDispatcher("result").forward(req, resp);
			
	//	resp.sendRedirect("result?name=" + name + "&age=" + age + "&fruit=" + fruits[0]);		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	
}
