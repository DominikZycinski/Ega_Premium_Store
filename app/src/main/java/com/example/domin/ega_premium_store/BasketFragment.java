package com.example.domin.ega_premium_store;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.domin.ega_premium_store.DBFlow.MobUser;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class BasketFragment extends Fragment {

    TextView showData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_basket, container, false);
        View v = inflater.inflate(R.layout.fragment_basket, container,false);

        showData = v.findViewById(R.id.showData2);

        List<MobUser> UserList = SQLite.select().
                from(MobUser.class).queryList();

        String DBname;
        int DBage;
        showData.setText("Twoj koszyk jest pusty!");
        int i = 0;
        int j = 0;
        for( MobUser mu : UserList ){
            i++;

            if(i ==1){
                showData.setText("");
            }
            DBname = mu.GetName();
            DBage = mu.GetAge();

            showData.append( "Arykuł: \t"+DBname+ "\nIlosc:  "+Global.amount[j] +"\t \nCena:  "+DBage * Global.amount[j] +".00 zł \n\n\n" );
            j++;
        }

        return v;
    }
}
