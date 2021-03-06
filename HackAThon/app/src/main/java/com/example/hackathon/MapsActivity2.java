package com.example.hackathon;

import android.content.ClipData;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity2 extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.map_primary);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        // Handle navigation view item clicks here.
                        switch (item.getItemId()) {

                            case R.id.nav_access: {
                                setCatagory("accessible");
                            }
                        }
                        //close navigation drawer
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }
                });

        drawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }


                }
        );

//        findViewById(R.id.drawer_layout).findViewById(R.id.nav_access).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setCatagory("accessible");
//            }
//        });
    }


    public void setCatagory(String catagory){
        // Add a marker in Sydney and move the camera
        for(Place plc : PlaceManager.getCategory(catagory)) {
            LatLng temp = plc.getAddress();
            mMap.addMarker(new MarkerOptions().position(plc.getAddress()).title(plc.getName())
                    .snippet("This location is " + catagory)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.access)));
        }
    }

    private static final String TAG = MapsActivity.class.getSimpleName();

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        ArrayList<String> temp = new ArrayList<>();
        temp.add("accessible");
        PlaceManager.addPlace(new Place(new LatLng(43.664415, -79.399590), temp, "Robarts Library"));
        PlaceManager.addPlace(new Place(new LatLng(43.668154, -79.397678), temp, "Tim Hortons"));
        PlaceManager.addPlace(new Place(new LatLng(43.663376, -79.397599), temp, "Your location"));
        // Add a marker in Sydney and move the camera
//        LatLng toronto = new LatLng(43.663376, -79.397599);
//        mMap.addMarker(new MarkerOptions().position(toronto).title("Your Location")
//                .snippet("This location has a Ramp and Electronic Entrance")
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.access)));

//        LatLng robarts = new LatLng(43.664415, -79.399590);
//        mMap.addMarker(new MarkerOptions().position(robarts).title("Robarts Library")
//                .snippet("This location has an Electronic Entrance")
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.access)));

//        LatLng timhortons = new LatLng(43.668154, -79.397678);
//        mMap.addMarker(new MarkerOptions().position(timhortons).title("Tim Hortons")
//                .snippet("246 Bloor St W, Toronto, ON M5S 1V4")                .icon(BitmapDescriptorFactory.fromResource(R.drawable.food2)));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(43.663376, -79.397599)));
        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style_json));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }
        // Position the map's camera near Sydney, Australia.}
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
