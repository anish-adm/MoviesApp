package com.anish.movies.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.anish.movies.data.remote.Resource;
import com.anish.movies.view.base.BaseAdapter;

import java.util.List;

/**
 * Binding adapters
 */
final class ListBindingAdapter{

    private ListBindingAdapter(){
        // Private Constructor to hide the implicit one
    }

    @SuppressWarnings("unchecked")
    @BindingAdapter(value = "resource")
    public static void setResource(RecyclerView recyclerView, Resource resource){
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if(adapter == null)
            return;

        if(resource == null || resource.data == null)
            return;

        if(adapter instanceof BaseAdapter){
            ((BaseAdapter)adapter).setData((List) resource.data);
        }
    }

}
