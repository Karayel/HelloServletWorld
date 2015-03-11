package _05_Request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/morerequestmethod")
public class MoreRequest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		// getHeader() metodu ile header bilgilerine ulasabiliriz.
		String hostHeader = req.getHeader("host");
		// getHeaderNames() metodu tum header bilgilerini geri dondururur.
		Enumeration<String> hostHeaders = req.getHeaderNames();
		// getServerName() metodu server ismini dondurur; localhost.
		String serverName = req.getServerName();
		/**
		 * local port ve server port arasinda kucuk bir kavram farkliligi
		 * vardir. server port requestin ilk karsilandigi basladigi porttur.
		 * local port ise bu istegin tamamlandigi porttur.
		 */
		int localPort = req.getLocalPort();
		int serverPort = req.getServerPort();
		//Istegin gonderildigi porttur. Remote’tan kasit client/istemci yani tarayicidir.
		int remotePort = req.getRemotePort();
		//getMethod() , bize kullandigimiz HTTP metodunun tur bilgisini dondurur.
		String method = req.getMethod();
		//getContextPath() metodu context path bilgisini dondurecektir.
		String contexPath = req.getContextPath();
		Enumeration<String> headerNames = req.getHeaderNames();

		pw.write("<html><body>");
		pw.write("<table>");
		pw.println("<tr><td>host<td>" + hostHeader);
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			pw.println("<tr><td>" + headerName);
			pw.println("<td>" + req.getHeader(headerName));
		}

		pw.println("<tr><td>serverName<td>" + serverName);
		pw.println("<tr><td>localPort<td>" + localPort);
		pw.println("<tr><td>serverPort<td>" + serverPort);
		pw.println("<tr><td>remotePort<td>" + remotePort);
		pw.println("<tr><td>method<td>" + method);
		pw.println("<tr><td>contexPath<td>" + contexPath);
		pw.write("</table>");
		pw.write("</body></html>");
		pw.write("Host Headers ");

		while (hostHeaders.hasMoreElements()) {
			pw.println(hostHeaders.nextElement());
		}
	}
}
