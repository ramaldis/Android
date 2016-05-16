package com.mobilhanem.tabswipekullanimi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.mobilhanem.actionbarkullanimi.R;

/**
 * Created by Serhan on 20.12.2015.
 */

public class KisiselBilgi extends Activity {
    public static final String USER_NAME = "USER_NAME";

    String gelenad;
    EditText kullanıcıad,cocukad,cocukcinsiyet,cocukdogumtarih;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kisisel_bilgiler);
        Intent intent = getIntent();

       kullanıcıad=(EditText) findViewById(R.id.txtFamilySafeKullanıcıAdı);
       cocukad=(EditText) findViewById(R.id.txtFamilySafeCocukAdı);
       cocukcinsiyet=(EditText) findViewById(R.id.txtFamilySafeCocukCinsiyet);
       cocukdogumtarih=(EditText) findViewById(R.id.txtFamilySafeCocukDogumTarihi);

        gelenad = intent.getStringExtra(ActivityLogin.USER_NAME);

        kullanıcıad.setText(gelenad);
    }
}
