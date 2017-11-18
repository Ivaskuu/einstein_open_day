package com.skuu.einsteinopenday;

/**
 * Created by Adrian on 14/11/2017.
 */

public class Attivita
{
    public String nomeAtt;
    public String prof;
    public String desc;
    public int imgRes;

    public Attivita(String nomeAtt, String prof, int imgRes)
    {
        this.nomeAtt = nomeAtt;
        this.prof = prof;
        this.imgRes = imgRes;
    }

    public Attivita(String nomeAtt, String prof, String desc, int imgRes)
    {
        this.nomeAtt = nomeAtt;
        this.prof = prof;
        this.desc = desc;
        this.imgRes = imgRes;
    }
}