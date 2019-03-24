package com.example.hackathon;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home_screen);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        //SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                //.findFragmentById(R.id.map);
        //mapFragment.getMapAsync(this);
//        try {
//            UserManager.userFromFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        UserManager.addManager();
//        PlaceManager.placesFromFile();
        final Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                EditText username = findViewById(R.id.user_name);
                EditText password = findViewById(R.id.user_password);
                User user = UserManager.login(username.getText().toString(), password.getText().toString());
                if (user != null) {
                    Intent intent = new Intent(MapsActivity.this, MapsActivity2.class);
                    startActivity(intent);
                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "Login not recognized please try again";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
        final TextView signUp = findViewById(R.id.textView);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
    }
