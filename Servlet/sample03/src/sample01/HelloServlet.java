package sample01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet doGet");
	
		createHTML("GET방식", req, resp);		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet doPost");
		
		createHTML("POST방식", req, resp);		
	}	
	
	public void createHTML(String methodType, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		String name = req.getParameter("name");
		System.out.println("name:" + name);
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		
		pw.println("<h1>Hello Servlet</h1>");
		pw.println("<p>" + methodType + "</p>");
		
		pw.println("<h3>name:" + name + "</h3>");
				
		pw.println("</body>");
		
		pw.println("</html>");		
		
		pw.close();
		
	}
	
}





