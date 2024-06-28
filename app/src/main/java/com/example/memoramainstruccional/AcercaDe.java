package com.example.memoramainstruccional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class AcercaDe extends AppCompatActivity {

    private Button btnB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        btnB =findViewById(R.id.btnB);

        setUpEvents();
    }

    private void setUpEvents() {
        btnB.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            Toast.makeText(this, "Developed by DRH", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        });
    }
}