package _08_Listener.ServletContextListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener("ServletContextListenerImpl")
public class ServletContextListenerImp2 implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context initialized 2 ...");

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("context contextDestroyed  2 ...");

	}

}
