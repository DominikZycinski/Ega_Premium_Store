package com.example.domin.ega_premium_store;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Recycler extends AppCompatActivity {
//

    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_CREATOR = "creatorName";
    public static final String EXTRA_LIKES = "likeCount";


    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }


    private void parseJSON() {
//        String url = "https://api.myjson.com/bins/1aowku";
        String url = "https://api.myjson.com/bins/n4qpe";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);
                                String categories = hit.getString("categories");
                                if(categories.equals(Global.categories)) {
                                    String creatorName = hit.getString("user");
                                    String imageUrl = hit.getString("webformatURL");
                                    String desc = hit.getString("desc");
                                    int likeCount = hit.getInt("likes");
                                    mExampleList.add(new ExampleItem(imageUrl, creatorName, likeCount,desc));
                                }
                                else {
                                    continue;
                                }
                            }

                            mExampleAdapter = new ExampleAdapter(Recycler.this, mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);
//                            mExampleAdapter.setOnItemClickListener(Recycler.this);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }

//    @Override
//    public void onItemClick(int position) {
//        Intent detailIntent = new Intent(this, DetailActivity.class);
//        ExampleItem clickedItem = mExampleList.get(position);
//
//        detailIntent.putExtra(EXTRA_URL, clickedItem.getImageUrl());
//        detailIntent.putExtra(EXTRA_CREATOR, clickedItem.getCreator());
//        detailIntent.putExtra(EXTRA_LIKES, clickedItem.getLikeCount());
//
//        startActivity(detailIntent);
//
//    }
}
