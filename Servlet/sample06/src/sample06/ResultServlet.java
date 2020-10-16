package sample06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ObjectDto;

public class ResultServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ObjectDto dto = (ObjectDto)req.getAttribute("myfruit");
		
		System.out.println(dto.toString());
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		
		pw.println("<h1>Hello Result</h1>");	
		
		pw.println("이름:<input type='text' value=" + dto.getName() + ">");
		pw.println("나이:<input type='text' value=" + dto.getAge() + ">");
		
		String fruits[] = dto.getFluit();
		for (int i = 0; i < dto.getFluit().length; i++) {			
			pw.println("<p>" + fruits[i] + "</p>");
		}
		
		pw.println("</body>");
		
		pw.println("</html>");		
		
		pw.close();
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	
}
