package _07_Attribute;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contextattribute")
public class ContextAttribute extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ServletContext context = getServletContext();

		context.setAttribute("contextAttribute", "myContextAttribute");
		// context attribute'ler tum web application icin gecerlidir.
		// projemizi deploy ettikten sonra bu servlet i calistiralim.
		// daha sonrasinda context attribute lerin tum web application icin
		// gecerli oldugunu gormek icin farkli bir browser dan
		// GetContextAttribute servletini calistiralim.

		// injavawetrust/getcontextattribute
	}
}
