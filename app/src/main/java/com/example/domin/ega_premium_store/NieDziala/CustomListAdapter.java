package com.example.domin.ega_premium_store.NieDziala;

import android.content.Context;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.domin.ega_premium_store.Global;
import com.example.domin.ega_premium_store.R;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



public class CustomListAdapter extends BaseAdapter{

    private List<RowItem> listData;
    private LayoutInflater layoutInflater;
    private Context context;


    public CustomListAdapter(Context aContext, List<RowItem> listData)
    {
        this.context = aContext;
        this.listData = listData;
        layoutInflater =LayoutInflater.from(aContext);

    }

    @Override
    public int getCount() {
        return  listData.size();
    }

    @Override
    public Object getItem(int position) {
       return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;



        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();

            holder.itemImageView = (ImageView) convertView.findViewById(R.id.imageView_flag);
            holder.NameView = (TextView) convertView.findViewById(R.id.textView_countryName);
            holder.priceView = (TextView) convertView.findViewById(R.id.textView_price);
            holder.descView = (TextView) convertView.findViewById(R.id.textView_desc);
            holder.quanity = (EditText) convertView.findViewById(R.id.edt_month);
            holder.plus = convertView.findViewById(R.id.btnPlus);
            holder.minus = convertView.findViewById(R.id.btnMinus);
            holder.bAddBasket = convertView.findViewById(R.id.bDodaj);
            holder.date_order = convertView.findViewById(R.id.tvData);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
            String date = sdf.format(new Date());
            System.out.println(date); //15/10/2013

            String x;

            x= date.toString();

            holder.date_order.setText(x);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        final RowItem rowItem = this.listData.get(position);
        holder.NameView.setText(rowItem.getName());
        holder.priceView.setText(String.valueOf(rowItem.getPrice()));
        holder.descView.setText(rowItem.getDesc());

        holder.quanity.setFilters(new InputFilter[]{new InputFilterMinMax(0, rowItem.getQuantity())});

        if(rowItem.getQuantity()<1)
            holder.quanity.setText(String.valueOf(0));
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(holder.quanity.getText().toString());


                if (i < rowItem.getQuantity()) {
                    i++;
                } else
                    i = rowItem.getQuantity();

                holder.quanity.setText(String.valueOf(i));
            }
        });

        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(holder.quanity.getText().toString());
                if(rowItem.getQuantity()>0) {
                    if (i > 1) {
                        i--;
                    } else
                        i = 1;

                    holder.quanity.setText(String.valueOf(i));
                }
                else
                    holder.quanity.setText(String.valueOf(0));
            }
        });

        holder.bAddBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final  String name = holder.NameView.getText().toString();
                final String date_order = holder.date_order.getText().toString();
                final String price = holder.priceView.getText().toString();

                String quanity = holder.quanity.getText().toString();

                String street = Global.Street;
                String username = Global.Username;
                Global.Street = holder.quanity.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){

                            }
                            else {}

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                BasketRequest basketRequest = new BasketRequest(name, date_order, quanity, price, street, username, responseListener); //stworzy zapytanie, uzywam tu konstruktora
                RequestQueue queue = Volley.newRequestQueue(context);
                queue.add(basketRequest);

            }
        });
        Picasso.with(context).load(rowItem.getImageName()).into(holder.itemImageView);


        return convertView;
    }

    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }


    static class ViewHolder {
        ImageView itemImageView;
        TextView NameView;
        TextView priceView;
        TextView descView;
        EditText quanity;
        Button plus;
        Button minus;
        Button bAddBasket;
        TextView date_order;
        TextView username;
        TextView edt_month;

    }
}
