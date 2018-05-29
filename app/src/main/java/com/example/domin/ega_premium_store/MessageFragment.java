package com.example.domin.ega_premium_store;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.domin.ega_premium_store.NieDziala.HttpHandler;
import com.example.domin.ega_premium_store.NieDziala.ItemFragment;
import com.example.domin.ega_premium_store.NieDziala.RowItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends Fragment {

    List<RowItem> item_details;
    //private String TAG = BasketActivity.class.getSimpleName();


    private Button bCategories;
    private ImageButton ibBudowlaneLogo;
    private ImageButton ibOgrodoweLogo;
    private ImageButton ibElektroLogo;
    private ImageView ivMotoryzacja;
    private ImageView ivKlucze;
    private ImageView ivWkretaki;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_message, container, false);
        View v = inflater.inflate(R.layout.fragment_message, container,false);

        item_details = new ArrayList<>();



        bCategories = v.findViewById(R.id.bKategorie);
        ivMotoryzacja = v.findViewById(R.id.ivMotoryzacja);
        ivKlucze = v.findViewById(R.id.ivKlucze);
        ibElektroLogo = v.findViewById(R.id.ibElektroLogo);
        ibBudowlaneLogo = v.findViewById(R.id.ibBudowlaneLogo);

        bCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Fragment fragment = new BuildFragment();

                //Fragment fragment = new BuildFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                        .commit();
            }
        });

        ivMotoryzacja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FragmentMotoryzacja();

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container,fragment)
                        .commit();
            }
        });

        ivKlucze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.categories ="elektronarzedzia";
                Intent intent = new Intent(getActivity(), Recycler.class);
                startActivity(intent);
            }
        });

        ibElektroLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.categories ="elektronarzedzia";
                Intent intent = new Intent(getActivity(), Recycler.class);
                startActivity(intent);
            }
        });


        ibBudowlaneLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.categories="budowlane";
                Intent intent = new Intent(getActivity(), Recycler.class);
                startActivity(intent);
            }
        });
        return v;
    }



}
