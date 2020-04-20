package com.example.fastpay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.fastpay.ui.history.HistoryFragment;
import com.example.fastpay.ui.home.HomeFragment;
import com.example.fastpay.ui.offers.OffersFragment;
import com.example.fastpay.ui.payments.PaymentsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                new HomeFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedfragment = null;

                    switch (menuItem.getItemId())
                    {
                        case R.id.navHome:
                            selectedfragment = new HomeFragment();
                            break;
                        case R.id.navOffers:
                            selectedfragment = new OffersFragment();
                            break;
                        case R.id.navPayment:
                            selectedfragment = new PaymentsFragment();
                            break;
                        case R.id.navHistory:
                            selectedfragment = new HistoryFragment();
                            break;

                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                            selectedfragment).commit();
                    return true;

                }
            };
}
