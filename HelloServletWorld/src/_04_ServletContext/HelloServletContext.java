package _04_ServletContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServletContext extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ServletContext context = getServletContext();
		ServletConfig config = getServletConfig();

		String name = config.getInitParameter("name");
		String lastName = config.getInitParameter("lastname");
		// String email = config.getServletContext().getInitParameter("email");
		String e_mail = context.getInitParameter("email");
		String address = context.getInitParameter("address");

		PrintWriter pw = resp.getWriter();
		pw.write("<html><body>");
		pw.write(name + "<br>");
		pw.write(lastName + "<br>");
		pw.write(e_mail + "<br>");
		pw.write(address + "<br>");
		pw.write("</html></body>");

		System.out.println("Servlet Context In�t Parameters Name");
		Enumeration<String> contextInitParam = context.getInitParameterNames();
		while (contextInitParam.hasMoreElements()) {
			System.out.println(contextInitParam.nextElement());
		}

		System.out.println("Servlet Config In�t Parameters Name");
		Enumeration<String> servletconfigInitParam = config.getInitParameterNames();
		while (servletconfigInitParam.hasMoreElements()) {
			System.out.println(servletconfigInitParam.nextElement());
		}
	}
}
