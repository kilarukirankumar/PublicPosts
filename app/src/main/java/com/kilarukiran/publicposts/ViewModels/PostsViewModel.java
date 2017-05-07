package com.kilarukiran.publicposts.ViewModels;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.view.View;

import com.kilarukiran.publicposts.BR;
import com.kilarukiran.publicposts.Models.PhotosService;
import com.kilarukiran.publicposts.PublicPostsApplication;
import com.kilarukiran.publicposts.ResponseModel.Photo;
import com.kilarukiran.publicposts.ResponseModel.PhotoDateComparator;
import com.kilarukiran.publicposts.ResponseModel.PhotosResponse;

import java.util.Collections;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by kirankumarkilaru on 03/05/17.
 */

public class PostsViewModel extends BaseObservable implements ViewModel {

    private final static  String TAG = "PostsViewModel";

    private Context mContext;
    private CompositeSubscription mSubscriptions;
    private DataListener dataListener;

    private List<Photo> photos;
    private String infoMsg;
    private int progressbarVisibility = View.GONE;
    private int recyclerViewVisibility = View.GONE;
    private int infoMsgVisibility = View.GONE;

    public PostsViewModel(Context context, DataListener dataListener){
        this.mContext = context;
        this.dataListener = dataListener;
    }

    public void loadPosts(){
        loadPublicPosts();
    }

    @Override
    public void destroy() {
        if(mSubscriptions != null && !mSubscriptions.isUnsubscribed()) mSubscriptions.unsubscribe();
        mSubscriptions = null;
        dataListener = null;
        mContext = null;
    }

    @Bindable
    public int getProgressbarVisibility() {
        return progressbarVisibility;
    }

    public void setProgressbarVisibility(int progressbarVisibility) {
        this.progressbarVisibility = progressbarVisibility;
        notifyPropertyChanged(BR.progressbarVisibility);
    }

    @Bindable
    public String getInfoMsg() {
        return infoMsg;
    }

    public void setInfoMsg(String infoMsg) {
        this.infoMsg = infoMsg;
        notifyPropertyChanged(BR.infoMsg);
    }

    @Bindable
    public int getRecyclerViewVisibility() {
        return recyclerViewVisibility;
    }

    public void setRecyclerViewVisibility(int recyclerViewVisibility) {
        this.recyclerViewVisibility = recyclerViewVisibility;
        notifyPropertyChanged(BR.recyclerViewVisibility);
    }

    @Bindable
    public int getInfoMsgVisibility() {
        return infoMsgVisibility;
    }

    public void setInfoMsgVisibility(int infoMsgVisibility) {
        this.infoMsgVisibility = infoMsgVisibility;
        notifyPropertyChanged(BR.infoMsgVisibility);
    }

    private void loadPublicPosts(){
        setRecyclerViewVisibility(View.GONE);
        setInfoMsgVisibility(View.GONE);
        setProgressbarVisibility(View.GONE);
        if(mSubscriptions != null && !mSubscriptions.isUnsubscribed()) mSubscriptions.unsubscribe();
        if(mSubscriptions == null) mSubscriptions = new CompositeSubscription();
        PublicPostsApplication publicPostsApplication = PublicPostsApplication.get(mContext);
        final PhotosService photosService = publicPostsApplication.getPhotosService();
        mSubscriptions.add(photosService.getPhotos("popular","nature","NE10NBHXbYyLy1MHT483YCmUnQmSkHUhNUZuOTV9")
                        .subscribeOn(publicPostsApplication.defaultSubscribeScheduler())
                        .observeOn(publicPostsApplication.defaultSubscribeScheduler())
                        .map(new Func1<PhotosResponse, List<Photo>>() {
                            @Override
                            public List<Photo> call(PhotosResponse photosResponse) {
                                return photosResponse.getPhotos();
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<List<Photo>>() {
                            @Override
                            public void onCompleted() {

                                dataListener.onPhotosChanged(photos);

                                if(!photos.isEmpty()){
                                    setProgressbarVisibility(View.GONE);
                                    setRecyclerViewVisibility(View.VISIBLE);
                                    dataListener.onPhotosChanged(photos);
                                }
                                else{
                                    setInfoMsg("No photos to display.");
                                    setInfoMsgVisibility(View.VISIBLE);
                                    setProgressbarVisibility(View.GONE);
                                }
                            }



                            @Override
                            public void onError(Throwable e) {
                                Log.e(TAG, "Error loading photos from public posts", e);
                                setInfoMsg("Error in loading photos from public posts. Please try after sometime.");
                                setInfoMsgVisibility(View.VISIBLE);
                                setProgressbarVisibility(View.GONE);
                            }

                            @Override
                            public void onNext(List<Photo> photos) {
                                Collections.sort(photos, new PhotoDateComparator());
                                PostsViewModel.this.photos = photos;
                            }
                        }));
    }

    public interface DataListener {
        void onPhotosChanged(List<Photo> photos);
    }
}
