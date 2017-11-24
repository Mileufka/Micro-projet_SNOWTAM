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
    private Context context;
    private RequestQueue queue;
    private Cache cache;
    private Network network;
    private String page_data;
    private String url_01;

    private static final String _url="https://v4p4sz5ijk.execute-api.us-east-1.amazonaws.com/anbdata/states/notams/notams-list?api_key=02417010-cde4-11e7-8f3f-ab5c0412d795&format=json&type=&Qcode=&locations=####&qstring=&states=&ICAOonly=";

    public HTTPRequester(Context context){
        this.context=context;
        this.queue=null;
        this.cache=null;
        this.network=null;
        this.page_data=null;
    }

    public void addRequest(String icao){
        icao=icao.toUpperCase();
        String url=_url.replace("####",icao);
        url_01=url;

        // Instantiate the cache
        this.cache = new DiskBasedCache(context.getCacheDir(), 1024 * 1024); // 1MB cap

        // Set up the network to use HttpURLConnection as the HTTP client.
        this.network = new BasicNetwork(new HurlStack());

        // Instantiate the RequestQueue with the cache and network.
        this.queue = new RequestQueue(cache,network);

        // Start the queue
        this.queue.start();

        // Formulate the request and handle the response.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
        new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                page_data=response;
            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                page_data="Error";
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public String get_page(){
        return(page_data);
    }

    public String get_url(){
        return(url_01);
    }
}
