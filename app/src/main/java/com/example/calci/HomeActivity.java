package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    GridLayout mainGrid;
    ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mainGrid = (GridLayout)findViewById(R.id.mainGrid);
        imageView1 = (ImageView)findViewById(R.id.imageView1) ;
        imageView2 = (ImageView)findViewById(R.id.imageView2) ;
        imageView3 = (ImageView)findViewById(R.id.imageView3) ;
        imageView4 = (ImageView)findViewById(R.id.imageView4) ;
        imageView5 = (ImageView)findViewById(R.id.imageView5) ;
        imageView6 = (ImageView)findViewById(R.id.imageView6) ;
        setToggleEvent(mainGrid);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this,scientificCalculatorActivity.class);
                startActivity(i);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this,matrixCalculatorActivity.class);
                startActivity(i);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this,bmiCalculatorActivity.class);
                startActivity(i);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this,cgpagpaActivity.class);
                startActivity(i);
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this,convertorActivity.class);
                startActivity(i);
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this,ageCalculatorActivity.class);
                startActivity(i);
            }
        });
    }

    private void setToggleEvent(GridLayout mainGrid) {
        for(int i=0;i<mainGrid.getChildCount();i++){
            //final int value = i;
            final CardView cardView = (CardView)mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cardView.getCardBackgroundColor().getDefaultColor()== -1){
                         cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                         Toast.makeText(HomeActivity.this,"Clicked",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    }
                }
            });
        }
    }
}
