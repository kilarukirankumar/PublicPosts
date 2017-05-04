package com.kilarukiran.publicposts.databinding;
import com.kilarukiran.publicposts.R;
import com.kilarukiran.publicposts.BR;
import android.view.View;
public class LoginActivityBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    public final android.support.v7.widget.AppCompatButton btnLogin;
    public final android.widget.EditText inputPassword;
    public final android.widget.EditText inputUserName;
    private final android.widget.ScrollView mboundView0;
    private final android.support.design.widget.TextInputLayout mboundView1;
    private final android.support.design.widget.TextInputLayout mboundView3;
    // variables
    private com.kilarukiran.publicposts.ViewModels.LoginViewModel mLogin;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener inputPasswordandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of login.password
            //         is login.setPassword((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(inputPassword);
            // localize variables for thread safety
            // login.password
            java.lang.String loginPassword = null;
            // login != null
            boolean loginJavaLangObjectNull = false;
            // login
            com.kilarukiran.publicposts.ViewModels.LoginViewModel login = mLogin;



            loginJavaLangObjectNull = (login) != (null);
            if (loginJavaLangObjectNull) {




                login.setPassword(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private android.databinding.InverseBindingListener inputUserNameandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of login.userName
            //         is login.setUserName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(inputUserName);
            // localize variables for thread safety
            // login != null
            boolean loginJavaLangObjectNull = false;
            // login.userName
            java.lang.String loginUserName = null;
            // login
            com.kilarukiran.publicposts.ViewModels.LoginViewModel login = mLogin;



            loginJavaLangObjectNull = (login) != (null);
            if (loginJavaLangObjectNull) {




                login.setUserName(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public LoginActivityBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds);
        this.btnLogin = (android.support.v7.widget.AppCompatButton) bindings[5];
        this.btnLogin.setTag(null);
        this.inputPassword = (android.widget.EditText) bindings[4];
        this.inputPassword.setTag(null);
        this.inputUserName = (android.widget.EditText) bindings[2];
        this.inputUserName.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.support.design.widget.TextInputLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView3 = (android.support.design.widget.TextInputLayout) bindings[3];
        this.mboundView3.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
            case BR.login :
                setLogin((com.kilarukiran.publicposts.ViewModels.LoginViewModel) variable);
                return true;
        }
        return false;
    }

    public void setLogin(com.kilarukiran.publicposts.ViewModels.LoginViewModel Login) {
        updateRegistration(0, Login);
        this.mLogin = Login;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.login);
        super.requestRebind();
    }
    public com.kilarukiran.publicposts.ViewModels.LoginViewModel getLogin() {
        return mLogin;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeLogin((com.kilarukiran.publicposts.ViewModels.LoginViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeLogin(com.kilarukiran.publicposts.ViewModels.LoginViewModel Login, int fieldId) {
        switch (fieldId) {
            case BR.userNameError: {
                synchronized(this) {
                        mDirtyFlags |= 0x2L;
                }
                return true;
            }
            case BR.userName: {
                synchronized(this) {
                        mDirtyFlags |= 0x4L;
                }
                return true;
            }
            case BR.passwordError: {
                synchronized(this) {
                        mDirtyFlags |= 0x8L;
                }
                return true;
            }
            case BR.password: {
                synchronized(this) {
                        mDirtyFlags |= 0x10L;
                }
                return true;
            }
            case BR._all: {
                synchronized(this) {
                        mDirtyFlags |= 0x1L;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String loginUserNameError = null;
        java.lang.String loginPassword = null;
        com.kilarukiran.publicposts.ViewModels.LoginViewModel login = mLogin;
        java.lang.String loginPasswordError = null;
        java.lang.String loginUserName = null;
        android.view.View.OnClickListener loginOnLoginClicked = null;

        if ((dirtyFlags & 0x3fL) != 0) {


            if ((dirtyFlags & 0x23L) != 0) {

                    if (login != null) {
                        // read login.userNameError
                        loginUserNameError = login.getUserNameError();
                    }
            }
            if ((dirtyFlags & 0x31L) != 0) {

                    if (login != null) {
                        // read login.password
                        loginPassword = login.getPassword();
                    }
            }
            if ((dirtyFlags & 0x29L) != 0) {

                    if (login != null) {
                        // read login.passwordError
                        loginPasswordError = login.getPasswordError();
                    }
            }
            if ((dirtyFlags & 0x25L) != 0) {

                    if (login != null) {
                        // read login.userName
                        loginUserName = login.getUserName();
                    }
            }
            if ((dirtyFlags & 0x21L) != 0) {

                    if (login != null) {
                        // read login.onLoginClicked()
                        loginOnLoginClicked = login.onLoginClicked();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x21L) != 0) {
            // api target 1

            this.btnLogin.setOnClickListener(loginOnLoginClicked);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.inputPassword, loginPassword);
        }
        if ((dirtyFlags & 0x20L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.inputPassword, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, inputPasswordandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.inputUserName, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, inputUserNameandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x25L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.inputUserName, loginUserName);
        }
        if ((dirtyFlags & 0x23L) != 0) {
            // api target 1

            com.kilarukiran.publicposts.ViewModels.LoginViewModel.setUserNameError(this.mboundView1, loginUserNameError);
        }
        if ((dirtyFlags & 0x29L) != 0) {
            // api target 1

            com.kilarukiran.publicposts.ViewModels.LoginViewModel.setPasswordError(this.mboundView3, loginPasswordError);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static LoginActivityBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static LoginActivityBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<LoginActivityBinding>inflate(inflater, com.kilarukiran.publicposts.R.layout.login_activity, root, attachToRoot, bindingComponent);
    }
    public static LoginActivityBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static LoginActivityBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.kilarukiran.publicposts.R.layout.login_activity, null, false), bindingComponent);
    }
    public static LoginActivityBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static LoginActivityBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/login_activity_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new LoginActivityBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): login
        flag 1 (0x2L): login.userNameError
        flag 2 (0x3L): login.userName
        flag 3 (0x4L): login.passwordError
        flag 4 (0x5L): login.password
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}