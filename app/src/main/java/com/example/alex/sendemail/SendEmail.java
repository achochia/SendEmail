package com.example.alex.sendemail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendEmail extends AppCompatActivity
{
    Button send;
    EditText to, cc, bcc, subject, message;
    String toStr, ccStr, bccStr;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);

        to = (EditText) findViewById(R.id.to);
        cc = (EditText) findViewById(R.id.cc);
        bcc = (EditText) findViewById(R.id.bcc);
        subject = (EditText) findViewById(R.id.subject);
        message = (EditText) findViewById(R.id.message);
        send = (Button) findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final Intent i = new Intent(Intent.ACTION_SEND);
                if(to.getText().length() > 0)
                {
                    toStr = '"' + to.getText().toString() + '"';
                    i.putExtra(Intent.EXTRA_EMAIL, toStr);

                }
                if(cc.getText().length() > 0)
                {
                    ccStr = '"' + cc.getText().toString() + '"';
                    i.putExtra(Intent.EXTRA_CC, ccStr);
                }
                if(bcc.getText().length() > 0)
                {
                    bccStr = '"' + cc.getText().toString() + '"';
                    i.putExtra(Intent.EXTRA_BCC, new String[] { bccStr });
                }
                i.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                i.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                i.setType("plain/text");
                startActivity(Intent.createChooser(i, "sending Email"));
            }
        });
    }


}
