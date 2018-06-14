package de.raoulis.testplugin.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler {

	// save Object in File
	public static void save(Object obj, File path) throws Exception {
		//create File if don't exist
		if (!path.exists()) {
			File parent = path.getParentFile();
			parent.mkdirs();
			path.createNewFile();
		}
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
	}

	// load Object from File
	public static Object load(File path) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		Object result = ois.readObject();
		ois.close();
		return result;
	}
}
