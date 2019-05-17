package com.example.nfcreader;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddWorkoutActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    private EditText weightInput, repInput;
    private Button buttonAddWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);
        configureMainPageButton();

        weightInput = (EditText) findViewById(R.id.weightInput);
        repInput = (EditText) findViewById(R.id.repInput);
        buttonAddWorkout = (Button) findViewById(R.id.buttonAddWorkout);
        databaseHelper = new DatabaseHelper(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonAddWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String machine = "machine_1";
                int reps = Integer.parseInt(repInput.getText().toString());
                int weight = Integer.parseInt(weightInput.getText().toString());

                if(machine.length() != 0 && reps != 0 && weight != 0) {
                    addData(machine, reps, weight);
                    finish();
                } else {
                    toastMessage("Please fill all the fields");
                }
            }
        });
    }

    public void addData(String machine, int reps, int weight) {
        boolean insertData = databaseHelper.addData(machine, reps, weight);

        if (insertData) {
            toastMessage("Workout Added!");
        } else {
            toastMessage("Error inserting data");
        }
    }


    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void configureMainPageButton() {
        Button databaseWrite = (Button) findViewById(R.id.page_main);
        databaseWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
