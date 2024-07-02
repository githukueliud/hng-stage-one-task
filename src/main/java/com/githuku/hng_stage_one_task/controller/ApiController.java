package com.githuku.hng_stage_one_task.controller;


import com.githuku.hng_stage_one_task.model.ApiModel;
import com.githuku.hng_stage_one_task.model.location.IpAddressInfo;
import com.githuku.hng_stage_one_task.model.weather.WeatherResponse;
import com.githuku.hng_stage_one_task.services.ApiService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;

@RestController
@RequestMapping("/api")
public class ApiController {

    public static final String YOUR_UNIQUE_API_KEY = "33f00175f1f74da1869deacbfaa64ed4";


    @Autowired
    private ApiService apiService;


    @GetMapping("/greet")
    public String greeting() {
        return "hello from greetings";
    }


    @GetMapping("/hello")
    public ApiModel getApiEndpoint(@RequestParam String visitor_name, @RequestHeader(value = "X-Forwarded-For", required = false) String xForwardedFor, HttpServletRequest request) {
        String ipAddress = "";
        if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
            ipAddress = xForwardedFor.split(",")[0];
        } else {
            ipAddress = request.getRemoteAddr();
        }
//        try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(), "UTF-8").useDelimiter("\\A")) {
//            ipAddress = s.next();
//            System.out.println("My current IP address is " + ipAddress);
//        } catch (MalformedURLException e) {
//            System.err.println("URL is malformed: " + e.getMessage());
//        } catch (IOException e) {
//            System.err.println("IOException occurred: " + e.getMessage());
//        }
        //apiService.getJsonFromEndpoint("https://ipgeolocation.abstractapi.com/v1/api_key=33f00175f1f74da1869deacbfaa64ed4&ip_address={ipAddress}");
        //https://ipgeolocation.abstractapi.com/v1/api_key=YOUR_UNIQUE_API_KEY&ip_address=166.171.248.255

        IpAddressInfo ipAddressInfo = getIpAddressInfo(ipAddress);
        String city = ipAddressInfo.getCity();
        double lat = ipAddressInfo.getLatitude();
        double lon = ipAddressInfo.getLongitude();
        double temp = getWeatherResponse(lat, lon).getMain().getTemp();
        //cleanse the leading and trailing " from the visitor's name
        if(visitor_name.startsWith("\"") || visitor_name.endsWith("\"")) {
            // Remove leading and trailing double quotes
            visitor_name = visitor_name.replaceAll("^\"|\"$", "");
        }
        String greeting = "Hello, " + visitor_name + "!, the temperature is " + Double.toString(temp) + " degrees Celsius in " + city;

        return new ApiModel(ipAddress, city, greeting);
    }

    private IpAddressInfo getIpAddressInfo(String ipAddress) {
        return apiService.getJsonFromEndpoint(ipAddress);
    }

    private WeatherResponse getWeatherResponse(Double lat, Double lon) {
        return apiService.getWeatherInfo(lat, lon);
    }


}
