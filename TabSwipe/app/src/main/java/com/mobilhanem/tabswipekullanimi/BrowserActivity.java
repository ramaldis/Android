package com.mobilhanem.tabswipekullanimi;

/**
 * Created by Ramaldis on 10.04.2016
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobilhanem.actionbarkullanimi.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;


public class BrowserActivity extends Activity {
    Button buttonGeri, buttonIleri, buttonAnasayfa, buttonGO,history;
    WebView webViewFK;
    EditText editTextURL;  //EditText'de ems özelliği textSize özelliğini belirtmedir.
    private EditText respText;

    String engel;
    String siteUrl ;
    final String[] code1 = { "google"};

    private static final String REGISTER_URL = "http://serhanyilmaz.890m.com/dbBrowserHistory.php";
    private static final String REGISTER_URL1 = "http://serhanyilmaz.890m.com/blockpage.php";

    String a=null,a1=null,a2=null,a3=null,a4=null,a5=null,a6=null;
    String a7=null,a8=null,a9=null,a10=null,a11=null,a12=null,a13=null;
    String a14=null,a15=null,a16=null,a17=null,a18=null,a19=null,a20=null;
    String a21=null,a22=null,a23=null,a24=null,a25=null,a26=null,a27=null;
    String a28=null,a29=null;

    boolean filtre,filtre1,filtre2,filtre3,filtre4,filtre5,filtre6;
    boolean filtre7,filtre8,filtre9,filtre10,filtre11,filtre12,filtre13;
    boolean filtre14,filtre15,filtre16,filtre17,filtre18,filtre19,filtre20;
    boolean filtre21,filtre22,filtre23,filtre24,filtre25,filtre26,filtre27;
    boolean  filtre28,filtre29;


    String alkol,alısveris,askeri,cinsel,din,hukumet,kumar,kurtaj,muzik,otomotiv,oyun,pornografi,reklam,sanat,saglık,seyahat,spor;
    String silah,siyaset,suc,tarikat,kavga,teknoloji,ticaret,tutun,uyusturucu,yasa,intihar,siddet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browser_main);

        Intent intent1 = getIntent();
        final String txtalkol = intent1.getStringExtra("alkol");
        final String txtalısveris = intent1.getStringExtra("alısveris");
        final String txtaskeri = intent1.getStringExtra("askeri");
        final String txtcinsel = intent1.getStringExtra("cinsel");
        final String txtdin = intent1.getStringExtra("din");
        final String txthukumet = intent1.getStringExtra("hukumet");
        final String txtkumar = intent1.getStringExtra("kumar");
        final String txtkurtaj = intent1.getStringExtra("kurtaj");
        final String txtmuzik = intent1.getStringExtra("muzik");
        final String txtotomotiv = intent1.getStringExtra("otomotiv");
        final String txtoyun = intent1.getStringExtra("oyun");
        final String txtpornografi = intent1.getStringExtra("pornografi");
        final String txtreklam = intent1.getStringExtra("reklam");
        final String txtsanat = intent1.getStringExtra("sanat");
        final String txtsaglık = intent1.getStringExtra("saglık");
        final String txtseyahat = intent1.getStringExtra("seyahat");
        final String txtsilah = intent1.getStringExtra("silah");
        final String txtsiyaset = intent1.getStringExtra("siyaset");
        final String txtspor = intent1.getStringExtra("spor");
        final String txtsuc = intent1.getStringExtra("suc");
        final String txttarikat = intent1.getStringExtra("tarikat");
        final String txtkavga = intent1.getStringExtra("kavga");
        final String txtteknoloji = intent1.getStringExtra("teknoloji");
        final String txtticaret = intent1.getStringExtra("ticaret");
        final String txttutun = intent1.getStringExtra("tutun");
        final String txtuyusturucu = intent1.getStringExtra("uyusturucu");
        final String txtyasa = intent1.getStringExtra("yasa");
        final String txtintihar = intent1.getStringExtra("intihar");
        final String txtsiddet = intent1.getStringExtra("siddet");

          // txt.setText(txtalkol.toString());

        alkol=txtalkol;
        alısveris=txtalısveris;
        askeri=txtaskeri;
        cinsel=txtcinsel;
        din=txtdin;
        hukumet=txthukumet;
        kumar=txtkumar;
        kurtaj=txtkurtaj;
        muzik=txtmuzik;
        otomotiv=txtotomotiv;
        oyun=txtoyun;
        pornografi=txtpornografi;
        reklam=txtreklam;
        sanat=txtsanat;
        saglık=txtsaglık;
        seyahat=txtseyahat;
        silah=txtsilah;
        siyaset=txtsiyaset;
        spor=txtspor;
        suc=txtsuc;
        tarikat=txttarikat;
        kavga=txtkavga;
        teknoloji=txtteknoloji;
        ticaret=txtticaret;
        tutun=txttutun;
        uyusturucu=txtuyusturucu;
        yasa=txtyasa;
        intihar=txtintihar;
        siddet=txtsiddet;

        //Webview tıpkı normal bir tarayıcıymış gibi upload ve download işlemleri
        // yapsın diye set java script enable özelliğini true yaptım
        webViewFK = (WebView) findViewById(R.id.webFK);

        webViewFK.getSettings().setJavaScriptEnabled(true);
        webViewFK.setWebViewClient(new MyWebViewClient());
        webViewFK.loadUrl("http://tr.norton.com/");
        webViewFK.getSettings().setSupportZoom(true);
        webViewFK.getSettings().setBuiltInZoomControls(true);
        webViewFK.getSettings().setJavaScriptEnabled(true);

        editTextURL = (EditText) findViewById(R.id.editTextURL);
        respText = (EditText) findViewById(R.id.txtHtmlTag);

        buttonGeri = (Button) findViewById(R.id.buttonGeri);
        buttonIleri = (Button) findViewById(R.id.buttonIleri);
        buttonAnasayfa = (Button) findViewById(R.id.buttonAnasayfa);
        buttonGO = (Button) findViewById(R.id.buttonGO);
        history = (Button) findViewById(R.id.btnHistory);

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BrowserActivity.this,History.class);
                startActivity(intent);
                finish();
            }
        });




        engel="<html>"+
                ""+
                "<head>"+
                "<title></title>"+
                "</head>"+
                "<style type=\"text/css\">"+
                "	.site{"+
                "		background-color: #000000;"+
                "	}"+
                "	.siteMainContainer{"+
                "		background-color: #885489;"+
                "		border : 5px solid #000;"+
                "		border-radius: 15px;"+
                "		align:center;"+
                "		width :1100px;"+
                "		height :700px;"+
                "		margin-top:10px;"+
                "		margin-bottom:10px;"+
                "	}"+
                "	.topic{"+
                "		color:#0978bf;"+
                "		float:left;"+
                "		margin-top: 30px;"+
                "		margin-left:30px;"+
                "	}"+
                "	.mainMenu{"+
                "		background-color: #884840;"+
                "		width: 1080px;"+
                "		height: 100px;"+
                "		border:10px solid #000;"+
                "		border-radius: 15px 15px 0px 0px;"+
                "		"+
                "	}"+
                "	.MainMenuProvider{"+
                "		list-style: none;"+
                "		float:right;"+
                "	}"+
                "	.item{"+
                "		float:left;"+
                "		border:2px solid #000;"+
                "		border-radius: 0px 20px 0px 20px;"+
                "		margin-left: 5px;"+
                "		margin-right: 20px;"+
                "	}"+
                "	.itemelement{"+
                "		color:#000000;"+
                "		display: block;"+
                "		text-decoration: none;"+
                "		border:2px solid #000;"+
                "		border-radius: 0px 20px 0px 20px;"+
                "		line-height: 2.5em;"+
                "		font: bold  \"Lucida Grande\", \"Trebuchet MS\", Verdana, Helvetica, sans-serif;"+
                "		font-size: 20px;"+
                "	}"+
                "	.parg{" +
                "		color:#000000;"+
                "		background-color:#FFFFFF;"+
                "		font-size: 18px;"+
                "	}"+
                "	.textstyle{"+
                "		border: 2px solid #E51E1E;"+
                "		border-radius: 0px 12px 0px 12px;"+
                "	}"+
                "	.columns{"+
                "		font-size:25px;"+
                "		font : bold;"+
                "	}"+
                "</style>"+
                ""+
                ""+
                "<body class=\"site\">"+
                ""+
                "<center>"+
                "	<div align=\"center\" class=\"siteMainContainer\">"+
                "		<div align=\"center\" class=\"mainMenu\">"+
                "			<h2 class=\"topic\">WELLCOME FAMILY SAFE !!!</h2>"+
                "		</div>"+
                "		<p class=\"parag\">BU SAYFAYA GIRIS UYGULAMA TARAFINDAN ENGELLENMISTIR...</p>"+
                "		<p class=\"parag\">FAMILY  SAFE...</p>"+
                "	</div>"+
                "</center>"+
                ""+
                "</body>"+
                ""+
                "</html>"+
                "";




        buttonGO.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


               registerUser();

                   Toast.makeText(
                            getApplicationContext(),
                            editTextURL.getText().toString().trim().toLowerCase()
                                    + " adresi yükleniyor...",
                            Toast.LENGTH_SHORT).show();

                    if (InternetKontrol()){
                        String adres =editTextURL.getText().toString();



                        //code1 için Kontrol
                        for(int i=0 ; i<code1.length;i++) // Burası Google sayfasıın açılmamasını sağlıyor
                        {
                            if (adres.toLowerCase().contains(code1[i].trim().toLowerCase())  ) {
                                a="yasaklı kelimeler var";
                                System.out.println("a:"+a);
                                break; // i sonlanınca break oluyor.
                            }
                            else{
                                a="yasaklı kelimeler yok";
                                System.out.println("a:"+a);

                            }

                        }

                        if(a.contains("yasaklı kelimeler var"))
                        {
                            filtre=true;

                        }

                        else{
                            filtre=false;

                        }
                        //Alkol için Kontrol
                            if (adres.toLowerCase().contains(txtalkol.trim().toLowerCase()  )  )
                            {
                                // Eğer adres içeriğinde alkol kelimesi içerirse yasaklı değer yapar sayfa açılmaz
                                a1="yasaklı kelimeler var";
                                System.out.println("a:"+a1);

                            }
                            else{
                                a1="yasaklı kelimeler yok";
                                System.out.println("a:"+a1);

                            }

                        if(a1.contains("yasaklı kelimeler var"))
                        {
                            filtre1=true;
                          // Alkol içeriğinin yasaklı(seçildiği) olduğu anlaşılır
                        }

                        else{
                            filtre1=false;

                        }



                        //Alışveriş için Kontrol
                        if (adres.toLowerCase().contains(txtalısveris.trim().toLowerCase())

                                ) {
                            a2="yasaklı kelimeler var";
                            System.out.println("a:"+a2);

                        }
                        else{
                            a2="yasaklı kelimeler yok";
                            System.out.println("a:"+a2);

                        }
                        if(a2.contains("yasaklı kelimeler var"))
                        {
                            filtre2=true;

                        }

                        else{
                            filtre2=false;

                        }

                        //Askeri için Kontrol
                        if (adres.toLowerCase().contains(txtaskeri.trim().toLowerCase())

                                ) {
                            a3="yasaklı kelimeler var";
                            System.out.println("a:"+a3);

                        }
                        else{
                            a3="yasaklı kelimeler yok";
                            System.out.println("a:"+a3);

                        }
                        if(a3.contains("yasaklı kelimeler var"))
                        {
                            filtre3=true;

                        }

                        else{
                            filtre3=false;

                        }


                        //Cinsel için Kontrol
                        if (adres.toLowerCase().contains(txtcinsel.trim().toLowerCase())

                                ) {
                            a4="yasaklı kelimeler var";
                            System.out.println("a:"+a4);

                        }
                        else{
                            a4="yasaklı kelimeler yok";
                            System.out.println("a:"+a4);

                        }
                       if(a4.contains("yasaklı kelimeler var"))
                        {
                            filtre4=true;

                        }

                        else{
                            filtre4=false;

                        }

                        //Din için Kontrol
                        if (adres.toLowerCase().contains(txtdin.trim().toLowerCase())

                                ) {
                            a5="yasaklı kelimeler var";
                            System.out.println("a:"+a5);

                        }
                        else{
                            a5="yasaklı kelimeler yok";
                            System.out.println("a:"+a5);

                        }
                        if(a5.contains("yasaklı kelimeler var"))
                        {
                            filtre5=true;

                        }

                        else{
                            filtre5=false;

                        }

                        //Hükümet için Kontrol
                        if (adres.toLowerCase().contains(txthukumet.trim().toLowerCase())

                                ) {
                            a6="yasaklı kelimeler var";
                            System.out.println("a:"+a6);

                        }
                        else{
                            a6="yasaklı kelimeler yok";
                            System.out.println("a:"+a6);

                        }

                        if(a6.contains("yasaklı kelimeler var"))
                        {
                            filtre6=true;

                        }

                        else{
                            filtre6=false;

                        }

                        //Kumar için Kontrol
                        if (adres.toLowerCase().contains(txtkumar.trim().toLowerCase())

                                ) {
                            a7="yasaklı kelimeler var";
                            System.out.println("a:"+a7);

                        }
                        else{
                            a7="yasaklı kelimeler yok";
                            System.out.println("a:"+a7);

                        }

                        if(a7.contains("yasaklı kelimeler var"))
                        {
                            filtre7=true;

                        }

                        else{
                            filtre7=false;

                        }
                        //Kürtaj için Kontrol
                        if (adres.toLowerCase().contains(txtkurtaj.trim().toLowerCase())

                                ) {
                            a8="yasaklı kelimeler var";
                            System.out.println("a:"+a8);

                        }
                        else{
                            a8="yasaklı kelimeler yok";
                            System.out.println("a:"+a8);

                        }

                        if(a8.contains("yasaklı kelimeler var"))
                        {
                            filtre8=true;

                        }

                        else{
                            filtre8=false;

                        }

                        //Müzik için Kontrol
                        if (adres.toLowerCase().contains(txtmuzik.trim().toLowerCase())

                                ) {
                            a9="yasaklı kelimeler var";
                            System.out.println("a:"+a9);

                        }
                        else{
                            a9="yasaklı kelimeler yok";
                            System.out.println("a:"+a9);

                        }


                        if(a9.contains("yasaklı kelimeler var"))
                        {
                            filtre9=true;

                        }

                        else{
                            filtre9=false;

                        }

                        //Otomotiv için Kontrol
                        if (adres.toLowerCase().contains(txtotomotiv.trim().toLowerCase())

                                ) {
                            a10="yasaklı kelimeler var";
                            System.out.println("a:"+a10);

                        }
                        else{
                            a10="yasaklı kelimeler yok";
                            System.out.println("a:"+a10);

                        }

                        if(a10.contains("yasaklı kelimeler var"))
                        {
                            filtre10=true;

                        }

                        else{
                            filtre10=false;

                        }

                        //Oyun için Kontrol
                        if (adres.toLowerCase().contains(txtoyun.trim().toLowerCase())

                                ) {
                            a11="yasaklı kelimeler var";
                            System.out.println("a:"+a11);

                        }
                        else{
                            a11="yasaklı kelimeler yok";
                            System.out.println("a:"+a11);

                        }

                        if(a11.contains("yasaklı kelimeler var"))
                        {
                            filtre11=true;

                        }

                        else{
                            filtre11=false;

                        }

                        //Pornografi için Kontrol
                        if (adres.toLowerCase().contains(txtpornografi.trim().toLowerCase())

                                ) {
                            a12="yasaklı kelimeler var";
                            System.out.println("a:"+a12);

                        }
                        else{
                            a12="yasaklı kelimeler yok";
                            System.out.println("a:"+a12);

                        }

                        if(a12.contains("yasaklı kelimeler var"))
                        {
                            filtre12=true;

                        }

                        else{
                            filtre12=false;

                        }

                        //Reklam için Kontrol
                        if (adres.toLowerCase().contains(txtreklam.trim().toLowerCase())

                                ) {
                            a13="yasaklı kelimeler var";
                            System.out.println("a:"+a13);

                        }
                        else{
                            a13="yasaklı kelimeler yok";
                            System.out.println("a:"+a13);

                        }

                        if(a13.contains("yasaklı kelimeler var"))
                        {
                            filtre13=true;

                        }

                        else{
                            filtre13=false;

                        }
                        //Sanat için Kontrol
                        if (adres.toLowerCase().contains(txtsanat.trim().toLowerCase())

                                ) {
                            a14="yasaklı kelimeler var";
                            System.out.println("a:"+a14);

                        }
                        else{
                            a14="yasaklı kelimeler yok";
                            System.out.println("a:"+a14);

                        }

                        if(a14.contains("yasaklı kelimeler var"))
                        {
                            filtre14=true;

                        }

                        else{
                            filtre14=false;

                        }

                        //Sağlık için Kontrol
                        if (adres.toLowerCase().contains(txtsaglık.trim().toLowerCase())

                                ) {
                            a15="yasaklı kelimeler var";
                            System.out.println("a:"+a15);

                        }
                        else{
                            a15="yasaklı kelimeler yok";
                            System.out.println("a:"+a15);

                        }

                        if(a15.contains("yasaklı kelimeler var"))
                        {
                            filtre15=true;

                        }

                        else{
                            filtre15=false;

                        }
                        //Seyahat için Kontrol
                        if (adres.toLowerCase().contains(txtseyahat.trim().toLowerCase())

                                ) {
                            a16="yasaklı kelimeler var";
                            System.out.println("a:"+a16);

                        }
                        else{
                            a16="yasaklı kelimeler yok";
                            System.out.println("a:"+a16);

                        }

                        if(a16.contains("yasaklı kelimeler var"))
                        {
                            filtre16=true;

                        }

                        else{
                            filtre16=false;

                        }

                        //Silah için Kontrol
                        if (adres.toLowerCase().contains(txtsilah.trim().toLowerCase())

                                ) {
                            a17="yasaklı kelimeler var";
                            System.out.println("a:"+a17);

                        }
                        else{
                            a17="yasaklı kelimeler yok";
                            System.out.println("a:"+a17);

                        }

                        if(a17.contains("yasaklı kelimeler var"))
                        {
                            filtre17=true;

                        }

                        else{
                            filtre17=false;

                        }

                        //Siyaset için Kontrol
                        if (adres.toLowerCase().contains(txtsiyaset.trim().toLowerCase())

                                ) {
                            a18="yasaklı kelimeler var";
                            System.out.println("a:"+a18);

                        }
                        else{
                            a18="yasaklı kelimeler yok";
                            System.out.println("a:"+a18);

                        }

                        if(a18.contains("yasaklı kelimeler var"))
                        {
                            filtre18=true;

                        }

                        else{
                            filtre18=false;

                        }


                        //Spor için Kontrol
                        if (adres.toLowerCase().contains(txtspor.trim().toLowerCase())

                                ) {
                            a19="yasaklı kelimeler var";
                            System.out.println("a:"+a19);

                        }
                        else{
                            a19="yasaklı kelimeler yok";
                            System.out.println("a:"+a19);

                        }

                        if(a19.contains("yasaklı kelimeler var"))
                        {
                            filtre19=true;

                        }

                        else{
                            filtre19=false;

                        }
                        //Suç için Kontrol
                        if (adres.toLowerCase().contains(txtsuc.trim().toLowerCase())

                                ) {
                            a20="yasaklı kelimeler var";
                            System.out.println("a:"+a20);

                        }
                        else{
                            a20="yasaklı kelimeler yok";
                            System.out.println("a:"+a20);

                        }

                        if(a20.contains("yasaklı kelimeler var"))
                        {
                            filtre20=true;

                        }

                        else{
                            filtre20=false;

                        }
                        //Tarikat için Kontrol
                        if (adres.toLowerCase().contains(txttarikat.trim().toLowerCase())

                                ) {
                            a21="yasaklı kelimeler var";
                            System.out.println("a:"+a21);

                        }
                        else{
                            a21="yasaklı kelimeler yok";
                            System.out.println("a:"+a21);

                        }

                        if(a21.contains("yasaklı kelimeler var"))
                        {
                            filtre21=true;

                        }

                        else{
                            filtre21=false;

                        }
                        //Kavga için Kontrol
                        if (adres.toLowerCase().contains(txtkavga.trim().toLowerCase())

                                ) {
                            a22="yasaklı kelimeler var";
                            System.out.println("a:"+a22);

                        }
                        else{
                            a22="yasaklı kelimeler yok";
                            System.out.println("a:"+a22);

                        }
                        if(a22.contains("yasaklı kelimeler var"))
                        {
                            filtre22=true;

                        }

                        else{
                            filtre22=false;

                        }

                        //Teknoloji için Kontrol
                        if (adres.toLowerCase().contains(txtteknoloji.trim().toLowerCase())

                                ) {
                            a23="yasaklı kelimeler var";
                            System.out.println("a:"+a23);

                        }
                        else{
                            a23="yasaklı kelimeler yok";
                            System.out.println("a:"+a23);

                        }
                        if(a23.contains("yasaklı kelimeler var"))
                        {
                            filtre23=true;

                        }

                        else{
                            filtre23=false;

                        }

                        //Ticaret için Kontrol
                        if (adres.toLowerCase().contains(txtticaret.trim().toLowerCase())

                                ) {
                            a24="yasaklı kelimeler var";
                            System.out.println("a:"+a24);

                        }
                        else{
                            a24="yasaklı kelimeler yok";
                            System.out.println("a:"+a24);

                        }

                        if(a24.contains("yasaklı kelimeler var"))
                        {
                            filtre24=true;

                        }

                        else{
                            filtre24=false;

                        }
                        //Tütün için Kontrol
                        if (adres.toLowerCase().contains(txttutun.trim().toLowerCase())

                                ) {
                            a25="yasaklı kelimeler var";
                            System.out.println("a:"+a25);

                        }
                        else{
                            a25="yasaklı kelimeler yok";
                            System.out.println("a:"+a25);

                        }

                        if(a25.contains("yasaklı kelimeler var"))
                        {
                            filtre25=true;

                        }

                        else{
                            filtre25=false;

                        }
                        //Uyuşturucu için Kontrol
                        if (adres.toLowerCase().contains(txtuyusturucu.trim().toLowerCase())

                                ) {
                            a26="yasaklı kelimeler var";
                            System.out.println("a:"+a26);

                        }
                        else{
                            a26="yasaklı kelimeler yok";
                            System.out.println("a:"+a26);

                        }

                        if(a26.contains("yasaklı kelimeler var"))
                        {
                            filtre26=true;

                        }

                        else{
                            filtre26=false;

                        }

                        //Yasa için Kontrol
                        if (adres.toLowerCase().contains(txtyasa.trim().toLowerCase())

                                ) {
                            a27="yasaklı kelimeler var";
                            System.out.println("a:"+a27);

                        }
                        else{
                            a27="yasaklı kelimeler yok";
                            System.out.println("a:"+a27);

                        }

                        if(a27.contains("yasaklı kelimeler var"))
                        {
                            filtre27=true;

                        }

                        else{
                            filtre27=false;

                        }
                        //İntihar için Kontrol
                        if (adres.toLowerCase().contains(txtintihar.trim().toLowerCase())

                                ) {
                            a28="yasaklı kelimeler var";
                            System.out.println("a:"+a28);

                        }
                        else{
                            a28="yasaklı kelimeler yok";
                            System.out.println("a:"+a28);

                        }

                        if(a28.contains("yasaklı kelimeler var"))
                        {
                            filtre28=true;

                        }

                        else{
                            filtre28=false;

                        }
                        //Şiddet için Kontrol
                        if (adres.toLowerCase().contains(txtsiddet.trim().toLowerCase())

                                ) {
                            a29="yasaklı kelimeler var";
                            System.out.println("a:"+a29);

                        }
                        else{
                            a29="yasaklı kelimeler yok";
                            System.out.println("a:"+a29);

                        }

                        if(a29.contains("yasaklı kelimeler var"))
                        {
                            filtre29=true;

                        }

                        else{
                            filtre29=false;

                        }


                        ////////////////////////////// FILTRE DOĞRULAMA
                        if(filtre==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");
                            // engel dosyasının Html formatında olduğunu belirttik.
                            registerBlock();


                        }

                      else  if(filtre1==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");
                            registerBlock();

                        }

                        else  if(filtre2==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");

                            registerBlock();
                        }

                      else  if(filtre3==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");
                            registerBlock();

                        }

                       else if(filtre4==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");
                            registerBlock();

                        }

                      else  if(filtre5==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");

                            registerBlock();
                        }

                      else  if(filtre6==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");
                            registerBlock();

                        }

///////////////////////////////////7-13
                     else   if(filtre7==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");

                            registerBlock();
                        }

                      else  if(filtre8==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");

                            registerBlock();
                        }

                       else if(filtre9==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");

                            registerBlock();
                        }

                      else  if(filtre10==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");

                            registerBlock();
                        }

                      else  if(filtre11==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");

                            registerBlock();
                        }

                       else  if(filtre12==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");
                            registerBlock();

                        }

                      else  if(filtre13==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");
                            registerBlock();

                        }

                        ///////////////////////////////////14-20
                      else  if(filtre14==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");
                            registerBlock();

                        }

                       else if(filtre15==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");

                            registerBlock();
                        }

                      else  if(filtre16==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");

                            registerBlock();
                        }

                      else  if(filtre17==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");

                            registerBlock();
                        }

                       else if(filtre18==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");
                            registerBlock();

                        }

                       else if(filtre19==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");
                            registerBlock();

                        }

                      else  if(filtre20==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");

                            registerBlock();
                        }

                        /////////////////////////////////////////21-27
                      else  if(filtre21==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");

                            registerBlock();
                        }

                       else if(filtre22==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");
                            registerBlock();

                        }

                       else if(filtre23==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");
                            registerBlock();
                        }

                      else  if(filtre24==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");
                            registerBlock();

                        }

                      else  if(filtre25==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");

                            registerBlock();
                        }

                      else  if(filtre26==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");
                            registerBlock();
                        }

                      else  if(filtre27==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");

                            registerBlock();
                        }

                     else   if(filtre28==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");
                            registerBlock();
                        }

                      else  if(filtre29==true )
                        {
                            webViewFK.loadData(engel, "text/html", "UTF-8");
                            registerBlock();

                        }

                       else if(adres.toLowerCase().contains("."))
                        {

                           siteUrl= "http://"+editTextURL.getText().toString();
                            ( new ParseURL() ).execute(new String[]{siteUrl});

                        //Adresi otomatik olarak başına http:// yazısını koyma
                        }

                        else{
                            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                            intent.putExtra(SearchManager.QUERY, editTextURL.getText().toString().trim().toLowerCase());
                            startActivity(intent);
                            webViewFK.setDownloadListener(new DownloadListener() {
                                @Override
                                public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                                    Intent i = new Intent(Intent.ACTION_VIEW);
                                    i.setData(Uri.parse(url));
                                    startActivity(i);
                                }
                            });
                        }

                    }

                    else
                        BaglantiHatasiVer();

            }
        });

        buttonAnasayfa.setOnClickListener(new View.OnClickListener() {
            //ANASAYFA BUTONU
            @Override
            public void onClick(View arg0) {
                if (InternetKontrol()){
                    webViewFK.loadUrl("http://tr.norton.com/");
                    editTextURL.setText("http://tr .norton.com/");
                    registerUser(); // HASH EDİLEN SINIF (DOINBCKGROUND İLE)
                }
                else
                    BaglantiHatasiVer();
            }
        });


        buttonGeri.setOnClickListener(new View.OnClickListener() {
            //GERİ BUTONU
            @Override
            public void onClick(View arg0) {
                if (webViewFK.canGoBack()) {

                    //Geri gidebilirse geri gitsin
                    webViewFK.goBack();

                }
            }
        });

        buttonIleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //İLERİ BUTONU
                if (webViewFK.canGoForward()) {

                    //İleri gidebilirse ileri gitsin
                    webViewFK.goForward();

                }
            }
        });

    }

    private class ParseURL extends AsyncTask<String, Void, String> {
        // AsynTask sunucudan sayfaya ait verileri çekerek onun üzerinde işlem yapmamaızı sağlar

        @Override
        protected String doInBackground(String... strings) {
            StringBuffer buffer = new StringBuffer();
            try {
                Log.d("JSwa", "Connecting to [" + strings[0] + "]");
                Document doc  = Jsoup.connect(strings[0]).get();
                Log.d("JSwa", "Connected to ["+strings[0]+"]");
                // Get document (HTML page) title
                String title = doc.title();
                Log.d("JSwA", "Title ["+title+"]");
                buffer.append("Title: " + title + "\r\n");

                // Get meta info
                // TARAYICIYA YAZDIĞIMIZ HTTP FORMATINDAKİ WEB SİTESİNİ HTML TAGLERİNE AYIRIR İÇİNDE CHECBOX İLE ONAYLADIĞIMIZ
                // YASAKLI KELİME VARSA O SAYFAYI AÇMAZ
                Elements metaElems = doc.select("meta");
                buffer.append("META DATA\r\n");
                for (Element metaElem : metaElems) {
                    String name = metaElem.attr("name");
                    String content = metaElem.attr("content");
                    buffer.append("name ["+name+"] - content ["+content+"] \r\n");
                }

                Elements topicList = doc.select("h2.topic");
                buffer.append("Topic list\r\n");
                for (Element topic : topicList) {
                    String data = topic.text();

                    buffer.append("Data ["+data+"] \r\n");
                }

            }
            catch(Throwable t) {
                t.printStackTrace();
            }

            return buffer.toString();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String adres) {
            super.onPostExecute(adres);

            respText.setText(adres); //HTMLL TAGI (txtHtmlTag)


            if(respText.getText().toString().trim().toLowerCase().contains(alkol.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(alkol))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock(); // HASH EDİLEN SINIF (DOINBCKGROUND İLE)

            }


           else if(respText.getText().toString().trim().toLowerCase().contains(alısveris.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(alısveris))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();

            }

           else  if(respText.getText().toString().trim().toLowerCase().contains(askeri.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(askeri))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();

            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(cinsel.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(cinsel))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();

            }

           else if(respText.getText().toString().trim().toLowerCase().contains(din.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(din))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();

            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(hukumet.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(hukumet))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();

            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(kumar.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(kumar))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();

            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(kurtaj.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(kurtaj))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();

            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(muzik.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(muzik))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();

            }

           else if(respText.getText().toString().trim().toLowerCase().contains(otomotiv.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(otomotiv))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();

            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(oyun.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(oyun))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();

            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(pornografi.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(pornografi))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();

            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(reklam.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(reklam))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();
            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(sanat.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(sanat))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();
            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(saglık.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(saglık))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();
            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(seyahat.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(seyahat))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();
            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(silah.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(silah))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();
            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(siyaset.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(siyaset))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();
            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(spor.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(spor))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();
            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(suc.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(suc))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();
            }

         else   if(respText.getText().toString().trim().toLowerCase().contains(tarikat.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(tarikat))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();
            }

           else if(respText.getText().toString().trim().toLowerCase().contains(kavga.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(kavga))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();
            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(teknoloji.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(teknoloji))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();
            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(ticaret.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(ticaret))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();
            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(tutun.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(tutun))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();
            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(uyusturucu.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(uyusturucu))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();
            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(yasa.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(yasa))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();
            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(intihar.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(intihar))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();
            }

          else  if(respText.getText().toString().trim().toLowerCase().contains(siddet.trim().toLowerCase())|| respText.getText().toString().trim().toLowerCase().contains(siddet))
            {
                webViewFK.loadData(engel, "text/html", "UTF-8");
                registerBlock();
            }
            else{

                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "http://"+editTextURL.getText().toString().trim().toLowerCase());
                startActivity(intent);
                webViewFK.setDownloadListener(new DownloadListener() {
                    @Override
                    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                });
            }
        }
    }
    private void registerUser() {
        String url = editTextURL.getText().toString().trim().toLowerCase();


        register(url);
    }

    private void registerBlock(){

        String url = editTextURL.getText().toString().trim().toLowerCase();


        registerblock(url);

    }

    private void register(String url) {
        class RegisterUser extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            RegisterUserClass ruc = new RegisterUserClass();


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(BrowserActivity.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String,String>();
                data.put("url",params[0]);


                String result = ruc.sendPostRequest(REGISTER_URL,data);

                return  result;
            }
        }

        RegisterUser ru = new RegisterUser();
        ru.execute(url);
    }



    private void registerblock(String url) {
        class RegisterUser extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            RegisterUserClass ruc = new RegisterUserClass();


            @Override
            protected void onPreExecute() { //POSTTAN ÖNCE (BEFORE POST)
                super.onPreExecute();
                loading = ProgressDialog.show(BrowserActivity.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) { //POSTTAN SONRA (AFTER POST)
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) { //ARKAPLANDA YAPILACAKLAR.

                HashMap<String, String> data = new HashMap<String,String>();
                data.put("url",params[0]);


                String result = ruc.sendPostRequest(REGISTER_URL1,data);

                return  result;
            }
        }

        RegisterUser ru = new RegisterUser();
        ru.execute(url);
    }

    public void BaglantiHatasiVer() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                BrowserActivity.this);
        alertDialogBuilder.setTitle("Sunucu Hatası");
        alertDialogBuilder.setMessage(
                "internet bağlantınızı kontrol edip tekrar deneyin")
                .setCancelable(true);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }



    public boolean InternetKontrol() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager.getActiveNetworkInfo() != null
                && manager.getActiveNetworkInfo().isAvailable()
                && manager.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
