package com.kilarukiran.publicposts.ViewModels;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.os.Build;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kilarukiran.publicposts.ResponseModel.Photo;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;

public class ItemPhotoViewModel extends BaseObservable implements ViewModel {

    private Context context;
    private Photo photo;

    public ItemPhotoViewModel(Context context, Photo photo){
        this.context = context;
        this.photo = photo;
    }

    public void setPhoto(Photo photo){
        this.photo = photo;
        notifyChange();
    }

    @Bindable
    public String getName() {
        return photo.getName();
    }

    public void setName(String name) {
        this.photo.setName(name);
        notifyPropertyChanged(com.kilarukiran.publicposts.BR.name);
    }

    @Bindable
    public String getImageUrl() {
        return photo.getImageUrl();
    }

    public void setImageUrl(String imageUrl) {
        this.photo.setImageUrl(imageUrl);
        notifyPropertyChanged(com.kilarukiran.publicposts.BR.imageUrl);
    }

    @SuppressWarnings("deprecation")
    @BindingAdapter("android:htmlText")
    public  static void setHtml(TextView view, String text){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            view.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT));
        else
            view.setText(Html.fromHtml(text));
        if(text.length() > 0)
            view.setVisibility(View.VISIBLE);
        else
            view.setVisibility(View.GONE);
    }

    @Bindable
    public String getDescription() {
        Object desc = this.photo.getDescription();
        if(desc != null)
            return desc.toString() ;
        else
            return "";
    }

    public void setDescription(String description) {
        this.photo.setDescription(description);
        notifyPropertyChanged(com.kilarukiran.publicposts.BR.description);
    }

    @Bindable
    public String getCreatedAt() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");
        return "Created At: " + dateFormat.format(photo.getCreatedAt());
    }

    public void setCreatedAt(java.util.Date createdAt) {
        this.photo.setCreatedAt(createdAt);
        notifyPropertyChanged(com.kilarukiran.publicposts.BR.createdAt);
    }

    @BindingAdapter("android:src")
    public static void loadImage(ImageView imageView, String imageUrl){
        Picasso.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

    @Override
    public void destroy() {
        this.context = null;
    }
}
