package net.timothyhahn.Buzzed.fragments;

import android.app.AlarmManager;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import net.timothyhahn.Buzzed.AlarmReceiver;
import net.timothyhahn.Buzzed.R;

/**
 * Created by tim on 4/12/14.
 */
public class BuzzedFragment extends Fragment  implements SurfaceHolder.Callback{
    private PendingIntent mAlarmIntent;
    private int mSecondsLeft = 1;
    private EditText mScheduleSeconds;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buzzed, container, false);

        Button scheduleButton = (Button) view.findViewById(R.id.schedule_alarm);
        mScheduleSeconds = (EditText) view.findViewById(R.id.schedule_seconds);
        Intent intent = new Intent(getActivity(), AlarmReceiver.class);
        mAlarmIntent = PendingIntent.getBroadcast(getActivity().getBaseContext(), 234324243, intent, 0);

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
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

        // Drawable stuff


        //SurfaceView surfaceView = (SurfaceView) view.findViewById(R.id.drawable_surface);
        //surfaceView.getHolder().addCallback(this);
//        surfaceView.invalidate();

        return view;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        tryDrawing(holder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int i, int i2, int i3) {
        tryDrawing(holder);
    }
    private void tryDrawing(SurfaceHolder holder) {

        Canvas canvas = holder.lockCanvas();
        if (canvas == null) {
        } else {
            drawMyStuff(canvas);
            holder.unlockCanvasAndPost(canvas);
        }
    }

    private void drawMyStuff(final Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawRect(0,0,10,10,paint);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
