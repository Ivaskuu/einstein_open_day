package com.skuu.einsteinopenday;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Adrian on 18/11/2017.
 */

public class AdapterListaAttivita extends ArrayAdapter<Attivita>
{
    public AdapterListaAttivita(@NonNull Context context, ArrayList<Attivita> attivita)
    {
        super(context, R.layout.tile_attivita, attivita);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        if(convertView == null) convertView = layoutInflater.inflate(R.layout.tile_attivita, parent, false);

        Attivita attivita = getItem(position);
        TextView textTitolo = (TextView)convertView.findViewById(R.id.text_titolo_attivita);
        TextView textDesc = (TextView)convertView.findViewById(R.id.text_desc_attivita);
        ImageView img = (ImageView)convertView.findViewById(R.id.img_attivita_tile);

        textTitolo.setText(attivita.nomeAtt);
        //textDesc.setText(attivita.desc);
        img.setImageResource(attivita.imgRes);

        return convertView;
    }
}
