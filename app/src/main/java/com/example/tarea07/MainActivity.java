package com.example.tarea07;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ClipData;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);

        setFragment(0);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                for (int i=0; i<=5; i++) navigationView.getMenu().getItem(i).setChecked(false);

                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                drawerLayout.closeDrawers();

                switch (item.getItemId()){
                    case R.id.ultimo:
                        setFragment(0);
                        break;
                    case R.id.sismos:
                        setFragment(1);
                        break;
                    case R.id.mapa:
                        setFragment(2);
                        break;
                    case R.id.ajustes:
                        setFragment(3);
                        break;
                    case R.id.glosario:
                        setFragment(4);
                        break;
                    case R.id.salir:
                        setFragment(5);
                }
                return false;
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuCompat.setGroupDividerEnabled(menu, true);
        return true;
    }

    public void setFragment(int pos){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (pos){
            case 0:
                FragmentUltimo fragmentUltimo = new FragmentUltimo();
                transaction.replace(R.id.fragment, fragmentUltimo).commit();
                break;
            case 1:
                FragmentSismos fragmentSismos = new FragmentSismos();
                transaction.replace(R.id.fragment, fragmentSismos).commit();
                break;
            case 2:
                FragmentMapa fragmentMapa = new FragmentMapa();
                transaction.replace(R.id.fragment, fragmentMapa).commit();
                break;
            case 3:
                FragmentAjustes fragmentAjustes = new FragmentAjustes();
                transaction.replace(R.id.fragment, fragmentAjustes).commit();
                break;
            case 4:
                FragmentGlosario fragmentGlosario = new FragmentGlosario();
                transaction.replace(R.id.fragment, fragmentGlosario).commit();
                break;
            case 5:
                finish();
        }
    }
}