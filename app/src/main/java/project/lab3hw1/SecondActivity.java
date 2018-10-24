package project.lab3hw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final ImageView colorPreview = (ImageView)( findViewByID( R.id.colorPreview ) );
        colorPreview.setBackgroundColor( 0 );

        final EditText CCRD = (EditText)( findViewByID( R.id.CCRD ) );
        CCRD.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    public void setColor( View v ){
        //Create an empty Intent and add the selected_sound variable to it
        Intent data = new Intent();
        data.putExtra( "color", 0 );
        //Set the result code for the MainActivity and attach the data Intent
        setResult( RESULT_OK, data );
        //Destroy this Activity and propagate the ActivityResult
        finish();
    }
}
