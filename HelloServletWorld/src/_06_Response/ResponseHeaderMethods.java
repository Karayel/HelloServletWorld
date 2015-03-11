package _06_Response;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responseheadermethods")
public class ResponseHeaderMethods extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// setHeader methodu ile response header ekliyoruz.İLgili isme sahip
		// header yoksa olusturu varsa override eder
		resp.setHeader("firstName", "myname");
		resp.setHeader("firstName", "myName");
		// getHeaderNames methodu ile bütün header namelere ulaşırız.
		Collection<String> headernames = resp.getHeaderNames();
		// getHeaders methodu ilgili headera ait value degerini Collection
		// olarak döndürür.
		String headervalues = resp.getHeader("firstName");

		boolean header = resp.containsHeader("firstName");
		for (String hn : headernames) {
			System.out.println("Header Name " + hn);
		}
		System.out.println("Header value " + headervalues);

		System.out.println("Contains " + header);

		// addHeader metodu override yapmaz! Bunun yerine ekleme yapacaktir.
		// firstName ismine sahip response header'inin 3 tane degeri var.
		resp.addHeader("firstName", "your name");
		resp.addHeader("firstName", "his name");

		// Sadece ilk headerın degerini döndürür.
		String firstName = resp.getHeader("firstName");
		System.out.println("firstName:" + firstName);
		// İlgili headerın bütün degerlerini döndürür.
		Collection<String> firstNames = resp.getHeaders("firstName");
		for (String fn : firstNames) {
			System.out.println(fn);
		}

		// setIntHeader ve addIntHeader da value parametresi int tipindedir.
		// Bu sayede int tipindeki bir degiskeni String'e convert etmeden direkt
		// kullanabiliriz.

		resp.setIntHeader("year", 571);
		resp.addIntHeader("year", 1071);

		// Benzer sekilde setDateHeader ve addDateHeader metodunun value kismi
		// long tipindedir.
		resp.setDateHeader("today", System.currentTimeMillis());
		resp.addDateHeader("today", 10000000L);

		System.out.println("#### getHeaderNames ####");

		// getHeaderNames metodu bize response header'larin ismini donecektir.
		Collection <String >headerNames = resp.getHeaderNames();
		for (String headerName : headerNames) {
			System.out.println(headerName);

		}

	}
}
