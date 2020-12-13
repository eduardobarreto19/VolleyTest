package com.example.volleytest;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}


    /*
VERSION LERR Y EXPONER JSON

     private static final String url = "https://my-json-server.typicode.com/typicode/demo/comments";
     //private static final String url = "https://caacae718a16.ngrok.io/v1/smartuj/students/luis.barreto/Biblioteca/academicRecommendation";

    private TextView textView;
    ListView listaDatos;

    List<String> datos = new ArrayList<String>();

    Cache cache;
    Network network;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textViewVolley);

        cache = new DiskBasedCache(getCacheDir(), 4096 * 4096); // 1MB cap
        network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);

        retrieveData();
        listaDatos = (ListView) findViewById(R.id.listData);

    }

    private void retrieveData() {
        requestQueue.start();
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("*************" + response);
                        textView.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.getMessage();
                    }
                }

        );
        requestQueue.add(request);
    }
}



-------------------
version parseo a objetos y visualizaodf en un textview


     private static final String url = "https://my-json-server.typicode.com/typicode/demo/comments";
     //private static final String url = "https://caacae718a16.ngrok.io/v1/smartuj/students/luis.barreto/Biblioteca/academicRecommendation";

    private TextView textView;
    ListView listaDatos;

    List<String> datos = new ArrayList<String>();

    Cache cache;
    Network network;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textViewVolley);

        cache = new DiskBasedCache(getCacheDir(), 4096 * 4096); // 1MB cap
        network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);

        retrieveData();
        listaDatos = (ListView) findViewById(R.id.listData);

    }

    private void retrieveData() {
        requestQueue.start();
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (!response.equals("null")){
                            try {
                                JSONArray jsonArray = new JSONArray(response);

                                for (int i = 0 ; i < jsonArray.length(); i++){
                                    JSONObject jsonObject= jsonArray.getJSONObject(i);

                                    int id= jsonObject.getInt("id");
                                    String body= jsonObject.getString("body");
                                    int postId= jsonObject.getInt("postId");

                                    textView.append(String.valueOf(id) + ", " +body + ", " + String.valueOf( postId)) ;
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }else{
                            textView.append("Se ha presentado un problema");
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.getMessage();
                    }
                }

        );
        requestQueue.add(request);
    }
}

}
     */


