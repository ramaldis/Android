package com.mobilhanem.tabswipekullanimi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.mobilhanem.actionbarkullanimi.R;

/**
 * Created by Ramaldis on 24.04.2016
 */
public class Kategori extends Activity {

    //Kategori Sayısı 29 tanedir.
    CheckBox alkol,alısveris,askeri,cinsel,din,hukumet,kumar,kurtaj,muzik,ototomiv,oyun,pornografi,reklam;
    CheckBox sanat,saglık,seyahat,silah,siyaset,spor,suc,tarikat,kavga,teknoloji,ticaret,tutun,uyusturucu;
    CheckBox yasa,intihar,siddet;

    Button bitti;

    public static final String TEXT = "TEXT"; // Seçilen Checkboxların İntent.putextra ile diğer class içine aktarıyorsun.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.katogori);

        bitti=(Button) findViewById(R.id.btnBitti);

        //CheckBox ve diğer kontroller,ScrollView içerisine alınarak yukarı_aşağı doğru kaydırılması sağlandı.

        alkol=(CheckBox)findViewById(R.id.alkol);
        alısveris=(CheckBox)findViewById(R.id.alısveris);
        askeri=(CheckBox)findViewById(R.id.askeri);
        cinsel=(CheckBox)findViewById(R.id.cinsel);
        din=(CheckBox)findViewById(R.id.din);
        hukumet=(CheckBox)findViewById(R.id.hukumet);
        kumar=(CheckBox)findViewById(R.id.kumar);
        kurtaj=(CheckBox)findViewById(R.id.kurtaj);
        muzik=(CheckBox)findViewById(R.id.muzik);
        ototomiv=(CheckBox)findViewById(R.id.otomotiv);
        oyun=(CheckBox)findViewById(R.id.oyun);
        pornografi=(CheckBox)findViewById(R.id.pornografi);
        reklam=(CheckBox)findViewById(R.id.reklam);
        sanat=(CheckBox)findViewById(R.id.sanat);
        saglık=(CheckBox)findViewById(R.id.saglık);
        seyahat=(CheckBox)findViewById(R.id.seyahat);
        silah=(CheckBox)findViewById(R.id.silah);
        siyaset=(CheckBox)findViewById(R.id.siyaset);
        spor=(CheckBox)findViewById(R.id.spor);
        suc=(CheckBox)findViewById(R.id.suc);
        tarikat=(CheckBox)findViewById(R.id.tarikat);
        kavga=(CheckBox)findViewById(R.id.kavga);
        teknoloji=(CheckBox)findViewById(R.id.teknoloji);
        ticaret=(CheckBox)findViewById(R.id.ticaret);
        tutun=(CheckBox)findViewById(R.id.tütün);
        uyusturucu=(CheckBox)findViewById(R.id.uyusturucu);
        yasa=(CheckBox)findViewById(R.id.yasa);
        intihar=(CheckBox)findViewById(R.id.intihar);
        siddet=(CheckBox)findViewById(R.id.siddet);




        bitti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ENG- For Run Stopped Application I Protected this variable
                // TR - çalışmayı durdurdu hatasını önlemek için seçilmeyen checkboxlara random değerler atayarak null olmasını engelledim.
                String text = "";

                String txtalkol="aersg";
                String txtalısveris="aesth";
                String txtaskeri="aerh";
                String txtcinsel="aweh";
                String txtdin="aewth";
                String txthukumet="werh";
                String txtkumar="awq3r5";
                String txtkurtaj="35ra";
                String txtmuzik="53ryq3a";
                String txtotomotiv="q35a";
                String txtoyun="awrth";
                String txtpornografi="ertdher";
                String txtreklam="4wthw4a";
                String txtsanat="hw4thwa";
                String txtsaglık="4thw4a";
                String txtseyahat="w45w4a";
                String txtsilah="5ww45yw";
                String txtsiyaset="w45hyw4a";
                String txtspor="45thw4ta";
                String txtsuc="aw4thyw45";
                String txttarikat="w45wa";
                String txtkavga="aw45yh245";
                String txtteknoloji="45245a";
                String txtticaret="245yt2q45ya";
                String txttutun="a2q45yt245";
                String txtuyusturucu="a45yt245";
                String txtyasa="aw45tyw";
                String txtintihar="45ywa";
                String txtsiddet="a45y2w45y";

                Intent intent = new Intent(Kategori.this, BrowserActivity.class);

                if (alkol.isChecked()) {
                    txtalkol = alkol.getText().toString() ;
                    intent.putExtra("alkol", txtalkol);

                }
                else{

                    intent.putExtra("alkol", txtalkol);
                }
                if (alısveris.isChecked()) {
                    txtalısveris = text +" "+ alısveris.getText().toString()+ "\n";
                    intent.putExtra("alısveris", txtalısveris);

                }
                else{

                    intent.putExtra("alısveris", txtalısveris);
                }
                if (askeri.isChecked()) {
                    txtaskeri = text +" "+ askeri.getText().toString()+ "\n";
                    intent.putExtra("askeri", txtaskeri);

                }
                else{

                    intent.putExtra("askeri", txtaskeri);
                }
                if (cinsel.isChecked()) {
                    txtcinsel ="cinsel" +"\n";
                    intent.putExtra("cinsel", txtcinsel);

                }
                else{
                    intent.putExtra("cinsel", txtcinsel);

                }
                if (din.isChecked()) {
                    txtdin = text +" "+ din.getText().toString()+ "\n";
                    intent.putExtra("din", txtdin);
                }
                else{

                    intent.putExtra("din", txtdin);
                }
                if (hukumet.isChecked()) {
                    txthukumet = text +" "+ hukumet.getText().toString()+ "\n";
                    intent.putExtra("hukumet", txthukumet);
                }
                else{

                    intent.putExtra("hukumet", txthukumet);
                }
                /////////////2
                if (kumar.isChecked()) {
                    txtkumar = text +" "+ kumar.getText().toString() + "\n";
                    intent.putExtra("kumar", txtkumar);
                }
                else{
                    intent.putExtra("kumar", txtkumar);

                }
                if (kurtaj.isChecked()) {
                    txtkurtaj = text +" "+ kurtaj.getText().toString()+ "\n";
                    intent.putExtra("kurtaj", txtkurtaj);
                }
                else{

                    intent.putExtra("kurtaj", txtkurtaj);
                }
                if (muzik.isChecked()) {
                    txtmuzik = text +" "+ muzik.getText().toString()+ "\n";
                    intent.putExtra("muzik", txtmuzik);
                }
                else{
                    intent.putExtra("muzik", txtmuzik);

                }
                if (ototomiv.isChecked()) {
                    txtotomotiv = text +" "+ ototomiv.getText().toString()+ "\n";
                    intent.putExtra("otomotiv", txtotomotiv);
                }
                else{
                    intent.putExtra("otomotiv", txtotomotiv);

                }
                if (oyun.isChecked()) {
                    txtoyun = text +" "+ oyun.getText().toString()+ "\n";
                    intent.putExtra("oyun", txtoyun);
                }
                else{

                    intent.putExtra("oyun", txtoyun);
                }
                if (pornografi.isChecked()) {
                    txtpornografi = "porno"+ "\n";
                    intent.putExtra("pornografi", txtpornografi);
                }
                else{

                    intent.putExtra("pornografi", txtpornografi);
                }
                /////////3
                if (reklam.isChecked()) {
                    txtreklam = text +" "+ reklam.getText().toString() + "\n";
                    intent.putExtra("reklam", txtreklam);
                }
                else{

                    intent.putExtra("reklam", txtreklam);
                }
                if (sanat.isChecked()) {
                    txtsanat = text +" "+ sanat.getText().toString()+ "\n";
                    intent.putExtra("sanat", txtsanat);
                }
                else{
                    intent.putExtra("sanat", txtsanat);

                }
                if (saglık.isChecked()) {
                    txtsaglık = text +" "+ saglık.getText().toString()+ "\n";
                    intent.putExtra("saglık", txtsaglık);
                }
                else{

                    intent.putExtra("saglık", txtsaglık);
                }
                if (seyahat.isChecked()) {
                    txtseyahat = text +" "+ seyahat.getText().toString()+ "\n";
                    intent.putExtra("seyahat", txtseyahat);
                }
                else{

                    intent.putExtra("seyahat", txtseyahat);
                }
                if (silah.isChecked()) {
                    txtsilah = text +" "+ silah.getText().toString()+ "\n";
                    intent.putExtra("silah", txtsilah);
                }
                else{
                    intent.putExtra("silah", txtsilah);

                }
                if (siyaset.isChecked()) {
                    txtsiyaset = text +" "+ siyaset.getText().toString()+ "\n";
                    intent.putExtra("siyaset", txtsiyaset);
                }
                else{

                    intent.putExtra("siyaset", txtsiyaset);
                }
                //////////4
                if (spor.isChecked()) {
                    txtspor = text +" "+ spor.getText().toString() + "\n";
                    intent.putExtra("spor", txtspor);
                }
                else{
                    intent.putExtra("spor", txtspor);

                }
                if (suc.isChecked()) {
                    txtsuc = text +" "+ suc.getText().toString()+ "\n";
                    intent.putExtra("suc", txtsuc);
                }
                else{

                    intent.putExtra("suc", txtsuc);
                }
                if (tarikat.isChecked()) {
                    txttarikat = text +" "+ tarikat.getText().toString()+ "\n";
                    intent.putExtra("tarikat", txttarikat);
                }
                else{
                    intent.putExtra("tarikat", txttarikat);

                }
                if (kavga.isChecked()) {
                    txtkavga = text +" "+ kavga.getText().toString()+ "\n";
                    intent.putExtra("kavga", txtkavga);
                }
                else{

                    intent.putExtra("kavga", txtkavga);
                }
                if (teknoloji.isChecked()) {
                    txtteknoloji = text +" "+ teknoloji.getText().toString()+ "\n";
                    intent.putExtra("teknoloji", txtteknoloji);
                }
                else{
                    intent.putExtra("teknoloji", txtteknoloji);

                }
                if (ticaret.isChecked()) {
                    txtticaret = text +" "+ ticaret.getText().toString()+ "\n";
                    intent.putExtra("ticaret", txtticaret);
                }
                else{

                    intent.putExtra("ticaret", txtticaret);
                }
                //////////5
                if (tutun.isChecked()) {
                    txttutun = text +" "+ tutun.getText().toString() + "\n";
                    intent.putExtra("tutun", txttutun);
                }
                else{
                    intent.putExtra("tutun", txttutun);

                }
                if (uyusturucu.isChecked()) {
                    txtuyusturucu = text +" "+ uyusturucu.getText().toString()+ "\n";
                    intent.putExtra("uyusturucu", txtuyusturucu);
                }
                else{

                    intent.putExtra("uyusturucu", txtuyusturucu);
                }
                if (yasa.isChecked()) {
                    txtyasa = text +" "+ yasa.getText().toString()+ "\n";
                    intent.putExtra("yasa", txtyasa);
                }
                else{
                    intent.putExtra("yasa", txtyasa);

                }
                if (intihar.isChecked()) {
                    txtintihar = text +" "+ intihar.getText().toString()+ "\n";
                    intent.putExtra("intihar", txtintihar);
                }
                else{
                    intent.putExtra("intihar", txtintihar);

                }
                if (siddet.isChecked()) {
                    txtsiddet = text +" "+ siddet.getText().toString()+ "\n";
                    intent.putExtra("siddet", txtsiddet);
                }
                else{

                    intent.putExtra("siddet", txtsiddet);
                }



                startActivity(intent);


            }
        });
    }
}
