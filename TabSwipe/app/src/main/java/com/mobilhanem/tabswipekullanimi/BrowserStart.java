package com.mobilhanem.tabswipekullanimi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mobilhanem.actionbarkullanimi.R;

/**
 * Created by Ramaldis on 01.05.2016
 */
public class BrowserStart extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browser_start);

        Button btn=(Button) findViewById(R.id.btnInternet);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BrowserStart.this,BrowserActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
