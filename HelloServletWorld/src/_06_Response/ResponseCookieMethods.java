package _06_Response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responsecookiemethods")
public class ResponseCookieMethods extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Cookie userName = new Cookie("username", "Mert");
		userName.setMaxAge(5); // 5 saniye time out suresi
		// bu servlet bir kere cagirdiktan sonra ResponseCookieTimeoutCheck
		// servlet ini calistiralim.
		
		// Cookilere goz attigimizda 5 saniye sonra userName cookiesi silinecektir.
		Cookie passwordCookie = new Cookie("password", "123456");
        //addHeader() metoduyla da Cookie olusturabiliriz. Bunun icin name degeri Set Cookie olmalidir.
		resp.setHeader("Set-Cookie", "testName=testValue");

		resp.addCookie(userName);
		resp.addCookie(passwordCookie);
		
		Cookie[] cookies=req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				System.out.println(c.getName() + " " + c.getValue());
			}
		}
	}
}
