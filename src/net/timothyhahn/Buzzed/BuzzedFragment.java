package net.timothyhahn.Buzzed;

import android.app.AlarmManager;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by tim on 4/12/14.
 */
public class BuzzedFragment extends Fragment {
    public static final String ARG_BUZZED_NUMBER = "BUZZED_NUMBER";
    private PendingIntent mAlarmIntent;
    private int mSecondsLeft = 1;
    private EditText mScheduleSeconds;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("HI1", Integer.toString(getArguments().getInt(ARG_BUZZED_NUMBER)));

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Integer fragmentNumber = getArguments().getInt(ARG_BUZZED_NUMBER);
        View view;
        switch(fragmentNumber) {
            case 1:
                view = inflater.inflate(R.layout.fragment_vibrations, container, false);
                break;
            case 2:
                view = inflater.inflate(R.layout.fragment_alarms, container, false);
                break;
            case 3:
                view  = inflater.inflate(R.layout.fragment_settings, container, false);
                break;
            default:
                view = buzzedView(inflater, container);
                break;
        }
        Log.d("HI2", Integer.toString(getArguments().getInt(ARG_BUZZED_NUMBER)));
        return view;
    }

    public View buzzedView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_buzzed, container, false);

        Button scheduleButton = (Button)view.findViewById(R.id.schedule_alarm);
        mScheduleSeconds = (EditText)view.findViewById(R.id.schedule_seconds);
        Intent intent = new Intent(getActivity(), AlarmReceiver.class);
        mAlarmIntent = PendingIntent.getBroadcast(getActivity().getBaseContext(), 234324243, intent, 0);

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    mSecondsLeft = Integer.parseInt(mScheduleSeconds.getText().toString());
                    Toast.makeText(getActivity().getBaseContext(), "Alarm scheduled for " + mSecondsLeft + " seconds", Toast.LENGTH_LONG).show();
                } catch (NumberFormatException nfe) {
                    mSecondsLeft = 1;
                    Toast.makeText(getActivity().getBaseContext(), "Use numbers please", Toast.LENGTH_LONG).show();
                }
                AlarmManager am = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
                am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + mSecondsLeft * 1000, mAlarmIntent);
            }
        });


        return view;

    }
}
