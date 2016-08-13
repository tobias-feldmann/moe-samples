package de.fotaris.retrofitsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.fotaris.retrofit.IpController;
import de.fotaris.retrofit.ResponseCallback;
import de.fotaris.retrofit.models.IpResponse;

/**
 * Created by Tobias Feldmann on 12.08.16.
 */
public class MainActivity extends AppCompatActivity {

    private TextView ipText;
    private Button getIpButton;
    private IpController ipController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ipController = new IpController();
        ipText = (TextView) findViewById(R.id.ip_text);
        getIpButton = (Button) findViewById(R.id.ip_button);
        getIpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ipController.getIp(new ResponseCallback<IpResponse>() {
                    @Override
                    public void success(IpResponse response) {
                        ipText.setText(response.getOrigin());
                    }

                    @Override
                    public void error() {

                    }
                });
            }
        });
    }
}
