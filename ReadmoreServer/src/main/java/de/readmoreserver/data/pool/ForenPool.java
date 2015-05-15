package de.readmoreserver.data.pool;

import java.util.HashMap;

import de.readmoreserver.data.beans.Forum;

public class ForenPool {
	
	private static HashMap<Integer, Forum> foren = new HashMap<Integer, Forum>();
	
	public static HashMap<Integer, Forum> getAllForen() {
		
		return foren;
	}
	
	public static Forum getForum(int id) {
		
		return foren.get(id);
	}
	
	public static void addForum(Forum f) {
		
		foren.put(f.getId(), f);
	}

}
