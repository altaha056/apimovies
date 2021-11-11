package com.example.apinews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<News>newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue=VolleySingleton.getmInstance(this).getRequestQueue();

        newsList=new ArrayList<>();
        fetchNews();

    }

    private void fetchNews() {
        String url = "https://api.themoviedb.org/3/list/1?api_key="+ getString(R.string.api_key);

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray items=response.getJSONArray("items");
                    for (int i=0;i<response.getInt("item_count");i++){
                        JSONObject item = items.getJSONObject(i);
                        String urlToImage= "https://image.tmdb.org/t/p/original"+item.getString("backdrop_path");
                        String title=item.getString("original_title");
                        String description=item.getString("overview");
                        String publishedAt=item.getString("release_date");
                        String author= item.getString("media_type");

                        News news = new News(urlToImage,title, description, publishedAt, author);
                        newsList.add(news);
                    }

                    NewsAdapter adapter = new NewsAdapter(MainActivity.this, newsList);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAG", error.toString());
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}