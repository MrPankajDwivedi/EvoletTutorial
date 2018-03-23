package com.dbrothers.pankaj_pc.evoletdemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCall, btnSMS, btnEmail, btnSearch, btnStartService,btnStopService;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        Intent intent = getIntent();
        String str = intent.getStringExtra("intentStr");
        btnCall = (Button) findViewById(R.id.btnCall);
        btnSMS = (Button) findViewById(R.id.btnSMS);
        btnEmail = (Button) findViewById(R.id.btnEmail);
        btnSearch = (Button) findViewById(R.id.btnBrowse);
        btnStartService=(Button) findViewById(R.id.btnStartService);
        btnStopService=(Button) findViewById(R.id.btnStopService);
        btnCall.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
        btnSMS.setOnClickListener(this);
        btnStopService.setOnClickListener(this);
        btnStartService.setOnClickListener(this);

        Toast.makeText(this, "Str from Intent:" + str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCall:
                String phone = "+34666777888";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intentCall);
                break;
            case R.id.btnSMS:
                String number = "12346556";  // The number on which you want to send SMS
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "950844753", null)));
                break;
            case R.id.btnEmail:
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL  , new String[] { "developer.dbrothers@gmail.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "Android Demo Intent Email");

                startActivity(Intent.createChooser(intent, "Email via..."));
                break;
            case R.id.btnBrowse:

                String url = "http://www.google.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                    break;
            case R.id.btnStartService:
                startService(new Intent(this, MyService.class));
                break;
            case R.id.btnStopService:
                stopService(new Intent(this, MyService.class));
                break;

        }
    }
}
