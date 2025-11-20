package kourtis.quadrum.philosophito.core.ui;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Base ViewHolder for RecyclerView
 * Provides common functionality for all ViewHolders
 * Replaces the old ListView + @SuppressLint("ViewHolder") pattern
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    /**
     * Bind data to the view
     * Subclasses must implement this method
     */
    public abstract void bind(T item);
}
