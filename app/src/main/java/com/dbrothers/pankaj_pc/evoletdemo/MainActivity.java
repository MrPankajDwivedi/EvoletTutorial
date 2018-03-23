package com.dbrothers.pankaj_pc.evoletdemo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    LinearLayout LL1,LL2;
    Spinner sp;
    Button btn, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LL1=(LinearLayout) findViewById(R.id.idLL1);
        LL2=(LinearLayout) findViewById(R.id.idLL2);
        btn=(Button) findViewById(R.id.btnTest1);
        btn2=(Button) findViewById(R.id.btn2);

       // btn2.setOnClickListener((View.OnClickListener) this);

        sp=(Spinner) findViewById(R.id.spinner1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LL1.setBackgroundColor(Color.GREEN);
                LL2.setBackgroundColor(Color.CYAN);
                Drawable buttonBackground = LL1.getBackground();
                int color = ((ColorDrawable) LL1.getBackground()).getColor();
                Toast.makeText(getApplicationContext(),"Hello Dear"+color,Toast.LENGTH_LONG).show();
                btn.setBackgroundColor(color);
                Intent intent=new Intent(MainActivity.this,IntentActivity.class);
                intent.putExtra("intentStr","Demo initent");
                startActivity(intent);
                finish();
            }
        });

        ArrayList<String> list=new ArrayList<String>();
        list.add("--Select value--");
        list.add("1. Option..");
        list.add("2. Option..");
        list.add("3. Option..");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        sp.setAdapter(dataAdapter);
    }

    public void testMethod(View v){

    }
   /* @Override
    public void onClick(View v){

    }*/
}
