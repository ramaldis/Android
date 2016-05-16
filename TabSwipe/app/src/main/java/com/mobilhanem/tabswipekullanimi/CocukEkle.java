package com.mobilhanem.tabswipekullanimi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mobilhanem.actionbarkullanimi.R;

/**
 * Created by Ramaldis on 04.04.2016
 */
public class CocukEkle extends Activity {
    public static final String USER_NAME = "USER_NAME";
    String gelenad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cocukekle);

        Button ekle=(Button) findViewById(R.id.btnCocukEkle);

        TextView txt=(TextView) findViewById(R.id.textView33);

        Intent intent = getIntent();

        gelenad = intent.getStringExtra(ActivityLogin.USER_NAME);
        txt.setText(gelenad);

        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CocukEkle.this,Cocuklar.class);
                intent.putExtra(USER_NAME,gelenad);
                startActivity(intent);


            }
        });
    }
}
