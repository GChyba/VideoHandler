package com.example.seba.lab12;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    public final static int send = 0;
    Button buttonScreenSec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonScreenSec = findViewById(R.id.buttonSecondActivity);
    DataBaseStructure dataBaseStructure = new DataBaseStructure();

        SQLiteDatabase base = openOrCreateDatabase(dataBaseStructure.BaseFile, MODE_PRIVATE, null);
        base.execSQL("CREATE TABLE IF NOT EXISTS 'Video' ('idVideo' TEXT PRIMARY KEY, 'path' TEXT)");
        Cursor cursor = base.query(dataBaseStructure.BaseTableVideo, new String[]{dataBaseStructure.BaseTableidVideo}, null, null, null, null, null );
        ContentValues content = new ContentValues();
        content.put("idVideo", "Video1");
        content.put("path", "Video1.mp4");
        base.insert("Video",null,content);
        content.put("idVideo", "Video2");
        content.put("path", "Video2.mp4");
        base.insert("Video",null,content);
        content.put("idVideo", "Video3");
        content.put("path", "Video3.mp4");
        base.insert("Video",null,content);
        cursor.close();
        base.close();
        buttonScreenSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondScreen = new Intent(getApplicationContext(), SecondActivity.class);
                startActivityForResult(secondScreen, send);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        VideoView videoViewMov = findViewById(R.id.videoViewMovie);
        MediaController VideoControl = new MediaController(this);
        Uri video_file = Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + data.getStringExtra("Nazwa"));

        videoViewMov.setMediaController(VideoControl);
        videoViewMov.setVideoURI(video_file);
        videoViewMov.start();
    }
}
