package com.mobilhanem.tabswipekullanimi;
/**
 * Created by Ramaldis on 23.04.2016
 */

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewConfiguration;

import com.mobilhanem.actionbarkullanimi.R;

import java.lang.reflect.Field;

public class EbeveynHomePage extends FragmentActivity implements ActionBar.TabListener{
	// action bar
		private ActionBar actionBar;
		private Menu optionsMenu;
		private ViewPager viewPager;
	    private EbeveynTabsPager adapter;


	// Tab başlıkları
	    private String[] tabs = { "Uyarılar", "Etkinlik", "Kurallar" };
	// Button website,konum,geri,a1,a2,a3,k1;
		protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.anasayfa);

		//ACTİON BAR İŞLEMLERİ
		actionBar = getActionBar();

		// Action Bar Başlığı saklar
		actionBar.setDisplayShowTitleEnabled(false);
		//actionBar.setDisplayHomeAsUpEnabled(true); ile YUKARI TUŞU AKTİF HALE GETİRİLİR.

		getOverflowMenu(); // bu Metodun neden kullanıldığını metod içinde anlattım.


		// Action Bar İkonu değiştirir
		// actionBar.setIcon(R.drawable.xxx);

		//Action Bar Kapatır Yani Gizli Yapar
		//actionBar.hide();

		//Action Bar Background değiştirir
		//actionBar.setBackgroundDrawable(Drawable d);

		//MenuItem item = optionsMenu.findItem(R.id.action_location_found);  //Menüdeki itemlerden birini şeçtik
	    //item.setVisible(false);  //itemi gizlemek için
		//item.setVisible(true);   //gizli itemi açmak için


       /*

        geri=(Button) findViewById(R.id.btnEbeveynGeri);
        a1=(Button) findViewById(R.id.btna1);
        a2=(Button) findViewById(R.id.btna2);
        a3=(Button) findViewById(R.id.btna3);
        k1=(Button) findViewById(R.id.btnk1);





        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EbeveynHomePage.this,EbeveynHomePage.class);
                startActivity(intent);
                finish();
            }
        });

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        k1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
*/

		//TAB ve SWIPE İŞLEMLERİ

        viewPager = (ViewPager) findViewById(R.id.pager); //xml de tanımladığımız pager alıyoruz
        adapter = new EbeveynTabsPager(getSupportFragmentManager());//TabsPager objesi oluşturuyoruz


        viewPager.setAdapter(adapter); //pager ımızı oluşturduğumuz objeye bağlıyoruz.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);//ActionBarı TAB'lı kullanmak için


        for(int i = 0 ;i<tabs.length;i++){ //Tabları ekliyorum
        	actionBar.addTab(actionBar.newTab().setText(tabs[i]).setTabListener(this)); //Action Barlara tabları ekledik
        }


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { //tablar arasındaki geçişleri dinleyen listener

            @Override
            public void onPageSelected(int position) {
                // sayfa değiştiğnde çalışır
                actionBar.setSelectedNavigationItem(position);

                //actionBar.setSelectedNavigationItem(2);//son tab ı seçili hale getirir.
                //1. tab 0 index i ile seçilir
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

    }



	////TabListener İmplements Methodlar
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {  //Tab seçildiği zaman çalısır
		// TODO Auto-generated method stub
		//Toast.makeText(getApplicationContext(), "" + tab.getPosition() + ".Tab seçildi", Toast.LENGTH_LONG).show();
        viewPager.setCurrentItem(tab.getPosition());
		//tab.getPosition()  //Hangi tabın seçildiğini anlamak için mesala 1. tab seçildiyse 0 değeri döner 2. tabda 1 ,3.tabda 2 değeri döner
		//tab.setText("deneme"); //seçilen tabın string değerini-adını değiştirmeye yarar
		//tab.setIcon(R.drawable.xx)  tab da icon kullanmak için

	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {  //Tab seçimi kaldırıldığı zaman
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {//Seçili tab tekrar seçildiğinde
		// TODO Auto-generated method stub


	}




	@Override
	public boolean onCreateOptionsMenu(Menu menu) {//Menüyü oluşturuyoruz
	     this.optionsMenu = menu;

		MenuInflater inflater = getMenuInflater();// inflater herhangi bir view ın java objesine dönüştürülüp düzenlenmesinde yardımcı olur.Burda menü düzenlenmesi için kullanacağız
		inflater.inflate(R.menu.anasayfa_actions, menu);//Xml olarak oluşturduğumuz menü yü alıyoruz

	    return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {// Action Bar itemden herhangi biri tıklandığında

		switch (item.getItemId()) {

		case R.id.action_settings: //settings iconu tıklandığında

			settings();

			break;


		case R.id.action_share: //share iconu

			share();

			break;

		case R.id.action_location_found: //Emülatörde hata veriyor.Gerçek Cihazlarda çalışır.

			location();

			break;
		case R.id.action_refresh://refresh iconu

			refresh();

			return true;
		case R.id.action_help://help iconu

			help();

			break;

		default:
			return super.onOptionsItemSelected(item);
		}
		return true;
	}



	public void share(){
		Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
	    sharingIntent.setType("text/plain");
	    String shareMesaj = "mobilhanem.com tarafından gönderildi";
	    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Mesaj Konu");
	    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareMesaj);
	    startActivity(Intent.createChooser(sharingIntent, "Paylaşmak İçin Seçiniz"));

	}

	public void settings(){
		Intent myIntent = new Intent(getApplicationContext(), Ayarlar.class);
		startActivity(myIntent);

	}

	public void location(){
	//IMPLICIT INTENT KULLANILIR.URI İLE VERİ OLUŞTURULUR. Örnek=Fotoğraf çekme,harita gösterme.
	//Implicit Intent, göster(View),gönder(Send) ve getir(Get) gibi eylemleri yapar.Farklı class'a geçmez.

		//Google map açıcak q=Karadeniz Teknik Üniversitesi
		// ile konumumuzdan Trabzon'a nasıl gideceğimizi göstericek
		// z parametresi yakınlaştırmayı verir.
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:40.992992, 39.777108 ? z=15"));
		startActivity(intent);
		
	}
	
	public void help(){
		AlertDialog alertDialog = new AlertDialog.Builder(EbeveynHomePage.this).create();
        alertDialog.setTitle("Mesaj");
        alertDialog.setMessage("Yardıma mı ihtiyaç var?");
        alertDialog.setCancelable(false);
        alertDialog.setButton(RESULT_OK,"Tamam", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();
	}
	
	public void refresh(){

		setRefreshActionButtonState(true);//progress bar refresh iconla değişecek ve çalışacak .

		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				setRefreshActionButtonState(false);//3 sn sonra duracak ve refresh iconu geri gelecek. Siz bu arada başka işlemler sunucu bağlantısı vs.. yapabilirsiniz

			}
		}, 3000);

	}
	
	public void setRefreshActionButtonState(final boolean refreshing) {
		
		//bu method refresh iteme tıklandığında progress bar gözükmesi için
	    if (optionsMenu != null) {
	        final MenuItem refreshItem = optionsMenu
	            .findItem(R.id.action_refresh);
	        if (refreshItem != null) {
	            if (refreshing) {
	                refreshItem.setActionView(R.layout.actionbar_refresh_progress);
	            } else {
	                refreshItem.setActionView(null);
	            }
	        }
	    }
	}
	
	private void getOverflowMenu() { 
		
		//Arkadaşlar bu method overflow menu için
		//Bazı cihazlarda action bar a sığmayan actionlar açılır menu de deilde cihazın menu buttonuna basınca klasik android options menu gibi açılıyor
		//Bu methodu onCreate içinde çağırarak actionBar a sığmayan action ları overFlow menude gösteriyoruz.
	    try {
	       ViewConfiguration config = ViewConfiguration.get(this);
	       Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
	       if(menuKeyField != null) {
	           menuKeyField.setAccessible(true);
	           menuKeyField.setBoolean(config, false);
	       }
	   } catch (Exception e) {
	       e.printStackTrace();
	   }
	 }
	
	
}
