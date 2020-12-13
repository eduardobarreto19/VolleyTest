package com.example.volleytest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //private static final String url = "https://my-json-server.typicode.com/typicode/demo/comments";
    private static final String url = "https://1284fb54a058.ngrok.io/v1/smartuj/students/luis.barreto/biblioteca/academicRecommendation";

    ListView listView;
    MyAdapter adapter;
    public static ArrayList<AcademicRecommendation> academicRecommendationsList = new ArrayList<>();
    AcademicRecommendation academicRecommendation;

    Cache cache;
    Network network;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.myListView);
        adapter = new MyAdapter(this, academicRecommendationsList);

        cache = new DiskBasedCache(getCacheDir(), 4096 * 4096); // 1MB cap
        network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

               // builder.setTitle("Expositor: " + academicRecommendationsList.get(position).getSpeaker_event());
               // builder.setMessage("Descripcion del evento:" + academicRecommendationsList.get(position).getDescription_event());
                builder.setTitle("! EVENTO ACADEMICO");
                builder.setIcon(android.R.drawable.ic_menu_info_details);
                builder.setMessage( "> Descripcion del evento: \n " + academicRecommendationsList.get(position).getDescription_event() + "\n \n" +
                ">Expositor: " + academicRecommendationsList.get(position).getSpeaker_event());
                builder.setPositiveButton("INSCRIBIRSE", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Se ha inscrito al evento seleccionado", Toast.LENGTH_LONG).show();
                        //startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                    }
                })
                .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
                builder.create().show();
            }
        });
        retrieveData();
    }

    private void retrieveData() {
        requestQueue.start();
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        academicRecommendationsList.clear();
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    int id_academic_event = jsonObject.getInt("id_academic_event");
                                    String name_event = jsonObject.getString("name_event");
                                    String start_time_event = jsonObject.getString("start_time_event");
                                    String site_event = jsonObject.getString("site_event");
                                    String speaker_event = jsonObject.getString("speaker_event");
                                    String description_event = jsonObject.getString("description_event");

                                    academicRecommendation= new AcademicRecommendation(id_academic_event,name_event, start_time_event, site_event, speaker_event, description_event );
                                    academicRecommendationsList.add(academicRecommendation);
                                    adapter.notifyDataSetChanged();
                                }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);
    }

    public void goSecondButton(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity2.class));
    }
}
