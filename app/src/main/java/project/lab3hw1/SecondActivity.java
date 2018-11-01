package project.lab3hw1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final ImageView colorPreview = (ImageView)( findViewById( R.id.colorPreview ) );
        colorPreview.setBackgroundColor( Color.rgb(0, 0, 0) );

        final EditText CCRD = (EditText)( findViewById( R.id.CCRD ) );
        CCRD.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                if ( !CCRD.getText().toString().isEmpty() ) {
                    if ( Integer.parseInt( CCRD.getText().toString() ) > 255 )
                        CCRD.setText("255");
                    else if ( Integer.parseInt( CCRD.getText().toString() ) < 0 )
                        CCRD.setText("0");
                }
                update();
            }
        });

        final EditText CCGD = (EditText)( findViewById( R.id.CCGD ) );
        CCGD.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                if ( !CCGD.getText().toString().isEmpty() ) {
                    if ( Integer.parseInt( CCGD.getText().toString() ) > 255 )
                        CCGD.setText("255");
                    else if ( Integer.parseInt( CCGD.getText().toString() ) < 0 )
                        CCGD.setText("0");
                }
                update();
            }
        });

        final EditText CCBD = (EditText)( findViewById( R.id.CCBD ) );
        CCBD.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                if ( !CCBD.getText().toString().isEmpty() ) {
                    if ( Integer.parseInt( CCBD.getText().toString() ) > 255 )
                        CCBD.setText("255");
                    else if ( Integer.parseInt( CCBD.getText().toString() ) < 0 )
                        CCBD.setText("0");
                }
                update();
            }
        });
    }


    public void setColor( View v ) {
        //Create an empty Intent and add the selected_sound variable to it
        Intent data = new Intent();

        String rs, gs, bs;
        rs = ( (EditText)( findViewById( R.id.CCRD ) ) ).getText().toString().isEmpty() ?
                "0" : ( (EditText)( findViewById( R.id.CCRD ) ) ).getText().toString();
        gs = ( (EditText)( findViewById( R.id.CCGD ) ) ).getText().toString().isEmpty() ?
                "0" : ( (EditText)( findViewById( R.id.CCGD ) ) ).getText().toString();
        bs = ( (EditText)( findViewById( R.id.CCBD ) ) ).getText().toString().isEmpty() ?
                "0" : ( (EditText)( findViewById( R.id.CCBD ) ) ).getText().toString();

        Integer r = Integer.parseInt( rs );
        Integer g = Integer.parseInt( gs );
        Integer b = Integer.parseInt( bs );

        data.putExtra( "Rvalue", r );
        data.putExtra( "Gvalue", g );
        data.putExtra( "Bvalue", b );
        //Set the result code for the MainActivity and attach the data Intent
        setResult( RESULT_OK, data );
        //Destroy this Activity and propagate the ActivityResult
        finish();
    }

    public void discardColor( View v ) {
        Intent data = new Intent();
        setResult( RESULT_CANCELED, data );
        finish();
    }

    public void update() {
        String rs, gs, bs;

        rs = ( (EditText)( findViewById( R.id.CCRD ) ) ).getText().toString().isEmpty() ?
                "0" : ( (EditText)( findViewById( R.id.CCRD ) ) ).getText().toString();
        gs = ( (EditText)( findViewById( R.id.CCGD ) ) ).getText().toString().isEmpty() ?
                "0" : ( (EditText)( findViewById( R.id.CCGD ) ) ).getText().toString();
        bs = ( (EditText)( findViewById( R.id.CCBD ) ) ).getText().toString().isEmpty() ?
                "0" : ( (EditText)( findViewById( R.id.CCBD ) ) ).getText().toString();

        Integer r = Integer.parseInt( rs );
        Integer g = Integer.parseInt( gs );
        Integer b = Integer.parseInt( bs );

        ( (ImageView)( findViewById( R.id.colorPreview ) ) ).setBackgroundColor( Color.rgb(r, g, b) );
    }
}
