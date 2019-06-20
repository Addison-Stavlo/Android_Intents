package com.example.imageviewer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int IMAGE_REQUEST_CODE = 100;
    private Button btnAddImage;
    private LinearLayout layout;
    private ArrayList<ImageData> imageList;

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        btnAddImage = findViewById(R.id.btn_add_img);
        layout = findViewById(R.id.image_layout);
        imageList = new ArrayList<ImageData>();

        btnAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imageIntent = new Intent(Intent.ACTION_GET_CONTENT);
                imageIntent.setType("image/*");
                startActivityForResult(imageIntent, IMAGE_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            if(requestCode == IMAGE_REQUEST_CODE) {
                Uri photoUri = data.getData();
                ImageData newImage = new ImageData();
                newImage.setImage(photoUri, "Some Name");
                imageList.add(newImage);
                addTextView("Click for Image", imageList.size()-1);
            }
        }
    }

    private void addTextView(String text, final int index){
        TextView view = new TextView(context);
        view.setText(text);
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 32);
        view.setPadding(15,15,15,15);
        view.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        view.setWidth(2000);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageData selectedImage = imageList.get(index);
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("imageData", selectedImage);
                intent.setAction(Intent.ACTION_SEND);
                startActivity(intent);
            }
        });
        layout.addView(view);
    }
}
