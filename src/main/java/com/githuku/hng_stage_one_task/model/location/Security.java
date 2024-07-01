package com.githuku.hng_stage_one_task.model.location;

import com.fasterxml.jackson.annotation.JsonProperty;



public class Security {
    @JsonProperty("is_vpn")
    private boolean isVpn;

    public boolean isVpn() {
        return isVpn;
    }

    public void setVpn(boolean vpn) {
        isVpn = vpn;
    }


}

