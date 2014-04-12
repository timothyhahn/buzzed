package net.timothyhahn.Buzzed;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by tim on 4/12/14.
 */
public class AlarmReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Time is up!!!!.", Toast.LENGTH_LONG).show();
    }
}
