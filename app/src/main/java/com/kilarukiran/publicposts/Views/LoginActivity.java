package com.kilarukiran.publicposts.Views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.kilarukiran.publicposts.Models.Login;
import com.kilarukiran.publicposts.R;
import com.kilarukiran.publicposts.ViewModels.LoginViewModel;
import com.kilarukiran.publicposts.databinding.LoginActivityBinding;

public class LoginActivity extends AppCompatActivity {

    Login mLogin;
    LoginViewModel mLoginViewModel;
    LoginActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.login_activity);
        if(savedInstanceState == null) {
            mLogin = new Login();
        }
        else{
            mLogin = savedInstanceState.getParcelable("mLogin");
        }
        mLoginViewModel = new LoginViewModel(mLogin, this);
        binding.setLogin(mLoginViewModel);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.login_screen_name));
    }



    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("mLogin", mLogin);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginViewModel.destroy();
    }
}
