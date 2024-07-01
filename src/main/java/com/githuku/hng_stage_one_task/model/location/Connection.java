package com.githuku.hng_stage_one_task.model.location;



import com.fasterxml.jackson.annotation.JsonProperty;

public class Connection {
    @JsonProperty("autonomous_system_number")
    private int autonomousSystemNumber;
    @JsonProperty("autonomous_system_organization")
    private String autonomousSystemOrganization;
    @JsonProperty("connection_type")
    private String connectionType;
    @JsonProperty("isp_name")
    private String ispName;
    @JsonProperty("organization_name")
    private String organizationName;


    public int getAutonomousSystemNumber() {
        return autonomousSystemNumber;
    }

    public void setAutonomousSystemNumber(int autonomousSystemNumber) {
        this.autonomousSystemNumber = autonomousSystemNumber;
    }

    public String getAutonomousSystemOrganization() {
        return autonomousSystemOrganization;
    }

    public void setAutonomousSystemOrganization(String autonomousSystemOrganization) {
        this.autonomousSystemOrganization = autonomousSystemOrganization;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public String getIspName() {
        return ispName;
    }

    public void setIspName(String ispName) {
        this.ispName = ispName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
}


