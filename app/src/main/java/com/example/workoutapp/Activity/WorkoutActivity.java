package com.example.workoutapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.example.workoutapp.Adapter.LessonsAdapter;
import com.example.workoutapp.Domain.Workout;
import com.example.workoutapp.R;
import com.example.workoutapp.databinding.ActivityWorkoutBinding;

public class WorkoutActivity extends AppCompatActivity {
    ActivityWorkoutBinding binding;
    private Workout workout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWorkoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        setVariable();
        getObject();
    }

    private void getObject() {
        workout = (Workout) getIntent().getSerializableExtra("object");
        if (workout == null) {
            // Handle the case where workout is null, e.g., finish the activity or show a message.
            finish();
        }
    }


    private void setVariable() {
        int resId = getResources().getIdentifier(workout.getPicPath(),"drawable",getPackageName());
        Glide.with(this)
                .load(resId)
                .into(binding.pic);
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.titleTxt.setText(workout.getTitle());
        binding.exerciseTxt.setText(workout.getLessons().size()+" Exercise");
        binding.kcalTxt.setText(workout.getKcal()+" Kcal");
        binding.durationTxt.setText(workout.getDurationAll());
        binding.descriptionTxt.setText(workout.getDescription());

        binding.view3.setLayoutManager(new LinearLayoutManager(WorkoutActivity.this,LinearLayoutManager.VERTICAL,false));
        binding.view3.setAdapter(new LessonsAdapter(workout.getLessons()));

    }

}