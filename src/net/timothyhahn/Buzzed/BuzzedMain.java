package net.timothyhahn.Buzzed;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BuzzedMain extends Activity {
    private PendingIntent alarmIntent;
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
                vibrator.vibrate(new long[]{0,500,110,500,110,450,110,200,110,170,40,450,110,200,110,170,40,500}, -1);
            }
        });

        Button alarmButton = (Button)findViewById(R.id.alarmButton);
        Intent intent = new Intent(this, AlarmReceiver.class);


        alarmIntent = PendingIntent.getBroadcast(getBaseContext(), 234324243, intent, 0);
        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 5 * 1000, alarmIntent);
            }
        });
    }
}
