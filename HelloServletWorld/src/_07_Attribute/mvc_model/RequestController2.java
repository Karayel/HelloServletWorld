package _07_Attribute.mvc_model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestcontroller2")
public class RequestController2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		People person1 = new People("Levent", "Erguder", "Bay");
		People person2 = new People("Semih Okan", "Pehlivan", "Bay");
		People person3 = new People("Muhammet", "Cagatay", "Bay");

		List peopleList = new ArrayList();
		peopleList.add(person1);
		peopleList.add(person2);
		peopleList.add(person3);

		req.setAttribute("peopleList", peopleList);

		ServletContext context = getServletContext();

		// RequestDispatcher dispatcher = context
		// .getRequestDispatcher("requestattribute/requestdispatcher.jsp");
		// #### / ile baslamalidir!

		RequestDispatcher dispatcher = context
				.getRequestDispatcher("/requestattribute/requestdispatcher.jsp");

		// RequestDispatcher objesi ServletContext (context) uzerinden elde
		// ediliyorsa bu durumda absolute path kullanilmalidir.
		// Yani / ile baslamalidir!

		dispatcher.forward(req, resp);
	}
}
