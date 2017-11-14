package com.skuu.einsteinopenday;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Adrian on 14/11/2017.
 */

public class Aula
{
    public String nomeAula;
    public int aulaNum;
    public int category;
    public LatLng pos;
    public Attivita[] attivita;

    public Aula(int aulaNum, int category, LatLng pos, Attivita[] attivita)
    {
        this.aulaNum = aulaNum;
        this.category = category;
        this.pos = pos;
        this.attivita = attivita;
    }

    public Aula(String nomeAula, int aulaNum, int category, LatLng pos, Attivita[] attivita)
    {
        this.nomeAula = nomeAula;
        this.aulaNum = aulaNum;
        this.category = category;
        this.pos = pos;
        this.attivita = attivita;
    }
}