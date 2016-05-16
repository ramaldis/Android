package com.mobilhanem.tabswipekullanimi;
/**
 * Created by Ramaldis on 02.04.2016
 */

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.mobilhanem.actionbarkullanimi.R;

import java.util.HashMap;

public class Cocuklar extends Activity implements View.OnClickListener{

    private EditText editTextName;
    private TextView editTextUsername;
    private Button buttonRegister;

    //Spinner'ları ve Adapter'lerini tanımlıyoruz.
    private Spinner spinnerCinsiyet;
    private Spinner spinnerTarih;

    public static final String USER_NAME = "USER_NAME";
    public static final String CİNSİYET = "CİNSİYET";
    public static final String TARİH = "TARİH";


    private static final String REGISTER_URL = "http://serhanyilmaz.890m.com/cocukekle.php";

    //Spinner içerisine koyacağımız verileri tanımlıyoruz.
    private String[] cinsiyet={"Erkek","Kız"};
    private String[] tarih0={"2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","Diğer"};
    private String[] tarih1={"2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","Diğer"};

    //ListView ve Spinner'lerde her zaman ArrayAdapter kullanılır.
    private ArrayAdapter<String> dataAdapterForCinsiyetler;
    private ArrayAdapter<String> dataAdapterForTarihler;

    String familyad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cocuklar);

        editTextName = (EditText) findViewById(R.id.txtGelenCocukAd);
        editTextUsername = (TextView) findViewById(R.id.txtFamilyName);
        Intent intent = getIntent();

        familyad = intent.getStringExtra(ActivityLogin.USER_NAME);
        editTextUsername.setText(familyad);
        //xml kısmında hazırladığımğız spinnerları burda tanımladıklarımızla eşleştiriyoruz.
        spinnerCinsiyet = (Spinner) findViewById(R.id.spinner1);
        spinnerTarih = (Spinner) findViewById(R.id.spinner2);

        //Spinner'lar için adapterleri hazırlıyoruz.
        dataAdapterForCinsiyetler = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cinsiyet);
        dataAdapterForTarihler = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,tarih0);

        //Listelenecek verilerin görünümünü belirliyoruz.
        dataAdapterForCinsiyetler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForTarihler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Hazırladğımız Adapter'leri Spinner'lara ekliyoruz.
        spinnerCinsiyet.setAdapter(dataAdapterForCinsiyetler);
        spinnerTarih.setAdapter(dataAdapterForTarihler);

        // Listelerden bir eleman seçildiğinde yapılacakları tanımlıyoruz.
        spinnerCinsiyet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                if(parent.getSelectedItem().toString().equals(tarih0[0]))
                    dataAdapterForTarihler = new ArrayAdapter<String>(Cocuklar.this, android.R.layout.simple_spinner_item,tarih0);
                else if(parent.getSelectedItem().toString().equals(tarih1[1]))
                    dataAdapterForTarihler = new ArrayAdapter<String>(Cocuklar.this, android.R.layout.simple_spinner_item,tarih1);

                dataAdapterForTarihler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerTarih.setAdapter(dataAdapterForTarihler);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerTarih.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //Seçilen il ve ilçeyi ekranda gösteriyoruz.
               // Toast.makeText(getBaseContext(), ""+spinnerCinsiyet.getSelectedItem().toString()+"\n"+parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        buttonRegister = (Button) findViewById(R.id.btnAddChild);


        buttonRegister.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v == buttonRegister){
            String name=editTextName.getText().toString();
            String username=editTextUsername.getText().toString();
              if(username.length()==0)
            {
                editTextUsername.requestFocus();
                editTextUsername.setError("Kullanıcı Adı alanı boş bırakılamaz!");
            }
          else  if(name.length()==0)
            {
                editTextName.requestFocus();
                editTextName.setError("İsim alanı boş bırakılamaz!");
            }
            else if(name.matches("[0-9 ]+"))
            {
                editTextName.requestFocus();
                editTextName.setError("Yalnızda alfabetik karakterler girilebilir!");
            }

            else{
                registerUser();

            }

        }

    }

    private void registerUser() {
        String uname = editTextUsername.getText().toString().trim().toLowerCase();
        String name = editTextName.getText().toString().trim().toLowerCase();
        String sex = spinnerCinsiyet.getSelectedItem().toString();
        String date = spinnerTarih.getSelectedItem().toString();

        register(uname,name,sex,date);
    }

    private void register(String username, final String name, final String sex, final String date) {

        class RegisterUser extends AsyncTask<String, Void, String>
        //AsyncTask'in 1. parametresi doInBackground, 2.paramtresi onProgressUpdate,3.parametresi onPostExecute şeklindedir.
        {
            ProgressDialog loading;
            RegisterUserClass ruc = new RegisterUserClass();

            //AsyncTask fonksiyonları: onPreExecute() ,onPostExecute() ,doInBackground(),onProgressUpdate(),onCancelled()

            @Override
            protected void onPreExecute() { //Post öncesi
                super.onPreExecute();
                loading = ProgressDialog.show(Cocuklar.this, "Please Wait",null, true, true);
            }

            @Override
            protected void onPostExecute(String s) { //Post sonrası
                super.onPostExecute(s);
                loading.dismiss(); //Yüklendikten sonra Dialog mesajını kaldırma işlemi.

                Intent intent=new Intent(Cocuklar.this,CocukDevam.class);
                intent.putExtra(USER_NAME,name);
                intent.putExtra(CİNSİYET,sex);
                intent.putExtra(TARİH,date);
                startActivity(intent);

            }

            @Override
            protected String doInBackground(String... params) { //Arkaplan

                HashMap<String, String> data = new HashMap<String,String>();

                data.put("username",params[0]);
                data.put("name",params[1]);
                data.put("sex",params[2]);
                data.put("date",params[3]);

                String result=ruc.sendPostRequest(REGISTER_URL,data);
                return  result;
            }
        }

        RegisterUser ru = new RegisterUser();
        ru.execute(username,name,sex,date);
    }
}