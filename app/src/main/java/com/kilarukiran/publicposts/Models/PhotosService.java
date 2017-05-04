package com.kilarukiran.publicposts.Models;

import com.google.gson.GsonBuilder;
import com.kilarukiran.publicposts.ResponseModel.PhotosResponse;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by kirankumarkilaru on 03/05/17.
 */

public interface PhotosService {

    @GET("/v1/photos")
    Observable<PhotosResponse> getPhotos(@Query("feature") String feature,
                                               @Query("only") String only,
                                               @Query("consumer_key") String consumerKey);

    class Factory{
        public static PhotosService create(){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.500px.com/")
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().
                            excludeFieldsWithoutExposeAnnotation().create()))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            return retrofit.create(PhotosService.class);
        }
    }
}
