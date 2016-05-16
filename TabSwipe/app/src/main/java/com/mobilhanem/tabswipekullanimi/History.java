package com.mobilhanem.tabswipekullanimi;

/**
 * Created by Ramaldis on 28.04.2016
 */

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.mobilhanem.actionbarkullanimi.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class History extends Activity {


    private static final String TAG_RESULTS="result";
    private static final String TAG_ID = "id";
    private static final String TAG_URL = "url";
    private static final String TAG_DATE="date";

    String myJSON;

    JSONArray peoples = null;

    ArrayList<HashMap<String, String>> personList;

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        list = (ListView) findViewById(R.id.listView);

        Button back=(Button) findViewById(R.id.btnGeri);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(History.this,BrowserActivity.class);
                startActivity(intent);
                finish();
            }
        });


        personList = new ArrayList<HashMap<String,String>>();
        getData();


    }

    //onPostExecute methodu
    protected void showList(){
        try {

            //URL'den JSON verisi çekme işlemi
            //JSON ,daha küçük boyutlarda veri alıp vermedir.JavaScript 'i verimli kullanmayı sağlar.
            /*
                <isim>Erhan</isim>
                <soyisim>Yılmaz</soyisim>
                <yas>22</yas>

                gibi bir örnek’te JSON olarak incelersek sürekli tag’lar
                arasında almak yerine isim:Erhan gibi sade ve anlaşılır bir hal alıcaktır.
             */

            //JSON veri tipleri=Object,String,Array,Number,Boolean,null
            //JSON YAPILARI=Object,Array
            //Manifest'te İnternet izni alınmalıdır.
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);

            for(int i=0;i<peoples.length();i++){
                JSONObject c = peoples.getJSONObject(i);

                String id = c.getString(TAG_ID);
                String url = c.getString(TAG_URL);
                String date = c.getString(TAG_DATE);

                HashMap<String,String> persons = new HashMap<String,String>();

                persons.put(TAG_ID,id);
                persons.put(TAG_URL,url);
                persons.put(TAG_DATE,date);

                personList.add(persons); //ArrayList'e verileri ekleme işlemi (Id,URL,Date)
            }

            //Listeye Yerleştirme İşlemi

           ListAdapter adapter=new SimpleAdapter(
                   History.this,personList,R.layout.list_item,
                   new String[]{TAG_ID,TAG_URL,TAG_DATE},
                   new int[] {R.id.ID,R.id.url,R.id.date});

            list.setAdapter(adapter);



        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

    }

    public void getData(){
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {
                DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                HttpPost httppost = new HttpPost("http://serhanyilmaz.890m.com/selecthistory.php");

                // Depends on your web service
                httppost.setHeader("Content-type", "application/json");

                InputStream inputStream = null;
                String result = null;
                try {
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();

                    inputStream = entity.getContent();
                    // json is UTF-8 by default
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (Exception e) {
                    // Oops UYARI
                }
                finally {
                    try{if(inputStream != null)inputStream.close();}catch(Exception squish){}
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result){
                myJSON=result;
                showList();
            }
        }

        //RegisterUser ru=new RegiserUser();
        //ru.execute();
        GetDataJSON g = new GetDataJSON();
        g.execute();
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
