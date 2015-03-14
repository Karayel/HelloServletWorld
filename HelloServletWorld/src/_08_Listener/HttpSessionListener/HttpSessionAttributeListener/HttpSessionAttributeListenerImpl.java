package _08_Listener.HttpSessionListener.HttpSessionAttributeListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener("HttpSessionAttributeListenerImpl")
public class HttpSessionAttributeListenerImpl implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("Session attributeAdded : " + se.getName() + " " + se.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("Session attributeRemoved : " + se.getName() + " " + se.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("Session attributeReplaced : " + se.getName() + " " + se.getValue());

	}

}