package de.readmoreserver.server.main;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

import de.readmoreserver.server.restlet.ForumRestlet;

public class ReadmoreServer extends Application {
	
	private static ForumRestlet forumRestlet;
	
	static {
		forumRestlet = new ForumRestlet();
	}
	
	
	public static void main(String[] args) throws Exception {
		
		Component component = new Component();
		component.getServers().add(Protocol.HTTP, 8182);
		
		ReadmoreServer server = new ReadmoreServer();
		
		component.getDefaultHost().attach("", server);
		
		component.start();
	}
	
	public Restlet createRoot() {
	    Router router = new Router(getContext());
	    router.attach("/category/{categoryId}/forum/{forenId}", forumRestlet);
	    return router;
	  }
	


}
