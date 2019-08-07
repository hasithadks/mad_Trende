package com.example.hasiya_mad_project;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        TextView b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView navView = findViewById(R.id.navigation_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        mListView = findViewById(R.id.listview);

        MainActivity.sellerAdptor sellerAdptorx = new MainActivity.sellerAdptor();
        mListView.setAdapter(sellerAdptorx);

        b1 = findViewById(R.id.seller);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Intent fav_intent = new Intent(MainActivity.this,UserProfile.class);
            startActivity(fav_intent);
        } else if (id == R.id.nav_my_add) {
            Intent fav_intent = new Intent(MainActivity.this,MyAds.class);
            startActivity(fav_intent);

        } else if (id == R.id.nav_cart) {
            Intent fav_intent = new Intent(MainActivity.this,Cart.class);
            startActivity(fav_intent);

        } else if (id == R.id.nav_payment) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_setting) {

        } else if (id == R.id.nav_my_favorite) {
            Intent fav_intent = new Intent(MainActivity.this,Favorite.class);
            startActivity(fav_intent);
        }


        else if (id == R.id.nav_logout) {
            Intent intent = new Intent(MainActivity.this,Login.class);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {

                case R.id.navigation_add_post:
                        Intent intent = new Intent(MainActivity.this,AddPost.class);
                        startActivity(intent);
                    return true;
            }
            return false;
        }
    };



    ListView mListView;

    int[] images = {R.drawable.bonsaiimag02,
            R.drawable.orchidvendar,
            R.drawable.tg12,
            R.drawable.tg13,
            R.drawable.bonsaiimg01,
            R.drawable.tg14};


    String[] names = {"Bonsai Trees" , "Orchid Platns-Vendar", "Cactus Plants", "Cactus Plants", "Bonsai Trees", "Cactus Plants"};

    String[] price = {"Rs. 7500.00" , "Rs. 2500.00", "Rs. 850.00", "Rs. 700", "Rs. 6750.00", "Rs. 1000.00"};

    class sellerAdptor extends BaseAdapter {


        @Override
        public int getCount() {
            return (images.length);
        }

        @Override
        public Object getItem(int i) {



            return null;
        }

        @Override
        public long getItemId(int i) {
            if(i == 3) {
                Intent intent = new Intent(MainActivity.this, AddItem.class);
                startActivity(intent);
            }
            return 0;
        }


        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View view1 = getLayoutInflater().inflate(R.layout.mainmenulayout, null);

            ImageView mimageView = view1.findViewById(R.id.imageView);
            TextView mTextView = view1.findViewById(R.id.textview);
            TextView pTextView = view1.findViewById(R.id.textviewprice);

            mimageView.setImageResource(images[i]);
            mTextView.setText(names[i]);
            pTextView.setText(price[i]);

            return view1;
        }
    }

    protected void onResume() {
        super.onResume();

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view1) {
                Intent save = new Intent(MainActivity.this,Sellers.class);
                startActivity(save);
            }
        });
    }


}
