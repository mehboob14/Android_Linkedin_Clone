package com.example.tabularview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.os.SharedMemory;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import com.google.android.material.imageview.ShapeableImageView;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import kotlinx.coroutines.Job;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    Fragment fragment = null;
    FrameLayout framelayout;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    ImageButton imgBtn;
   ShapeableImageView profile_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        SharedPreferences sharedPreferences = getSharedPreferences("for_login",MODE_PRIVATE);
        Boolean isFistTime = sharedPreferences.getBoolean("isFirstTime",true);
        Boolean isLogged = sharedPreferences.getBoolean("isLogged",false);

        if(isFistTime){
            Intent i = new Intent(getApplicationContext(), SignUp.class);
            startActivity(i);
            finish();
        }else if(!isLogged){
            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            finish();
        }else {
           setContentView(R.layout.activity_main);
        }

        tabLayout = findViewById(R.id.tablayout);
        framelayout = findViewById(R.id.framelayout);

        tabLayout.getTabAt(0).setIcon(R.drawable.home).setText("Home");
        tabLayout.getTabAt(1).setIcon(R.drawable.friend).setText("MyNetwork");
        tabLayout.getTabAt(2).setIcon(R.drawable.more).setText("Post");
        tabLayout.getTabAt(3).setIcon(R.drawable.active).setText("Notifications");
        tabLayout.getTabAt(4).setIcon(R.drawable.suitcase).setText("Jobs");
        imgBtn = findViewById(R.id.messaging);
        profile_img = findViewById(R.id.profile_img);
        ImageView logout = findViewById(R.id.logout);

        fragment = new HomeFragment();
       // fragment = new Post_Fragment_Item();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.setCustomAnimations(R.anim.slide_in,R.anim.slide_out,R.anim.pop_enter,R.anim.pop_remove);
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
                    case 4:
                        fragment = new JobFragment();
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

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        profile_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = getLayoutInflater();
                View dialogView = layoutInflater.inflate(R.layout.dialog, null);

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Material_Light_NoActionBar_Fullscreen);
                dialogBuilder.setView(dialogView);
                dialogView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean("isLogged",false);
                        editor.putBoolean("isFirstTime",true);

                        Intent i = new Intent(getApplicationContext(), Login.class);
                        startActivity(i);
                        finish();
                    }
                });

                AlertDialog dialog = dialogBuilder.create();


                dialog.show();
                Window window = dialog.getWindow();
                if (window != null) {
                    window.setGravity(Gravity.START);

                    window.setLayout(
                            (int) (getResources().getDisplayMetrics().widthPixels * 0.8),
                            (int) (getResources().getDisplayMetrics().heightPixels * 1)
                    );
                }
            }
        });

    }
    public void showPopUp(View view){
        PopupMenu popupMenu = new PopupMenu(MainActivity.this,view);
        popupMenu.getMenuInflater().inflate(R.menu.profile_menu,popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case 0:
                        Toast.makeText(MainActivity.this, "Settings Clicked", Toast.LENGTH_SHORT).show();
                        return true;
                }

                return false;
            }
        });

        popupMenu.show();
    }
}
