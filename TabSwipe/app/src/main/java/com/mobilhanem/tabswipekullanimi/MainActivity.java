package com.mobilhanem.tabswipekullanimi;
/**
 * Created by Ramaldis on 20.03.2016
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobilhanem.actionbarkullanimi.R;

import java.util.HashMap;

public class MainActivity extends Activity implements View.OnClickListener{

    public EditText editTextName;
    public EditText editTextUsername;
    public EditText editTextPassword;
    public EditText editTextEmail;

    public Button buttonRegister;
    public Button login;

    private static final String REGISTER_URL = "http://serhanyilmaz.890m.com/register.php";
    //URL başına http:// koymak zorunludu.

    //32*32 lik resimler Iconfinder sitesinden alıntıdır.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextUsername = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        login = (Button) findViewById(R.id.buttonLogin);

        buttonRegister.setOnClickListener(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ActivityLogin.class);
                startActivity(intent);
            }
        });




    }

    @Override
    public void onClick(View v) {
        if(v == buttonRegister){
            String name=editTextName.getText().toString();
            String username=editTextUsername.getText().toString();
            String password=editTextPassword.getText().toString();
            String email=editTextEmail.getText().toString();
            if(name.length()==0)
            {
                editTextName.requestFocus();
                editTextName.setError("İsim alanı boş bırakılamaz!");
            }
            else if(name.matches("[0-9 ]+"))
            {
                editTextName.requestFocus();
                editTextName.setError("Yalnızda alfabetik karakterler girilebilir!");
            }
            else  if(username.length()==0)
            {
                editTextUsername.requestFocus();
                editTextUsername.setError("Kullanıcı Adı alanı boş bırakılamaz!");
            }
            else if(password.length()==0)
            {
                editTextPassword.requestFocus();
                editTextPassword.setError("Şifre boş geçilemez!");
            }
            else  if(email.length()==0)
            {
                editTextEmail.requestFocus();
                editTextEmail.setError("Mail alanı boş bırakılamaz!");
            }
            else if(!email.matches("(?simx)\\b[A-Z0-9._%+-]+" +
                    "@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b"))
            {
                editTextEmail.requestFocus();
                editTextEmail.setError("Geçerli Mail giriniz!");
            }


            else
            {
                registerUser();
            }

        }

    }

    private void registerUser() {
        String name = editTextName.getText().toString().trim().toLowerCase();
        String username = editTextUsername.getText().toString().trim().toLowerCase();
        String password = editTextPassword.getText().toString().trim().toLowerCase();
        String email = editTextEmail.getText().toString().trim().toLowerCase();

        register(name,username,password,email);
    }

    private void register(String name, String username, String password, String email) {
        class RegisterUser extends AsyncTask<String, Void, String>{
            ProgressDialog loading;
            RegisterUserClass ruc = new RegisterUserClass();


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this, "Please Wait",null, true, true);
            }

            @Override
            protected void onPostExecute( final String s) {
                super.onPostExecute(s);
                loading.dismiss();
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Kayıt !!");
                builder.setMessage("Üye Kayıt  İşleminiz Bitmiştir..");
                builder.setCancelable(false);
                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }

            @Override
                protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String,String>();
                data.put("name",params[0]);
                data.put("username",params[1]);
                data.put("password",params[2]);
                data.put("email",params[3]);

                String result = ruc.sendPostRequest(REGISTER_URL,data);

                return  result;
            }
        }

        RegisterUser ru = new RegisterUser();
        ru.execute(name,username,password,email);
    }
}