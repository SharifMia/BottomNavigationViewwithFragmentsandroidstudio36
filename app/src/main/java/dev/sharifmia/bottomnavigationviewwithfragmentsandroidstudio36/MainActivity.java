package dev.sharifmia.bottomnavigationviewwithfragmentsandroidstudio36;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new HomePage()).commit();
        }

        BottomNavigationView navigationView = findViewById(R.id.NavBar);
        navigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_home:
                            fragment = new HomePage();
                            break;
                        case R.id.nav_favorite:
                            fragment = new FavoritePage();
                            break;
                        case R.id.nav_search:
                            fragment = new SearchPage();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
                    return true;
                }
            };

}
