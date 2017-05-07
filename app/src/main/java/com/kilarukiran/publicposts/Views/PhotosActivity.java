package com.kilarukiran.publicposts.Views;

import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.kilarukiran.publicposts.R;
import com.kilarukiran.publicposts.ResponseModel.Photo;
import com.kilarukiran.publicposts.ViewModels.PostsViewModel;
import com.kilarukiran.publicposts.databinding.ActivityPhotosBinding;

import java.util.List;

/**
 * Created by kirankumarkilaru on 03/05/17.
 */

public class PhotosActivity extends AppCompatActivity implements PostsViewModel.DataListener {

    PostsViewModel mPostsViewModel;
    ActivityPhotosBinding mActivityPhotosDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityPhotosDataBinding  =
                DataBindingUtil.setContentView(this, R.layout.activity_photos);
        if(mActivityPhotosDataBinding.getPostsViewModel() == null) {
            mPostsViewModel = new PostsViewModel(this, this);
            mActivityPhotosDataBinding.setPostsViewModel(mPostsViewModel);
            mPostsViewModel.loadPosts();
        }
        else
            mPostsViewModel = mActivityPhotosDataBinding.getPostsViewModel();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mActivityPhotosDataBinding.photosRecyclerView.setLayoutManager(layoutManager);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onPhotosChanged(List<Photo> photos) {
        Log.d("onPhotosChanged", "Photos Count: " + Integer.toString(photos.size()));
        ItemPhotoAdapter adapter = new ItemPhotoAdapter(photos);
        mActivityPhotosDataBinding.photosRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        mPostsViewModel.destroy();
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
            case R.id.action_logout:
                doLogout();
                break;
            default:
                break;
        }
        return true;
    }

    private void doLogout(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure you want to logout? Press \"Yes\" to continue \"No\" to cancel.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        doLogout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_photos, menu);
        return true;
    }
}
