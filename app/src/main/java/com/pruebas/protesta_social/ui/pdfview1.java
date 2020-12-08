package com.pruebas.protesta_social.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.pruebas.protesta_social.R;

public class pdfview1 extends AppCompatActivity {

    private PDFView pdfViewDefPopular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfview1);

        pdfViewDefPopular = (PDFView) findViewById(R.id.pdfDEFPOP);
        pdfViewDefPopular.fromAsset("DPop.pdf").load();
    }
}