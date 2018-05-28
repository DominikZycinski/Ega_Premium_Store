package com.example.domin.ega_premium_store.NieDziala;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.domin.ega_premium_store.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemFragment2 extends android.support.v4.app.Fragment {

    private ListView lv;
    List<RowItem> image_details;
    ArrayList<HashMap<String,String>> contactList;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_list, container, false);



    }


}
