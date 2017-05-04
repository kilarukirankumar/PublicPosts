package com.kilarukiran.publicposts.ViewModels;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.design.widget.TextInputLayout;
import android.view.View;

import com.kilarukiran.publicposts.BR;
import com.kilarukiran.publicposts.Models.Login;
import com.kilarukiran.publicposts.R;
import com.kilarukiran.publicposts.Utilities.PasswordValidator;
import com.kilarukiran.publicposts.Views.PhotosActivity;

public class LoginViewModel extends BaseObservable implements ViewModel {

    private Context mContext;
    private Login mLogin;

    public LoginViewModel(Login login, Context context){
        this.mLogin = login;
        this.mContext = context;
    }

    @Bindable
    public String getUserName() {
        return mLogin.getUserName();
    }

    public void setUserName(String userName) {
        mLogin.setUserName(userName);
        notifyPropertyChanged(com.kilarukiran.publicposts.BR.userName);
    }

    private void validateUserName(){
        if(mLogin.getUserName() == null || mLogin.getUserName().length() == 0){
            mLogin.setUserNameError(mContext.getString(R.string.username_req_error));
        }
        else
            mLogin.setUserNameError("");
    }

    @Bindable
    public String getUserNameError(){
        return mLogin.getUserNameError();
    }

    @Bindable
    public String getPassword() {
        return mLogin.getUserName();
    }

    public void setPassword(String password) {
        mLogin.setPassword(password);
    }

    @BindingAdapter("userNameErrorText")
    public static void setUserNameError(TextInputLayout view, String error){
        view.setError(error);
    }

    @BindingAdapter("passwordErrorText")
    public static void setPasswordError(TextInputLayout view, String error){
        view.setError(error);
    }

    @Bindable
    public String getPasswordError(){
        return mLogin.getPasswordError();
    }

    private void validatePassword(){
        String password = mLogin.getPassword();
        if(password == null || password.length() == 0){
            mLogin.setPasswordError(mContext.getString(R.string.password_req_error));
        }
        else if(!(new PasswordValidator().validate(password))){
            mLogin.setPasswordError(mContext.getString(R.string.password_validation_error));
        }
        else
            mLogin.setPasswordError("");
    }

    public View.OnClickListener onLoginClicked(){
        return  new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                validateUserName();
                validatePassword();

                notifyPropertyChanged(com.kilarukiran.publicposts.BR.passwordError);
                notifyPropertyChanged(com.kilarukiran.publicposts.BR.userNameError);

                if((mLogin.getUserNameError() == null || mLogin.getUserNameError().length() == 0) &&
                        (mLogin.getPasswordError() == null || mLogin.getPasswordError().length() == 0)){
                    mLogin.setPassword("");
                    notifyPropertyChanged(BR.password);
                    Intent intent = new Intent(mContext, PhotosActivity.class);
                    mContext.startActivity(intent);
                }
            }
        };
    }

    @Override
    public void destroy() {
        this.mContext = null;
        this.mLogin = null;
    }
}
