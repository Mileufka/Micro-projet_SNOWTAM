package ensim.snowtam.Controler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ensim.snowtam.Model.HTTPRequester;
import ensim.snowtam.R;

public class MainActivity extends AppCompatActivity {

    private TextView text_view_1;
    private Button button;
    private HTTPRequester httprequester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_view_1 = (TextView) findViewById(R.id.text_view_1);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                httprequester=new HTTPRequester(view.getContext());
                httprequester.addRequest("ESSA");
                text_view_1.setText(httprequester.get_page());
            }
        });
    }

}
