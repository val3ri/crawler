package spark.template.velocity;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;

public class SaveFile {
//	private static final File pathA = new File(System.getProperty("user.dir") + "\\resources\\public\\");
//	private static final String pathU = System.getProperty("user.dir");
	private static final DateFormat sdf = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
	private static final String ERROR = "{There is no files with so many words}";

	public static void toJson(String path, String name) throws IOException{
		// toJson("E:/PROG/","LongList")
		Date date = new Date();

		// edin put za SHORT list i oshte vednuj za LONG LIST
		// PATH should be in form = "E:/PROG/"
		// NAME = LongList or ShortList
//		try (FileWriter file = new FileWriter(path + name + " - timestamp " + sdf.format(date) + ".txt")) {
		try (FileWriter file = new FileWriter(path + name + ".json")) {
			if (name == "ShortList"){
				if (WordsCounting.getShortList().isEmpty() == false){
					JSONObject brrrr = WordsCounting.getShortList();
					brrrr.put("TimeStamp", sdf.format(date));
					file.write(brrrr.toJSONString());
				}else{
					file.write(ERROR);
				}
			}else{
				if (WordsCounting.getLongList().isEmpty() == false){
					file.write(WordsCounting.getLongList().toJSONString());
				}else{
					file.write(ERROR);
				}
			}
			//					file.write(getShortList().toJSONString());
			//					System.out.println("Successfully Copied JSON Object to File...");
			//					System.out.println("\nJSON Object: " + getShortList());
			//		}
			//		try (FileWriter file = new FileWriter("/Users/val3r/Documents/longList12 " + sdf.format(date) + ".txt")) {
			//			file.write(WordsCounting.getLongList().toJSONString());
			//			System.out.println("Successfully Copied JSON Object to File...");
			//			System.out.println("\nJSON Object: " + WordsCounting.getLongList());
			//		}
		}
	}
}
