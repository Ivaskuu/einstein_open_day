package com.skuu.einsteinopenday;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import static com.skuu.einsteinopenday.R.id.map;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback
{
    private GoogleMap mMap;
    private ArrayList<MarkerOptions> markers = new ArrayList<>();

    private final int DEFAULT_SWIPE_MIN_DISTANCE = 120;
    private int swipeMinDistance = 120;

    private int currentCategory = 0;

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
        bottomNavigationView.setOnNavigationItemSelectedListener // On bottom navigation view click
        (
            new BottomNavigationView.OnNavigationItemSelectedListener()
            {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item)
                {
                    int category = 0;

                    if(item.getItemId() == R.id.action_ele) category = 1;
                    else if(item.getItemId() == R.id.action_bio) category = 2;
                    else if(item.getItemId() == R.id.action_art) category = 3;

                    showMarkers(category);
                    return true;
                }
            }
        );

        final GestureDetector gdt = new GestureDetector(new BottomNavigationBarGestureListener());
        for(int i = 0; i < bottomNavigationView.getTouchables().size(); i++)
        {
            BottomNavigationItemView btn = (BottomNavigationItemView)bottomNavigationView.getTouchables().get(i);
            btn.setOnTouchListener(new View.OnTouchListener()
            {
                @Override
                public boolean onTouch(View v, MotionEvent event)
                {
                    gdt.onTouchEvent(event);
                    return false;
                }
            });
        }
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
        mMap.setIndoorEnabled(true);

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

        initMarkers();
        showMarkers(0);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
        {
            @Override
            public boolean onMarkerClick(Marker marker)
            {
                onMarkerPress(marker);
                return false;
            }
        });
    }

    // Create markers based on the listaAule at the same index position
    private void initMarkers()
    {
        for(int i = 0; i < ListaAule.adule.length; i++)
        {
            markers.add(new MarkerOptions().position(ListaAule.adule[i].pos).title(ListaAule.adule[i].attivita.nomeAtt).snippet("Clicca qui per più informazioni"));
        }
    }

    // Show only the markers that belongs with the given category
    private void showMarkers(int category)
    {
        currentCategory = category;

        mMap.clear();
        for(int i = 0; i < ListaAule.adule.length; i++)
        {
            if(ListaAule.adule[i].category == category || ListaAule.adule[i].category == -1) mMap.addMarker(markers.get(i));
        }
    }

    // Inflate the toolbar menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    private class BottomNavigationBarGestureListener extends GestureDetector.SimpleOnGestureListener
    {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)
        {
            if(e1.getY() - e2.getY() > swipeMinDistance)
            {
                showListaAttivita(null);
            }

            return false;
        }
    }

    public void showListaAttivita(View v)
    {
        swipeMinDistance = 120000; // Prevent the infinite swipe bug

        // Get all attivita
        ArrayList<Attivita> listaAttivita = new ArrayList<>();
        for(int i = 0; i < ListaAule.adule.length; i++)
        {
            if(ListaAule.adule[i].category == currentCategory || ListaAule.adule[i].category == -1) // TODO : Spostare l'attributo category da Aula a Attivita
            {
                listaAttivita.add(ListaAule.adule[i].attivita);
            }
        }

        // Inflate the bottom sheet dialog
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        View dialogView = getLayoutInflater().inflate(R.layout.bottom_sheet_lista_attivita, null);

        // Init the listaAttivita
        BottomSheetListView listView = (BottomSheetListView)dialogView.findViewById(R.id.listaAttivita);
        AdapterListaAttivita adapter = new AdapterListaAttivita(this, listaAttivita);
        listView.setAdapter(adapter);


        dialog.setContentView(dialogView);
        dialog.show();

        // Reset swipeMinDistance on dialog close
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
            @Override
            public void onDismiss(DialogInterface dialog)
            {
                swipeMinDistance = DEFAULT_SWIPE_MIN_DISTANCE;
            }
        });
    }

    private void onMarkerPress(Marker marker)
    {
        int pos = -1;

        final Dialog dialog = new Dialog(MainActivity.this); // Custom dialog
        dialog.setContentView(R.layout.lab_dialog);

        for(int i = 0; i < ListaAule.adule.length; i++)
        {
            if(ListaAule.adule[i].attivita.nomeAtt.equals(marker.getTitle()))
            {
                pos = i;
                break;
            }
        }

        // Set the custom dialog components - text, image and button
        TextView textAttivita = (TextView) dialog.findViewById(R.id.text_attivita);
        TextView textProf = (TextView) dialog.findViewById(R.id.text_prof);

        textAttivita.setText(ListaAule.adule[pos].attivita.nomeAtt);
        textProf.setText(ListaAule.adule[pos].attivita.prof);

        /*Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });*/

        dialog.show();
    }
}