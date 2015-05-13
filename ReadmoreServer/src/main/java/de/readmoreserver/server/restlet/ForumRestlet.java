package de.readmoreserver.server.restlet;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;

public class ForumRestlet extends Restlet {
	
	@Override
    public void handle(Request request, Response response) {
        // Print the requested URI path
		String categoryId = (String) request.getAttributes().get("categoryId");
		String forenId = (String) request.getAttributes().get("forenId");
		
        String message = "CategoryId: " + categoryId + " ForenId: " + forenId;
        response.setEntity(message, MediaType.TEXT_PLAIN);
    }

}
