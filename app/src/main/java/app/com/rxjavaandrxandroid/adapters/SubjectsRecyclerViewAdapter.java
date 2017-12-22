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

public class SubjectsRecyclerViewAdapter extends RecyclerView.Adapter<SubjectsRecyclerViewAdapter.SubjectHolder> {

    private String[] mStringList;
    private int mResourceId;
    private Context mContext;
    private LayoutInflater layoutInflater;

    public SubjectsRecyclerViewAdapter(String[] mStringList, int mResourceId, Context mContext) {
        this.mStringList = mStringList;
        this.mResourceId = mResourceId;
        this.mContext = mContext;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public SubjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(mResourceId, parent, false);
        return new SubjectHolder(view);
    }

    @Override
    public void onBindViewHolder(SubjectHolder holder, int position) {
        holder.mTitle.setText(mStringList[position]);
        if (position % 2 == 0) {
            holder.mTitle.setBackgroundColor(Color.BLUE);
        } else {
            holder.mTitle.setBackgroundColor(Color.GREEN);
        }
    }

    @Override
    public int getItemCount() {
        return mStringList.length;
    }

    static class SubjectHolder extends RecyclerView.ViewHolder {
        TextView mTitle;

        public SubjectHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
        }
    }
}
