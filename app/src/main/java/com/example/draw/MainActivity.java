package com.example.draw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.support.v4.app.INotificationSideChannel;
import android.view.MenuItem;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

DrawerLayout drawerLayout;
NavigationView navigationView;
Toolbar toolbar;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

drawerLayout=findViewById(R.id.mainDrawer);
navigationView=findViewById(R.id.nav_view);
toolbar=findViewById(R.id.appBar);

ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

     drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


       // getSupportFragmentManager().beginTransaction()
               // .replace(R.id.contentContainer, new Default())
              //  .commit();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

               if (id == R.id.startQuizItem){
                    loadFragment(new Quiz());
                    System.out.println("id: quiz");
                } else if (id == R.id.showResultItem){
                    loadFragment(new CheckResult());
                    System.out.println("id: result");
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }
    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.contentContainer, fragment);
        fragmentTransaction.commit();
    }
    }
