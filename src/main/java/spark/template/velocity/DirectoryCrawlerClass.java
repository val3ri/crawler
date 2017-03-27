package spark.template.velocity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DirectoryCrawlerClass {
	private static List<File> allFiles = new ArrayList<File>();
//	static File[] filesAndDirs;
	
	public static List<File> getAllFiles() {
		return allFiles;
	}

	public static void directoryCrawler(File aStartingDir){
		File[] filesAndDirs = aStartingDir.listFiles();
		List<File> dir = new ArrayList<File>();
		
		//Current Directory being traversed
//		System.out.println("------------------------------------------------");
//		System.out.println("Current directory: " + aStartingDir.toString());
//		System.out.println("------------------------------------------------");
//		System.out.println("Files in the folder:");
//		System.out.println("------------------------------------------------");
		//List all files in directory
		for(File file:filesAndDirs){
			if (file.isFile()) {
				//Display file names
//				System.out.println(file.getPath());
//				if (file.getName().endsWith("txt")){
					allFiles.add(file);
//				}
			}
			else {
				//Add first level directory to a list
				dir.add(file);
			}
		}
		if(dir.isEmpty())
			return;
		else {
			/*Traverse directory structure recursively
			by calling directory crawler */
			for(File file:dir){
				directoryCrawler(file);
			}
		}
//		System.out.println("experiment");
//		System.out.println("experiment");
//		for(File d : dir){
//			System.out.println(d);
//		}
//		System.out.println("experiment");
//		System.out.println("experiment");
	}
	
	public static void printingList(){
//		System.out.println("------");
//		System.out.println("------");
//		System.out.println("------");
		for(File file : allFiles){
			if (file.isFile()){
				System.out.println(file.getPath());
			}
		}
	}
	
	public static void getFolder(File currFile){
		String pattern = Pattern.quote(System.getProperty("file.separator"));
//		String x = getAllFiles().get(8).toString();
		// current path
		String currFilePath = currFile.getPath();
		System.out.println("PATH: " + currFilePath);
		
//		System.out.println(getAllFiles().get(8));
//		String x = "E:\PROG\testdata";
//		File asd = (File) getAllFiles();
//		String[] asb = asd.list();
		// split the path to peaces
		String[] elements = currFilePath.split(pattern);
		
		// for testing only to check if it works properly 
//		for (String element : elements){
//			System.out.println(element);
//		}
		
		if(currFile.isFile()){
			System.out.println("subfolder: " + elements[(elements.length-2)]);
		}else{
			System.out.println("is not a file");
		}
	}
}
