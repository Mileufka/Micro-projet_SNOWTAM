package ensim.snowtam.Model;

import java.net.URL;

/**
 * Created by clement on 20/11/17.
 */

public class HTTPRequester{
    //private static final byte offset=(byte)163;
    private String icao;
    private String url;

    public HTTPRequester(String icao,String url){
        this.icao=icao;
        this.icao.toUpperCase();
        url="https://v4p4sz5ijk.execute-api.us-east-1.amazonaws.com/anbdata/states/notams/notams-list?api_key=02417010-cde4-11e7-8f3f-ab5c0412d795&format=json&type=&Qcode=&locations=####&qstring=&states=&ICAOonly=";
        url.replace("####",icao);
        //url=new StringBuilder(url).insert(offset,icao).toString();
    }
    /*
    public Snowtam doRequest(){

    }
    */
}
