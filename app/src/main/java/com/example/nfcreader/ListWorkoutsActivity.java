package com.example.nfcreader;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListWorkoutsActivity extends AppCompatActivity {

    private static final String TAG = "ListWorkoutsActivity";

    DatabaseHelper databaseHelper;
    ArrayList<Workout> workoutList;
    Workout workout;

    private ListView list_workouts;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_workouts_layout);

        list_workouts = (ListView) findViewById(R.id.list_workouts);
        databaseHelper = new DatabaseHelper(this);
        workoutList = new ArrayList<Workout>();
        
        populateWorkoutsList();
    }

    private void populateWorkoutsList() {
        Log.d(TAG, "Displaying the workouts list");

        Cursor data = databaseHelper.getData();
        int numRows = data.getCount();

        //check to see that there's something in the database
        if(numRows == 0) {
            toastMessage("There's no workouts saved right now");
            finish();
        }

        while(data.moveToNext()) {
            workoutList.add(new Workout(data.getString(1), data.getInt(2), data.getInt(3)));
        }

        ThreeColumnListAdapter adapter = new ThreeColumnListAdapter(this, R.layout.list_adapter_view, workoutList);

        list_workouts = (ListView) findViewById(R.id.list_workouts);
        list_workouts.setAdapter(adapter);

    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
