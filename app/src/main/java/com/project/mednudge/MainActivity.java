package com.project.mednudge;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
  FragmentTransaction fragmentTransaction;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragment = new Login();//the fragment you want to show
        fragmentTransaction.replace(R.id.content_frame, fragment);//R.id.content_frame is the layout you want to replace
        fragmentTransaction.commit();
    }
    @Override
    public void onBackPressed()

    {
        int count=getFragmentManager().getBackStackEntryCount();
        if (count==0) {
            super.onBackPressed();
        }
        else
        {
            getFragmentManager().popBackStack();
        }
    }
}

