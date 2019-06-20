package com.example.imageviewer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        ImageData imageData = (ImageData)intent.getSerializableExtra("imageData");

        ImageView imageView = findViewById(R.id.image_view);
        Button btnBack = findViewById(R.id.btn_back);

        imageView.setImageURI(imageData.getImage());

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
