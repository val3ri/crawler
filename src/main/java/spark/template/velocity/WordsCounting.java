package spark.template.velocity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WordsCounting {

	private static final String pathUser = new String(System.getProperty("user.dir") + "\\resources\\public\\");

	// private static JSONObject s = new JSONObject();
	// private static List<List<String>> shortList = new
	// ArrayList<List<String>>();
	// private static List<List<String>> longList = new
	// ArrayList<List<String>>();

	private static JSONObject shortList = new JSONObject();
	private static JSONObject longList = new JSONObject();

	public static JSONObject getShortList() {
		return shortList;
	}

	public static JSONObject getLongList() {
		return longList;
	}

	public static void setShortList(JSONObject shortList) {
		WordsCounting.shortList = shortList;
	}

	public static void setLongList(JSONObject longList) {
		WordsCounting.longList = longList;
	}

	public static void countWords(List<File> files) throws Exception {
		// String fileVar = "E:\\PROG\\testdata\\Germany.txt";
		// System.out.println ("Counting Words");
		for (File file : files) {
			// for words appearances - HashMap
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			int count = 0;
			while (line != null) {
				// split characters: ':' ';' ',' '.' '[' ']' '(' ')' '\t' ' '
				String[] parts = line.split("[:;,.\\[\\]\\(\\)\\t ]");
				for (String w : parts) {
					// checks if they are is an empty space saved like an
					// element
					if (w.isEmpty() != true) {
						// System.out.println(w);
						count++;
						// if statement for checking the HashMap
						if (map.containsKey(w)) {
							// increase count to 1 if this word has already
							// existed in map
							int appsWord = map.get(w) + 1;
							map.put(w, appsWord);
						} else {
							map.put(w, 1);
						}
					}
				}
				line = br.readLine();
			}
			br.close();
			System.out.println(file.getPath() + " ===words=== " + count);
			// System.out.println(map);
			sortFiles(count, file, map);
			// if count >= 1000 save file in the long list and count the words
			// apps
			// else save file in the short list
			// maybe is good idea to create a method that does all this
		}

	}

	/**
	 * 
	 * @param count
	 * @param file
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static void sortFiles(int count, File file, HashMap<String, Integer> map) throws IOException {
		if (count >= 1000) {
			// longList.put(file.getAbsolutePath(), count);
			System.out.println("long list " + file.getName() + "___" + count);
			// String[]
			// longList.add(file.getPath());
			// BETA
			// String name = file.getAbsolutePath();
			longList.put(file.getAbsolutePath(), count);
			JSONArray fileWords = new JSONArray();
			for (String key : map.keySet()) {
				if (map.get(key) >= 50) {
					// longList.put(file.getAbsoluteFile(), key + " " +
					// map.get(key));
					fileWords.add(key + " " + map.get(key));
				}
			}
			longList.put(file.getName() + " -words app- ", fileWords);
			setLongList(longList);
			// ======>>>>>>>>>> <<<<<<<<<<================
			SaveFile.toJson(pathUser, "LongList");
		} else {
			shortList.put(file.getName(), count);
			System.out.println("short list " + count);
			setShortList(shortList);
			SaveFile.toJson(pathUser, "ShortList");
		}
	}

}