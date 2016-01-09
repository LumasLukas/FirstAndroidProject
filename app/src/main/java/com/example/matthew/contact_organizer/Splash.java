package com.example.matthew.contact_organizer;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by Matthew on 1/8/2016.
 * class for the splash screen
 * these different activities are similar
 * to different screens/tabs in the app
 * almost all activity's should implement:
 *
 * Here is a good diagram of the activity life cycle
 * http://www.skill-guru.com/blog/2011/01/13/android-activity-life-cycle/
 * onCreate, *  (call setContentView)
 * onStart, onRestart, onResume, onPause, onStop, onDestroy
 *
 * onPause(): used to save data if the user switches to some
 * other application, similar to an embedded system before the
 * application resets because of a watchdog timer
 *
 * onResume() when the app is restarted after being paused or stopped
 */
public class Splash extends Activity {
    MediaPlayer introSong;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //R.layout holds a list of layout resource IDs from the package
        setContentView(R.layout.splash);

        //classes for music
        //the sound pool: used for short bursts of music ex gunshots
        //media player: most other things

        //could also set this variable up as a global so it can be used
        //outside of the onCreate
        introSong = MediaPlayer.create(Splash.this, R.raw.opening_sound);
        introSong.start();
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000); //5 seconds
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent openMenu = new Intent("com.example.matthew.contact_organizer.MENU");
                    //when one activity starts another, it enters the
                    //activities override of the "onPause()" method
                    startActivity(openMenu);
                }
            }
        };
        timer.start(); //start the thread defined above
    }

    @Override
    //override of the onPause method from Activity
    //this will be called when the main activity is called
    //in the finally block
    protected void onPause() {
        super.onPause();
        //releases the music when the intro page is left
        introSong.release();
        finish();
    }
}
