package com.kilarukiran.publicposts.ResponseModel;

/**
 * Created by kirankumarkilaru on 03/05/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Large {

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
