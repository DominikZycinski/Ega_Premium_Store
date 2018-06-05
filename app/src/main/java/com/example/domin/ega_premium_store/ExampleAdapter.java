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
import android.widget.Toast;

import com.example.domin.ega_premium_store.DBFlow.MobUser;
import com.raizlabs.android.dbflow.sql.language.Delete;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.example.domin.ega_premium_store.Recycler.EXTRA_CREATOR;
import static com.example.domin.ega_premium_store.Recycler.EXTRA_LIKES;
import static com.example.domin.ega_premium_store.Recycler.EXTRA_URL;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<ExampleItem> mExampleList;
    private OnItemClickListener mListener;
    String text2;
    int price;

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
        price = likeCount;

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
        public Button bIncrease;
        public Button bDecrease;
        public Button bClear;
        public TextView tvCount;



         int count = 1;
        public ExampleViewHolder(final View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCreator = itemView.findViewById(R.id.text_view_creator);
            mTextViewLikes = itemView.findViewById(R.id.text_view_likes);
            mTextDesc = itemView.findViewById(R.id.tv_desc);
            bAdd = itemView.findViewById(R.id.b_add);
            bIncrease = itemView.findViewById(R.id.bIncrease);
            bDecrease = itemView.findViewById(R.id.bDecrease);
            tvCount = itemView.findViewById(R.id.tvCount);
//            bClear = itemView.findViewById(R.id.bUsun);

//            bClear.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Delete.table(MobUser.class);
//                }
//            });


            bDecrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if( count>1){
                        count--;
                        tvCount.setText(String.valueOf(count));


                    }
                }
            });

            bIncrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                    tvCount.setText(String.valueOf(count));


                }
            });





            bAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(itemView.getContext(),"Dodano do koszyka",Toast.LENGTH_SHORT ).show();

                    CharSequence text = "Hello toast!";


                    String x =tvCount.getText().toString();

                    int amount = Integer.parseInt(String.valueOf(x));

                    Global.amount[Global.counter] = amount;

                    Global.counter ++;

                    List<Integer> lista = new ArrayList<Integer>();
                    lista.add(amount);

                    String a= EXTRA_CREATOR;

                    int b = 1000;
                    MobUser mUsr = new MobUser();
                    mUsr.InsertData( text2, price );
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
