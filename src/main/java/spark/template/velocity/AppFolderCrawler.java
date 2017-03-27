package spark.template.velocity;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;

public class AppFolderCrawler {
	public static void main(String[] args) {

		// how to define file location better:
		// -> create a new source folder !!!
		staticFileLocation("/public");
		String layout = "templates/layout.vtl";

		get("/form", (request, response) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("template", "templates/form.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());

		get("/result", (request, response) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			// ===
//			String pathU = System.getProperty("user.dir");
//			System.out.println(pathU);
//			File pathUs = new File(pathU + "\\resources\\public\\");
//			System.out.println(pathUs);

			// ===
			String path = request.queryParams("path");
			System.out.println(path);
			File aStartingDir = new File(path);
			DirectoryCrawlerClass.directoryCrawler(aStartingDir);
			List<File> a = DirectoryCrawlerClass.getAllFiles();
			FilterFileExtentsion.checkFileForText(a);
			List<File> bc = FilterFileExtentsion.getTextFiles();
			WordsCounting.countWords(bc);

			model.put("template", "templates/hello.vtl");
			// System.out.println(request.queryParams());
			return new ModelAndView(model, layout);
			// return WordsCounting.getLongList();
		}, new VelocityTemplateEngine());

		// Gson gson = new Gson();
		// get("/hello", (request, response) -> new MyMessage("Hello World"),
		// gson::toJson);

		// get("/hello", (req, res) -> WordsCounting.getLongList()+ "NOW SHORT
		// LIST " + WordsCounting.getShortList());

		 get("/jsons", (req,res) -> "<a href='/ShortList.json'>shorlist</a> <br>" + " <a href='/LongList.json'> longlist </a>");
	}
}
