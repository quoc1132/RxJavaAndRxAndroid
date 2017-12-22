package app.com.rxjavaandrxandroid.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.com.rxjavaandrxandroid.R;

/**
 * Created by quoc1132 on 12/22/17.
 */

public class CreatingAnObservableFromListRecyclerViewAdapter extends RecyclerView.Adapter<CreatingAnObservableFromListRecyclerViewAdapter.CreatingAnObservableFromListViewHolder> {

    private Context mContext;
    private List<String> mInts;
    private int mResourceId;
    private LayoutInflater layoutInflater;

    public CreatingAnObservableFromListRecyclerViewAdapter(Context mContext, List<String> mInts, int mResourceId) {
        this.mContext = mContext;
        this.mInts = mInts;
        this.mResourceId = mResourceId;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public CreatingAnObservableFromListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(mResourceId,parent,false);
        return new CreatingAnObservableFromListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CreatingAnObservableFromListViewHolder holder, int position) {
        holder.mContent.setText(mInts.get(position)+"");
        if (position % 2 == 0) {
            holder.mContent.setBackgroundColor(Color.BLUE);
        } else {
            holder.mContent.setBackgroundColor(Color.GREEN);
        }
    }

    @Override
    public int getItemCount() {
        return mInts.size();
    }

    static class CreatingAnObservableFromListViewHolder extends RecyclerView.ViewHolder {

        TextView mContent;
        public CreatingAnObservableFromListViewHolder(View itemView) {
            super(itemView);
            mContent = itemView.findViewById(R.id.title);
        }
    }

}
