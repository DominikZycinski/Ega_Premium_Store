package com.example.domin.ega_premium_store;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class BuildFragment extends Fragment {

    private ImageButton ibElektronarzedzia;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_build, container, false);
        View v = inflater.inflate(R.layout.fragment_build, container,false);

        ibElektronarzedzia = v.findViewById(R.id.ibElektronarzedzia);

        ibElektronarzedzia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.categories ="elektronarzedzia";
                Intent intent = new Intent(getActivity(), Recycler.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
