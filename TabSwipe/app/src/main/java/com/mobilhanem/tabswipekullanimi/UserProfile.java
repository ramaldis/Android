package com.mobilhanem.tabswipekullanimi;

/**
 * Created by Ramaldis on 01.05.2016
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.mobilhanem.actionbarkullanimi.R;

public class UserProfile extends Activity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        textView = (TextView) findViewById(R.id.textViewUserName);

        Intent intent = getIntent();

        String username = intent.getStringExtra(ActivityLogin.USER_NAME);

        textView.setText("Welcome User "+username);
    }

}
