package br.edu.fateczl.teste20222;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoActivity extends AppCompatActivity {

    private TextView tvResultado;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setGravity(Gravity.CENTER);
        btnVoltar = findViewById(R.id.btnVoltar);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        int random = bundle.getInt("random");

        tvResultado.setText(getString(R.string.acerto)+" "+random);
        Toast.makeText(this, "Parabéns", Toast.LENGTH_LONG).show();

        btnVoltar.setOnClickListener(click -> voltar());
    }

    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }
}