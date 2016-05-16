package com.mobilhanem.tabswipekullanimi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class EbeveynTabsPager extends FragmentPagerAdapter {

    public EbeveynTabsPager(FragmentManager fm) {
        super(fm);
    }

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		 switch (arg0) {
	        case 0:
	            // Beyaz fragment activity
	            return new Uyarılar();
	        case 1:
	            // Kırmızı fragment activity
	            return new Etkinlik();
	        case 2:
	            // Mavi fragment activity
	            return new EbeveynKurallar();
	        }
	 
	        return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3; //Tab sayımız
	}
 
    
}
