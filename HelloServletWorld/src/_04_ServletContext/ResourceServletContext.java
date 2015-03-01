package _04_ServletContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/resourceservletcontext")
public class ResourceServletContext extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/**
		 * Important 
		 * getOutputStream() metodu getWriter() metoduna benzer. Bu
		 * metot binary datayi okumak/yazmak icin uygundur. getWriter() ve
		 * getOutputStream() metotlari ayni anda ayni servlette kullanilamazlar
		 * aksi durumda calisma zamaninda hata ile karsilasiriz.
		 */

		ServletContext context = getServletContext();
		// Reading Properties
		InputStream inputStream = context.getResourceAsStream("/Resource/myproperties.properties");

		Properties props = new Properties();
		props.load(inputStream);

		System.out.println(props.get("name"));
		System.out.println(props.get("surname"));
		

		/**
		 * Reading txt file
		 */
		InputStream inputStream2 = context.getResourceAsStream("/Resource/text.txt");
		int content;
		ServletOutputStream os = resp.getOutputStream();
		while ((content = inputStream2.read()) != -1) {
			System.out.print((char) content);
			os.write(content);
		}
		System.out.println();
		

		/**
		 * Reading txt file getResource metodu geri java.net.URL objesi
		 * dondurmektedir. Bu sinifta yer alan openStream metodu yardimi ile
		 * dosya icerigini okuyabiliriz.
		 */
		URL url = context.getResource("/Resource/text.txt");
		InputStream inputStream3 = url.openStream();

		int content2;
		while ((content2 = inputStream3.read()) != -1) {
			System.out.print((char) content2);
			os.write(content2);
		}
	}
}
