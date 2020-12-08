package com.pruebas.protesta_social.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.pruebas.protesta_social.R;

public class pdfview2 extends AppCompatActivity {

    private PDFView pdfViewMedLibres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfview2);

        pdfViewMedLibres = (PDFView) findViewById(R.id.pdfMEDLIB);
        pdfViewMedLibres.fromAsset("MLibres.pdf").load();
    }
}