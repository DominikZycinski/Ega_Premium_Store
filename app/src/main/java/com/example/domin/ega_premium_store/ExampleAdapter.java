package com.example.domin.ega_premium_store;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.domin.ega_premium_store.DBFlow.MobUser;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.domin.ega_premium_store.Recycler.EXTRA_CREATOR;
import static com.example.domin.ega_premium_store.Recycler.EXTRA_LIKES;
import static com.example.domin.ega_premium_store.Recycler.EXTRA_URL;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<ExampleItem> mExampleList;
    private OnItemClickListener mListener;
    String text2;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public ExampleAdapter(Context context, ArrayList<ExampleItem> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);

        String imageUrl = currentItem.getImageUrl();
        String creatorName = currentItem.getCreator();
        int likeCount = currentItem.getLikeCount();
        String desc = currentItem.getDesc();

        text2 = creatorName;

        holder.mTextViewCreator.setText(creatorName);
        holder.mTextViewLikes.setText("Cena: " + likeCount +".00 zł");
        holder.mTextDesc.setText(desc);

        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewCreator;
        public TextView mTextViewLikes;
        public TextView mTextDesc;
        public Button bAdd;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCreator = itemView.findViewById(R.id.text_view_creator);
            mTextViewLikes = itemView.findViewById(R.id.text_view_likes);
            mTextDesc = itemView.findViewById(R.id.tv_desc);
            bAdd = itemView.findViewById(R.id.b_add);

            bAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String a= EXTRA_CREATOR;

                    int b = 1000;
                    MobUser mUsr = new MobUser();
                    mUsr.InsertData( text2, b );
                    mUsr.save();

                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}
