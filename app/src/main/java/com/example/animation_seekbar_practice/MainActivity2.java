package com.example.animation_seekbar_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    ImageView monkeyImage;
    Button rotateXButton;
    Button rotateYButton;
    Button hideButton;
    Button showButton;
    Button scaleXButton;
    Button scaleYButton;
    Button resetButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        monkeyImage= (ImageView) findViewById(R.id.imageView);
        rotateXButton=(Button)findViewById(R.id.rotateXButton);
        rotateYButton=(Button)findViewById(R.id.rotateYButton);
        hideButton=(Button)findViewById(R.id.HideButton);
        showButton=(Button)findViewById(R.id.ShowButton);
        scaleXButton=(Button)findViewById(R.id.ScaleXButton);
        scaleYButton=(Button)findViewById(R.id.ScaleYButton);
        resetButton=(Button)findViewById(R.id.resetButton);

        rotateXButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                monkeyImage.animate().rotationXBy(360).setDuration(1000);
            }
        });

        rotateYButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                monkeyImage.animate().rotationYBy(360).setDuration(1000);
            }
        });

        hideButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                monkeyImage.animate().alpha(0).setDuration(600);
            }
        });

        showButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                monkeyImage.animate().alpha(1).setDuration(600);
            }
        });

        scaleXButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                monkeyImage.animate().scaleX((float)1.5).setDuration(600);
            }
        });

        scaleYButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                monkeyImage.animate().scaleY((float)1.5).setDuration(600);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                monkeyImage.animate().scaleX(1).setDuration(600);
                monkeyImage.animate().scaleY(1).setDuration(600);
                monkeyImage.animate().alpha(1).setDuration(600);
            }
        });
    }




}