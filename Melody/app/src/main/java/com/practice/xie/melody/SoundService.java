package com.practice.xie.melody;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.IBinder;

import java.io.File;
import java.io.IOException;

public class SoundService extends Service {
    private MediaPlayer mp;
    public SoundService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp = new MediaPlayer();
        String song = Environment.getExternalStorageDirectory().getAbsolutePath()
                        + File.separator + "test.mp3";
        try {
            mp.setDataSource(song);
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.release();
        stopSelf();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        boolean playing = intent.getBooleanExtra("playing",false);
        if(playing){
            mp.start();
        }else{
            mp.pause();
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
