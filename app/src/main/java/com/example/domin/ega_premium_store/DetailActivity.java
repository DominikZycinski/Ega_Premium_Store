package com.example.domin.ega_premium_store;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.domin.ega_premium_store.DBFlow.MobUser;
import com.squareup.picasso.Picasso;

import static com.example.domin.ega_premium_store.Recycler.EXTRA_CREATOR;
import static com.example.domin.ega_premium_store.Recycler.EXTRA_LIKES;
import static com.example.domin.ega_premium_store.Recycler.EXTRA_URL;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String creatorName = intent.getStringExtra(EXTRA_CREATOR);
        int likeCount = intent.getIntExtra(EXTRA_LIKES, 0);

        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView textViewCreator = findViewById(R.id.text_view_creator_detail);
        TextView textViewLikes = findViewById(R.id.text_view_like_detail);

        Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);
        textViewCreator.setText(creatorName);
        textViewLikes.setText("Likes: " + likeCount);
        int x = 0;

        MobUser mUsr = new MobUser();
        mUsr.InsertData(creatorName, likeCount );
         mUsr.save();
    }
}
