package com.mobilhanem.tabswipekullanimi;

/**
 * Created by Ramaldis on 07.03.2016
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mobilhanem.actionbarkullanimi.R;

public class Atla extends Activity{
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.son);
         Button basla=(Button) findViewById(R.id.btnBasla);

         basla.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(Atla.this, MainActivity.class);
                 startActivity(intent);
             }
         });
	        /*
	         * Bu sayfadan geri Action Bar ile dönmek istiyorsak
	         * Manifest dosyasında olusturduğumuz activity e 
	         *  android:parentActivityName=".Anasayfa" 
	         *  yukarıdaki satırı ekliyoruz
	         * Manifest dosyasından inceleyebilirsiniz
	         * 
	         */
	    }

}
