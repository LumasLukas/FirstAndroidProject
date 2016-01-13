package com.example.matthew.contact_organizer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Matthew on 1/10/2016.
 */
public class Email extends Activity implements View.OnClickListener {
    EditText sendTo, subject, greeting, message, salutation, signature;
    String sSendTo,  sSubject, sGreeting, sMessage, sSalutation, sSignature;
    Button sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);
        initializerVars();
        sendEmail.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        /*
        Calling finish() in onCreate(): onCreate() -> onDestroy()
        Calling finish() in onStart() : onCreate() -> onStart() -> onStop() -> onDestroy()
        Calling finish() in onResume(): onCreate() -> onStart() -> onResume() -> onPause() -> onStop() -> onDestroy()
        */
        finish();
    }

    private void initializerVars() {
        sendTo = (EditText) findViewById(R.id.etSendTo);
        subject = (EditText) findViewById(R.id.etSubject);
        greeting = (EditText) findViewById(R.id.etGreeting);
        message = (EditText) findViewById(R.id.etMessageOne);
        salutation = (EditText) findViewById(R.id.etSalutation);
        signature = (EditText) findViewById(R.id.etSignature);
    }
    public void onClick(View v){
        editTxtToString();
        String emailaddress[] = {sSendTo};
        String message = "" +
                greeting + "\n\n" +
                sMessage + "\n\n" +
                salutation + "\n\n" +
                signature + "\n";

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, emailaddress); //email sending to
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, sSubject);
        emailIntent.setType("plain/text");
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(emailIntent);
    }

    private void editTxtToString() {
        sSendTo = sendTo.getText().toString();
        sSubject = subject.getText().toString();
        sGreeting = greeting.getText().toString();
        sMessage = message.getText().toString();
        sSalutation = salutation.getText().toString();
        sSignature = signature.getText().toString();
    }

}
