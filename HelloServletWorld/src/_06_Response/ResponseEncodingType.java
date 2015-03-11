package _06_Response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responseencodingtype")
public class ResponseEncodingType extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("ISO-8859-9");
		PrintWriter pw = resp.getWriter();
		//Browser Encoding ayarı için <meta charset> tagı kullanılır.
		pw.print("<html>");
        pw.print("<head> <meta charset='ISO-8859-9'> </head>");
        pw.print("<body>");
        pw.println("<p>ışçğüö</p>");
        pw.print("</body> </html>");
		String characterencoding = resp.getCharacterEncoding();
		System.out.println("Character Encoding:" + characterencoding);
	}
}
