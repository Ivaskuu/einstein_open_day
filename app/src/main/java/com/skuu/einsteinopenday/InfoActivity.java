package com.skuu.einsteinopenday;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class InfoActivity extends AppCompatActivity
{
    private final String URL_LINKEDIN = "https://www.linkedin.com/in/ivascu-adrian";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    public void apriLinkedin(View v)
    {
        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(URL_LINKEDIN));
        startActivity(intent);
    }

    public void inviaEmail(View v)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("mailto:ivascuadrian9@gmail.com?subject=" + "Ho bisogno di una app" + "&body=" + "Ciao, avrei bisogno di una app.\n\nEcco la mia idea: ");
        intent.setData(data);
        startActivity(intent);
    }

    public void chiudiInfoAttivita(View v)
    {
        finish();
    }
}
