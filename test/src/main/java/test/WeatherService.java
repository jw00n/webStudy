package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Model.WeatherDTO;

public class WeatherService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("====Weather Service====");
		request.setCharacterEncoding("utf-8");

		
		String location = request.getParameter("location");

		String weather = searchWeather(location);
		String temperature=searchTemperature(location);
		
		System.out.println("날씨"+weather+"\n온도"+temperature);
		WeatherDTO wdto=new WeatherDTO(location, temperature, weather);
		
		HttpSession session= request.getSession(); 
		session.setAttribute("wdto", wdto);
		response.sendRedirect("result.jsp");
	}
	
	
	public String searchWeather(String location) {
		String URL = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=" + location + "+날씨";

		String present_wt="";	
	
		
		try {
			// 2. Connection 생성
			Connection conn = Jsoup.connect(URL);
			// 3. HTML 파싱.
			Document html = conn.get(); // conn.post();

			// 4. 요소 탐색
			Elements weather_mains = html.getElementsByClass("weather_main");
			Element weather_main = weather_mains.get(0);

			present_wt = weather_main.getElementsByClass("blind").get(0).text();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return present_wt;
	}
	
	public String searchTemperature(String location) {
		String URL = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=" + location + "+날씨";

		String present_tp = "";
		try {
			// 2. Connection 생성
			Connection conn = Jsoup.connect(URL);
 
			// 3. HTML 파싱.
			Document html = conn.get(); // conn.post();

			// 4. 요소 탐색
			Elements temperatures = html.getElementsByClass("temperature_text");
			Element temperature= temperatures.get(0);
			
			present_tp= temperature.text();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return present_tp;
	
	}

}
