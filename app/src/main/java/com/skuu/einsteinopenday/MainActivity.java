package com.skuu.einsteinopenday;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.skuu.einsteinopenday.R.id.map;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback
{
    private Button[] btnCategorie = new Button[4];
    private GoogleMap mMap;
    private LatLng[] aule =
            {
                    new LatLng(45.616608, 9.384372), // Lab Cisco (sistemi)
                    new LatLng(45.616257, 9.384769), // Polifunzionale
                    new LatLng(45.616203, 9.384639), // Lab info
                    new LatLng(45.615969, 9.384042), // Lab Sistemi 1
                    new LatLng(45.615931, 9.383960), // Lab Sistemi 2
                    new LatLng(45.616265, 9.384343), // Paninaro 1
                    new LatLng(45.616726, 9.383933), // Paninaro 2
            };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(map);
        mapFragment.getMapAsync(this);

        Toolbar toolbar = (Toolbar)this.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)this.findViewById(R.id.bottomNavigationBar);

        bottomNavigationView.setOnNavigationItemSelectedListener
        (
            new BottomNavigationView.OnNavigationItemSelectedListener()
            {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item)
                {
                    mMap.clear();

                    switch (item.getItemId())
                    {
                        case R.id.action_info:
                            for(int i = 0; i < aule.length; i += 2)
                            {
                                mMap.addMarker(new MarkerOptions().position(aule[i]));
                            }
                            break;
                        case R.id.action_ele:
                            for(int i = 0; i < aule.length; i += 3)
                            {
                                mMap.addMarker(new MarkerOptions().position(aule[i]));
                            }
                            break;
                        case R.id.action_bio:
                            for(int i = 0; i < aule.length; i++)
                            {
                                mMap.addMarker(new MarkerOptions().position(aule[i]));
                            }
                            break;
                        case R.id.action_art:
                            for(int i = 0; i < aule.length; i++)
                            {
                                mMap.addMarker(new MarkerOptions().position(aule[i]));
                            }
                            break;
                    }
                    return true;
                }
            }
        );
    }

    // Inflate the toolbar menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    // Load the map
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        // Inizializza la mappa
        mMap = googleMap;
        mMap.setMinZoomPreference(17.7f);
        mMap.getUiSettings().setZoomControlsEnabled(true); // Show the zoom buttons
        mMap.getUiSettings().setMapToolbarEnabled(false); // Disable the go to google maps buttons

        // Center the camera on the school
        final LatLngBounds superficieScuola = new LatLngBounds(new LatLng(45.615673, 9.382930), new LatLng(45.617378, 9.384733));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(superficieScuola.getCenter(), 0));

        // Limit the map view scroll distance
        mMap.setLatLngBoundsForCameraTarget(superficieScuola);

        // Enable my location
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
        mMap.setMyLocationEnabled(true);

        // Aggiunge i marker delle aule
        for(int i = 0; i < aule.length; i++)
        {
            mMap.addMarker(new MarkerOptions().position(aule[i]));
        }
    }
}