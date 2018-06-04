package com.example.domin.ega_premium_store;

import android.app.FragmentManager;

public interface NavigationInterface {

    void changeFragment(BaseFragment fragment);
    void changeFragment(BaseFragment fragment, boolean addToBackStack);
    void goBack();
    FragmentManager getFragmentManager();

}
