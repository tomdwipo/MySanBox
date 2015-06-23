package com.example.android.mysanbox;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView artistTextView;
    private Button prevButton;
    private Button playButton;
    private Button nextButton;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.game_field);

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                int duration = mp.getDuration();
                Toast.makeText(getApplicationContext(),"duration: "+duration/1000+" second",Toast.LENGTH_LONG).show();
            }
        });

        prevButton = (Button)findViewById(R.id.prevButton);
        playButton = (Button)findViewById(R.id.playButton);
        nextButton = (Button)findViewById(R.id.nextButton);
        artistTextView = (TextView)findViewById(R.id.ArtistTextView);

        playButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.playButton:
               if (mediaPlayer.isPlaying()){
                   pauseMusic();
               }else {
                   playMusic();
               }

                break;
            case R.id.prevButton:


                break;
            case R.id.nextButton:

                break;
        }

    }
    public void playMusic(){
        if (mediaPlayer != null){
            mediaPlayer.start();
            artistTextView.setText("Music Playing Now..");
            playButton.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_pause));

        }

    }
    public void pauseMusic(){
        if (mediaPlayer !=null){
            mediaPlayer.pause();
            artistTextView.setText("Music Pause!");
            playButton.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_play));

        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer !=null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
