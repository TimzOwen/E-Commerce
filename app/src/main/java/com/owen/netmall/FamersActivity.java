package com.owen.netmall;

package com.owen.contactlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class WorkActivity extends AppCompatActivity {

    private AudioManager mAudioMager;

    private AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focus)
        {
            if (focus == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK || focus == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT)
            {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
            else if (focus == AudioManager.AUDIOFOCUS_GAIN)
            {
                mediaPlayer.start();
            }
            else if (focus == AudioManager.AUDIOFOCUS_LOSS)
            {
                releaseResources();
            }

        }
    };

    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener onCompletionListener =new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseResources();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mAudioMager= (AudioManager) getSystemService(AUDIO_SERVICE);

        final ArrayList<Contact> arrayListWork = new ArrayList<>();

        arrayListWork.add(new Contact("Boss","0757161845", R.raw.color_black));
        arrayListWork.add(new Contact("Secretary","07542161845", R.raw.color_dusty_yellow));
        arrayListWork.add(new Contact("kitchen","07654161845", R.raw.color_green));
        arrayListWork.add(new Contact("Security","07574161845", R.raw.number_one));
        arrayListWork.add(new Contact("Driver","07585161845", R.raw.color_dusty_yellow));
        arrayListWork.add(new Contact("Clerk","0754161845", R.raw.phrase_are_you_coming));
        arrayListWork.add(new Contact("watchman","07574161845", R.raw.family_daughter));
        arrayListWork.add(new Contact("Senior Engineer","075661845", R.raw.phrase_what_is_your_name));
        arrayListWork.add(new Contact("Cook","075761845", R.raw.color_green));
        arrayListWork.add(new Contact("Mailer","07575161845", R.raw.family_daughter));
        arrayListWork.add(new Contact("Callers","07557161845", R.raw.family_grandmother));
        arrayListWork.add(new Contact("Partners","0757161845", R.raw.color_white));
        arrayListWork.add(new Contact("Suppliers","075678161845", R.raw.phrase_what_is_your_name));
        arrayListWork.add(new Contact("Buyer","07656161845", R.raw.color_black));

        ContactAdapter adapter = new ContactAdapter(this, arrayListWork, R.color.category_work);

        ListView listView = findViewById(R.id.listView_Linear);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Contact contact = arrayListWork.get(position);
                releaseResources();

                int result = mAudioMager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mediaPlayer = MediaPlayer.create(WorkActivity.this, contact.getmAudioResourceId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(onCompletionListener);
                }
            }
        });

    }
    //method to release media resourcse
    private void releaseResources()
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.release();
        }
        mediaPlayer = null;

        mAudioMager.abandonAudioFocus(afChangeListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseResources();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.exit_nav:
                startActivity(new Intent(WorkActivity.this, MainActivity.class));
            case R.id.home_nav:
                startActivity(new Intent(WorkActivity.this, MainActivity.class));
            case R.id.logout_nav:
                startActivity(new Intent(WorkActivity.this, MainActivity.class));
                default:
                    return super.onOptionsItemSelected(item);

        }
    }
