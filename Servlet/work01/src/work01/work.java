package work01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class work extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");		
		PrintWriter pw = resp.getWriter();
		String name = req.getParameter("name");
		String stNum1 = req.getParameter("stNum1");
		String stNum2 = req.getParameter("stNum2");
		String address = req.getParameter("address");
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>송부 정보</title>");
		pw.println("</head>");		
		pw.println("<body>");
		
		pw.println("</body>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

}
