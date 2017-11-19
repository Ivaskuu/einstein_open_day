package com.skuu.einsteinopenday;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

/**
 * Created by Adrian on 18/11/2017.
 */

public class AdapterListaAttivita extends ArrayAdapter<Attivita>
{
    private BottomSheetDialog dialog;
    private GoogleMap mMap;
    private MainActivity mainActivity;
    private ImageLoader imageloader;

    public AdapterListaAttivita(@NonNull Context context, ArrayList<Attivita> attivita, BottomSheetDialog dialog, GoogleMap mMap, MainActivity mainActivity)
    {
        super(context, R.layout.tile_attivita, attivita);

        this.dialog = dialog; // To close the dialog on button click
        this.mMap = mMap; // To animate the camera to the marker position
        this.mainActivity = mainActivity; // To show the lab dialog

        imageloader = ImageLoader.getInstance();
        imageloader.init(ImageLoaderConfiguration.createDefault(context));
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        if(convertView == null)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.tile_attivita, parent, false);
        }

        final Attivita attivita = getItem(position);
        ImageView img = (ImageView)convertView.findViewById(R.id.img_attivita_tile);
        TextView textTitolo = (TextView)convertView.findViewById(R.id.text_titolo_attivita);
        TextView textDesc = (TextView)convertView.findViewById(R.id.text_desc_attivita);

        textTitolo.setText(attivita.nomeAtt);
        //textDesc.setText(attivita.desc);
        imageloader.displayImage("drawable://" + attivita.imgRes, img);

        //img.setImageResource(attivita.imgRes);

        Button btnVisualizza = (Button)convertView.findViewById(R.id.btn_visualizza_aula);
        btnVisualizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();

                int pos = -1;
                LatLng latLng = ListaAule.adule[0].pos;
                for(int i = 0; i < ListaAule.adule.length; i++)
                {
                    if(ListaAule.adule[i].attivita == attivita) // TODO : Spostare l'attributo category da Aula a Attivita
                    {
                        latLng = ListaAule.adule[i].pos;
                        pos = i;
                        break;
                    }
                }

                final int arrayPos = pos;
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 19), 800, new GoogleMap.CancelableCallback()
                {
                    @Override
                    public void onFinish()
                    {
                        mainActivity.showLabDialog(arrayPos);
                    }

                    @Override public void onCancel() {}
                });
            }
        });

        return convertView;
    }
}
