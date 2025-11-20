package kourtis.quadrum.philosophito.feature.dictionary.presentation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.core.data.local.entity.DictionaryEntity;
import kourtis.quadrum.philosophito.core.ui.BaseViewHolder;
import kourtis.quadrum.philosophito.ui.main.home.dictionary.DictionaryItemFragment;

/**
 * RecyclerView Adapter for Dictionary items
 * Uses proper ViewHolder pattern (no more @SuppressLint!)
 * Uses DiffUtil for efficient updates
 */
public class DictionaryAdapter extends ListAdapter<DictionaryEntity, DictionaryAdapter.DictionaryViewHolder> {

    private static final DiffUtil.ItemCallback<DictionaryEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<DictionaryEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull DictionaryEntity oldItem,
                                                @NonNull DictionaryEntity newItem) {
                    return oldItem.getId() == newItem.getId();
                }

                @Override
                public boolean areContentsTheSame(@NonNull DictionaryEntity oldItem,
                                                   @NonNull DictionaryEntity newItem) {
                    return oldItem.getTitle().equals(newItem.getTitle()) &&
                           oldItem.getDescription().equals(newItem.getDescription());
                }
            };

    public DictionaryAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public DictionaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new DictionaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DictionaryViewHolder holder, int position) {
        DictionaryEntity item = getItem(position);
        holder.bind(item);
    }

    /**
     * ViewHolder for Dictionary items
     * Properly implements ViewHolder pattern
     */
    static class DictionaryViewHolder extends BaseViewHolder<DictionaryEntity> {
        private final TextView titleTextView;
        private final Context context;

        public DictionaryViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            titleTextView = itemView.findViewById(R.id.termtitle);
        }

        @Override
        public void bind(DictionaryEntity item) {
            titleTextView.setText(item.getTitle());

            itemView.setOnClickListener(v -> {
                // Navigate to detail screen using Fragment transaction
                // Note: This requires the context to be a FragmentActivity
                // Better approach: Use click listener interface (see BUGS_AND_FIXES.md)

                if (context instanceof androidx.fragment.app.FragmentActivity) {
                    Bundle bundle = new Bundle();
                    bundle.putString("title", item.getTitle());
                    bundle.putString("definition", item.getDescription());
                    bundle.putString("source", item.getExternalUrl());

                    DictionaryItemFragment fragment = new DictionaryItemFragment();
                    fragment.setArguments(bundle);

                    androidx.fragment.app.FragmentActivity activity =
                        (androidx.fragment.app.FragmentActivity) context;

                    activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.wrapperframe, fragment)
                        .addToBackStack(null)
                        .commit();
                }
            });
        }
    }
}
