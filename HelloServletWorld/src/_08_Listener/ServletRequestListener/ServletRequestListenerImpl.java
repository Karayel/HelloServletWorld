package _08_Listener.ServletRequestListener;

import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener("ServletRequestListenerImpl")
public class ServletRequestListenerImpl implements ServletRequestListener{

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("requestInitialized...");

		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();

		String servletPath = request.getServletPath();
		Date date = new Date();

		System.out.println(servletPath + " " +date);
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request Destroyed...");
	}

}
