package de.readmoreserver.server.restlet;

import java.util.List;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.Form;
import org.restlet.data.MediaType;

import com.google.gson.Gson;

import de.readmoreserver.data.beans.Beitrag;
import de.readmoreserver.data.beans.RMThread;
import de.readmoreserver.data.parser.BeitragParser;
import de.readmoreserver.data.parser.ThreadParser;

public class BeitragRestlet extends Restlet {

	@Override
    public void handle(Request request, Response response) {
        // Print the requested URI path
		Form queryAsForm = request.getResourceRef().getQueryAsForm();
		int categoryId = Integer.parseInt(queryAsForm.getFirstValue("categoryId"));
		int forenId = Integer.parseInt(queryAsForm.getFirstValue("forenId"));
		int threadId = Integer.parseInt(queryAsForm.getFirstValue("threadId"));
		
		List<Beitrag> threads = getBeitraege(categoryId, forenId, threadId);
		
        String message = null;
        
        Gson gson = new Gson();
        message = gson.toJson(threads);
        
        response.setEntity(message, MediaType.TEXT_PLAIN);
    }

	private List<Beitrag> getBeitraege(int categoryId, int forenId, int threadId) {

		BeitragParser tp = new BeitragParser();
		
		return tp.getBeitraege(forenId, categoryId, threadId);
	}
}
