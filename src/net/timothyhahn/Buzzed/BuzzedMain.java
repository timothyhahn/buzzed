package net.timothyhahn.Buzzed;

import android.app.Activity;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class BuzzedMain extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button buzzButton = (Button)findViewById(R.id.buzzButton);
        buzzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                //vibrator.vibrate(1000);
                vibrator.vibrate(0,500,110,500,110,450,110,200,110,170,40,450,110,200,110,170,40,500);
            }
        });
    }
}
