package _04_ServletContext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/moreservletcontext")
public class MoreServletContext extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/**
		 * getRealPath() metodu ; verilen virtual pathe karsilik bize real path
		 * bilgisini donecektir. /test.txt , /helloservletcontext bilgilerine
		 * karsilik real path bilgisini elde ederiz.
		 * 
		 * getContextPath() metodu; Projemizin context path bilgisini bize
		 * dondurecektir.
		 * 
		 * getServletContextName() metodu; Projemizin context adini bize
		 * dondurecektir.
		 */
		ServletContext context = getServletContext();

		System.out.println(context.getRealPath("/Resource/text.txt"));
		System.out.println(context.getContextPath());
		System.out.println(context.getServletContextName());

	}
}
