package com.example.domin.ega_premium_store;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.domin.ega_premium_store.DBFlow.MobUser;
import com.raizlabs.android.dbflow.sql.language.SQLite;


import java.util.List;

public class ViewActivity extends AppCompatActivity {

    TextView showData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        showData = (TextView) findViewById(R.id.showData);




        List<MobUser> UserList = SQLite.select().
                from(MobUser.class).queryList();

//        SQLite.delete().from(MobUser.class).where(Mo);



        String DBname;
        int DBage;

        for( MobUser mu : UserList ){

            DBname = mu.GetName();
            DBage = mu.GetAge();

            showData.append(DBname +"\t"+DBage+"\n\n" );
        }




    }
}
