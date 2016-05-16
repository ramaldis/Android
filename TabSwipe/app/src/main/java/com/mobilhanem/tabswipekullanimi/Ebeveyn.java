package com.mobilhanem.tabswipekullanimi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mobilhanem.actionbarkullanimi.R;

/**
 * Created by Ramaldis on 27.04.2016
 */
public class Ebeveyn extends Activity {
    public static final String USER_NAME = "USER_NAME";
    String gelenad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ebeveyn);

        Button devam=(Button) findViewById(R.id.btnDevam);
        Button geri=(Button) findViewById(R.id.btnGeri);
        Button cıkıs=(Button) findViewById(R.id.btnCıkıs);

        TextView txt=(TextView) findViewById(R.id.textView51);


        //Intent'de sonuç döndürme setResult(Activity.RESULT_OK,"Intent Adı")komutu ile olur.
        //setResult() kullandıktan sonra sonucu döndürüp Activity'e dönmesi için finish() metdodu da yazılmalıdır.
        Intent intent = getIntent();

        gelenad = intent.getStringExtra(CocukDevam.USER_NAME);
        txt.setText(gelenad);

        devam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Ebeveyn.this,EbeveynHomePage.class);
                //intent.putExtra(USER_NAME,gelenad);
                startActivity(intent);
                finish();
            }
        });

        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Ebeveyn.this,OpenScreen.class);
                startActivity(intent);
                finish();
            }
        });

        cıkıs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // ÇIKIŞ İÇİN 1.YÖNTEM
               // Intent intent = new Intent(Intent.ACTION_MAIN);
               // intent.addCategory(Intent.CATEGORY_HOME);
               // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               // startActivity(intent);

                // ÇIKIŞ İÇİN 2.YÖNTEM
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
    }
}
