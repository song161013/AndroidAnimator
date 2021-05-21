package com.animator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class AnimatorAdapter extends RecyclerView.Adapter<AnimatorAdapter.ViewHolde> {

    private Context mContext;
    private List<String> mDatas;

    private int mViewHolderPosition;

    public AnimatorAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.mDatas = list;
    }


    @NonNull
    @Override
    public ViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_btn, parent, false);
        return new ViewHolde(itemView);
    }

    public void onBindViewHolder(@NonNull ViewHolde holder, final int position) {
        holder.markViewHolderPosition(position);
        holder.mTvBtnId.setText(mDatas.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    final class ViewHolde extends RecyclerView.ViewHolder {
        private TextView mTvBtnId;

        public ViewHolde(@NonNull View itemView) {
            super(itemView);
            mTvBtnId = itemView.findViewById(R.id.tv_btn_id);

        }

        public View getItemView() {
            return itemView;
        }


        final void markViewHolderPosition(int pos) {
            mViewHolderPosition = pos;
        }

        public int getViewHolderPosition() {
            return mViewHolderPosition;
        }
    }

    private OnItemClickListenere mItemClickListener;

    public void setOnItemClickListener(OnItemClickListenere listener) {
        this.mItemClickListener = listener;
    }

    public interface OnItemClickListenere {
        void onItemClick(int pos);
    }

}
