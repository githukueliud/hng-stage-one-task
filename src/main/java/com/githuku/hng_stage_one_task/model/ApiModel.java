package com.githuku.hng_stage_one_task.model;

public class ApiModel {
    private String client_ip;
    private String visitor_name;
    private String location;
    private String greeting;

    public ApiModel(String client_ip, String visitor_name, String location, String greeting) {
        this.client_ip = client_ip;
        this.visitor_name = visitor_name;
        this.location = location;
        this.greeting = greeting;
    }


    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public String getVisitor_name() {
        return visitor_name;
    }

    public void setVisitor_name(String visitor_name) {
        this.visitor_name = visitor_name;
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
