package com.rescuer.earth;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class Navigator extends AppCompatActivity {

    Drawable[] imgs;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    try{
                    Fragment fragment = StartPage.newInstance(70);
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.content, fragment);
                    transaction.commit();
                    }catch (Exception e){
                        Log.e("Error","Failed to load Fragment");
                    }

                    return true;
                case R.id.navigation_dashboard:
                    try{
                        Fragment fragment = new Challenges();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.content, fragment);
                        transaction.commit();
                    }catch (Exception e){
                        Log.e("Error","Failed to load Fragment");
                    }


                    return true;
                case R.id.navigation_notifications:
                    try{
                        Fragment fragment = new LowScore();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.content, fragment);
                        transaction.commit();
                    }catch (Exception e){
                        Log.e("Error","Failed to load Fragment");
                    }

                    return true;
                case R.id.navigation_hints:
                    try{
                        Fragment fragment = new Hints();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.content, fragment);
                        transaction.commit();
                    }catch (Exception e){
                        Log.e("Error","Failed to load Fragment");
                    }

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        try{
            Fragment fragment = new StartPage();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }catch (Exception e){
            Log.e("Error","Failed to load Fragment");
        }
    }

}
