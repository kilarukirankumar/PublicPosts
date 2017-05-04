package com.kilarukiran.publicposts;

import android.app.Application;
import android.content.Context;

import com.kilarukiran.publicposts.Models.PhotosService;
import com.squareup.leakcanary.LeakCanary;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by kirankumarkilaru on 03/05/17.
 */

public class PublicPostsApplication extends Application {
    private PhotosService photosService;
    private Scheduler defaultSubscribeScheduler;

    public static PublicPostsApplication get(Context context) {
        return (PublicPostsApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    public PhotosService getPhotosService() {
        if (photosService == null) {
            photosService = PhotosService.Factory.create();
        }
        return photosService;
    }

    public void setPhotosService(PhotosService photosService) {
        this.photosService = photosService;
    }

    public Scheduler defaultSubscribeScheduler() {
        if (defaultSubscribeScheduler == null) {
            defaultSubscribeScheduler = Schedulers.io();
        }
        return defaultSubscribeScheduler;
    }

    public void setDefaultSubscribeScheduler(Scheduler scheduler) {
        this.defaultSubscribeScheduler = scheduler;
    }
}
