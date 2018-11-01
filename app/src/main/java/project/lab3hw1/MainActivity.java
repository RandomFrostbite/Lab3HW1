package project.lab3hw1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int BUTTON_REQUEST = 1;
    private MediaPlayer mainPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageDrawable( getResources().getDrawable( android.R.drawable.ic_media_pause ) );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( mainPlayer.isPlaying() ) {
                    ((FloatingActionButton)view).setImageDrawable( getResources().getDrawable( android.R.drawable.ic_media_play ) );
                    mainPlayer.pause();
                }
                else {
                    ((FloatingActionButton)view).setImageDrawable( getResources().getDrawable( android.R.drawable.ic_media_pause ) );
                    mainPlayer.start();
                }
            }
        });

        final Button btn1 = (Button)( findViewById( R.id.btn1 ) );
        btn1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnData = new Intent( getApplicationContext(), SecondActivity.class );
                startActivityForResult( btnData, 1 );
            }
        });

        final Button btn2 = (Button)( findViewById( R.id.btn2 ) );
        btn2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnData = new Intent( getApplicationContext(), SecondActivity.class );
                startActivityForResult( btnData, 2 );
            }
        });

        final Button btn3 = (Button)( findViewById( R.id.btn3 ) );
        btn3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnData = new Intent( getApplicationContext(), SecondActivity.class );
                startActivityForResult( btnData, 3 );
            }
        });
    }

    @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent data ) {
        if (resultCode == RESULT_OK) {
            // Make sure the request was successful
            Integer r = data.getIntExtra("Rvalue", 0);
            Integer g = data.getIntExtra("Gvalue", 0);
            Integer b = data.getIntExtra("Bvalue", 0);

            switch (requestCode) {
                case 1:
                    (findViewById(R.id.main)).setBackgroundColor(Color.rgb(r, g, b));
                    break;
                case 2:
                    (findViewById(R.id.btn1)).setBackgroundColor(Color.rgb(r, g, b));
                    (findViewById(R.id.btn2)).setBackgroundColor(Color.rgb(r, g, b));
                    (findViewById(R.id.btn3)).setBackgroundColor(Color.rgb(r, g, b));
                    break;
                case 3:
                    ((Button) (findViewById(R.id.btn1))).setTextColor(Color.rgb(r, g, b));
                    ((Button) (findViewById(R.id.btn2))).setTextColor(Color.rgb(r, g, b));
                    ((Button) (findViewById(R.id.btn3))).setTextColor(Color.rgb(r, g, b));
                    break;
            }
        }
        else if ( resultCode == RESULT_CANCELED )
            Toast.makeText( getApplicationContext(), getText( R.string.cancel ), Toast.LENGTH_SHORT ).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mainPlayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPlayer = MediaPlayer.create( this, R.raw.theme );
        mainPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                mp.start();
            }});
        ((FloatingActionButton)findViewById(R.id.fab)).setImageDrawable( getResources().getDrawable( android.R.drawable.ic_media_pause ) );
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPlayer.release();
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
