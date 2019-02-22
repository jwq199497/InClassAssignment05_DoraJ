package com.example.android.inclassassignment05_doraj;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewMessageActivity extends AppCompatActivity {

    public TextView viewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);

        viewMessage = (TextView)findViewById(R.id.viewMessage);
        Intent intent = getIntent();
        viewMessage.setText(intent.getStringExtra("MESSAGE"));
        setTitle(intent.getStringExtra("TITLE"));

    }
}
