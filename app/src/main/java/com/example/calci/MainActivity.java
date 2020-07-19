package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     ProgressBar progressBar;
     TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textView);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        progressBar.setMax(100);
        progressBar.setScaleY(3f);
        progressAnimation();
    }
    public void progressAnimation(){
        ProgressBarAnimation anim = new ProgressBarAnimation(this,progressBar,textView,0,100);
        anim.setDuration(8000);
        progressBar.setAnimation(anim);
    }
}
