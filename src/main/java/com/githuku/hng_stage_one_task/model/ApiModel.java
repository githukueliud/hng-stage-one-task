package com.githuku.hng_stage_one_task.model;

public class ApiModel {
    private String client_ip;
    //private String visitor_name;
    private String location;
    private String greeting;
    //private double temperature;

    public ApiModel(String client_ip, String location, String greeting) {
        this.client_ip = client_ip;
        this.location = location;
        this.greeting = greeting;
    }




    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }



    @Override
    public String toString() {
        return super.toString();
    }
}
