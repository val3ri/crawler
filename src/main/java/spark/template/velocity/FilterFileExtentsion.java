package spark.template.velocity;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class FilterFileExtentsion {

	private final static String txtExtension = new String ("txt");
	private static List<File> textFiles = new ArrayList<File>();

	public static List<File> getTextFiles() {
		return textFiles;
	}

	public static void checkFileForText(List<File> fileList) {
		for (File file : fileList){		

			if (file.getName().toLowerCase().endsWith(txtExtension))
			{
				// add to File[] where are all .txt files
				textFiles.add(file);	
			}
		}
	}
}
