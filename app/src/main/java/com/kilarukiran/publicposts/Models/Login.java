package com.kilarukiran.publicposts.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kirankumarkilaru on 03/05/17.
 */

public class Login implements Parcelable {
    private String mUserName;
    private String mPassword;
    private String mUserNameError;
    private String mPasswordError;

    public Login(){}

    public Login(Parcel in){
        setUserName(in.readString());
        setPassword(in.readString());
        setUserNameError(in.readString());
        setPasswordError(in.readString());
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        this.mUserName = userName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }

    public String getUserNameError() {
        return mUserNameError;
    }

    public void setUserNameError(String mUserNameError) {
        this.mUserNameError = mUserNameError;
    }

    public String getPasswordError() {
        return mPasswordError;
    }

    public void setPasswordError(String mPasswordError) {
        this.mPasswordError = mPasswordError;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mUserName);
        dest.writeString(mPassword);
        dest.writeString(mUserNameError);
        dest.writeString(mPasswordError);
    }

    public static final Parcelable.Creator<Login> CREATOR =
            new Parcelable.Creator<Login>(){

                @Override
                public Login createFromParcel(Parcel source) {
                    return new Login(source);
                }

                @Override
                public Login[] newArray(int size) {
                    return new Login[0];
                }
            };
}
