package com.kilarukiran.publicposts.Views;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kilarukiran.publicposts.R;
import com.kilarukiran.publicposts.ResponseModel.Photo;
import com.kilarukiran.publicposts.ViewModels.ItemPhotoViewModel;
import com.kilarukiran.publicposts.databinding.ListItemPhotoBinding;

import java.util.Collections;
import java.util.List;

/**
 * Created by kirankumarkilaru on 04/05/17.
 */

public class ItemPhotoAdapter extends  RecyclerView.Adapter<ItemPhotoAdapter.PhotoViewHolder>{

    private List<Photo> photos;

    public ItemPhotoAdapter(){
        this.photos = Collections.emptyList();
    }

    public ItemPhotoAdapter(List<Photo> photos){
        this.photos = photos;
    }

    public void setPhotos(List<Photo> photos){
        this.photos = photos;
        notifyDataSetChanged();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemPhotoBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.list_item_photo,
                parent,
                false
        );
        return new PhotoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        holder.bindRepository(photos.get(position));
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public static class PhotoViewHolder extends RecyclerView.ViewHolder{
        final ListItemPhotoBinding binding;
        public PhotoViewHolder(ListItemPhotoBinding binding){
            super(binding.cardView);
            this.binding = binding;
        }
        void bindRepository(Photo photo) {
            if(binding.getViewModel() == null)
                binding.setViewModel(new ItemPhotoViewModel(itemView.getContext(), photo));
            else
                binding.getViewModel().setPhoto(photo);
        }
    }
}
