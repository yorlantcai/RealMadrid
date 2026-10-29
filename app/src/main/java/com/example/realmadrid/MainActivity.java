package com.example.realmadrid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNav);

        cambiarFragment(new InicioFragment());

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_inicio) {
                    cambiarFragment(new InicioFragment());
                    return true;
                } else if (id == R.id.nav_configuracion) {
                    cambiarFragment(new ConfiguracionFragment());
                    return true;
                }
                return false;
            }
        });
    }

    private void cambiarFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contenedor, fragment)
                .commit();
    }
}
