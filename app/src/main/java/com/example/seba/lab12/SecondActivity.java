package com.example.seba.lab12;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        GuiSpinerAutocplete guiSpinerAutocplete = new GuiSpinerAutocplete();
        Button buttonClick2 = findViewById(R.id.buttonShowVideo);
        final AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.setAdapter(guiSpinerAutocplete.LoadAdapterFromBaseAutocomplete(this,DataBaseStructure.BaseTableVideo,DataBaseStructure.BaseTableVideoName));


        buttonClick2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message= autoCompleteTextView.getText().toString();
                Intent SecondScreenInfo = new Intent();
                SecondScreenInfo.putExtra("Nazwa", message);
                SecondScreenInfo.putExtra("Komunikat", "jest OK");
                setResult(Activity.RESULT_OK,SecondScreenInfo);
                finish();
            }
        });
    }
}
