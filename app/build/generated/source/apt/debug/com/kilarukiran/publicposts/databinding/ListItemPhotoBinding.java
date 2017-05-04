package com.kilarukiran.publicposts.databinding;
import com.kilarukiran.publicposts.R;
import com.kilarukiran.publicposts.BR;
import android.view.View;
public class ListItemPhotoBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.const_layout, 5);
    }
    // views
    public final android.support.v7.widget.CardView cardView;
    public final android.support.constraint.ConstraintLayout constLayout;
    public final android.widget.TextView createdDate;
    public final android.widget.TextView description;
    public final android.widget.TextView name;
    public final android.widget.ImageView photo;
    // variables
    private com.kilarukiran.publicposts.ViewModels.ItemPhotoViewModel mPhoto;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ListItemPhotoBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds);
        this.cardView = (android.support.v7.widget.CardView) bindings[0];
        this.cardView.setTag(null);
        this.constLayout = (android.support.constraint.ConstraintLayout) bindings[5];
        this.createdDate = (android.widget.TextView) bindings[3];
        this.createdDate.setTag(null);
        this.description = (android.widget.TextView) bindings[4];
        this.description.setTag(null);
        this.name = (android.widget.TextView) bindings[2];
        this.name.setTag(null);
        this.photo = (android.widget.ImageView) bindings[1];
        this.photo.setTag(null);
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
            case BR.photo :
                setPhoto((com.kilarukiran.publicposts.ViewModels.ItemPhotoViewModel) variable);
                return true;
        }
        return false;
    }

    public void setPhoto(com.kilarukiran.publicposts.ViewModels.ItemPhotoViewModel Photo) {
        updateRegistration(0, Photo);
        this.mPhoto = Photo;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.photo);
        super.requestRebind();
    }
    public com.kilarukiran.publicposts.ViewModels.ItemPhotoViewModel getPhoto() {
        return mPhoto;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangePhoto((com.kilarukiran.publicposts.ViewModels.ItemPhotoViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangePhoto(com.kilarukiran.publicposts.ViewModels.ItemPhotoViewModel Photo, int fieldId) {
        switch (fieldId) {
            case BR.imageUrl: {
                synchronized(this) {
                        mDirtyFlags |= 0x2L;
                }
                return true;
            }
            case BR.name: {
                synchronized(this) {
                        mDirtyFlags |= 0x4L;
                }
                return true;
            }
            case BR.createdAt: {
                synchronized(this) {
                        mDirtyFlags |= 0x8L;
                }
                return true;
            }
            case BR.description: {
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
        java.lang.String photoDescription = null;
        java.lang.String photoCreatedAt = null;
        java.lang.String photoName = null;
        java.lang.String photoImageUrl = null;
        com.kilarukiran.publicposts.ViewModels.ItemPhotoViewModel photo = mPhoto;

        if ((dirtyFlags & 0x3fL) != 0) {


            if ((dirtyFlags & 0x31L) != 0) {

                    if (photo != null) {
                        // read photo.description
                        photoDescription = photo.getDescription();
                    }
            }
            if ((dirtyFlags & 0x29L) != 0) {

                    if (photo != null) {
                        // read photo.createdAt
                        photoCreatedAt = photo.getCreatedAt();
                    }
            }
            if ((dirtyFlags & 0x25L) != 0) {

                    if (photo != null) {
                        // read photo.name
                        photoName = photo.getName();
                    }
            }
            if ((dirtyFlags & 0x23L) != 0) {

                    if (photo != null) {
                        // read photo.imageUrl
                        photoImageUrl = photo.getImageUrl();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x29L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.createdDate, photoCreatedAt);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            com.kilarukiran.publicposts.ViewModels.ItemPhotoViewModel.setHtml(this.description, photoDescription);
        }
        if ((dirtyFlags & 0x25L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.name, photoName);
        }
        if ((dirtyFlags & 0x23L) != 0) {
            // api target 1

            com.kilarukiran.publicposts.ViewModels.ItemPhotoViewModel.loadImage(this.photo, photoImageUrl);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ListItemPhotoBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ListItemPhotoBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ListItemPhotoBinding>inflate(inflater, com.kilarukiran.publicposts.R.layout.list_item_photo, root, attachToRoot, bindingComponent);
    }
    public static ListItemPhotoBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ListItemPhotoBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.kilarukiran.publicposts.R.layout.list_item_photo, null, false), bindingComponent);
    }
    public static ListItemPhotoBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ListItemPhotoBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/list_item_photo_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ListItemPhotoBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): photo
        flag 1 (0x2L): photo.imageUrl
        flag 2 (0x3L): photo.name
        flag 3 (0x4L): photo.createdAt
        flag 4 (0x5L): photo.description
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}