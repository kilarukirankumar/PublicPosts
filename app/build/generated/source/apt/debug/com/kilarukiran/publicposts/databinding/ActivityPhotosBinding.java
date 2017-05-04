package com.kilarukiran.publicposts.databinding;
import com.kilarukiran.publicposts.R;
import com.kilarukiran.publicposts.BR;
import android.view.View;
public class ActivityPhotosBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    private final android.widget.FrameLayout mboundView0;
    private final android.widget.ProgressBar mboundView2;
    private final android.widget.TextView mboundView3;
    public final android.support.v7.widget.RecyclerView photosRecyclerView;
    // variables
    private com.kilarukiran.publicposts.ViewModels.PostsViewModel mPostsViewModel;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityPhotosBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.ProgressBar) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.photosRecyclerView = (android.support.v7.widget.RecyclerView) bindings[1];
        this.photosRecyclerView.setTag(null);
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
            case BR.postsViewModel :
                setPostsViewModel((com.kilarukiran.publicposts.ViewModels.PostsViewModel) variable);
                return true;
        }
        return false;
    }

    public void setPostsViewModel(com.kilarukiran.publicposts.ViewModels.PostsViewModel PostsViewModel) {
        updateRegistration(0, PostsViewModel);
        this.mPostsViewModel = PostsViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.postsViewModel);
        super.requestRebind();
    }
    public com.kilarukiran.publicposts.ViewModels.PostsViewModel getPostsViewModel() {
        return mPostsViewModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangePostsViewModel((com.kilarukiran.publicposts.ViewModels.PostsViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangePostsViewModel(com.kilarukiran.publicposts.ViewModels.PostsViewModel PostsViewModel, int fieldId) {
        switch (fieldId) {
            case BR.recyclerViewVisibility: {
                synchronized(this) {
                        mDirtyFlags |= 0x2L;
                }
                return true;
            }
            case BR.progressbarVisibility: {
                synchronized(this) {
                        mDirtyFlags |= 0x4L;
                }
                return true;
            }
            case BR.infoMsg: {
                synchronized(this) {
                        mDirtyFlags |= 0x8L;
                }
                return true;
            }
            case BR.infoMsgVisibility: {
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
        com.kilarukiran.publicposts.ViewModels.PostsViewModel postsViewModel = mPostsViewModel;
        int postsViewModelRecyclerViewVisibility = 0;
        java.lang.String postsViewModelInfoMsg = null;
        int postsViewModelInfoMsgVisibility = 0;
        int postsViewModelProgressbarVisibility = 0;

        if ((dirtyFlags & 0x3fL) != 0) {


            if ((dirtyFlags & 0x23L) != 0) {

                    if (postsViewModel != null) {
                        // read postsViewModel.recyclerViewVisibility
                        postsViewModelRecyclerViewVisibility = postsViewModel.getRecyclerViewVisibility();
                    }
            }
            if ((dirtyFlags & 0x29L) != 0) {

                    if (postsViewModel != null) {
                        // read postsViewModel.infoMsg
                        postsViewModelInfoMsg = postsViewModel.getInfoMsg();
                    }
            }
            if ((dirtyFlags & 0x31L) != 0) {

                    if (postsViewModel != null) {
                        // read postsViewModel.infoMsgVisibility
                        postsViewModelInfoMsgVisibility = postsViewModel.getInfoMsgVisibility();
                    }
            }
            if ((dirtyFlags & 0x25L) != 0) {

                    if (postsViewModel != null) {
                        // read postsViewModel.progressbarVisibility
                        postsViewModelProgressbarVisibility = postsViewModel.getProgressbarVisibility();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x25L) != 0) {
            // api target 1

            this.mboundView2.setVisibility(postsViewModelProgressbarVisibility);
        }
        if ((dirtyFlags & 0x29L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, postsViewModelInfoMsg);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            this.mboundView3.setVisibility(postsViewModelInfoMsgVisibility);
        }
        if ((dirtyFlags & 0x23L) != 0) {
            // api target 1

            this.photosRecyclerView.setVisibility(postsViewModelRecyclerViewVisibility);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ActivityPhotosBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityPhotosBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityPhotosBinding>inflate(inflater, com.kilarukiran.publicposts.R.layout.activity_photos, root, attachToRoot, bindingComponent);
    }
    public static ActivityPhotosBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityPhotosBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.kilarukiran.publicposts.R.layout.activity_photos, null, false), bindingComponent);
    }
    public static ActivityPhotosBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityPhotosBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_photos_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityPhotosBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): postsViewModel
        flag 1 (0x2L): postsViewModel.recyclerViewVisibility
        flag 2 (0x3L): postsViewModel.progressbarVisibility
        flag 3 (0x4L): postsViewModel.infoMsg
        flag 4 (0x5L): postsViewModel.infoMsgVisibility
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}