package work02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/lady")
public class LadyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		

		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		HttpSession session = req.getSession();
		
		String name = (String)session.getAttribute("name");
		String age = (String)session.getAttribute("age");
		String hobby = (String)session.getAttribute("hobby");
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>여성 사이트</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		pw.println("<div align='center'>");
		pw.println("<h1>여성사이트!</h1>");
		pw.println("<br><br><p>이름: " + name + "</p><br>");
		pw.println("<p>연령대: " + age + "</p><br>");
		pw.println("<p>취미: " + hobby + "</p><br>");
	
		
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
