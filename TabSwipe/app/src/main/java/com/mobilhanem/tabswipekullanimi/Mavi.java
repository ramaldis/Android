package com.mobilhanem.tabswipekullanimi;

/**
 * Created by Ramaldis on 07.03.2016
 */
import com.mobilhanem.actionbarkullanimi.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Mavi extends Fragment {
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.mavi, container, false);

        Button gec=(Button) rootView.findViewById(R.id.btnMaviGec);

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