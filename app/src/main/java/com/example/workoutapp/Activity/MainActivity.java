package com.example.workoutapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.workoutapp.Adapter.WorkoutAdapter;
import com.example.workoutapp.Domain.Lessons;
import com.example.workoutapp.Domain.Workout;
import com.example.workoutapp.R;
import com.example.workoutapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        binding.view1.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        binding.view1.setAdapter(new WorkoutAdapter(getData()));
    }

    private ArrayList<Workout> getData(){
        ArrayList<Workout> list = new ArrayList<>();

        list.add(new Workout("Running", "You just woke up. It is a brand new day. The canvas is blank. How do you begin? Take 21 minutes to cultivate a peaceful mind and strong body", "pic_1", 160,"9 min",getLesson_1()));
        list.add(new Workout("Stretching", "You just woke up. It is a brand new day The canvas is blank. How do you begin? Take 21 minutes to cultivate a peaceful mind and strong body", "pic_2", 230,"85 min",getLesson_2()));
        list.add(new Workout("Yoga", "You just woke up. It is a brand new day The canvas is blank. How do you begin? Take 21 minutes to cultivate a peaceful mind and strong body", "pic_3", 180,"65 min",getLesson_3()));

        return list;
    }
    private ArrayList<Lessons> getLesson_1(){
        ArrayList<Lessons> list = new ArrayList<>();

        list.add(new Lessons("Lesson1","03:46","HBMvFkpNgE","pic_1_1"));
        list.add(new Lessons("Lesson2","03:41","K6I24WgiiPw","pic_1_2"));
        list.add(new Lessons("Lesson3","01:57","Zc08v4YY0eA","pic_1_3"));

        return list;
    }

    private ArrayList<Lessons> getLesson_2(){
        ArrayList<Lessons> list = new ArrayList<>();

        list.add(new Lessons("Lesson 1","20:23","L3eImBAXT7I","pic_3_1"));
        list.add(new Lessons("Lesson 2","18:27","47Exgz07FLU","pic_3_2"));
        list.add(new Lessons("Lesson 3","32:25","OmLx8tmaQ-4","pic_3_3"));
        list.add(new Lessons("Lesson 4","07:52","w86EalEoFRY","pic_3_4"));

        return list;
    }

    private ArrayList<Lessons> getLesson_3(){
        ArrayList<Lessons> list = new ArrayList<>();

        list.add(new Lessons("Lesson 1","23:00","v7AYKMP6r0E","pic_3_1"));
        list.add(new Lessons("Lesson 2","27:00","Eml2xnoLpYE","pic_3_2"));
        list.add(new Lessons("Lesson 3","25:00","v7SN-d4qXx0","pic_3_3"));
        list.add(new Lessons("Lesson 4","21:00","LqXZ628YNj4","pic_3_4"));

        return list;
    }
}