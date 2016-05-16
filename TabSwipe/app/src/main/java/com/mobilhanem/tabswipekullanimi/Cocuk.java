package com.mobilhanem.tabswipekullanimi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mobilhanem.actionbarkullanimi.R;

/**
 * Created by Ramaldis on 01.04.2016
 */
public class Cocuk extends Activity {
    public static final String USER_NAME = "USER_NAME";
    String gelenad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cocuk);

        Button devam=(Button) findViewById(R.id.btnDevam);
        Button geri=(Button) findViewById(R.id.btnGeri);
        Button cıkıs=(Button) findViewById(R.id.btnCıkıs);

        TextView txt=(TextView) findViewById(R.id.textView32);

        Intent intent = getIntent();

        gelenad = intent.getStringExtra(ActivityLogin.USER_NAME);
        txt.setText(gelenad);

        devam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Cocuk.this,CocukEkle.class);
                intent.putExtra(USER_NAME,gelenad);
                startActivity(intent);

            }
        });

        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Cocuk.this,OpenScreen.class);
                startActivity(intent);
            }
        });

        cıkıs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1. ÇIKIŞ KOMUTU

               // Intent intent = new Intent(Intent.ACTION_MAIN);
               // intent.addCategory(Intent.CATEGORY_HOME);
               // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               // startActivity(intent);

                //2.ÇIKIŞ KOMUTU

                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());


            }
        });
    }
}
