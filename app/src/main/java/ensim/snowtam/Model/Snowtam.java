package ensim.snowtam.Model;

import android.support.annotation.NonNull;

import java.util.ArrayList;

/**
 * Created by clement on 20/11/17.
 */

public class Snowtam {
    protected String icao;
    protected String date_last;
    protected ArrayList<String> runway;
    protected String date_next;
    protected String informations;

    public Snowtam(){
        icao=null;
        date_last=null;
        runway=new ArrayList<>();
        date_next=null;
        informations=null;
    }

    public Snowtam(String icao,String date_last,ArrayList<String> runway,String date_next,String informations){
        this.icao=icao;
        this.date_last=date_last;
        this.runway=new ArrayList<>(runway);
        this.date_next=date_next;
        this.informations=informations;
    }

    public Snowtam(Snowtam s) {
        this.icao=s.icao;
        this.date_last=s.date_last;
        this.runway=new ArrayList<>(s.runway);
        this.date_next=s.date_next;
        this.informations=s.informations;
    }
}
