package com.zhxg.listener;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Application Lifecycle Listener implementation class MemebersListener
 *
 */
@WebListener
public class MemebersListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public MemebersListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub


    	
    	ServletContext serverContext= event.getSession().getServletContext();
    	if(event.getName().equals("user")) {
    		//有用户登录
    		Integer total=(Integer)serverContext.getAttribute("total");
    		if(total==null) {
    			total=1;
    			serverContext.setAttribute("total", 1);
    		}else {
    			serverContext.setAttribute("total", ++total);
    		}
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub

    	ServletContext serverContext= event.getSession().getServletContext();
    	Integer num=(Integer)serverContext.getAttribute("total");
    	if(num==null) {
    		num=0;
    	}else {
    		num--;
    	}
    	if(num<=0) {
    		num=0;
    	}
    	serverContext.setAttribute("total", num);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub

    	
    	HttpSession session= event.getSession();
    	Object o=session.getAttribute("user");
    	if(o!=null) {
    		return;
    	}
    	ServletContext serverContext=session.getServletContext();
    	
    	if(event.getName().equals("user")) {
    		//有用户登录
    		Integer total=(Integer)serverContext.getAttribute("total");
    		if(total==null) {
    			total=1;
    			serverContext.setAttribute("total", 1);
    		}else {
    			serverContext.setAttribute("total", ++total);
    		}
    	}
    }
	
}
