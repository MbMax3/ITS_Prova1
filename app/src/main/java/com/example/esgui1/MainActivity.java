package com.example.esgui1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bottone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button inserisci = findViewById(R.id.Clicca);
        Button crea2 = findViewById(R.id.Crea2);
        LinearLayout ll = findViewById(R.id.SpazioBottoni);
        LinearLayout griglia1 = findViewById(R.id.Griglia);

        Context ma = this;
        inserisci.setOnClickListener((View.OnClickListener) v -> {
            Button bottone = new Button(ma);
            final TextView Testo = (TextView) findViewById(R.id.InserisciTesto);
            bottone.setText(Testo.getText());
            LinearLayoutCompat.LayoutParams lp = new LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
            bottone.setLayoutParams(lp);
            ll.addView(bottone);
         });
        crea2.setOnClickListener((View.OnClickListener) v -> {
            Button bottone = new Button(ma);
            final TextView Testo = (TextView) findViewById(R.id.InserisciTesto);
            bottone.setText(Testo.getText());

             // layout orizzontali
            if(griglia1.getChildCount() ==0) {
                LinearLayout hl = new LinearLayout(ma);
                hl.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                hl.setOrientation(LinearLayout.HORIZONTAL);
                hl.addView(bottone);
                griglia1.addView(hl);
                return;
            }

            LinearLayout hl = (LinearLayout) griglia1.getChildAt(griglia1.getChildCount() -1);

            if (hl.getChildCount() >= 2) {
                LinearLayout nhl = new LinearLayout(ma);
                nhl.setOrientation(LinearLayout.HORIZONTAL);
                nhl.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                nhl.addView(bottone);
                griglia1.addView(nhl);
                return;
            }

            hl.addView(bottone);
        }
        );


    }
}