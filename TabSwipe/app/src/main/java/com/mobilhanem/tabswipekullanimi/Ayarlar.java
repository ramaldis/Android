package com.mobilhanem.tabswipekullanimi;

/**
 * Created by Ramaldis on 07.03.2016
 */
import com.mobilhanem.actionbarkullanimi.R;

import android.app.Activity;
import android.os.Bundle;

public class Ayarlar extends Activity{
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.ayarlar);
	         
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
