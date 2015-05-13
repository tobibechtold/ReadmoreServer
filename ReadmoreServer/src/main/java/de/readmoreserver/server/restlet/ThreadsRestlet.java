package de.readmoreserver.server.restlet;

import java.util.List;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.Form;
import org.restlet.data.MediaType;

import com.google.gson.Gson;

import de.readmoreserver.data.beans.RMThread;
import de.readmoreserver.data.parser.ThreadParser;

public class ThreadsRestlet extends Restlet {
	
	@Override
    public void handle(Request request, Response response) {
        // Print the requested URI path
		Form queryAsForm = request.getResourceRef().getQueryAsForm();
		queryAsForm.getFirstValue("categoryId");
		int categoryId = Integer.parseInt(queryAsForm.getFirstValue("categoryId"));
		int forenId = Integer.parseInt(queryAsForm.getFirstValue("forenId"));
		
		List<RMThread> threads = getThreads(categoryId, forenId);
		
        String message = null;
        
        Gson gson = new Gson();
        message = gson.toJson(threads);
        
        response.setEntity(message, MediaType.TEXT_PLAIN);
    }

	private List<RMThread> getThreads(int categoryId, int forenId) {

		ThreadParser tp = new ThreadParser();
		
		return tp.getThreads(forenId, categoryId);
	}

}
