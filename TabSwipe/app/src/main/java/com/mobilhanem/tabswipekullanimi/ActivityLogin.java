package com.mobilhanem.tabswipekullanimi;

/**
 * Created by Ramaldis on 14.3.2016.
 */

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.mobilhanem.actionbarkullanimi.R;

import java.util.HashMap;

public class ActivityLogin extends Activity implements View.OnClickListener{

    public static final String USER_NAME = "USER_NAME";

    public static final String PASSWORD = "PASSWORD";

    // Public Static final String varsa Intent ile başka yerlerde kullanıldığını gör.

    RelativeLayout layout;//layout referans

    private static final String LOGIN_URL = "http://serhanyilmaz.890m.com/familylogin.php";
    //URL başına http:// koymak zorunludur.

    private EditText editTextUserName;
    private EditText editTextPassword;

    private Button buttonLogin;
    private String username,password;
    private Button ok;
    private CheckBox saveLoginCheckBox;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_login);

        editTextUserName = (EditText) findViewById(R.id.username);
        editTextPassword = (EditText) findViewById(R.id.password);

        buttonLogin = (Button) findViewById(R.id.buttonUserLogin);
        saveLoginCheckBox = (CheckBox)findViewById(R.id.saveLoginCheckBox);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        StartAnimations();//Animasyonu ba�lat�yoruz

        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            editTextUserName.setText(loginPreferences.getString("username", ""));
            editTextPassword.setText(loginPreferences.getString("password", ""));
            saveLoginCheckBox.setChecked(true);
        }
        buttonLogin.setOnClickListener(this);

    }

    private void StartAnimations() {
        Animation animation=AnimationUtils.loadAnimation(this,R.anim.alpha);
        ImageView iv=(ImageView) findViewById(R.id.logo);
        animation.reset();
        iv.clearAnimation();
        iv.startAnimation(animation);
    }


    private void login(){
        String username = editTextUserName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        userLogin(username,password);
    }

    private void userLogin(final String username, final String password){
        class UserLoginClass extends AsyncTask<String,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ActivityLogin.this,"Please Wait",null,true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if(s.equalsIgnoreCase("success")){
                    Intent intent = new Intent(ActivityLogin.this,OpenScreen.class);
                    intent.putExtra(USER_NAME,username);
                    startActivity(intent);
                }else{
                    Toast.makeText(ActivityLogin.this,s,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {
                HashMap<String,String> data = new HashMap<>();
                data.put("username",params[0]);
                data.put("password",params[1]);

                RegisterUserClass ruc = new RegisterUserClass();

                String result = ruc.sendPostRequest(LOGIN_URL,data);

                return result;
            }
        }
        UserLoginClass ulc = new UserLoginClass();
        ulc.execute(username,password);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonLogin){
            login();
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(editTextUserName.getWindowToken(), 0);

            username = editTextUserName.getText().toString();
            password = editTextPassword.getText().toString();

            if (saveLoginCheckBox.isChecked()) {
                loginPrefsEditor.putBoolean("saveLogin", true);
                loginPrefsEditor.putString("username", username);
                loginPrefsEditor.putString("password", password);
                loginPrefsEditor.commit();
            } else {
                loginPrefsEditor.clear();
                loginPrefsEditor.commit();
            }


        }
    }

}
