package com.example.pps_penugasan4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FormActivity extends AppCompatActivity {
    // Deklarasi variabel
    Button btnSimpan, btnHapus;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Mengaktifkan EdgeToEdge
        setContentView(R.layout.activity_form);

        // Mengatur padding berdasarkan insets sistem
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Mengaitkan button Simpan dengan ID-nya
        btnSimpan = findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FormActivity.this, "Data Disimpan", Toast.LENGTH_SHORT).show();
            }
        });

        // Mengaitkan button Hapus dengan ID-nya
        btnHapus = findViewById(R.id.btnHapus);
        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Membuat alert dialog
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(FormActivity.this);
                alertDialogBuilder.setTitle("Peringatan");
                alertDialogBuilder.setMessage("Apakah Anda yakin akan menghapus Data?")
                        .setIcon(R.drawable.ic_warning)
                        .setCancelable(false)
                        .setPositiveButton("Ya", (dialogInterface, i) ->
                                Toast.makeText(getApplicationContext(), "Data Dihapus", Toast.LENGTH_SHORT).show()
                        )
                        .setNegativeButton("Tidak", (dialogInterface, i) -> dialogInterface.cancel());

                // Membuat dan menampilkan dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }
}
