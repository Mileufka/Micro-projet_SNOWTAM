package ensim.snowtam.Model;

/**
 * Created by clement on 20/11/17.
 */

public class Snowtam_decode extends Snowtam {

    //Attributes
    private String runway_state;
    private String mean_depth;
    private String braking_action;
    private String taxiways;

    public Snowtam_decode(){

    }

    public Snowtam_decode(Snowtam s,String runway_state,String mean_depth,String braking_action,String taxiways){
        super(s);
        this.runway_state=runway_state;
        this.mean_depth=mean_depth;
        this.braking_action=braking_action;
        this.taxiways=taxiways;
    }
}
