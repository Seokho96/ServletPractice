package work02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.MemberDto;

@WebServlet("/man")
public class ManServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberDto dto = (MemberDto)req.getAttribute("mem");
		
    resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>남성 사이트</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		pw.println("<div align='center'>");
		pw.println("<h1>남성사이트!</h1>");
		pw.println("<br><br><p>이름: " + dto.getName() + "</p><br>");
		pw.println("<p>나이: " + dto.getAge() + "</p><br>");
		
		String hobby[] = dto.getHobby();
		for (int i = 0; i < dto.getHobby().length; i++) {			
			pw.println("<p>취미: " + hobby[i] + "</p>");
		}
		pw.println("</div>");
		pw.println("</body>");
		
		pw.println("</html>");		
		
		pw.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	

}
