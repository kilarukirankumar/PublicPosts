package com.kilarukiran.publicposts.ResponseModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tiny {

    @SerializedName("https")
    @Expose
    private String https;

    public String getHttps() {
        return https;
    }

    public void setHttps(String https) {
        this.https = https;
    }

}
