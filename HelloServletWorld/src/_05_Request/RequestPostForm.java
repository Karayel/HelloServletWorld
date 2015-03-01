package _05_Request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Html/requestpostform")
public class RequestPostForm extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String gender = req.getParameter("gender");
		String maritalStatus = req.getParameter("marital status");
		String[] language = req.getParameterValues("lang");

		PrintWriter pw = resp.getWriter();

		pw.write("Name " + firstName + " Lastname " + lastName);
		pw.write(" gender " + gender);
		pw.write(" marital status " + maritalStatus);
		pw.write(" Language ");
		if (language != null) {
			for (String str : language) {
				pw.write(str + " ");
			}
		}

		Enumeration paraNames = req.getParameterNames();
		while (paraNames.hasMoreElements()) {
			System.out.println(paraNames.nextElement());
		}

		Map<String, String[]> paramMap = req.getParameterMap();
		for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
			System.out.println(entry.getKey() + " "+ Arrays.asList(entry.getValue()));
		}
	}
}
