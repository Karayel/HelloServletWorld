package _08_Listener.HttpSessionListener;



import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener("HttpSessionListenerImpl")
public class HttpSessionListenerImpl implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {

		System.out.println("sessionCreated .... " + new Date());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {

		System.out.println("sessionDestroyed ... " + new Date());
	}

}
