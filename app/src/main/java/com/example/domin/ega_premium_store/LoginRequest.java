//package com.example.domin.ega_premium_store;
//
//import com.android.volley.Request;
//import com.android.volley.Response;
//import com.android.volley.toolbox.StringRequest;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by Domin on 10.01.2018.
// */
//
//public class LoginRequest extends StringRequest {
//
//    private static final String LOGIN_REQUEST_URL ="https://apkaegapremium.000webhostapp.com/login5.php";
//    private Map<String,String> params;
//
//    //konstruktor
//    public LoginRequest(String username, String password, Response.Listener<String> listener ){
//        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
//        params = new HashMap<>();
//        //wsadamy do params;
//        params.put("username", username);
//        params.put("password", password);
//
//    }
//
//    //get paramas zwroci parametry ktore napisalismy wyzej
//
//    public Map<String,String> getParams(){
//        return params;
//    }
//}
