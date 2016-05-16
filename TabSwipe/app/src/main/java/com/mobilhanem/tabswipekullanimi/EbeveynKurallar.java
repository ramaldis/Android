package com.mobilhanem.tabswipekullanimi;
/**
 * Created by Ramaldis on 01.05.2016
 */
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.mobilhanem.actionbarkullanimi.R;

public class EbeveynKurallar extends Fragment {
    Button geri,a1,a2,a3,k1,website,konum;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.ebeveynkurallar, container, false);

        geri=(Button) rootView.findViewById(R.id.btnEbeveynGeri);

        a1=(Button) rootView.findViewById(R.id.btna1);
        a2=(Button) rootView.findViewById(R.id.btna2);
        a3=(Button) rootView.findViewById(R.id.btna3);
        k1=(Button) rootView.findViewById(R.id.btnKategori);

        final Button website=(Button)rootView.findViewById(R.id.btnEbeveynWebSite);
        final Button konum=(Button)rootView.findViewById(R.id.btnEbeveynKonum);




        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),EbeveynHomePage.class);
                startActivity(intent);

            }
        });

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               a1.setText("KAPALI");
               a1.setBackgroundColor(Color.RED);
                Toast.makeText(getView().getContext(), "BU İŞLEMLE KİŞİSEL BİLGİ GÖZETİMİ ERİŞİMİNİ KAPATTINIZ ", Toast.LENGTH_SHORT).show();

            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // WEB GÖZEİMİ ANA KISIM

                Intent intent=new Intent(getActivity(),WebGozetimi.class);
                startActivity(intent);




            }
        });

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a3.setText("KAPALI");
                a3.setBackgroundColor(Color.RED);

                Toast.makeText(getView().getContext(), "BU İŞLEMLE KONUM GÖZETİMİ ERİŞİMİNİ KAPATTINIZ ", Toast.LENGTH_SHORT).show();


            }
        });

        k1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                k1.setText("AÇIK");
                k1.setTextColor(Color.BLACK);
                k1.setBackgroundColor(Color.GREEN);

            }
        });
        return rootView;
    }
}