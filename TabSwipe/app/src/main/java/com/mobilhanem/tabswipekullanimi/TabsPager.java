package com.mobilhanem.tabswipekullanimi;
/**
 * Created by Ramaldis on 11.03.2016
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPager extends FragmentPagerAdapter{
	 
    public TabsPager(FragmentManager fm) {
        super(fm);
    }

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		 switch (arg0) {
	        case 0:
	            // Beyaz fragment activity
	            return new Beyaz();
	        case 1:
	            // Kırmızı fragment activity
	            return new Kirmizi();
	        case 2:
	            // Mavi fragment activity
	            return new Mavi();
             case 3:
                 // Mavi fragment activity
                 return new DahaFazlası();
             case 4:
                 // Mavi fragment activity
                 return new Androidİcin();
             case 5:
                 // Mavi fragment activity
                 return new Son();

	        }
	 
	        return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 6; //Tab sayımız
	}




}
