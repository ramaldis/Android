package com.mobilhanem.tabswipekullanimi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mobilhanem.actionbarkullanimi.R;

/**
 * Created by Ramaldis on 14.3.2016.
 */
public class OpenScreen extends Activity {

    public static final String USER_NAME = "USER_NAME";
    String gelenad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.openscreen);
        Button cocuk=(Button) findViewById(R.id.btnCocuk);
        Button ebeveyn=(Button) findViewById(R.id.btnEbeveyn);
        TextView txt=(TextView) findViewById(R.id.textView28);
        Intent intent = getIntent();

        gelenad = intent.getStringExtra(ActivityLogin.USER_NAME);
        //ActivityLogin Sınıfından gelen ismi buraya Login ettik.
        txt.setText(gelenad);

        cocuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OpenScreen.this,Cocuk.class);
                intent.putExtra(USER_NAME,gelenad);
                startActivity(intent);
                finish();
            }
        });

        ebeveyn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OpenScreen.this,Ebeveyn.class);

                startActivity(intent);
            }
        });

    }
}
