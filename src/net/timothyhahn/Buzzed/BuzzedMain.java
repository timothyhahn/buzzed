package net.timothyhahn.Buzzed;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.*;

public class BuzzedMain extends Activity {
    private PendingIntent alarmIntent;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        String[] mMenuOptions = getResources().getStringArray(R.array.menu_names);
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ListView mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mMenuOptions));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener(this));

        /**
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
        **/
    }
}
