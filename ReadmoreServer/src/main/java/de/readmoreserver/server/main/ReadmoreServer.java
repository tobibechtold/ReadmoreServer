package de.readmoreserver.server.main;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.resource.ServerResource;
import org.restlet.routing.Router;

import de.readmoreserver.server.restlet.BeitragRestlet;
import de.readmoreserver.server.restlet.ForumRestlet;
import de.readmoreserver.server.restlet.ThreadsRestlet;

public class ReadmoreServer extends Application {
	
	private static ThreadsRestlet threadsRestlet;
	private static ForumRestlet forumRestlet;
	private static BeitragRestlet beitragRestlet;
	
	static {
		threadsRestlet = new ThreadsRestlet();
		forumRestlet = new ForumRestlet();
		beitragRestlet = new BeitragRestlet();
	}
	
	
	public static void main(String[] args) throws Exception {
		
		Component component = new Component();
		component.getServers().add(Protocol.HTTP, 8182);
		
		ReadmoreServer server = new ReadmoreServer();
		
		component.getDefaultHost().attach("", server);
		
		component.start();
	}
	
	public Restlet createInboundRoot() {
	    Router router = new Router(getContext());
	    router.attach("/threads", threadsRestlet);
	    router.attach("/forum", forumRestlet);
	    router.attach("/beitrag", beitragRestlet);
	    return router;
	  }
}
