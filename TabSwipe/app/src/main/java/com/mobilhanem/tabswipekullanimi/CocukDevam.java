package com.mobilhanem.tabswipekullanimi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mobilhanem.actionbarkullanimi.R;

/**
 * Created by Ramaldis on 04.04.2016
 */
public class CocukDevam extends Activity {

    public static final String USER_NAME = "USER_NAME";
    String gelenad;
    String gelencinsiyet;
    String gelentarih;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cocukdevam);

        TextView username=(TextView) findViewById(R.id.txtGelenCocukAd);
        TextView cinsiyet=(TextView) findViewById(R.id.txtGelenCinsiyet);
        TextView tarih=(TextView) findViewById(R.id.txtGelenTarih);

        ImageView resim=(ImageView) findViewById(R.id.resim);

        Intent intent = getIntent();

        gelenad = intent.getStringExtra(Cocuklar.USER_NAME);
        gelencinsiyet = intent.getStringExtra(Cocuklar.CİNSİYET);
        gelentarih = intent.getStringExtra(Cocuklar.TARİH);


        username.setText(gelenad);
        cinsiyet.setText(gelencinsiyet);
        tarih.setText(gelentarih);

        Button kural=(Button) findViewById(R.id.btnKurallar);
        Button kaydet=(Button) findViewById(R.id.btnCocukKaydet);

        kural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(CocukDevam.this,Kurallar.class);
                startActivity(intent);

            }
        });

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(CocukDevam.this);
                builder.setTitle("Kayıt !!");
                builder.setMessage("Çocuk Ekleme İşleminiz Bitmiştir..");
                builder.setCancelable(false);
                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        Toast.makeText(CocukDevam.this, "Açılıyor.", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(CocukDevam.this, Kategori.class);
                        intent.putExtra(USER_NAME, gelenad);
                        startActivity(intent);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

    }
}
