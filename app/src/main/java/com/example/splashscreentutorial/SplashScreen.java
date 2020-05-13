package com.example.splashscreentutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        StartSplash();
    }

    protected void StartSplash(){
            /** set the time to splash out */
            final int welcomeScreenDisplay = 3500;
            /** create a thread to show splash up to splash time */
            Thread splashTimer = new Thread(){
                int wait =0;
                    @Override
                    public void run(){
                        try{
                            super.run();
                            /**
                             use while go to get the splash time. Use sleep() to increase the wait variable for every 100l
                             */
                            while (wait < welcomeScreenDisplay){
                                sleep(100);
                                wait +=100;
                            }
                        }catch (Exception e){
                            System.out.println("EXc="+e);
                        }finally {
                            /**
                             Called after splash times up. Do some action after splash here
                             times up. Here we moved to another main activity class
                             * */
                            startActivity(new Intent(SplashScreen.this, MainActivity.class));
                            finish();
                        }
                    }

            };
            splashTimer.start();
    }

    public void onBackPressed(){
        /** blank means no action on this activity,
         * Thanks for watching **/
    }
}
