package com.example.tabularview;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    Fragment fragment = null;
    FrameLayout framelayout;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        framelayout = findViewById(R.id.framelayout);

        tabLayout.getTabAt(0).setIcon(R.drawable.home_icon).setText("Home");
        tabLayout.getTabAt(1).setIcon(R.drawable.network_icon).setText("MyNetwork");
       tabLayout.getTabAt(2).setIcon(R.drawable.post_icon).setText("Post");
        tabLayout.getTabAt(3).setIcon(R.drawable.notifications_icon).setText("Notifications");
        //tabLayout.getTabAt(4).setIcon(R.drawable.job_icon).setText("Jobs");


        fragment = new HomeFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new HomeFragment();
                        break;
                    case 1:
                        fragment = new AboutFragment();
                        break;
                    case 2:
                        fragment = new ProfileFragment();
                        break;
                    case 3:
                        fragment = new ContactsUs();
                        break;
                }
                FragmentManager fn = getSupportFragmentManager();
                FragmentTransaction ft = fn.beginTransaction();
                ft.replace(R.id.framelayout, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Handle tab unselected state if needed
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Handle tab reselected state if needed
            }
        });

        // Enable edge-to-edge mode
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
