package com.example.domin.ega_premium_store.NieDziala;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.domin.ega_premium_store.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemFragment extends android.support.v4.app.Fragment{

    /*private String TAG = ItemActivity.class.getSimpleName();
    private ListView lv;
    List<RowItem> image_details;
    ArrayList<HashMap<String, String>> contactList;*/

    private ListView lv;
    List<RowItem> image_details;
    ArrayList<HashMap<String,String>> contactList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_list, container,false);

//         lv = (ListView) getView().findViewById(R.id.listView);

        Bundle bundleObject = getActivity().getIntent().getExtras();

       image_details = (List<RowItem>) bundleObject.getSerializable("items");

        return v;

    }
}
