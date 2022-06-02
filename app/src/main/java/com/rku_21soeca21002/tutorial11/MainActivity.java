package com.rku_21soeca21002.tutorial11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaCodec;
import android.media.ToneGenerator;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    UserAdapter adapter;
    ArrayList<User> users;
    JsonArrayRequest request;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        users = new ArrayList<User>();
        queue = Volley.newRequestQueue(this);
        fetchOnlineData();
        adapter = new UserAdapter(users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void fetchOnlineData() {
        request = new JsonArrayRequest(
                Request.Method.GET,
                "https://jsonplaceholder.typicode.com/users",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        generateData(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        queue.add(request);
    }

    private void generateData(JSONArray response) {
        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject object = response.getJSONObject(i);
                String name = object.getString("name");
                String email = object.getString("email");
                String phone = object.getString("phone");
                String website = object.getString("website");
                users.add(new User(name, email, phone, website));
            }
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}