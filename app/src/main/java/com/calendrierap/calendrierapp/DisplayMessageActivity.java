package com.calendrierap.calendrierapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        Button one = (Button)this.findViewById(R.id.button5);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.groovy);
        one.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                    if (mp.isPlaying())
                    {mp.pause();}
               else{ mp.start();}
            }

        });
        Button second = (Button)this.findViewById(R.id.button6);
        final MediaPlayer backtrack = MediaPlayer.create(this, R.raw.backtrack);
        second.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                if (backtrack.isPlaying())
                {backtrack.pause();}
                else{backtrack.start();}
            }
        });

        Button third = (Button)this.findViewById(R.id.button7);
        final MediaPlayer sanglier = MediaPlayer.create(this, R.raw.sanglier);
        third.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {

                if (sanglier.isPlaying())
                {sanglier.pause();}
                else{sanglier.start();}
            }

        });

        Button fourth = (Button)this.findViewById(R.id.button8);
        final MediaPlayer jacquouille = MediaPlayer.create(this, R.raw.jacquouille);
        fourth.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {

                if (jacquouille.isPlaying())
                {jacquouille.pause();}
                else{jacquouille.start();}
            }

        });

    }
}
