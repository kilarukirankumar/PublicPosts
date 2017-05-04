
package android.databinding;
import com.kilarukiran.publicposts.BR;
class DataBinderMapper  {
    final static int TARGET_MIN_SDK = 24;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.kilarukiran.publicposts.R.layout.login_activity:
                    return com.kilarukiran.publicposts.databinding.LoginActivityBinding.bind(view, bindingComponent);
                case com.kilarukiran.publicposts.R.layout.activity_photos:
                    return com.kilarukiran.publicposts.databinding.ActivityPhotosBinding.bind(view, bindingComponent);
                case com.kilarukiran.publicposts.R.layout.list_item_photo:
                    return com.kilarukiran.publicposts.databinding.ListItemPhotoBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case 1714328027: {
                if(tag.equals("layout/login_activity_0")) {
                    return com.kilarukiran.publicposts.R.layout.login_activity;
                }
                break;
            }
            case -2061271171: {
                if(tag.equals("layout/activity_photos_0")) {
                    return com.kilarukiran.publicposts.R.layout.activity_photos;
                }
                break;
            }
            case -305473901: {
                if(tag.equals("layout/list_item_photo_0")) {
                    return com.kilarukiran.publicposts.R.layout.list_item_photo;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"createdAt"
            ,"description"
            ,"imageUrl"
            ,"infoMsg"
            ,"infoMsgVisibility"
            ,"login"
            ,"name"
            ,"password"
            ,"passwordError"
            ,"photo"
            ,"postsViewModel"
            ,"progressbarVisibility"
            ,"recyclerViewVisibility"
            ,"userName"
            ,"userNameError"};
    }
}