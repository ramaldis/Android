package com.mobilhanem.tabswipekullanimi;
/**
 * Created by Ramaldis on 28.04.2016
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mobilhanem.actionbarkullanimi.R;

public class Uyarılar extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.uyarilar, container, false);
        Button tıkla=(Button) rootView.findViewById(R.id.btnBlockPage);

        tıkla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SelectBlock.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}