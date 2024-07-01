package com.githuku.hng_stage_one_task.controller;


import com.githuku.hng_stage_one_task.model.location.IpAddressInfo;
import com.githuku.hng_stage_one_task.model.weather.WeatherResponse;
import com.githuku.hng_stage_one_task.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    public static final String YOUR_UNIQUE_API_KEY = "33f00175f1f74da1869deacbfaa64ed4";


    @Autowired
    private ApiService apiService;



    @GetMapping("/hello/{visitor_name}")
    public String getApiEndpoint(@PathVariable String visitor_name) {
        String ipAddress = "";
        try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(), "UTF-8").useDelimiter("\\A")) {
            ipAddress = s.next();
            System.out.println("My current IP address is " + ipAddress);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        //apiService.getJsonFromEndpoint("https://ipgeolocation.abstractapi.com/v1/api_key=33f00175f1f74da1869deacbfaa64ed4&ip_address={ipAddress}");
        //https://ipgeolocation.abstractapi.com/v1/api_key=YOUR_UNIQUE_API_KEY&ip_address=166.171.248.255

        IpAddressInfo ipAddressInfo = getIpAddressInfo(ipAddress);
        String city = ipAddressInfo.getCity();
        double lat = ipAddressInfo.getLatitude();
        double lon = ipAddressInfo.getLongitude();
        double temp = getWeatherResponse(lat, lon).getMain().getTemp();
        return "hello " + visitor_name + " your ip address is " + ipAddress + " you live in " + city + " temperature today is " + Double.toString(temp);
    }

    private IpAddressInfo getIpAddressInfo(String ipAddress) {
        return apiService.getJsonFromEndpoint(ipAddress);
    }

    private WeatherResponse getWeatherResponse(Double lat, Double lon) {
        return apiService.getWeatherInfo(lat, lon);
    }


}
