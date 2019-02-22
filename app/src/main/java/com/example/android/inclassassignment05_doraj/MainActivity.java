package com.example.android.inclassassignment05_doraj;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText titleBox;
    public EditText messageBox;
    public CheckBox titleOnly;
    public Button sendEmail;
    public Button launchActivity;
    public Button launchCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleBox = (EditText)findViewById(R.id.titleBox);
        messageBox = (EditText)findViewById(R.id.messageBox);
        titleOnly = (CheckBox)findViewById(R.id.check_box);
        sendEmail = (Button)findViewById(R.id.sendEmail);
        launchActivity = (Button)findViewById(R.id.launchActivity);
        launchCamera = (Button)findViewById(R.id.launchCamera);


        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_SUBJECT, titleBox.getText().toString());
                if (titleOnly.isChecked() == false){
                    intent.putExtra(Intent.EXTRA_TEXT, messageBox.getText().toString());
                }
                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });

        launchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewMessageActivity.class);
                intent.putExtra("TITLE", titleBox.getText().toString());
                if (titleOnly.isChecked() == false){
                    intent.putExtra("MESSAGE", messageBox.getText().toString());
                }else{
                    intent.putExtra("MESSAGE", (String) null);
                }
                MainActivity.this.startActivity(intent);
            }
        });

        launchCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent, 0);
            }
        });
    }
}
