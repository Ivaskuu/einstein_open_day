package com.skuu.einsteinopenday;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.skuu.einsteinopenday.R.id.map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{
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
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);

        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        // Inizializza la mappa
        mMap = googleMap;
        mMap.setMinZoomPreference(18);
        mMap.getUiSettings().setZoomControlsEnabled(true); // Show the zoom buttons
        mMap.getUiSettings().setMapToolbarEnabled(false); // Show the zoom buttons

        // Center the camera on the school
        final LatLngBounds superficieScuola = new LatLngBounds(new LatLng(45.615673, 9.382930), new LatLng(45.617378, 9.384733));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(superficieScuola.getCenter(), 0));

        // Limit the map view scroll
        mMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener()
        {
            @Override
            public void onCameraChange(CameraPosition arg0)
            {
                mMap.setLatLngBoundsForCameraTarget(superficieScuola);
            }
        });

        /*// Set the location button
        mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener()
        {
            @Override
            public boolean onMyLocationButtonClick()
            {
                return false;
            }
        });
        mMap.setOnMyLocationClickListener(new GoogleMap.OnMyLocationClickListener()
        {
            @Override
            public void onMyLocationClick(@NonNull Location location)
            {

            }
        });*/

        // Enable my location
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            askForLocationPermission();
        }

        mMap.setMyLocationEnabled(true);

        // Aggiunge i marker
        for(int i = 0; i < aule.length; i++)
        {
            mMap.addMarker(new MarkerOptions().position(aule[i]));
        }
    }

    void askForLocationPermission()
    {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
    }
}
