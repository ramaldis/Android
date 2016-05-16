package com.mobilhanem.tabswipekullanimi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mobilhanem.actionbarkullanimi.R;

/**
 * Created by Ramaldis on 04.04.2016
 */
public class Kurallar extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kurallar);

        Button kuralgeri=(Button)  findViewById(R.id.btnGozetimGeri);

        kuralgeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Kurallar.this,CocukDevam.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
