package com.mobilhanem.tabswipekullanimi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mobilhanem.actionbarkullanimi.R;

public class Androidİcin extends Fragment {

    //Framgment aynı anda 2 Arayüzü (Layout'u) tek Class(Sınıf) içerisine yazabilme.
    //Örnek Uygulama:MESSENGER

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.sadeceandroidicindegil, container, false);

        Button gec=(Button) rootView.findViewById(R.id.btnAndroidIcınGec);

        gec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),MainActivity.class);
                //Fragment'de SınıfAdı.this yerine getActivity() kullanılır.
                startActivity(intent);
            }
        });

        return rootView;
    }
}