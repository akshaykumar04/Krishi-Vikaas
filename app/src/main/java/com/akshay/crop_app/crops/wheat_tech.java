package com.akshay.crop_app.crops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.akshay.crop_app.R;
import com.github.barteksc.pdfviewer.PDFView;

public class wheat_tech extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheat_tech);

        pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("wheat_tech.pdf").load();
    }
}
