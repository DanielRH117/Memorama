package com.example.memoramainstruccional;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnJ, btnAD, btnIntrucciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnJ = findViewById(R.id.btnJ);
        btnAD = findViewById(R.id.btnAD);
        btnIntrucciones = findViewById(R.id.btnInstr);

        setUpEvents();
    }

    private void setUpEvents() {

        btnJ.setOnClickListener(view -> {
            Intent intent = new Intent(this, Menu.class);
            Toast.makeText(this,"Bienvenido",Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });

        btnAD.setOnClickListener(view -> {
            Intent intent = new Intent(this, AcercaDe.class);
            Toast.makeText(this, "Acerca de...", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
        btnIntrucciones.setOnClickListener(view -> {
            Intent intent = new Intent(this, Juego.class);
            Toast.makeText(this, "Intrucciones", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
    }
}
