package Model;

public class WeatherDTO {
	private String location;
	private String temperature;
	private String weather;

	
	public WeatherDTO(String location, String temperature, String weather) {
		this.location = location;
		this.temperature = temperature;
		this.weather = weather;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	//현재 온도 5 이런식으로 오니까 쪼개야돼
	public String getTemperature() {
		
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

}
