package de.readmoreserver.server.restlet;

import java.util.List;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;

import com.google.gson.Gson;

import de.readmoreserver.data.beans.Forum;
import de.readmoreserver.data.parser.ForenParser;

public class ForumRestlet extends Restlet {
	
	@Override
    public void handle(Request request, Response response) {
		
		List<Forum> forum = getForum();
		
        String message = null;
        
        Gson gson = new Gson();
        message = gson.toJson(forum);
        
        response.setEntity(message, MediaType.TEXT_PLAIN);
    }

	private List<Forum> getForum() {

		ForenParser tp = new ForenParser();
		
		return tp.getForen();
	}

}
