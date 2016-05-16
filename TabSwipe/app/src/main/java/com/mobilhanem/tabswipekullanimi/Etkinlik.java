package com.mobilhanem.tabswipekullanimi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mobilhanem.actionbarkullanimi.R;

public class Etkinlik extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.etkinlik, container, false);

        Button website=(Button)   rootView.findViewById(R.id.btnEbeveynWebSite);
        Button konum=(Button) rootView.findViewById(R.id.btnEbeveynKonum);

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EbeveynHistory.class);
                startActivity(intent);

            }
        });
        konum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("google.navigation:q=Kocaeli Üniversitesi"));
                startActivity(intent);
            }
        });
        return rootView;
    }
}