package ensim.snowtam.Model;

import android.content.Context;

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

/**
 * Created by clement on 20/11/17.
 */

public class HTTPRequester{
    //private static final byte offset=(byte)163;
    private String icao;
    private String url;
    private Context context;

    public HTTPRequester(String icao,String url,Context context){
        this.icao=icao;
        this.icao.toUpperCase();
        url="https://v4p4sz5ijk.execute-api.us-east-1.amazonaws.com/anbdata/states/notams/notams-list?api_key=02417010-cde4-11e7-8f3f-ab5c0412d795&format=json&type=&Qcode=&locations=####&qstring=&states=&ICAOonly=";
        url.replace("####",icao);
        //url=new StringBuilder(url).insert(offset,icao).toString();
        this.context=context;
    }

    public void doRequest(){
        RequestQueue queue;
        // Instantiate the cache
        Cache cache = new DiskBasedCache(context.getCacheDir(), 1024 * 1024); // 1MB cap

        // Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

        // Instantiate the RequestQueue with the cache and network.
        queue = new RequestQueue(cache,network);

        // Start the queue
        queue.start();

        // Formulate the request and handle the response.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, this.url,
        new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Do something with the response
            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

}
