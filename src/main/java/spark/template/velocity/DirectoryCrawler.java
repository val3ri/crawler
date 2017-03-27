package spark.template.velocity;
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class DirectoryCrawler{
	
	public static void main(String [] args) throws Exception{
		
		Scanner folder = new Scanner(System.in);
		System.out.println("give a foleder, for example - E:/PROG");
		String folderName = folder.nextLine();
		folder.close();
		//Starting directory for parsing
		File aStartingDir = new File(folderName);
		DirectoryCrawlerClass.directoryCrawler(aStartingDir);
		System.out.println("Parsing complete");
//		filesAndDirs
//		DirectoryCrawlerClass.printingList();
//		System.out.println("-----");
//		System.out.println(DirectoryCrawlerClass.getAllFiles().get(5).isFile());
		
		System.out.println("-----");
//		String[] testTest = new String[] {"a","b","c"};
//		for (String test : testTest){
//			System.out.println(test);
//		}
		System.out.println("-----");
		List<File> a = DirectoryCrawlerClass.getAllFiles();
		FilterFileExtentsion.checkFileForText(a);
		List<File> bc = FilterFileExtentsion.getTextFiles();
//		String f = a.get(2).getPath();
//		String c = a.get(2).getName();
//		boolean b = a.get(2).getName().endsWith("txt");
//		System.out.println(f);
//		System.out.println(c);
//		System.out.println(b);
		
//		System.out.println("--all files---");
//		DirectoryCrawlerClass.printingList();
//		System.out.println("--text files---");
		//for (File asd : bc){
		//	System.out.println(asd.getPath());
		//}
		System.out.println("--words in files---");
		WordsCounting.countWords(bc);
		System.out.println("-----");
//		WordsCounting.sortFiles(1230);
		
//		for (File ac : b){
//			System.out.println(ac.getPath());
//		}
//		String a = DirectoryCrawlerClass.textFiles.get(3).toString();
//		String[] b = a.split(".");
		System.out.println("-----");
//		for(String t : b){
//			System.out.println("tryhard");
//			System.out.println(t);
//		}
		System.out.println("------------opalq---------------");
		File example = new File("E:/PROG/testdata/Andromeda.txt/");
		DirectoryCrawlerClass.getFolder(example);
		
		System.out.println("long:");
		System.out.println(WordsCounting.getLongList());
		System.out.println("short:");
		System.out.println(WordsCounting.getShortList());
		
	}
	
	
}
