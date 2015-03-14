package _07_Attribute;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestattribute")
public class RequestAttribute extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setAttribute("requestAttribute", "my request attribute");
		// request objesine attribute ekleyebiliriz.
		// request attribute sadece ilgili request icin gecerlidir.
	}
}
