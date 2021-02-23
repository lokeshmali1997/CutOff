package com.example.cutoff;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    Fragment fragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.maincontainer,new HomeFragment());
        fragmentTransaction.commit();



        drawerLayout = findViewById(R.id.drawer1);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        navigationView = findViewById(R.id.navigationview);

        navigationView.setNavigationItemSelectedListener(item -> {


             switch (item.getItemId())
             {
                 case R.id.navhome:
                     fragment = new HomeFragment();
                     loadfragement(fragment);
                     drawerLayout.closeDrawer(GravityCompat.START);
                     break;
                 case R.id.navnews :
                     fragment = new NewsFragment();
                     loadfragement(fragment);
                     drawerLayout.closeDrawer(GravityCompat.START);
                     break;
                 case R.id.navlogout :
                     startActivity(new Intent(MainActivity.this,Login.class));
                     drawerLayout.closeDrawer(GravityCompat.START);
                     break;

                 default:
                      return true;

             }



            return true;
        });




    }

    public void loadfragement(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.maincontainer,fragment).addToBackStack(null).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
        fragmentTransaction.addToBackStack(null);
    }

}