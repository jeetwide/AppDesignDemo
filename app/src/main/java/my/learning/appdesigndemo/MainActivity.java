package my.learning.appdesigndemo;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bottomNavigationView = findViewById(R.id.navigationView);



        //loading the default fragment
        loadFragment(new ShuttleFragment());


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;

                switch (menuItem.getItemId()) {

                    case R.id.navigation_android:
                        Toast.makeText(MainActivity.this, "Android selected", Toast.LENGTH_SHORT).show();
                        fragment= new AndroidFragment();
                        break;

                    case R.id.navigation_call:
                        Toast.makeText(MainActivity.this, "Call  selected", Toast.LENGTH_SHORT).show();
                        fragment= new CallFragment();
                        break;

                    case R.id.navigation_shuttle:
                        Toast.makeText(MainActivity.this, "Shuttle  selected", Toast.LENGTH_SHORT).show();
                        fragment= new ShuttleFragment();
                        break;

                }


               // return true;
               return loadFragment(fragment);
            }
        });
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
