package com.example.matthew.contact_organizer;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.security.KeyStore;
import java.util.Random;

/**
 * Created by Matthew on 1/9/2016.
 */
public class TextPlay extends Activity implements View.OnClickListener{
    Button chkCmd;
    ToggleButton passTog;
    EditText input;
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);
        //setup variables for things from the layout file
        initXmlAttributes();
        //needs an object with onClick implemented.
        //could also have used anon method
        /*
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        };
        */
        //View must have an interface inside it with the method
        //onClick, this type of thing is similar to using function
        //pointers in c/c++, for example, could be useful for a AVL tree
        // library to have an interface with a "compare method" that
        //the user could implement
        passTog.setOnClickListener(this);
        chkCmd.setOnClickListener(this);
    }
    private void initXmlAttributes(){
        chkCmd = (Button) findViewById(R.id.bResults);
        passTog = (ToggleButton) findViewById(R.id.tbPassword);
        input = (EditText) findViewById(R.id.etCommands);
        display = (TextView) findViewById(R.id.tvResults);
    }
    public void onClick(View theView){
        switch (theView.getId()){
            case(R.id.bResults):
                //get text from input text box
                String check = input.getText().toString();
                display.setText(check);
                //setting the gravity, similar to how it is
                //done in the xml file
                if(check.contentEquals("left")){
                    display.setGravity(Gravity.LEFT);
                }
                else if(check.contentEquals("center")){
                    display.setGravity(Gravity.CENTER);
                }
                else if(check.contentEquals("right")){
                    display.setGravity(Gravity.RIGHT);
                }
                else if(check.contentEquals("blue")){
                    display.setTextColor(Color.BLUE);
                }
                else if(check.contains("WTF")){
                    Random crazy = new Random();
                    display.setText("WTFFFFF!!!!!!!!!!");
                    display.setTextSize(crazy.nextInt(75));
                    display.setTextColor(Color.rgb(crazy.nextInt(255),
                            crazy.nextInt(255), crazy.nextInt(255)));
                }
                else{
                    display.setText("invalid");
                    display.setGravity(Gravity.CENTER);
                }


                break;
            case(R.id.tbPassword):
                if(passTog.isChecked() == true){
                    input.setInputType(InputType.TYPE_CLASS_TEXT
                            | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                else{
                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                }

                break;
            case(R.id.etCommands):
                break;
            case(R.id.tvResults):
                break;
        }
    }


}
