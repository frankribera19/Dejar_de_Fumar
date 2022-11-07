package com.example.dejardefumar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Atributos para la vista
    private TextView lblDineroAhorrado;
    private TextView lblCigarros;
    private Button btnFumar;

    private int cigarros = 20;
    private float dinero = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        inicializarVista();


        btnFumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cigarros == 1){
                    cigarros = 20;
                    dinero+=5;
                    lblDineroAhorrado.setText(""+dinero+"€");
                    lblCigarros.setText(""+cigarros);
                }else{
                    cigarros--;
                    lblCigarros.setText(String.valueOf(cigarros));
                    lblDineroAhorrado.setText(""+dinero+"€");
                }
            }
        });
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("CIGARROS",cigarros);
        outState.putFloat("DINERO",dinero);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        dinero = savedInstanceState.getFloat("DINERO");
        lblDineroAhorrado.setText(""+dinero+"€");

        cigarros = savedInstanceState.getInt("CIGARROS");
        lblCigarros.setText(""+cigarros);
    }

    private void inicializarVista() {
        lblDineroAhorrado = findViewById(R.id.lblDineroAhorradoMainActivity);
        lblCigarros = findViewById(R.id.lblCigarrosMainActivity);
        btnFumar = findViewById(R.id.btnFumarMainActivity);
    }
}