package com.example.diario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText txtTema;
    private Spinner spinAsignatura, spinSeccion;
    private  Button btnRegistrar;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTema = findViewById(R.id.txtTema);
        spinAsignatura = findViewById(R.id.spinAsignatura);
        spinSeccion = findViewById(R.id.spinSeccion);

        btnRegistrar = findViewById(R.id.btRegistrar);

        //Obtenemso un Snapshor de la base de datos
        mDatabase = FirebaseDatabase.getInstance().getReference("Clase");

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarClase();
            }
        });
    }

    public void registrarClase(){
        String seccion = spinSeccion.getSelectedItem().toString();
        String asignatura = spinAsignatura.getSelectedItem().toString();
        String tema = txtTema.getText().toString();

        if(!TextUtils.isEmpty(tema)){
            String id = mDatabase.push().getKey();
            Clases leccion = new Clases(id, seccion, asignatura, tema);
            mDatabase.child(id).setValue(leccion);
            Toast.makeText(this, "Clase registrada", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Introduzca un tema", Toast.LENGTH_LONG).show();

        }
    }

}
