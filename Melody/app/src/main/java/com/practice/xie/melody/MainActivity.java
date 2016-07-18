package com.practice.xie.melody;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class MainActivity extends Activity {

    private Button start;
    private Button stop;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button)findViewById(R.id.start);
        stop = (Button)findViewById(R.id.stop);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mp = new MediaPlayer();
//                String song = Environment.getExternalStorageDirectory().getAbsolutePath()
//                        + File.separator + "test.mp3";
//                try {
//                    mp.setDataSource(song);
//                    mp.prepare();
//                    mp.start();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                mp = MediaPlayer.create(MainActivity.this,R.raw.test);
//                mp.start();
                Intent i = new Intent(MainActivity.this, SoundService.class);
                i.putExtra("playing",true);
                startService(i);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SoundService.class);
                i.putExtra("playing",false);
                startService(i);
            }
        });
    }
}
