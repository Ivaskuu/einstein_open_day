package com.skuu.einsteinopenday;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
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
    public static ArrayList<MarkerOptions> markers = new ArrayList<>(); // TODO: Try to integrate it in the Aula class
    private GoogleMap mMap;
    private SharedPreferences prefs;

    private final int[] categoriesName = {R.string.menu_cat_info, R.string.menu_cat_ele, R.string.menu_cat_bio, R.string.menu_cat_art, R.string.menu_cat_sport};
    private final int[] categoriesIcon = {R.drawable.ic_reorder_24dp, R.drawable.ic_memory_24dp, R.drawable.ic_flask_24dp, R.drawable.ic_brush_24dp, R.drawable.ic_directions_run};

    private final int DEFAULT_SWIPE_MIN_DISTANCE = 100;
    private int swipeMinDistance = 100;

    private int currentCategory = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(map);
        mapFragment.getMapAsync(this);

        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) this.findViewById(R.id.bottomNavigationBar);
        bottomNavigationView.setOnNavigationItemSelectedListener // On bottom navigation view click
                (
                        new BottomNavigationView.OnNavigationItemSelectedListener() {
                            @Override
                            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                                int category = 0;

                                if (item.getItemId() == R.id.action_ele) category = 1;
                                else if (item.getItemId() == R.id.action_bio) category = 2;
                                else if (item.getItemId() == R.id.action_art) category = 3;
                                else if (item.getItemId() == R.id.action_sport) category = 4;

                                showMarkers(category);
                                return true;
                            }
                        }
                );
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                showListaAttivita(null);
            }
        });

        final GestureDetector gdt = new GestureDetector(new BottomNavigationBarGestureListener());
        for (int i = 0; i < bottomNavigationView.getTouchables().size(); i++) {
            BottomNavigationItemView btn = (BottomNavigationItemView) bottomNavigationView.getTouchables().get(i);
            btn.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    gdt.onTouchEvent(event);
                    return false;
                }
            });
        }

        // Show the tutorial
        prefs = getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);
        if (!prefs.contains("tutorial")) showTutorial(0);
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
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
        else
        {
            mMap.setMyLocationEnabled(true);
        }

        initMarkers();
        showMarkers(0);

        // Show the lab dialog on marker click
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
        {
            @Override
            public boolean onMarkerClick(Marker marker)
            {
                onMarkerPress(marker);
                return false;
            }
        });

        // Show the lab dialog on infowindow click
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener()
        {
            @Override
            public void onInfoWindowClick(Marker arg0)
            {
                onMarkerPress(arg0);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            mMap.setMyLocationEnabled(true);
        }
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

    private void onMarkerPress(Marker marker)
    {
        for(int i = 0; i < ListaAule.adule.length; i++)
        {
            if(ListaAule.adule[i].attivita.nomeAtt.equals(marker.getTitle()))
            {
                showLabDialog(i);
                break;
            }
        }
    }

    public void showLabDialog(int pos)
    {
        final Dialog dialog = new Dialog(MainActivity.this); // Custom dialog
        dialog.setContentView(R.layout.lab_dialog);

        // Set the custom dialog components
        TextView textAttivita = (TextView) dialog.findViewById(R.id.text_attivita);
        TextView textProf = (TextView) dialog.findViewById(R.id.text_prof);
        ImageView img = (ImageView) dialog.findViewById(R.id.img_lab);

        textAttivita.setText(ListaAule.adule[pos].attivita.nomeAtt);
        textProf.setText(ListaAule.adule[pos].attivita.prof);
        img.setImageResource(ListaAule.adule[pos].attivita.imgRes);

        // Close the dialog on button press
        Button dialogButton = (Button) dialog.findViewById(R.id.btn_chiudi_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
            }
        });

        dialog.show();
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

    // Show the lista attivita bottom sheet dialog
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
        final BottomSheetDialog dialog = new BottomSheetDialog(this);
        View dialogView = getLayoutInflater().inflate(R.layout.bottom_sheet_lista_attivita, null);

        // Init the listaAttivita
        BottomSheetListView listView = (BottomSheetListView)dialogView.findViewById(R.id.listaAttivita);
        AdapterListaAttivita adapter = new AdapterListaAttivita(this, listaAttivita, dialog, mMap, this);
        listView.setAdapter(adapter);

        ImageView imgCat = (ImageView)dialogView.findViewById(R.id.img_category);
        TextView textCat = (TextView)dialogView.findViewById(R.id.text_category);
        ImageButton btnClose = (ImageButton)dialogView.findViewById(R.id.btn_close_dialog);

        textCat.setText(getResources().getString(categoriesName[currentCategory]));
        imgCat.setImageResource(categoriesIcon[currentCategory]);
        btnClose.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
            }
        });

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

    private void showTutorial(final int step)
    {
        View view;
        String title, desc;
        int radius;

        switch (step)
        {
            case 0:
                view = findViewById(R.id.map);
                title = "Questa è la mappa della scuola.";
                desc = "Puoi muoverti e ingrandirla per orientarti e visualizzare tutte le attività.";
                radius = 180;
                break;
            case 1:
                view = findViewById(R.id.bottomNavigationBar);
                title = "Questa è la barra dei vari indirizzi";
                desc = "Seleziona un indirizzo per scoprire tutte le sue relative attività";
                radius = 140;
                break;
            case 2:
                view = findViewById(R.id.bottomNavigationBar).getTouchables().get(1);
                title = "Clicca qui per cambiare indirizzo.";
                desc = "";
                radius = 50;
                break;
            case 3:
                ((BottomNavigationView) findViewById(R.id.bottomNavigationBar)).setSelectedItemId(R.id.action_ele);

                view = findViewById(R.id.map);
                title = "Come puoi vedere, i segnalini hanno cambiato posizione.";
                desc = "Per ogni indirizzo troverai delle attività diverse alle quali potrai partecipare.";
                radius = 160;
                break;
            case 4:
                for (int i = 0; i < ListaAule.adule.length; i++)
                {
                    if(ListaAule.adule[i].category == 1)
                    {
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(markers.get(i).getPosition(), 19), 500, new GoogleMap.CancelableCallback()
                        {
                            @Override public void onFinish() {}
                            @Override public void onCancel() {}
                        });
                        break;
                    }
                }

                view = findViewById(R.id.map);
                title = "Clicca su questo segnalino per avere più informazioni.";
                //Qua c'è una ripetizione (riga 346). Si l'ho cambiata perciò non è uguale ma il significato è lo stesso
             //   desc = "Per ogni indirizzo troverai delle attività diverse dove partecipare.";
                radius = 50;
                break;
            case 5:
                for (int i = 0; i < ListaAule.adule.length; i++)
                {
                    if(ListaAule.adule[i].category == 1)
                    {
                        showLabDialog(i);
                        break;
                    }
                }
                mMap.animateCamera(CameraUpdateFactory.zoomTo(0));

                view = findViewById(R.id.map);
                title = "Cliccare sui segnalini non è l'unico modo per visualizzare tutte le attività.";
                desc = "";
                radius = 180;
                break;
            case 6:
                view = findViewById(R.id.bottomNavigationBar).getTouchables().get(1);
                title = "Clicca un'altra volta sull'indirizzo elettronica per far apparire la lista delle attività (funziona con tutti gli altri indirizzi).";
                desc = "Puoi anche tirare verso l'alto con il dito.";
                radius = 60;
                break;
            case 7:
                showListaAttivita(null);

                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(this);

                builder.setTitle("Complimenti")
                        .setMessage("Abbiamo finito il tutorial, addesso sei pronto ad usarla da solo!")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {public void onClick(DialogInterface dialog, int which) {}})
                        .show();

                prefs.edit().putBoolean("tutorial", true).commit();
                return;
            default:
                return;
        }

        TapTargetView.showFor(
                this,
                TapTarget.forView
                        (view, title, desc)
                        .outerCircleColor(R.color.colorPrimary)      // Specify a color for the outer circle
                        .outerCircleAlpha(0.75f)            // Specify the alpha amount for the outer circle
                        .targetCircleColor(R.color.transparent)   // Specify a color for the target circle
                        .titleTextColor(R.color.white)      // Specify the color of the title text
                        .dimColor(R.color.black)            // If set, will dim behind the view with 30% opacity of the given color
                        .drawShadow(true)                   // Whether to draw a drop shadow or not
                        .cancelable(false)                  // Whether tapping outside the outer circle dismisses the view
                        .tintTarget(true)                   // Whether to tint the target view's color
                        .transparentTarget(true)           // Specify whether the target is transparent (displays the content underneath)
                        .targetRadius(radius),                  // Specify the target radius (in dp)
                new TapTargetView.Listener()
                {          // The listener can listen for regular clicks, long clicks or cancels
                    @Override
                    public void onTargetClick(TapTargetView view)
                    {
                        super.onTargetClick(view);      // This call is optional
                        showTutorial(step + 1);
                    }
                });
    }
}
