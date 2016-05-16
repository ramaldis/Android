package com.mobilhanem.tabswipekullanimi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mobilhanem.actionbarkullanimi.R;

/**
 * Created by Serhan on 20.12.2015.
 */
public class WebGozetimi extends Activity {

    Button geri,kısıt,izin,kategori;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_gozetimi);

        kategori=(Button) findViewById(R.id.btnKategori);
        geri=(Button) findViewById(R.id.btnGozetimGeri);
        kısıt=(Button) findViewById(R.id.btnKısıtEkle);
        izin=(Button) findViewById(R.id.btnİzinEkle);

        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WebGozetimi.this,EbeveynHomePage.class);
                startActivity(intent);
                finish();
            }
        });

        kategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WebGozetimi.this,Kategori.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
