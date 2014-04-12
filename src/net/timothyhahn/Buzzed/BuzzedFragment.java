package net.timothyhahn.Buzzed;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tim on 4/12/14.
 */
public class BuzzedFragment extends Fragment {
    public static final String ARG_BUZZED_NUMBER = "BUZZED_NUMBER";
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("HI1", Integer.toString(getArguments().getInt(ARG_BUZZED_NUMBER)));

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Integer fragmentNumber = getArguments().getInt(ARG_BUZZED_NUMBER);
        View v;
        switch(fragmentNumber) {
            case 1:
                v = inflater.inflate(R.layout.fragment_vibrations, container, false);
                break;
            case 2:
                v = inflater.inflate(R.layout.fragment_alarms, container, false);
                break;
            case 3:
                v  = inflater.inflate(R.layout.fragment_settings, container, false);
                break;
            default:
                v = inflater.inflate(R.layout.fragment_buzzed, container, false);
                break;
        }
        Log.d("HI2", Integer.toString(getArguments().getInt(ARG_BUZZED_NUMBER)));
        return v;
    }
}
