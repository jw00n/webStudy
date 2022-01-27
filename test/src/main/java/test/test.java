package test;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/*
 public class test {
public static void main(String[] args) {
	
	String present_wt="";	
	String location="광주";
	String URL = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=" + location + "+날씨";

	
	try {
	Connection conn = Jsoup.connect(URL);

	// 3. HTML 파싱.
	Document html = conn.get(); // conn.post();


	// 4. 요소 탐색
	Elements weather_mains = html.getElementsByClass("weather_main");
	Element weather_main = weather_mains.get(0);

	present_wt = weather_main.getElementsByClass("blind").get(0).text();

	System.out.println(present_wt);
} catch (IOException e) {
	e.printStackTrace();
}	
 }
 }*/
	/*
	String present_tp = "";
	String location="광주";
	String URL = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=" + location + "+날씨";

	try {
		// 2. Connection 생성
		Connection conn = Jsoup.connect(URL);

		// 3. HTML 파싱.
		Document html = conn.get(); // conn.post();

		// 4. 요소 탐색
		Elements temperatures = html.getElementsByClass("temperature_text");
		Element temperature= temperatures.get(0);
		
		String data_temp= temperature.text();
		
		System.out.println();
	} catch (IOException e) {
		e.printStackTrace();
	}

}
}

  
 */