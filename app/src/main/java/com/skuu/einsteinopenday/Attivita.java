package com.skuu.einsteinopenday;

/**
 * Created by Adrian on 14/11/2017.
 */

public class Attivita
{
    public String nomeAtt;
    public String prof;
    public String desc;

    public Attivita(String nomeAtt, String prof)
    {
        this.nomeAtt = nomeAtt;
        this.prof = prof;
    }

    public Attivita(String nomeAtt, String prof, String desc)
    {
        this.nomeAtt = nomeAtt;
        this.prof = prof;
        this.desc = desc;
    }
}