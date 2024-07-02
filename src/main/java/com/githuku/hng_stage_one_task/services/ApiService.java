package com.githuku.hng_stage_one_task.services;



import com.githuku.hng_stage_one_task.model.location.IpAddressInfo;
import com.githuku.hng_stage_one_task.model.response.NewWeatherResponse;
import com.githuku.hng_stage_one_task.model.weather.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;




@Service
public class ApiService {

    RestTemplate restTemplate = new RestTemplate();

    private static final String LOCATION_API_KEY = "33f00175f1f74da1869deacbfaa64ed4";
    private static final String URL_TEMPLATE = "https://ipgeolocation.abstractapi.com/v1/?api_key=" + LOCATION_API_KEY + "&ip_address={ipAddress}";
    public static final String WEATHER_API_KEY = "eac37c91340095cc790053359ea851d8";
    public static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&units=metric&appid=" + WEATHER_API_KEY;
    private static final String WEATHER_URL_TEMPLATE = "https://api.weatherapi.com/v1/current.json?key=a988eef3a8a84d20a35145522240207&q={lat},{lon}&aqi=no";


    public IpAddressInfo getJsonFromEndpoint(String ipAddress) {

        return restTemplate.getForObject(URL_TEMPLATE, IpAddressInfo.class, ipAddress);
    }

    public NewWeatherResponse getWeatherInfo(Double lat, Double lon) {
        return restTemplate.getForObject(WEATHER_URL_TEMPLATE, NewWeatherResponse.class, lat, lon);
    }
}
