package com.example.nfcreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ThreeColumnListAdapter extends ArrayAdapter<Workout> {

    private LayoutInflater inflater;
    private ArrayList<Workout> workouts;
    private int viewResourceId;

    public ThreeColumnListAdapter(Context context, int viewResourceId, ArrayList<Workout> workouts) {
        super(context, viewResourceId, workouts);
        this.workouts = workouts;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.viewResourceId = viewResourceId;
    }

    public View getView(int posiiton, View convertView, ViewGroup parents) {
        convertView = inflater.inflate(viewResourceId, null);

        Workout workout = workouts.get(posiiton);

        if(workout != null) {
            TextView machine = (TextView) convertView.findViewById(R.id.textMachine);
            TextView reps = (TextView) convertView.findViewById(R.id.textReps);
            TextView weight = (TextView) convertView.findViewById(R.id.textWeight);

            if(machine != null) {
                machine.setText(workout.getMachine());
            }
            if(reps != null) {
                reps.setText(workout.getReps());
            }
            if(weight != null) {
                weight.setText(workout.getWeight());
            }
        }

        return convertView;
    }
}
